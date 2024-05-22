package com.marcello.course.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Data
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
	private Set<Category> categories = new HashSet<>();
	
	@OneToMany(mappedBy = "id.product")
	public Set<OrderItem> items = new HashSet<>();

	public Product(Long id, String name, String defectDescription, Double price, String imgUrl) {
		super();
		this.id = id;
		this.name = name;
		this.defectDescription = defectDescription;
		this.price = price;
		this.imgUrl = imgUrl;
		this.categories = categories;
		this.items = items;
	}


}
