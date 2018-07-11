package com.musala.gateways.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.musala.gateways.business.DeviceImpl;

/**
 * 
 * Helper class for validations
 */
public class Validator {

	/**
	 * Basic ipv4 validation
	 * 
	 * @param ipv4
	 * @return
	 */
	public static boolean validateIPv4(String ipv4) {

		String ipv4Validator = "^.*([0-9]{1,3}\\.){3}[0-9]{1,3}.*$";
		Pattern p = Pattern.compile(ipv4Validator);

		Matcher m = p.matcher(ipv4);
		if (m.find()) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Validation if number of devices corresponding to one gateway is under 10.
	 * Executes sql count.
	 * 
	 * @param gateway_id
	 * @return
	 */
	public static boolean checkIfPossibleInsert(int gateway_id) {

		int countAssoDevices = DeviceImpl.countDevices(gateway_id);

		if (countAssoDevices < 10 && countAssoDevices > 0) {
			return true;
		}

		return false;
	}
}
