package com.hibernate.practice.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="parent_details")
public class Parent {

	@Id
	private int pId;
	private String pName;
	@OneToMany
	private List<Child> child;

	public Parent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Parent(int pId, String pName, List<Child> child) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.child = child;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public List<Child> getChild() {
		return child;
	}

	public void setChild(List<Child> child) {
		this.child = child;
	}

	@Override
	public String toString() {
		return "Parent [pId=" + pId + ", pName=" + pName + ", child=" + child + "]";
	}

}
