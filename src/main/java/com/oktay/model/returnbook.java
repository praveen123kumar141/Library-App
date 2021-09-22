package com.oktay.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class returnbook {
	@Id
	int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
