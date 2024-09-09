package com.gls;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddData
 */
@WebServlet("/AddData")
public class AddData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		try
		{
			PrintWriter out = response.getWriter();
			String s_name = request.getParameter("s_name");
			String u_name = request.getParameter("u_name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
//			Class.forName("com.mysql.cj.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/java","root1","root@123");
			PreparedStatement pst = con.prepareStatement("INSERT INTO gro_user(Shop_Name,User_Name,Email,Password) values (?,?,?,?)");
			pst.setString(1, s_name);
			pst.setString(2, u_name);
			pst.setString(3, email);
			pst.setString(4, password);
			pst.executeUpdate();
			out.println("Successfully");
			
			response.sendRedirect("login.jsp");
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
