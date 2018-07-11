package com.musala.gateways.helper;

public class SQLConstants {

	// SQL Prepared statements for Device object
	public static final String GET_DEVICE_BY_GW_ID = "select * from device where gateway_id=?";
	public static final String INSERT_DEVICE = "insert into device(uid, vendor, creation_date, status, gateway_id) values (?, ?, ?, ?, ?);";
	public static final String DELETE_DEVICE = "delete from device where uid=?";
	public static final String COUNT_DEVICES = "select count(*) from device where gateway_id=?";
	
	// SQL Prepared statements for Gateway object
	public static final String GET_GATEWAYS = "select * from gateway";
	public static final String GET_GATEWAY_BY_ID = "select * from gateway where id=?";
	public static final String DELETE_GATEWAY_BY_ID = "delete from gateway where id=?";
	public static final String INSERT_GATEWAY = "insert into gateway (name, ipv4) values (?, ?)";
}
