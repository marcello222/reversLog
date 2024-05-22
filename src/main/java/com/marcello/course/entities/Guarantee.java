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


    public Guarantee(Long id, GuaranteeStatus guaranteeStatus, Instant purchaseDate, Order order) {
        super();
        this.id = id;
        setStatusOrder(guaranteeStatus);
        this.purchaseDate = purchaseDate;
        this.order = order;
    }

    public GuaranteeStatus getGuaranteeStatusCode() {
        return GuaranteeStatus.valueOf(guaranteeStatusCode);
    }

    public void setStatusOrder(GuaranteeStatus guaranteeStatus) {
        if (guaranteeStatus != null) {
            this.guaranteeStatusCode = guaranteeStatus.getCode();
        }
    }

}
