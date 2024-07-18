package com.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="Wife_Details")
public class Wife {
	@Id
	private int wId;
	@Column (name="wife_name")
	private String wName;
	@OneToOne
	private Husband husband;
	public Wife() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Wife(int wId, String wName, Husband husband) {
		super();
		this.wId = wId;
		this.wName = wName;
		this.husband = husband;
	}
	public int getwId() {
		return wId;
	}
	public void setwId(int wId) {
		this.wId = wId;
	}
	public String getwName() {
		return wName;
	}
	public void setwName(String wName) {
		this.wName = wName;
	}
	public Husband getHusband() {
		return husband;
	}
	public void setHusband(Husband husband) {
		this.husband = husband;
	}
	@Override
	public String toString() {
		return "Wife [wId=" + wId + ", wName=" + wName + ", husband=" + husband + "]";
	}
	
	
}
