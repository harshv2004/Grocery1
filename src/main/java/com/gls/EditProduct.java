package com.gls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditProduct
 */
@WebServlet("/EditProduct")
public class EditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		res.setContentType("text/html");
		PrintWriter out= res.getWriter();
		out.println("Edit Product");
		String id = req.getParameter("id");
		String p_name = req.getParameter("p_name");
        String p_price = req.getParameter("p_price");
        String p_qty = req.getParameter("p_qty");

        out.println(p_name);
        out.println("<form action='EditProductAction' method='POST'>");
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+id+"'/></td></tr>");  
        out.print("<tr><td>Product Name:</td><td><input type='text' name='p_name' value='"+p_name+"'/></td></tr>");  
        out.print("<tr><td>Price:</td><td><input type='text' name='p_price' value='"+p_price+"'/></td></tr>");
        out.print("<tr><td>Quantity:</td><td><input type='text' name='p_qty' value='"+p_qty+"'/></td></tr>"); 

        out.println("<tr><td></td><td><input type='submit'value='EditProduct'></td>");
        out.println("</table></form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
