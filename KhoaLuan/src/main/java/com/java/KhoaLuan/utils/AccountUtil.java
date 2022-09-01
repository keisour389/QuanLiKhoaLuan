package com.java.KhoaLuan.utils;

import java.util.Random;

import com.java.KhoaLuan.config.Constant;

public class AccountUtil {
	public static String passwordGenerator(int len) {
		String chars = Constant.CHARS;
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return sb.toString();
	}
} 
