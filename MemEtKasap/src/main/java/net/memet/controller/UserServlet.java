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

import net.memet.DBConnection.UserDAO;
import net.memet.models.User;


/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/User")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       UserDAO userDAO;
	public void init() {
		userDAO = new UserDAO();
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
			case "/insert":
				signUp(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			case "/list":
				listUser(request, response);
				break;
			default:
				signUp(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	public void listUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		List<User> users = userDAO.SellectAllUsers();
		request.setAttribute("listUser", users);
		RequestDispatcher rd = request.getRequestDispatcher("userlist.jsp");
		rd.forward(request, response);
	}
	
	public void signUp(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		String address = request.getParameter("address");
		User user = new User(name,mail,password,role,address);
		userDAO.InsertUser(user);
		response.sendRedirect("mainpageforuser.jsp");
	}
	public void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		String address = request.getParameter("address");
		User user =(new User(id, name, mail, password, role, address)); 
		userDAO.UpdateUser(user);
		response.sendRedirect("updateuserpage.jsp");
	}
	public void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		userDAO.DeleteUser(id);
		response.sendRedirect("adminpage.jsp");
	}
}
