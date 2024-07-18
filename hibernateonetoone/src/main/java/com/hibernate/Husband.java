package com.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="husband_details")
public class Husband {
	
	@Id
	private int hid;
	@Column (name="")
	private String hName;
	@OneToOne
	private Wife wife;

	public Husband() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Husband(int hid, String hName, Wife wife) {
		super();
		this.hid = hid;
		this.hName = hName;
		this.wife = wife;
	}

	public int getHid() {
		return hid;
	}

	public void setHid(int hid) {
		this.hid = hid;
	}

	public String gethName() {
		return hName;
	}

	public void sethName(String hName) {
		this.hName = hName;
	}

	public Wife getWife() {
		return wife;
	}

	public void setWife(Wife wife) {
		this.wife = wife;
	}

	@Override
	public String toString() {
		return "Husband [hid=" + hid + ", hName=" + hName + ", wife=" + wife + "]";
	}
	
	
}
