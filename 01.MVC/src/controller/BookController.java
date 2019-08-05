package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;
import dao.BookImpl;

@WebServlet(name = "BookController", urlPatterns= {"/publisher_select"})
public class BookController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		
		System.out.println(uri);
		
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex+1);
		
		req.setCharacterEncoding("utf-8");
		
		if(action.equals("publisher_select")) {
			BookDAO bookdao = new BookImpl();
			req.setAttribute("publisher", bookdao.selectByPublisher());
			
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/book/BookForm.jsp");
			rd.forward(req, resp);		
		}				
	}
}
