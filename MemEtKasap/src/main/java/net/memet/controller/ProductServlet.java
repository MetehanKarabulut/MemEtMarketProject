package net.memet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.memet.DBConnection.ProductDAO;
import net.memet.models.Product;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ProductDAO productDAO;
	public void init() {
		productDAO = new ProductDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/addproduct":
				addProduct(request, response);
				break;
			case "/deleteproduct":
				deleteProduct(request, response);
				break;
			case "/updateproduct":
				updateProduct(request, response);
				break;
			case "/listproduct":
				listProduct(request, response);
				break;
			default:
				listProduct(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	public void listProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		List<Product> products = productDAO.SellectAllProducts();
		request.setAttribute("listUser", products);
		RequestDispatcher rd = request.getRequestDispatcher("userlist.jsp");
		rd.forward(request, response);
	}
	
	public void addProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		int id = Integer.parseInt(request.getParameter("Pid"));
		int categoryid = Integer.parseInt(request.getParameter("Cid"));
		String name = request.getParameter("Pname");
		float stock = Float.parseFloat(request.getParameter("stock"));
		float price = Float.parseFloat(request.getParameter("price"));
		Product product = new Product(id,categoryid,name,stock,price);
		productDAO.addProduct(product);
		response.sendRedirect("mainpageforuser.jsp");
	}
	
	public void updateProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("Pid"));
		int categoryid = Integer.parseInt(request.getParameter("Cid"));
		String name = request.getParameter("Pname");
		float stock = Float.parseFloat(request.getParameter("stock"));
		float price = Float.parseFloat(request.getParameter("price"));
		Product product =(new Product(id, categoryid, name,stock, price)); 
		productDAO.UpdateProduct(product);
		response.sendRedirect("updateuserpage.jsp");
	}
	public void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("Pid"));
		productDAO.DeleteProduct(id);
		response.sendRedirect("adminpage.jsp");
	}
}
