package com.george.GnuCashAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InterestIncome {
    private double db_result_value;

    public static void main(String[] args) {
	double interest_gain = new InterestIncome().getInterestIncomeSinceDate();
	System.out.println(interest_gain);
    }

    public double getInterestIncomeSinceDate() {
	Connection connection = null;
	try {
	    Class.forName("org.postgresql.Driver");
	    connection = DriverManager.getConnection("jdbc:postgresql://thinkpad:5432/gnucash", "postgres",
						     "stenia1981");
	    PreparedStatement psmt = connection.prepareStatement("select interest_gain('2022-01-01')");
	    ResultSet rs = psmt.executeQuery();
	    while (rs.next()) {
		db_result_value = rs.getDouble("interest_gain");
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
