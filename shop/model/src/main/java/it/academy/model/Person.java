package it.academy.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class Person {

    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String personID;

    private String name;

    private String secondName;

    private Date dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ElementCollection
    @OrderColumn(name = "C_ORDER")
    private String[] comments;

    @OneToOne
    @JoinColumn(name = "SHOP_USER_ID")
    private ShopUser shopUser;



    enum Status{
        NEW, UPDATED, DELETED
    }

}
