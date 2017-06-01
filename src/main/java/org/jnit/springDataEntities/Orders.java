package org.jnit.springDataEntities;

import java.util.Date;

public class Orders {
	private int orderId;
	private String orderName;
	private Date orderDate;
	private String orderDescription;
	private String orderIsAvailable;
	private int customerId;

	

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderDescription() {
		return orderDescription;
	}

	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}

	public String getOrderIsAvailable() {
		return orderIsAvailable;
	}

	public void setOrderIsAvailable(String orderIsAvailable) {
		this.orderIsAvailable = orderIsAvailable;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderName=" + orderName + ", orderDate=" + orderDate
				+ ", orderDescription=" + orderDescription + ", orderIsAvailable=" + orderIsAvailable + ", customerId="
				+ customerId + "]";
	}

}
