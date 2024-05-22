package com.marcello.course.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.marcello.course.entities.enums.RefundStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_refund")
public class Refund implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer statusRefund;

    private String voucher;

    private String value;

    @JsonIgnore
    @OneToOne
    @MapsId
    private Product product;


    public RefundStatus getStatusRefund() {
        return RefundStatus.valueOf(statusRefund);
    }

    public void setStatusOrder(RefundStatus refundStatus) {
        if (refundStatus != null) {
            this.statusRefund = refundStatus.getCode();
        }
    }


    public Refund(Long id, String voucher,
                  RefundStatus refundStatus, String value, Product product) {
        this.id = id;
        this.voucher = voucher;
        this.value = value;
        setStatusOrder(refundStatus);
        this.product = product;
    }

}
