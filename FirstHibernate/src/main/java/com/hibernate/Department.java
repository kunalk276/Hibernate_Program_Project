package com.hibernate;



import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Department {
@Id
	private int did;
	private String dname;
	private String address;
	
	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Department(int did, String dname, String address) {
		super();
		this.did = did;
		this.dname = dname;
		this.address = address;
	}


	public int getDid() {
		return did;
	}


	public void setDid(int did) {
		this.did = did;
	}


	public String getDname() {
		return dname;
	}


	public void setDname(String dname) {
		this.dname = dname;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Department [did=" + did + ", dname=" + dname + ", address=" + address + "]";
	}
	
	
}
