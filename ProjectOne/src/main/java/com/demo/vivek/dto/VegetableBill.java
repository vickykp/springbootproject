package com.demo.vivek.dto;

import java.util.List;

public class VegetableBill {
	private EmployeeDto clerk;
	private List<ItemDto> receipt;
	private double total;
	private double internalDiscount;

	public EmployeeDto getClerk() {
		return clerk;
	}

	public void setClerk(EmployeeDto clerk) {
		this.clerk = clerk;
	}

	public List<ItemDto> getReceipt() {
		return receipt;
	}

	public void setReceipt(List<ItemDto> receipt) {
		this.receipt = receipt;
	}

	public double getTotal() {
		return Math.rint(total * 100) / 100.0;

	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getInternalDiscount() {
		return internalDiscount;
	}

	public void setInternalDiscount(double internalDiscount) {
		this.internalDiscount = internalDiscount;
	}

}
