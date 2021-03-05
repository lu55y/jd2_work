package it.academy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.persistence.*;

@Entity
@Table(name = "T_VISITOR_COUNT")
@Data
public class VisitorCount {

    @Id
    private Integer id;

    @Column
    private Integer count;
}
