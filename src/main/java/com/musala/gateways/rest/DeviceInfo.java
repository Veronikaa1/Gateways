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

import com.musala.gateways.business.DeviceImpl;
import com.musala.gateways.entity.Device;
import com.musala.gateways.helper.Validator;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DeviceInfo implements IDevice {

	/**
	 * Gives all devices based on gateways id.
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(value = "/devices", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Device> devices(@RequestParam("id") int id) {

		return DeviceImpl.retrieveDevicesOnGW(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@RequestMapping(value = "/devices/add", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<String> addDevice(@RequestBody Device device) {

		if (Validator.checkIfPossibleInsert(device.getGateway_id())) {
			DeviceImpl.insertDevice(device);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("You have reached maximum device number for this gateway.");
		}

		return ResponseEntity.status(HttpStatus.OK).build();
	}

	/**
	 * {@inheritDoc}
	 */
	@RequestMapping(value = "/devices/delete", method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody void deleteGWById(@RequestParam("uid") String uid) {
		DeviceImpl.deleteDeviceById(uid);
	}

}
