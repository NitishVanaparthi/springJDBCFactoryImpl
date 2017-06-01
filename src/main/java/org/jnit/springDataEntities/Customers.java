package org.jnit.springDataEntities;

import java.util.List;

public class Customers {
	private int customersId;
	private String customerName;
	private String sex;
	private String address1;
	private String address2;
	private String city;

	private List<Orders> orders;

	public int getCustomerId() {
		return customersId;
	}

	public void setCustomerId(int customersId) {
		this.customersId = customersId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Customers [customerId=" + customersId + ", customerName=" + customerName + ", sex=" + sex
				+ ", address1=" + address1 + ", address2=" + address2 + ", city=" + city + ", orders=" + orders + "]";
	}

}
