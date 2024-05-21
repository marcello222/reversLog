package com.marcello.course.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private Reversal reversal;

	@ManyToMany
	@JoinTable(name = "tb_product_category", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<Category> categories = new HashSet<>();
	
	@OneToMany(mappedBy = "id.product")
	public Set<OrderItem> items = new HashSet<>();

	public Product() {
	}

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDefectDescription() {
		return defectDescription;
	}

	public void setDefectDescription(String defectDescription) {
		this.defectDescription = defectDescription;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public Set<OrderItem> getItems() {
		return items;
	}

	public void setItems(Set<OrderItem> items) {
		this.items = items;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Product product = (Product) o;
		return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(defectDescription, product.defectDescription) && Objects.equals(price, product.price) && Objects.equals(imgUrl, product.imgUrl) && Objects.equals(reversal, product.reversal) && Objects.equals(categories, product.categories) && Objects.equals(items, product.items);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, defectDescription, price, imgUrl, reversal, categories, items);
	}
}
