package com.musala.gateways.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.musala.gateways.business.DeviceImpl;
import com.musala.gateways.entity.Device;
import com.musala.gateways.entity.Gateway;

/**
 * Manages gateway DB data 
 *
 */
public class SQLGatewayHelper {

	static Connection conn = null;

	private void init() throws ClassNotFoundException, SQLException {
		
		Class.forName("org.h2.Driver");
		conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
	}

	public SQLGatewayHelper() {
		try {
			this.init();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retrieves all gateway from DB
	 * 
	 * @param getGateways
	 * @return
	 * @throws SQLException
	 */
	public List<Gateway> retrieveAllGateways(String getGateways) throws SQLException {

		Statement stmt = null;
		List<Gateway> retrievedGW = new ArrayList<>();
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(getGateways);

		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String ipv4 = rs.getString("ipv4");
			System.out.println(id + ", " + name + ", " + ipv4);
			retrievedGW.add(new Gateway(id, name, ipv4));
		}
		return retrievedGW;

	}

	/**
	 * Retrieves information for one exact gateway with all devices 
	 * 
	 * @param getGatewayById
	 * @param gwId
	 * @return
	 * @throws SQLException
	 */
	public List<Gateway> retrieveAllGateways(String getGatewayById, int gwId)
			throws SQLException {
		PreparedStatement preparedStatement = conn.prepareStatement(getGatewayById);
		preparedStatement.setInt(1, gwId);
		ResultSet rs = preparedStatement.executeQuery();
		List<Gateway> retrievedGW = new ArrayList<>();
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String ipv4 = rs.getString("ipv4");
			System.out.println(id + ", " + name + ", " + ipv4);
			List<Device> assoDevices = DeviceImpl.retrieveDevicesOnGW(id);
			retrievedGW.add(new Gateway(id, name, ipv4, assoDevices));
		}

		return retrievedGW;
	}

	/**
	 * Retrieves information for all gateways with all devices 
	 * 
	 * @param getGateways
	 * @return
	 * @throws SQLException
	 */
	public List<Gateway> retrieveAllGatewaysWithDevices(String getGateways)
			throws SQLException {

		Statement stmt = null;
		List<Gateway> retrievedGW = new ArrayList<>();
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(getGateways);

		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String ipv4 = rs.getString("ipv4");
			System.out.println(id + ", " + name + ", " + ipv4);
			List<Device> assoDevices = DeviceImpl.retrieveDevicesOnGW(id);
			retrievedGW.add(new Gateway(id, name, ipv4, assoDevices));
		}
		return retrievedGW;
	}

	/**
	 * Deletes concrete gateway by its id.
	 * Deletes also all corresponding devices.
	 * 
	 * @param deleteGatewayById
	 * @param gwId
	 * @throws SQLException
	 */
	public void deleteGWById(String deleteGatewayById, int gwId) throws SQLException {

		PreparedStatement preparedStatement = conn.prepareStatement(deleteGatewayById);
		preparedStatement.setInt(1, gwId);
		preparedStatement.executeUpdate();

	}

	/**
	 * Insert new gateway
	 * 
	 * @param insertGateway
	 * @param gateway
	 * @throws SQLException
	 */
	public void insertGateway(String insertGateway, Gateway gateway) throws SQLException {

		PreparedStatement preparedStatement = conn.prepareStatement(insertGateway);
		preparedStatement.setString(1, gateway.getName());
		preparedStatement.setString(2, gateway.getIpv4());

		preparedStatement.executeUpdate();

	}

}
