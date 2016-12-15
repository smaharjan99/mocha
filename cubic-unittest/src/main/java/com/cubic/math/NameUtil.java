package com.cubic.math;

public class NameUtil {
	public String getFullName(final String firstName, final String lastName) {
		String result = "";
		if (firstName != null) {
			result += firstName;
		}
		if (firstName != null && lastName != null) {
			result += "";
		}
		if (lastName != null) {
			result += lastName;
		}
		return result;
	}

}
