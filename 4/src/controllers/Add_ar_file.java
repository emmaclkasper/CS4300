package controllers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import clss.Article;
import dao.DAO;

public class Add_ar_file extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Add_ar_file() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		DAO dao=new DAO();
		String UPLOAD_DIRECTORY = "/home/ucef/MyprojectMVC/MiniProjetEcommerce_MVC/WebContent/img/";
        if (ServletFileUpload.isMultipartContent(request)) {
            try {
            	List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(new ServletRequestContext(request));
                String titre= null,aut= null,cate= null;int prix= 0,stock= 0;
                String name = null;
                for (FileItem item : multiparts) {
                    if (!item.isFormField()) {
                        name = new File(item.getName()).getName();
                        item.write(new File(UPLOAD_DIRECTORY + File.separator + name));
                        //System.out.println(name);
                        
                    } else {
                        InputStream input = item.getInputStream();
                        if (item.getFieldName().equals("design")) {
                            byte[] str = new byte[input.available()];
                            input.read(str);
                            titre = new String(str, "UTF8");System.out.println(titre);

                        }
                        if (item.getFieldName().equals("aut")) {
                            byte[] str = new byte[input.available()];
                            input.read(str);
                            aut = new String(str, "UTF8");
                        }
                        if (item.getFieldName().equals("cat")) {
                            byte[] str = new byte[input.available()];
                            input.read(str);
                            cate = new String(str, "UTF8");
                        }
                        if (item.getFieldName().equals("prix")) {
                            byte[] str = new byte[input.available()];
                            input.read(str);
                            prix = Integer.parseInt(new String(str, "UTF8"));
                        }
                        if (item.getFieldName().equals("stock")) {
                            byte[] str = new byte[input.available()];
                            input.read(str);
                            stock = Integer.parseInt(new String(str, "UTF8"));
                        }
                    }
                }
                String photo =name;
                Article ar=new Article();
                ar.setDesignation(titre);
                ar.setAuteur(aut);
                ar.setCategorie(cate);
                ar.setPhoto(photo);
                ar.setPrix(prix);
                ar.setStock(stock);
                dao.addart(ar);
                }catch (Exception ex) {
            		ex.printStackTrace();
            		//request.getRequestDispatcher("/Add_ar.jsp").forward(request, response);
            }
        }
		response.sendRedirect(request.getContextPath()+"/admin");
       // request.getRequestDispatcher("/Home_admin.jsp").forward(request, response);	
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
