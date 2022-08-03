package com.george.GnuCashAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class USAssetsTotal {
    private double db_result_value;

    public static void main(String[] args) {
	double rate = new USAssetsTotal().getUSAssetsTotalData();
	System.out.println(rate);
    }

    public double getUSAssetsTotalData() {
	Connection connection = null;
	try {
	    Class.forName("org.postgresql.Driver");
	    connection = DriverManager.getConnection("jdbc:postgresql://thinkpad:5432/gnucash", "postgres",
						     "stenia1981");
	    PreparedStatement psmt = connection.prepareStatement("select us_total_proc()");
	    ResultSet rs = psmt.executeQuery();
	    while (rs.next()) {
		db_result_value = rs.getDouble("us_total_proc");
	    }
	} catch (Exception e) {
	    throw new RuntimeException(e);
	} finally {
	    if (connection != null)
		try {
		    connection.close();
		} catch (Exception e) {
		}
	}
	return db_result_value;
    }
}
