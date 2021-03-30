package dao;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import clss.Article;
import clss.Client;
import clss.Commande;
import clss.Panier;


public class DAO {

	Connection connection=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	public void ajouterClient(Client c) {
		connection = DatabaseConnection.getConnection();
		try {
			ps = connection.prepareStatement("INSERT INTO client (nom, email, adresse, telephone, password) values(?,?,?,?,?)");
		    ps.setString(2, c.getEmail());
		    ps.setString(1, c.getNom()); 
		    ps.setString(3, c.getAdresse());
		    ps.setString(4, c.getTel());
		    ps.setString(5, c.getMotpasse());
		    ps.executeUpdate();
		    ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean validerCompte(String em, String pass) {
		connection = DatabaseConnection.getConnection();
		boolean bol=false;
		try {
			String email=null;
			ps = connection.prepareStatement("SELECT *FROM client where email =? ");
			ps.setString(1, em);
			//ps.setString(2, pass);
			rs = ps.executeQuery();
			if(rs.next()){
				email=rs.getString("email");
				//passe=rs.getString("motpasse");
			}
			if(email!=null && pass.equals(rs.getString("password"))) bol=true;
			else {bol=false;}
			ps.close();
		} catch (SQLException e2) {
			// TODO: handle exception
		}
		return bol;
	}
	public boolean valideradmin(String em, String pass) {
		connection = DatabaseConnection.getConnection();
		boolean bol=false;
		try {
			String email=null;
			ps = connection.prepareStatement("SELECT *FROM admin where email =? ");
			ps.setString(1, em);
			//ps.setString(2, pass);
			rs = ps.executeQuery();
			if(rs.next()){
				email=rs.getString("email");
				//passe=rs.getString("motpasse");
			}
			if(email!=null && pass.equals(rs.getString("password"))) bol=true;
			else {bol=false;}
			ps.close();
		} catch (SQLException e2) {
			// TODO: handle exception
		}
		return bol;
	}
	
	public ArrayList<String> listeCategories(){
		ArrayList<String> lis = new ArrayList<>();
		connection = DatabaseConnection.getConnection();
		try {
			ps=connection.prepareStatement("select DISTINCT(nom) from categorie ");
			rs=ps.executeQuery();
		    while(rs.next()){
		    	lis.add(rs.getString("nom"));
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		return lis;
	}
	public ArrayList<Article> articlesParCategorie(String categorie) {
		
		ArrayList<Article> article = new ArrayList<Article>();
		connection = DatabaseConnection.getConnection();
	try {
		ps = connection.prepareStatement("select ar.id, ar.design, ar.auth, ar.img, ar.prix, ar.cat from article as ar, categorie as cat where cat.nom=ar.cat and cat.nom = ?");
	    ps.setString(1, categorie);
		rs=ps.executeQuery();
	    while(rs.next()){
	    Article a= new Article();
	        a.setId(rs.getInt("id"));
	    	a.setDesignation(rs.getString("design"));
	    	a.setAuteur(rs.getString("auth"));
	    	a.setPhoto(rs.getString("img"));
	    	a.setPrix(rs.getDouble("prix"));
	    	article.add(a);
	    }
	    ps.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return article;
	}

	
	public Article detailArticle(int codeA) {
		Article a = null;
        connection = DatabaseConnection.getConnection();
	try {
		ps = connection.prepareStatement("select *from article where id = ?");
	    ps.setInt(1, codeA);
		rs=ps.executeQuery();
	    if(rs.next()){
	        a= new Article();
	        a.setId(codeA);
	    	a.setDesignation(rs.getString("design"));
	    	a.setAuteur(rs.getString("Auth"));
	    	a.setStock(rs.getInt("stock"));
	    	a.setPhoto(rs.getString("img"));
	    	a.setPrix(rs.getDouble("prix"));
	    	
	    }
	    ps.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return a;
	}

	
	public void ajouterCommande(int codeArticle, int codeClient,int qte) {
		
		connection = DatabaseConnection.getConnection();
				try {
						ps = connection.prepareStatement("INSERT INTO commande(id_client,id_article,date,qte) VALUES(?,?,?,?)");
						ps.setInt(1, codeClient);
						ps.setInt(2, codeArticle);
						ps.setString(3, new java.util.Date().toString());
						ps.setInt(4, qte);
						ps.executeUpdate();
						System.out.println("b1 inserer");
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

	
	public List<Commande> commandeDuClient(int numClient) {
		List<Commande> cmd = new ArrayList<>();
		connection = DatabaseConnection.getConnection();
	try {
		ps = connection.prepareStatement("select ar.design,cm.qte,cm.date from article ar,commande cm where cm.id_article=ar.id AND cm.id_client=?");
	    ps.setInt(1, numClient);
		rs=ps.executeQuery();
		Commande c=null;
	    while(rs.next()){
	       c=new Commande();
	       c.setDesign(rs.getString("design"));
	       c.setDate(rs.getString("date"));
	       c.setQte(rs.getInt("qte"));
	        cmd.add(c);
	    }
	   
	} catch (Exception e) {
		e.printStackTrace();
	}
	return cmd;
		
	}
	public double prixTotal(int numClient){
    connection = DatabaseConnection.getConnection();
    double n=0;
	try {
		ps = connection.prepareStatement("select sum(ar.prix)from articles as ar, commande as cm, clients as cl where ar.codeArticle = cm.CodeArticle and cl.id = cm.CodeClient GROUP BY(cl.id) HAVING cl.id = ? ");
		ps.setInt(1, numClient);
		rs = ps.executeQuery();
		if (rs.next())
		n= rs.getDouble(1);
		System.out.println(n);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return n;
	}
	public int getIdClient(String email) {
		connection = DatabaseConnection.getConnection();
		int n=0;
		try {
			
			ps = connection.prepareStatement("select id from client where email=?");
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next())
				 n=rs.getInt("id");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	public int getIdClient2(String nom) {
		connection = DatabaseConnection.getConnection();
		int n=0;
		try {
			
			ps = connection.prepareStatement("select id from client where nom=?");
			ps.setString(1, nom);
			rs = ps.executeQuery();
			if (rs.next())
				 n=rs.getInt("id");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	public Client nomClient(int n) {
		connection = DatabaseConnection.getConnection();
		Client c = null;
		try {
			ps = connection.prepareStatement("select nom from client where id = ?");
		    ps.setInt(1, n);
			rs=ps.executeQuery();
			if (rs.next()){
				c = new Client();
				c.setNom(rs.getString("nom"));
			}
		    ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	public Panier getcart(int id) {
		connection=DatabaseConnection.getConnection();
		Panier c=null;
		try {
			ps = connection.prepareStatement("select *from article where id = ?");
		    ps.setInt(1, id);
			rs=ps.executeQuery();
			if (rs.next()){
				c = new Panier();
				c.setImg(rs.getString("img"));
				c.setPrix(rs.getDouble("prix"));
				c.setId_art(rs.getString("id"));
				c.setDesign(rs.getString("design"));
			}
		    ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	public ArrayList<Article> getarlist() {
		Article a = null;
        connection = DatabaseConnection.getConnection();
        ArrayList<Article> ls=new ArrayList<>();
	try {
		ps = connection.prepareStatement("select *from article");
		rs=ps.executeQuery();
	    while(rs.next()){
	        a= new Article();
	    	a.setDesignation(rs.getString("design"));
	    	a.setAuteur(rs.getString("Auth"));
	    	a.setStock(rs.getInt("stock"));
	    	a.setPhoto(rs.getString("img"));
	    	a.setPrix(rs.getDouble("prix"));
	    	a.setCategorie(rs.getString("cat"));
	    	a.setId(rs.getInt("id"));
	    	ls.add(a);
	    }
	    ps.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return ls;
	}
	public ArrayList<Client> getclients(){
		ArrayList<Client> cl=new ArrayList<>();
		connection = DatabaseConnection.getConnection();
		Client c=null;
		try {
			ps = connection.prepareStatement("select *from client");
			rs=ps.executeQuery();
		    while(rs.next()){
		       c=new Client();
		       c.setNom(rs.getString("nom"));
		       c.setEmail(rs.getString("email"));
		       c.setAdresse(rs.getString("adresse"));
		       c.setTel(rs.getString("telephone"));
		       cl.add(c);
		    }
		    ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cl;
	}
	
	public ArrayList<Commande> getcmd(){
		connection = DatabaseConnection.getConnection();
		Commande cmdd=null;
		ArrayList<Commande> cmd=new ArrayList<>();
		try {
			ps = connection.prepareStatement("select cl.nom,cl.email,ar.design,cmd.date,cmd.id from client cl,article ar,commande cmd WHERE ar.id=cmd.id_article and cl.id=cmd.id_client ORDER BY cmd.date");
			rs=ps.executeQuery();
		    while(rs.next()){
		   cmdd=new Commande();
		   cmdd.setNomc(rs.getString("nom"));
		   cmdd.setMail(rs.getString("email"));
		   cmdd.setDesign(rs.getString("design"));
		   cmdd.setDate(rs.getString("date"));
		   cmdd.setNumCmd(rs.getInt("id"));
		   cmd.add(cmdd);
		    }
		    ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cmd;
	}
	public void delcmd(int id) {
		connection = DatabaseConnection.getConnection();
			try {
				ps = connection.prepareStatement("Delete from commande where id=?");
				ps.setInt(1, id);
				ps.executeUpdate();
				System.out.println("b1 supprimer");
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
		}}
	public void delart(int id) {
		connection = DatabaseConnection.getConnection();
			try {
				ps = connection.prepareStatement("Delete from article where id=?");
				ps.setInt(1, id);
				ps.executeUpdate();
				System.out.println("b1 supprimer");
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
		}}
	
	public void addart(Article c) {
		connection = DatabaseConnection.getConnection();
		try {
			ps = connection.prepareStatement("INSERT INTO article (design, prix, stock, cat, img,auth) values(?,?,?,?,?,?)");
			ps.setString(1, c.getDesignation());
			ps.setInt(2,(int)c.getPrix()); 
		    ps.setInt(3, c.getStock());
		    ps.setString(4, c.getCategorie());
		    ps.setString(5, c.getPhoto());
		    ps.setString(6, c.getAuteur());
		    ps.executeUpdate();
		    ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

    }
