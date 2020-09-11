package com.revature.models.templates;

import java.sql.Timestamp;
import java.util.Objects;

import com.revature.models.User;

public class ManagerReimburseTemplate {
	private int id;
	private double amount;
	private Timestamp timeSubmitted;
	private String description;
	private String receipt;
	private User author;
	private String status;
	private String type;
	
	public ManagerReimburseTemplate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ManagerReimburseTemplate(int id, double amount, Timestamp timeSubmitted, String description, String receipt,
			User author, String status, String type) {
		super();
		this.id = id;
		this.amount = amount;
		this.timeSubmitted = timeSubmitted;
		this.description = description;
		this.receipt = receipt;
		this.author = author;
		this.status = status;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Timestamp getTimeSubmitted() {
		return timeSubmitted;
	}

	public void setTimeSubmitted(Timestamp timeSubmitted) {
		this.timeSubmitted = timeSubmitted;
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

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, author, description, id, receipt, status, timeSubmitted, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ManagerReimburseTemplate other = (ManagerReimburseTemplate) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& Objects.equals(author, other.author) && Objects.equals(description, other.description)
				&& id == other.id && Objects.equals(receipt, other.receipt) && Objects.equals(status, other.status)
				&& Objects.equals(timeSubmitted, other.timeSubmitted) && Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "ManagerReimburseTemplate [id=" + id + ", amount=" + amount + ", timeSubmitted=" + timeSubmitted
				+ ", description=" + description + ", receipt=" + receipt + ", author=" + author + ", status=" + status
				+ ", type=" + type + "]";
	}
	
	

}
