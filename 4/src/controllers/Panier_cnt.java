package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clss.Panier;
import dao.DAO;


public class Panier_cnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String Msgpanier;
	public String getMsgpanier() {
		return Msgpanier;
	}


	public void setMsgpanier(String msgpanier) {
		Msgpanier = msgpanier;
	}


	public Panier_cnt() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String submit=request.getParameter("submit");
		HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies();
		String url = null;
		DAO dao = new DAO();
		Information info=new Information();
		
		 if(submit ==null) {
			if(request.getParameter("lang")!=null) {
				request.getRequestDispatcher("addcart").forward(request, response);
			}
		}
		 else if(submit.equals("add")){
			int idAr = Integer.parseInt(request.getParameter("id"));
				System.out.println("my cart");
				ArrayList<Integer> s=new ArrayList<>();
				
				if(session.getAttribute("panier")=="" || session.getAttribute("panier")==null){
					s.add(idAr);
					session.setAttribute("panier",s);
					url="add_panier.jsp";
				}else {
					s=(ArrayList<Integer>) session.getAttribute("panier");
					if(s.contains(idAr)) {url="Home.jsp";}
					else {
					s.add(idAr);
					session.setAttribute("panier",s);
					url="add_panier.jsp";}
					for (Integer integer : s) {
						System.out.println(integer);
					}
				}
			info.setMsgpanier("Le produit est ajouté au panier avec succées");
			request.setAttribute("info",info);
			request.getRequestDispatcher(url).forward(request, response);
		}
		//-----------------visualiser--------------------
		else if(submit.equals("mycart")){
					if(session.getAttribute("panier")==null) {
						url="emptycart.jsp";
					}else {
					ArrayList<Panier> pa=new ArrayList<>();		
					ArrayList<Integer> s=new ArrayList<>();
					s=(ArrayList<Integer>) session.getAttribute("panier");
					for (Integer integer : s) {
						pa.add(dao.getcart(integer));
					}
					info.setCart(pa);
					url="mycart.jsp";}
					request.setAttribute("info",info);
					request.getRequestDispatcher(url).forward(request, response);
				}
		//----------------vider---------------------
		else if(submit.equals("viderpanier")){
					//session.invalidate();
					session.removeAttribute("panier");
					url="espaceClient.jsp";
				}
		
				
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
