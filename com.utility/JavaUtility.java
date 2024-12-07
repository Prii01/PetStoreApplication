package com.utility;

import java.time.LocalDateTime;
import java.util.Random;
/**
 * JavaUtility is used to write java related utility codes like random number, time stamp and etc...
 */
public class JavaUtility {
	
	/**
	 * getRandonNumber() is used to generate random number
	 * @return random number
	 */
	public static int getRandomNumber() {
		return new Random().nextInt(9999);
	}
	
	/**
	 * getTimeStamp() is used to fetch the local data & time
	 * @return system data
	 */
	public static String getTimeStamp() {
		return LocalDateTime.now().toString().replace(":", "-");
	}
}
