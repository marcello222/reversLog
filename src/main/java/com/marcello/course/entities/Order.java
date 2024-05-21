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

@Entity
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
		
	public Order() {
	}

	public Order(Long id, Instant orderDate, OrderStatus statusOrder, Client client) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		setStatusOrder(statusOrder);
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Instant moment) {
		this.orderDate = moment;
	}

	public OrderStatus getStatusOrder() {
		return OrderStatus.valueOf(statusOrder);
	}

	public void setStatusOrder(OrderStatus orderStatus) {
		if (orderStatus != null) {
			this.statusOrder = orderStatus.getCode();
		}
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
	
	public Guarantee getPayment() {
		return guarantee;
	}

	public void setPayment(Guarantee guarantee) {
		this.guarantee = guarantee;
	}

	public Set<OrderItem> getItems(){
		return items;
	}
	
	public Double getTotal() {
		double sum = 0.0;
		for(OrderItem x : items) {
			sum += x.getSubTotal();
		}
		return sum;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}

}
