package com.marcello.course.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_product")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String defectDescription;

	private Double price;

	private String imgUrl;

	@OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
	private Refund refund;

	@ManyToMany
	@JoinTable(name = "tb_product_category", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	@Builder.Default
	private Set<Category> categories = new HashSet<>();

	@OneToMany(mappedBy = "id.product")
	@Builder.Default
	public Set<OrderItem> items = new HashSet<>();
}