package org.project.sample.loginapplication.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignInDao {

	public String fetchUserData(String Email, String Password) {
		System.out.println("signindao start");
		String qry = "SELECT First_Name,Last_Name FROM user_data.user_details WHERE Email=? AND Password=?";
		String Last_Name = "";
		String First_Name = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "3505");
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setString(1, Email);
			ps.setString(2, Password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				First_Name = rs.getString(1);
				Last_Name = rs.getString(2);
				System.out.println(First_Name + " " + Last_Name);

			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return First_Name;
	}

}
