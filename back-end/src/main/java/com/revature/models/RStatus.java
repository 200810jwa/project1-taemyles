package com.revature.models;

import java.util.Objects;

public class RStatus {
	
	private int id;
	private String name;
	
	public RStatus() {
		super();
	}

	public RStatus(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof RStatus)) {
			return false;
		}
		RStatus other = (RStatus) obj;
		return id == other.id && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "RStatus [id=" + id + ", name=" + name + "]";
	}
}
