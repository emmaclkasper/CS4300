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


public class Login_cnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       DAO dao=new DAO();

    public Login_cnt() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession(true);
		Cookie[] cookies = request.getCookies();
		String url;
		ArrayList<String> cate =new ArrayList<>();
		
			System.out.println("login");
			String emailCli = request.getParameter("email");
			String passCli = request.getParameter("password");
			System.out.println(emailCli+passCli);
			String message="L'email ou le mot de passe incorrect";
			if(dao.validerCompte(emailCli,passCli)){
				
				System.out.println("ok");
				Client cl = new Client();
				int n = dao.getIdClient(emailCli);
				cl=dao.nomClient(n);
				url="home";
				session.setAttribute("username", cl.getNom());
				response.sendRedirect(request.getContextPath()+"/home");
				//request.getRequestDispatcher(url).forward(request, response);
				Cookie cookie1 = new Cookie(emailCli,passCli);
				Cookie cookie2= new Cookie("nom",emailCli);
				response.addCookie(cookie1);
				response.addCookie(cookie2);
			}else if(dao.valideradmin(emailCli,passCli)){
				url="/admin";
				session.setAttribute("admin","admin");
				response.sendRedirect(request.getContextPath()+url);
				Cookie cookie1 = new Cookie(emailCli,passCli);
				Cookie cookie2= new Cookie("nom",emailCli);
				response.addCookie(cookie1);
				response.addCookie(cookie2);
			}
			else{
				if(request.getParameter("lang")!=null) {
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
				else {
				System.out.println("pas bon");
				url="login.jsp";
				request.getRequestDispatcher(url).forward(request, response);}
			}

			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
