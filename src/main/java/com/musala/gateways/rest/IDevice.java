package com.musala.gateways.rest;

import java.sql.SQLException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.musala.gateways.entity.Device;
/**
 * 
 * IDevice interface
 *
 */
public interface IDevice {

	/**
	 *	Adds new device for a concrete gateway. Check if the maximum number of devices is reached. 
	 * @param device
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ResponseEntity<String> addDevice(@RequestBody Device device) throws SQLException;
	
	/**
	 * Deletes a device on given uid.
	 * 
	 * @param uid
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public @ResponseBody void deleteGWById(@RequestParam("uid") String uid) throws SQLException;
}
