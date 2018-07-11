package com.musala.gateways.business;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.musala.gateways.entity.Device;
import com.musala.gateways.helper.SQLConstants;
import com.musala.gateways.helper.SQLDeviceHelper;

public class DeviceImpl {

	@Autowired
	public static SQLDeviceHelper sql = new SQLDeviceHelper();

	/**
	 * Retrieves devices on gateways
	 * 
	 * @param id
	 * @return
	 */
	public static List<Device> retrieveDevicesOnGW(final int id) {
		List<Device> result = null;
		try {
			return sql.retrieveDevicesOnGW(SQLConstants.GET_DEVICE_BY_GW_ID, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Insert new device into DB
	 * 
	 * @param device
	 */
	public static void insertDevice(Device device) {

		try {
			sql.insertDevice(SQLConstants.INSERT_DEVICE, device);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Delete device on in
	 * 
	 * @param uid
	 */
	public static void deleteDeviceById(String uid) {

		try {
			sql.deleteDeviceById(SQLConstants.DELETE_DEVICE, uid);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Executes sql count for devices corresponding to a concrete gateway.
	 * 
	 * @param gwId
	 * @return
	 */
	public static int countDevices(int gwId) {
		int result = -1;
		try {
			result = sql.countDevices(SQLConstants.COUNT_DEVICES, gwId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

	}
}
