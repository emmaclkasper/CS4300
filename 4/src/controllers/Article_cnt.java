package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;


public class Article_cnt extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Article_cnt() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		DAO dao=new DAO();
		String submit=request.getParameter("submit");
		System.out.println("test");
		
		if(submit==null) {
			request.setAttribute("articles", dao.getarlist());
			request.getRequestDispatcher("Home_admin.jsp").forward(request, response);
		}else if(submit.equals("del")) {
			int id=Integer.parseInt(request.getParameter("id"));
			dao.delart(id);
			request.setAttribute("articles", dao.getarlist());
			request.getRequestDispatcher("Home_admin.jsp").forward(request, response);
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
