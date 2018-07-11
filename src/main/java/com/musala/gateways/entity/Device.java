package com.musala.gateways.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Device {

	@Id
	private String uid;
	private String vendor;
	
	@Temporal(TemporalType.DATE)
	private Date creation_date;
	private boolean status;
	private int gateway_id;
	
	public Device() {}

	public Device(String uid, String vendor, Date date, boolean status) {
		this.uid = uid;
		this.vendor = vendor;
		this.creation_date = date;
		this.status = status;
	}

	public Device(String uid, String vendor, Date date, boolean status, int gateway_id) {
		this.uid = uid;
		this.vendor = vendor;
		this.creation_date = date;
		this.status = status;
		this.gateway_id = gateway_id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getGateway_id() {
		return gateway_id;
	}

	public void setGateway_id(int gateway_id) {
		this.gateway_id = gateway_id;
	}

}
