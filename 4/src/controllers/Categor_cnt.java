package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Categor_cnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String cat;
	
    public String getCat() {
		return cat;
	}
	public void setCat(String cat) {
		this.cat = cat;
	}

	public Categor_cnt() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Categor_cnt t=new Categor_cnt();
		System.out.println("cat");
		String ls = request.getParameter("cate");
		t.setCat(ls);
		request.setAttribute("cat",t);
		request.getRequestDispatcher("Home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
