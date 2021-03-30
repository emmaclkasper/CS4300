package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;


public class Cmd_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Cmd_controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		DAO dao=new DAO();
		String submit=request.getParameter("submit");
		if(submit==null) {
			request.setAttribute("cmd", dao.getcmd());
			request.getRequestDispatcher("cmd_list.jsp").forward(request, response);
			
			
		}else {
			int id=Integer.parseInt(request.getParameter("id"));
			dao.delcmd(id);
			request.setAttribute("cmd", dao.getcmd());
			request.getRequestDispatcher("cmd_list.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
