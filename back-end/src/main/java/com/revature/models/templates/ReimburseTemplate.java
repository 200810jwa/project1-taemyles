package com.revature.models.templates;

import java.nio.file.Path;
import java.sql.Blob;
import java.util.Arrays;
import java.util.Objects;

public class ReimburseTemplate {
	private double amount;
	private String description;
	private byte[] receipt;
	private String type;

	public ReimburseTemplate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReimburseTemplate(double amount, String description, byte[] receipt, String type) {
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

	public byte[] getReceipt() {
		return receipt;
	}

	public void setReceipt(byte[] receipt) {
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
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(receipt);
		result = prime * result + Objects.hash(amount, description, type);
		return result;
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
				&& Objects.equals(description, other.description) && Arrays.equals(receipt, other.receipt)
				&& Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "ReimburseTemplate [amount=" + amount + ", description=" + description + ", receipt=" + receipt
				+ ", type=" + type + "]";
	}

}
