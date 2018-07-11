package com.musala.gateways.rest;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.musala.gateways.business.GatewayImpl;
import com.musala.gateways.entity.Gateway;
import com.musala.gateways.helper.Validator;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class GatewayInfo implements IGateway {

	/**
	 * Gives only all gateways with no corresponding info for devices
	 * 
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(value = "/gateways/all", method = RequestMethod.GET, produces = "application/json")
	public List<Gateway> retrieveAllGateways() {

		return GatewayImpl.retrieveAllGateways();
	}

	/**
	 * {@inheritDoc}
	 */
	@RequestMapping(value = "/gateways/full", method = RequestMethod.GET, produces = "application/json")
	public List<Gateway> retrieveAllGatewaysWithDevices() {

		return GatewayImpl.retrieveAllGatewaysWithDevices();
	}

	/**
	 * {@inheritDoc}
	 */
	@RequestMapping(value = "/gateways", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Gateway> retrieveGatewayWithDevices(@RequestParam("id") int id) {

		return GatewayImpl.retrieveGatewayWithDevices(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@RequestMapping(value = "/gateways/delete", method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody void deleteGWById(@RequestParam("id") int id) {

		GatewayImpl.deleteGWById(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@RequestMapping(value = "/gateways/add", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<String> addGateway(@RequestBody Gateway gateway) {

		if (Validator.validateIPv4(gateway.getIpv4())) {
			GatewayImpl.insertGateway(gateway);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("IPv4 has invalid format. Should be: X.X.X.X");
		}
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
