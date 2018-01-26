package org.project.sample.loginapplication.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignUpDao {
	public void saveUserData(String User_Id, String First_Name, String Last_Name, String Email, String Password) {
		System.out.println("DaoClass beginig");
		String qry = "insert into user_data.user_details values(?,?,?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "3505");
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setString(1, User_Id);
			ps.setString(2, First_Name);
			ps.setString(3, Last_Name);
			ps.setString(4, Email);
			ps.setString(5, Password);
			ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("dao class ending");

	}

}
