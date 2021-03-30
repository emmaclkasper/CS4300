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

import clss.Client;
import dao.DAO;

public class Signup_cnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao=new DAO();
    public Signup_cnt() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession(true);
		Cookie[] cookies = request.getCookies();
		String url;
		ArrayList<String> cate=new ArrayList<String>();
		Information info=new Information();
		cate=dao.listeCategories();
		
		System.out.println("inscrire");
		Client cl = new Client();
		Client c = new Client();
		c.setNom(request.getParameter("username"));
		c.setAdresse(request.getParameter("adress"));
		c.setTel(request.getParameter("phone"));
		c.setEmail(request.getParameter("email"));
		c.setMotpasse(request.getParameter("password"));
		dao.ajouterClient(c);
		Cookie cookie1 = new Cookie(c.getEmail(),c.getMotpasse());
		Cookie cookie2= new Cookie("nom",c.getEmail());
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		
		int n = dao.getIdClient(c.getEmail());
		cl = dao.nomClient(n);
		request.setAttribute("cate",cate);
		session.setAttribute("username", c.getNom());
		response.sendRedirect(request.getContextPath()+"/home");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
