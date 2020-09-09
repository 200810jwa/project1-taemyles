package com.revature.models;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Objects;

public class Reimbursement {
	
	private int id;
	private double amount;
	private Timestamp timeSubmitted;
	private Timestamp timeResolved;
	private String description;
	private byte[] receipt;
	private User author;
	private User resolver;
	private RStatus status;
	private RType type;
	
	public Reimbursement() {
		super();
	}

	public Reimbursement(int id, double amount, Timestamp timeSubmitted, Timestamp timeResolved,
			String description, byte[] receipt, User author, User resolver, RStatus status, RType type) {
		super();
		this.id = id;
		this.amount = amount;
		this.timeSubmitted = timeSubmitted;
		this.timeResolved = timeResolved;
		this.description = description;
		this.receipt = receipt;
		this.author = author;
		this.resolver = resolver;
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

	public Timestamp getTimeResolved() {
		return timeResolved;
	}

	public void setTimeResolved(Timestamp timeResolved) {
		this.timeResolved = timeResolved;
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

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public User getResolver() {
		return resolver;
	}

	public void setResolver(User resolver) {
		this.resolver = resolver;
	}

	public RStatus getStatus() {
		return status;
	}

	public void setStatus(RStatus status) {
		this.status = status;
	}

	public RType getType() {
		return type;
	}

	public void setType(RType type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(receipt);
		result = prime * result
				+ Objects.hash(amount, author, description, id, resolver, status, timeResolved, timeSubmitted, type);
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
		Reimbursement other = (Reimbursement) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& Objects.equals(author, other.author) && Objects.equals(description, other.description)
				&& id == other.id && Arrays.equals(receipt, other.receipt) && Objects.equals(resolver, other.resolver)
				&& Objects.equals(status, other.status) && Objects.equals(timeResolved, other.timeResolved)
				&& Objects.equals(timeSubmitted, other.timeSubmitted) && Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", timeSubmitted=" + timeSubmitted + ", timeResolved="
				+ timeResolved + ", description=" + description + ", receipt=" + receipt + ", author=" + author
				+ ", resolver=" + resolver + ", status=" + status + ", type=" + type + "]";
	}
	
}