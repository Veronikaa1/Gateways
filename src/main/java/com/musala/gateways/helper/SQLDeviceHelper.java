package com.musala.gateways.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.musala.gateways.entity.Device;

/**
 * Manages DB data for Devices
 * 
 */
public class SQLDeviceHelper {

	static Connection conn = null;

	private void init() throws ClassNotFoundException, SQLException {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
	}

	public SQLDeviceHelper() {
		try {
			this.init();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Retrieves all devices for concrete gateway
	 * 
	 * @param getDeviceByGwId
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public List<Device> retrieveDevicesOnGW(String getDeviceByGwId, int id) throws SQLException {
		PreparedStatement preparedStatement = conn.prepareStatement(getDeviceByGwId);
		preparedStatement.setInt(1, id);
		List<Device> retrievedDevices = new ArrayList<>();
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			String uid = rs.getString("uid");
			String vendor = rs.getString("vendor");
			Date date = rs.getDate("creation_date");
			boolean status = rs.getBoolean("status");
			System.out.println(uid + ", " + vendor + ", " + date + ", " + status + ", " + status);
			retrievedDevices.add(new Device(uid, vendor, date, status, id));
		}
		return retrievedDevices;

	}

	/**
	 * Inserts device for gateway.
	 * 
	 * @param insertDevice
	 * @param device
	 * @throws SQLException
	 */
	public void insertDevice(String insertDevice, Device device) throws SQLException {

		PreparedStatement preparedStatement = conn.prepareStatement(insertDevice);
		preparedStatement.setString(1, device.getUid());
		preparedStatement.setString(2, device.getVendor());
		System.out.println("ZZZZZZZZz" + device.getCreation_date());
		java.sql.Date sqlDate = new java.sql.Date(device.getCreation_date().getTime());
		preparedStatement.setDate(3, sqlDate);
		preparedStatement.setBoolean(4, device.isStatus());
		preparedStatement.setInt(5, device.getGateway_id());

		preparedStatement.executeUpdate();

		return;

	}

	/**
	 * Deletes device based on id.
	 * 
	 * @param deleteDevice
	 * @param uid
	 * @throws SQLException
	 */
	public void deleteDeviceById(String deleteDevice, String uid) throws SQLException {

		PreparedStatement preparedStatement = conn.prepareStatement(deleteDevice);
		preparedStatement.setString(1, uid);
		preparedStatement.executeUpdate();
	}

	public int countDevices(String countDevices, int gwId) throws SQLException {
		int countAssoDevices = -1;
	
		PreparedStatement preparedStatement = conn.prepareStatement(countDevices);
		preparedStatement.setInt(1, gwId);
		ResultSet rs = preparedStatement.executeQuery();
		if (rs.next()) {
			countAssoDevices = rs.getInt(1);
		}
		
		return countAssoDevices;
	}

}
