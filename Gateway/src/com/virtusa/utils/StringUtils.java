package com.virtusa.utils;

import java.util.Arrays;

public class StringUtils {
	public static boolean isNullOrEmpty(String str) {
        if(str != null && !str.isEmpty())
            return false;
        return true;
    }
	public static String arrayToString(String[] str) {
		String searchString = Arrays.toString(str).replace(",","").replace("[","").replace("]","");
		return searchString;		
	}
}
