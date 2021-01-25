package it.academy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name = "T_PRODUCT")
public class Product {

    @Id
    @Column(name = "PRODUCT_ID")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String productId;

    @Column(name = "P_PRODUCT_NAME")
    private String productName;

    @Column(name = "P_PRODUCT_DESCRIPTION")
    private String description;

    @OneToMany(mappedBy = "product")
    private List <ProductPrice> productPrice;
}
