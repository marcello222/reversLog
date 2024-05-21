package com.marcello.course.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.marcello.course.entities.enums.ReversalStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "tb_reversal")
public class Reversal implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer statusReversal;

    private String voucher;

    private String value;

    @JsonIgnore
    @OneToOne
    @MapsId
    private Product product;


    public ReversalStatus getStatusReversal() {
        return ReversalStatus.valueOf(statusReversal);
    }

    public void setStatusOrder(ReversalStatus reversalStatus) {
        if (reversalStatus != null) {
            this.statusReversal = reversalStatus.getCode();
        }
    }


    public Reversal(Long id, String voucher,
                    ReversalStatus reversalStatus, String value, Product product) {
        this.id = id;
        this.voucher = voucher;
        this.value = value;
        setStatusOrder(reversalStatus);
        this.product = product;
    }


    public Reversal() {

    }
    public Product getProduct() {
        return product;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Reversal other = (Reversal) obj;
        return Objects.equals(id, other.id);
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getVoucher() {
		return voucher;
	}

	public void setVoucher(String voucher) {
		this.voucher = voucher;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
