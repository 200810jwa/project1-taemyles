package com.revature.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Reimbursement {
	
	private int id;
	private LocalDateTime timeSubmitted;
	private LocalDateTime timeResolved;
	private Employee author;
	private Employee resolver;
	private RStatus status;
	private RType type;
	
	public Reimbursement() {
		super();
	}

	public Reimbursement(int id, LocalDateTime timeSubmitted, LocalDateTime timeResolved, Employee author,
			Employee resolver, RStatus status, RType type) {
		super();
		this.id = id;
		this.timeSubmitted = timeSubmitted;
		this.timeResolved = timeResolved;
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

	public LocalDateTime getTimeSubmitted() {
		return timeSubmitted;
	}

	public void setTimeSubmitted(LocalDateTime timeSubmitted) {
		this.timeSubmitted = timeSubmitted;
	}

	public LocalDateTime getTimeResolved() {
		return timeResolved;
	}

	public void setTimeResolved(LocalDateTime timeResolved) {
		this.timeResolved = timeResolved;
	}

	public Employee getAuthor() {
		return author;
	}

	public void setAuthor(Employee author) {
		this.author = author;
	}

	public Employee getResolver() {
		return resolver;
	}

	public void setResolver(Employee resolver) {
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
		return Objects.hash(author, id, resolver, status, timeResolved, timeSubmitted, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Reimbursement)) {
			return false;
		}
		Reimbursement other = (Reimbursement) obj;
		return Objects.equals(author, other.author) && id == other.id && Objects.equals(resolver, other.resolver)
				&& Objects.equals(status, other.status) && Objects.equals(timeResolved, other.timeResolved)
				&& Objects.equals(timeSubmitted, other.timeSubmitted) && Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", timeSubmitted=" + timeSubmitted + ", timeResolved=" + timeResolved
				+ ", author=" + author + ", resolver=" + resolver + ", status=" + status + ", type=" + type + "]";
	}
}
