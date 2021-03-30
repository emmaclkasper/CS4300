package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;

public class Homme_cnt extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Homme_cnt() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		DAO dao=new DAO();
		String url;
		ArrayList<String> cate =new ArrayList<>();
		cate=dao.listeCategories();
		request.setAttribute("cate",cate);
		
		if(request.getParameter("lang")!=null) {
			request.getRequestDispatcher("Home.jsp").forward(request, response);
		}else {
		
		request.getRequestDispatcher("Home.jsp").forward(request, response);}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
