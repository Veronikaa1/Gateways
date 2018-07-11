package com.musala.gateways.entity;

import java.util.List;

public class Gateway {

	private int id;
	private String name;
	private String ipv4;
	private List<Device> asso_devices;

	public Gateway() {
	}
	
	public Gateway(String name, String ipv4) {
		this.name = name;
		this.ipv4 = ipv4;
	}

	public Gateway(int id, String name, String ipv4) {
		this.id = id;
		this.name = name;
		this.ipv4 = ipv4;
	}

	public Gateway(int id, String name, String ipv4, List<Device> asso_devices) {
		this.id = id;
		this.name = name;
		this.ipv4 = ipv4;
		this.asso_devices = asso_devices;
	}

	public List<Device> getAsso_devices() {
		return asso_devices;
	}

	public void setAsso_devices(List<Device> asso_devices) {
		this.asso_devices = asso_devices;
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

	public String getIpv4() {
		return ipv4;
	}

	public void setIpv4(String ipv4) {
		this.ipv4 = ipv4;
	}

}
