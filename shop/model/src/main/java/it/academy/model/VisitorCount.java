package it.academy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "T_VISITOR_COUNT")
public class VisitorCount {

    @Id
    private Integer id;
    @Column(name = "visitor_count")
    private Integer count;

}
