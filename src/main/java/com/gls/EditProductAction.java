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
 * Servlet implementation class EditProductAction
 */
@WebServlet("/EditProductAction")
public class EditProductAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProductAction() {
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
		String id = request.getParameter("id");
		String p_name = request.getParameter("p_name");
		String p_price = request.getParameter("p_price");
		String p_qty= request.getParameter("p_qty");

		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String uptSQL = "Update gro_prod set p_name=? , p_price=? ,p_qty=? where id=?";
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/java","root1","root@123");
			PreparedStatement pst = con.prepareStatement(uptSQL);
			pst.setString(1, p_name);
			pst.setString(2, p_price);
			pst.setString(3,p_qty);
			pst.setString(4,id);

			pst.executeUpdate();
			
			out.println("Product Updated");
			out.println("<br><a href=\"validate\">Show Products</a>");
//			out.println("Book Updated");
			System.out.println("Product Updated");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
