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

import net.memet.DBConnection.CategoryDAO;
import net.memet.models.Category;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    CategoryDAO categoryDAO;
	public void init() {
		categoryDAO = new CategoryDAO();
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
			case "/addcategory":
				addCategory(request, response);
				break;
			case "/deletecategory":
				deleteCategory(request, response);
				break;
			case "/updatecategory":
				updateCategory(request, response);
				break;
			case "/listcategory":
				listCategory(request, response);
				break;
			default:
				listCategory(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	public void listCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		List<Category> categories = categoryDAO.SellectAllCategory();
		request.setAttribute("listcategory", categories);
		RequestDispatcher rd = request.getRequestDispatcher("updatecategorypage.jsp");
		rd.forward(request, response);
	}
	
	public void addCategory(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		String name = request.getParameter("name");
		Category category = new Category(name);
		categoryDAO.AddCategory(category);
		response.sendRedirect("updatecategorypage.jsp");
	}
	
	public void updateCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		Category category =(new Category(id, name)); 
		categoryDAO.UpdateCategory(category);
		response.sendRedirect("updatecategorypage.jsp");
	}
	
	public void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		categoryDAO.DeleteCategory(id);
		response.sendRedirect("updatecategorypage.jsp");
	}
}
