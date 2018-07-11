package com.musala.gateways.business;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.musala.gateways.entity.Gateway;
import com.musala.gateways.helper.SQLConstants;
import com.musala.gateways.helper.SQLGatewayHelper;

public class GatewayImpl {

	@Autowired
	public static SQLGatewayHelper sql = new SQLGatewayHelper();


	public static List<Gateway> retrieveAllGateways() {
		List<Gateway> result = null;
		try {
			return sql.retrieveAllGateways(SQLConstants.GET_GATEWAYS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static List<Gateway> retrieveGatewayWithDevices(final int gwId) {
		List<Gateway> result = null;
		try {
			return sql.retrieveAllGateways(SQLConstants.GET_GATEWAY_BY_ID, gwId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static List<Gateway> retrieveAllGatewaysWithDevices() {
		List<Gateway> result = null;
		try {
			result = sql.retrieveAllGatewaysWithDevices(SQLConstants.GET_GATEWAYS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void deleteGWById(int gwId) {

		try {
			sql.deleteGWById(SQLConstants.DELETE_GATEWAY_BY_ID, gwId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void insertGateway(Gateway gateway) {

		try {
			sql.insertGateway(SQLConstants.INSERT_GATEWAY, gateway);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
