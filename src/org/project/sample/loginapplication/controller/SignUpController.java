package org.project.sample.loginapplication.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.sample.loginapplication.model.service.UserIdGeneratror;
@WebServlet(urlPatterns="/signup")
public class SignUpController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ControllerClassbegining");
		String First_Name = req.getParameter("fn");
		String Last_Name = req.getParameter("ln");
		String Email = req.getParameter("em");
		String Passwd = req.getParameter("pw");
		String Repeat_Password = req.getParameter("rpw");
		String Password = "";
		if (Passwd.equals(Repeat_Password)) {
			Password = Passwd;
		} else {
			resp.sendRedirect("sign_up.html");
		}
		UserIdGeneratror uig = new UserIdGeneratror();
		uig.generateUserId(First_Name, Last_Name, Email, Password);
		System.out.println("ControllerClasslast");
	}

}
