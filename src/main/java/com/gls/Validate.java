package com.gls;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Validate
 */
@WebServlet("/Validate")
public class Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/java","root1","root@123");
			PreparedStatement pst = con.prepareStatement("Select * from gro_prod");
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
//				
				String id = rs.getString(1);
				String p_name = rs.getString(2);
				String p_price = rs.getString(3);
				String p_qty = rs.getString(4);
				
				String linkURL = "Details?bname=" + p_name + "&bprice="+p_price+"&id="+id+"&p_qty="+p_qty; 
				out.println("<html>");
				out.println("<body>");
				out.println("<a href='"+linkURL+"'>"+p_name+"</a>");
				out.println("</body>");
				out.println("</html>");
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);

		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/java","root1","root@123");
			PreparedStatement pst = con.prepareStatement("Select * from gro_user where User_Name=? and Password=?");
			pst.setString(1, uname);
			pst.setString(2, password);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next())
			{
				response.sendRedirect("sucess.jsp");
			}
			else
			{
				response.sendRedirect("error.jsp");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
