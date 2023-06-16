package net.memet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.memet.DBConnection.ShoppingHistoryDAO;
import net.memet.models.Product;
import net.memet.models.ShoppingHistory;

public class ShoppingHistoryServlet {
	/**
	 * Servlet implementation class historyServlet
	 */
	@WebServlet("/historyServlet")
	public class historyServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
	    ShoppingHistoryDAO historyDAO;
		public void init() {
			historyDAO = new ShoppingHistoryDAO();
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
				case "/addhistory":
					addhistory(request, response);
					break;
				case "/deletehistory":
					deletehistory(request, response);
					break;
				case "/updatehistory":
					updatehistory(request, response);
					break;
				case "/listhistory":
					listhistory(request, response);
					break;
				default:
					listhistory(request, response);
					break;
				}
			} catch (SQLException ex) {
				throw new ServletException(ex);
			}
		}
		public void listhistory(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
			List<ShoppingHistory> historys = historyDAO.SellectAllShoppingHistorys();
			request.setAttribute("listUser", historys);
			RequestDispatcher rd = request.getRequestDispatcher("userlist.jsp");
			rd.forward(request, response);
		}
		
		public void addhistory(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
			int shid = Integer.parseInt(request.getParameter("Shid"));
			int uid = Integer.parseInt(request.getParameter("Uid"));
			List<String> list = List.of(request.getParameter("list"));
			Time time= Time.valueOf(request.getParameter("time"));
			String address = String.valueOf(request.getParameter("address"));
			ShoppingHistory history = new ShoppingHistory(shid,uid,list,address,time);
			historyDAO.AddShoppingHistory(history);
			response.sendRedirect("mainpageforuser.jsp");
		}
		
		public void updatehistory(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
			int shid = Integer.parseInt(request.getParameter("Shid"));
			int uid = Integer.parseInt(request.getParameter("Uid"));
			List<String> list = List.of(request.getParameter("list"));
			Time time= Time.valueOf(request.getParameter("time"));
			String address = String.valueOf(request.getParameter("address"));
			ShoppingHistory history =(new ShoppingHistory(shid, uid, list,address, time)); 
			historyDAO.UpdateShoppingHistory(history);
			response.sendRedirect("updateuserpage.jsp");
		}
		public void deletehistory(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
			int id = Integer.parseInt(request.getParameter("Pid"));
			historyDAO.DeleteShoppingHistory(id);
			response.sendRedirect("adminpage.jsp");
			
		}
	}
}