package org.project.sample.loginapplication.model.service;

import java.util.Random;

import org.project.sample.loginapplication.model.dao.SignUpDao;

public class UserIdGeneratror {
	public void generateUserId(String First_Name, String Last_Name, String Email, String Password) {
		System.out.println("service class begining");
		Random rd = new Random();
		int number = rd.nextInt();
		String User_Id = "";
		if (number > 100000) {
			User_Id = "First_Name" + number;
		}
		SignUpDao sud = new SignUpDao();
		sud.saveUserData(User_Id, First_Name, Last_Name, Email, Password);
		System.out.println("Service class ending");
	}

}
