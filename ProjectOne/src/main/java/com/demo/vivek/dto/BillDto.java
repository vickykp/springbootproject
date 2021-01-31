package com.demo.vivek.dto;

import java.util.List;

public class BillDto {
	private EmployeeDto employee;
	private List<Long> itemsIds;

	public EmployeeDto getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeDto employee) {
		this.employee = employee;
	}

	public List<Long> getItemsIds() {
		return itemsIds;
	}

	public void setItemsIds(List<Long> itemsIds) {
		this.itemsIds = itemsIds;
	}
}
