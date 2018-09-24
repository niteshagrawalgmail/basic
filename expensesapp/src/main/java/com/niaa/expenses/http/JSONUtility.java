package com.niaa.expenses.http;

import java.io.UnsupportedEncodingException;

import com.google.gson.Gson;

public class JSONUtility {
	
	public byte[] serialize(Object value) {
		return getBytes(new Gson().toJson(value));
	}

	private byte[] getBytes(String str) {
		if (str == null || str.isEmpty()) {
			return new byte[0];
		}
		try {
			return str.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			return str.getBytes();// NOSONAR
		}
	}
}
