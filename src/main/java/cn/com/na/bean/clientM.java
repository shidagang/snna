package cn.com.na.bean;

import cn.com.na.utils.PhapiAesUtil;

public class clientM {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String encode = PhapiAesUtil.encode(String.valueOf(3),Constants.ACC_KEY);
		System.out.println(encode);
		String decode1 = PhapiAesUtil.decode("F0BD8DE6F743825949D9AA179A6359A0",Constants.ACC_KEY);
		System.out.println(decode1);
	}

}
