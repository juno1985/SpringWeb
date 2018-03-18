package common;

import java.util.UUID;

public class UUIDUtil {
	
	public static String UUIDGenerator(){
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		return uuid;
	}

}
