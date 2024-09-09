package com.gls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Details
 */
@WebServlet("/Details")
public class Details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Details() {
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
		String id = request.getParameter("id");
		String p_name = request.getParameter("p_name");
		String p_price = request.getParameter("p_price");
		String p_qty= request.getParameter("p_qty");

		
		out.println("<html><body><center>");
		out.println("<h1>Product Name : "+p_name+"</h1>");
		out.println("<h1>Product Price : "+p_price+"</h1>");
		out.println("<h1>Product quantity : "+p_qty+"</h1>");

		
//		Links to update delete 
		String delUrl = "delete?id"+id;
		out.println("<a href='"+delUrl+"'>"+"delete"+"</a>");
		
		String editUrl = "EditProduct?id="+id+"&p_name="+p_name+"&p_price="+p_price;
		out.println("<a href='"+editUrl+"'>"+"Edit"+"</a>");
		
		String linkUrl = "login.jsp";
		out.println("<a href='"+linkUrl+"'>"+"Home"+"</a>");
		
		out.println("<center></body>");
		out.println("</html>");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
