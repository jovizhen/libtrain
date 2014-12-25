package com.gcit.library.util;

public class StringHelper
{
	public static boolean emptyOrNullString(String string)
	{
		if (string == null)
			return true;
		else if (string.length() == 0)
			return true;
		return false;
	}
}
