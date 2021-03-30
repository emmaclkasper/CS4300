package controllers;



import java.util.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.*;
import clss.*;

public class Controleur extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private DAO dao;
	 ArrayList<String> cate=new ArrayList<String>();
	 String ls;
	 Information info=new Information();
	public void init(){
		dao=new DAO();
	}
	
	public static int i=0;
	@Override
	protected void doGet(HttpServletRequest request,
	HttpServletResponse response) throws ServletException, IOException {
		cate=dao.listeCategories();
		HttpSession session = request.getSession();
		String url=null;
		String submit=request.getParameter("submit");;
		if(submit!=null){

		if(submit.equals("detail")){
			try{
			int id=Integer.parseInt(request.getParameter("id"));
			info.setDetail(dao.detailArticle(id));
			
			}
			catch(RuntimeException e){
				e.getMessage();
			}
			url="details.jsp";
			request.setAttribute("info",info);
			request.getRequestDispatcher(url).forward(request, response);
		}

				if(submit.equals("viderpanier")){
					session.invalidate();
					url="espaceClient.jsp";
				}			
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, 
	HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
