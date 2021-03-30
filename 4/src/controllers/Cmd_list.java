package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;



public class Cmd_list extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Cmd_list() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		String submit=request.getParameter("submit");
		HttpSession session;
		Cookie[] cookies = request.getCookies();
		String cliencookie=null,passCli=null,emailCli=null,url=null,idAr=null, prix=null;
		DAO dao = new DAO();
		System.out.println(submit);
		
		
		session=request.getSession();
		String name=(String)session.getAttribute("username");
		int idCli = dao.getIdClient2(name);
		request.setAttribute("list",dao.commandeDuClient(idCli));
		request.getRequestDispatcher("Myorders.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
