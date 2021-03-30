package controllers;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;

public class Cmd_cnt extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Cmd_cnt() {
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
		
		if(submit.equals("check out")){
			session=request.getSession();
			String name=(String)session.getAttribute("username");
			int qte=Integer.parseInt(request.getParameter("nbr"));
			
			int id=Integer.parseInt(request.getParameter("id"));
			int idCli = dao.getIdClient2(name);
			System.out.println(qte+id+idCli);
			dao.ajouterCommande(id, idCli,qte);
			//.setCommandeReussi("Votre Commande est enregistr�e avec succ�s, vous allez la recevoir dans 2 jours !");
			ArrayList<Integer> val=new ArrayList<>();
			val=(ArrayList<Integer>) session.getAttribute("panier");
			if(val.size()==1) val.clear();
			else {
			for (int i=0;i<val.size();i++) {
				if(i==id) val.remove(i);
			}}
			session.setAttribute("panier", val);
			url="successCommande.jsp";
			request.getRequestDispatcher(url).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
