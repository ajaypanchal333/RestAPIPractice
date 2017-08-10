package com.group1.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.group1.data.DbMgr;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/Registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		
		
		ServletContext context = getServletContext();
		DbMgr dbMgr= (DbMgr)context.getAttribute("DbMgr");
		Connection conn= dbMgr.getConnection();
		String InsertQuery = "insert into users" +"(user_id, user_name, email, country user_password)" + " values(?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(InsertQuery);
			ps.setString(1, userName+email);
			ps.setString(2, userName);
			ps.setString(3,email);
			ps.setString(4,country);
			ps.setString(5,password);
			ps.executeQuery();
		}
		catch (SQLException ex) {
			Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE,null, ex);
			
		}
		
		response.setContentType("text/html;charset=utf-8");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	 doGet(request, response);
	}

}
