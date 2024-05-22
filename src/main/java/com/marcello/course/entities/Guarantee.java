package com.marcello.course.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.marcello.course.entities.enums.GuaranteeStatus;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "tb_guarantee")
public class Guarantee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant purchaseDate;

    private Integer guaranteeStatusCode;

    @JsonIgnore
    @OneToOne
    @MapsId
    private Order order;

}
