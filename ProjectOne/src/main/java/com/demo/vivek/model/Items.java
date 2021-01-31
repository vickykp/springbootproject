package com.demo.vivek.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Items {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemsId;

	private String name;
	private double price;
	private double discount;
	public Long getItemsId() {
		return itemsId;
	}
	public void setItemsId(Long itemsId) {
		this.itemsId = itemsId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

}
