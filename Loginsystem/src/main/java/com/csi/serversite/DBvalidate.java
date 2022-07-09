package com.csi.serversite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBvalidate {

	public static boolean isValidate (String custEmailID,String custPassword) {
		
		boolean status = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Customerdatabase","root","0708");
			PreparedStatement preparedStatement =connection.prepareStatement("SELECT * FROM customer where custmailid=? and custpasseord=?");
			preparedStatement.setString(1, custEmailID);
			preparedStatement.setString(2, custPassword);
			
			ResultSet resultSet= preparedStatement.executeQuery();
			status = resultSet.next();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
}
