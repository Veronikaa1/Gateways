package com.musala.gateways.rest;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.musala.gateways.entity.Gateway;

/**
 * 
 * IGateway interface
 * 
 */
public interface IGateway {

	/**
	 * Retrieves all available gateways with their corresponding devices.
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<Gateway> retrieveAllGatewaysWithDevices() throws SQLException;

	/**
	 * Gives information about concrete gateway with its devices based on gateway
	 * id.
	 * 
	 * @param id
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public @ResponseBody List<Gateway> retrieveGatewayWithDevices(@RequestParam("id") int id)
			throws SQLException;

	/**
	 * Deletes gateway based on id. If one or more devices are associated with this
	 * gateway they are deleted as well.
	 * 
	 * @param id
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public @ResponseBody void deleteGWById(@RequestParam("id") int id) throws SQLException;

	/**
	 * Adds new gateway.
	 * 
	 * @param gateway
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ResponseEntity<String> addGateway(@RequestBody Gateway gateway) throws SQLException;

}
