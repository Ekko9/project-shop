package com.user.utils;

import java.util.UUID;



public class UUIDUtils {
	
	public static  String  getUuuids() {
		
		String str = UUID.randomUUID().toString().replace("-", "");
		return str;
	}


}
