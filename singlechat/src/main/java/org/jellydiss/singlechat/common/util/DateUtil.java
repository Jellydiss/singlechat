package org.jellydiss.singlechat.common.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	private static final DateFormat dateFormat = 
			new SimpleDateFormat("yyyyMMddHHmmss");
	
	public static String getCurrentTime(){
		return dateFormat.format(new Date());
	}
}
