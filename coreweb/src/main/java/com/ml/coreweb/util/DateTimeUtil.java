package com.ml.coreweb.util;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

/**
 * BookWormV2
 * Created on 19/8/22 - Friday
 * User Khan, C M Abdullah
 * Ref:
 */
public class DateTimeUtil {
	public static final int OFF_SET_BD = 6;
	public static final ZoneOffset ZONE_OFFSET_BD = ZoneOffset.ofHours(OFF_SET_BD);
	public static ZonedDateTime timeNow() {
		return ZonedDateTime.now(ZONE_OFFSET_BD);
	}
	
	public static long timeNowToEpochSecond(){
		return timeNow().toInstant().toEpochMilli();
	}
}
