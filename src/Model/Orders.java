/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author asanka
 */
public class Orders {
    

	private String orderId;
	private String customerId;
	private String customerName;
	private int qty;
	private double value;
	private int orderStaus;
	private final int CANCEL = 0;
	private final int PREPARING = 1;
	private final int DELIVERED = 2;

	public int getCancel() {
		return CANCEL;
	}

	public int getPreparing() {
		return PREPARING;
	}

	public int getDelieverd() {
		return DELIVERED;
	}

	public Orders(String orderId, String customerId, String customerName, int qty, double value, int orderStaus) {
		this.orderId = orderId;
		this.customerId = customerId;
		this.customerName = customerName;
		if (qty > 0) {
			this.qty = qty;
		}
		this.orderStaus = orderStaus;
		this.value = value;

	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setQty(int qty) {
		if (qty > 0) {
			this.qty = qty;
		}
	}

	public void setOrderStatus(int orderStaus) {
		this.orderStaus = orderStaus;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getOrderId() {
		return orderId;
	}

	public int getOrderStatus() {
		return orderStaus;
	}

	public String getCustomerId() {
		return customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public int getQty() {
		return qty;
	}

	public double getValue() {
		return value;
	}


}
