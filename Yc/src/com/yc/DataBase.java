package com.yc;

import java.util.Vector;

public class DataBase {
	private static String COL_ID = "ID";
	private static String COL_NAME = "NAME";
	private static String COL_GENDER = "GENDER";
	private static String COL_AGE = "AGE";
	public static Vector showColumns = new Vector();
	public static Vector noShowColumns = new Vector();
	
	static{
		noShowColumns.add(COL_ID); 
		noShowColumns.add(COL_GENDER); 
		showColumns.add(COL_NAME); 
		showColumns.add(COL_AGE); 
	}
	
}
