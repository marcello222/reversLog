package com.marcello.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.marcello.course.entities.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "tb_order")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant orderDate;

	private Integer statusOrder;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Client client;
	
	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> items = new HashSet<>();
		
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private Guarantee guarantee;

	public Order(Long id, Instant orderDate, OrderStatus statusOrder, Client client) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		setStatusOrder(statusOrder);
		this.client = client;
	}

	public OrderStatus getStatusOrder() {
		return OrderStatus.valueOf(statusOrder);
	}

	public void setStatusOrder(OrderStatus orderStatus) {
		if (orderStatus != null) {
			this.statusOrder = orderStatus.getCode();
		}
	}


	public Guarantee getPayment() {
		return guarantee;
	}

	public void setPayment(Guarantee guarantee) {
		this.guarantee = guarantee;
	}

}
