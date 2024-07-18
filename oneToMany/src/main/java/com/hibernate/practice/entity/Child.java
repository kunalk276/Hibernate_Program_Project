package com.hibernate.practice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="child_details")
public class Child {

	@Id
	private int cId;
	private String cName;
	@ManyToOne
	private Parent parent;

	public Child() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Child(int cId, String cName, Parent parent) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.parent = parent;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "Child [cId=" + cId + ", cName=" + cName + ", parent=" + parent + "]";
	}
	
	
}
