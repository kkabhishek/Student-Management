package org.project.sample.loginapplication.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.sample.loginapplication.model.dao.SignInDao;

@WebServlet(urlPatterns = "/signin")
public class SignInController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Email = req.getParameter("eml");
		String Password = req.getParameter("paswd");
		System.out.println("signin controller first");
		SignInDao sid = new SignInDao();
		String First_Name = sid.fetchUserData(Email, Password);
		if (First_Name.isEmpty()) {
			resp.sendRedirect("sign_in.html");
		} else {
			req.setAttribute("firstName", First_Name );
			RequestDispatcher rd = req.getRequestDispatcher("New.jsp");
			rd.forward(req, resp);
			//resp.sendRedirect("user_profile.html");
		}
		System.out.println("signin controller first");
	}
}
