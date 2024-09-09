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
 * Servlet implementation class insertServlet
 */
@WebServlet("/insertServlet")
public class insertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertServlet() {
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String p_name= request.getParameter("p_name");
		String p_price = request.getParameter("p_price");
		String p_qty = request.getParameter("p_qty");

		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String insertSQL = "Insert into gro_prod (P_Name,P_Price,P_Qty) VALUES(?,?,?)";
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/java","root1","root@123");
			PreparedStatement pst = con.prepareStatement(insertSQL);
			pst.setString(1, p_name);
			pst.setString(2, p_price);
			pst.setString(3, p_qty);
			pst.executeUpdate();
			out.println("Product Added");
			out.println("<a href=\"Validate\">Show Products</a>");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
