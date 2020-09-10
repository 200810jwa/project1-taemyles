package com.revature.models.templates;

import java.util.Arrays;
import java.util.Objects;


public class ReimburseTemplate {
	private double amount;
	private String description;
	private String receipt;
	private String type;

	public ReimburseTemplate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReimburseTemplate(double amount, String description, String receipt, String type) {
		super();
		this.amount = amount;
		this.description = description;
		this.receipt = receipt;
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, description, receipt, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReimburseTemplate other = (ReimburseTemplate) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& Objects.equals(description, other.description) && Objects.equals(receipt, other.receipt)
				&& Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "ReimburseTemplate [amount=" + amount + ", description=" + description + ", receipt=" + receipt
				+ ", type=" + type + "]";
	}

}
