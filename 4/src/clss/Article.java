package clss;


public class Article {
	private int id;
	private String auteur;
	private double prix;
	private int stock;
	private String categorie;
	private String photo;
	private String designation;
	
	
	public Article(String designation, double prix, int stock, String refCat, String photo) {
		super();
		this.prix = prix;
		this.stock = stock;
		this.categorie = refCat;
		this.photo = photo;
		this.designation=designation;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Article() {
		super();
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String refCat) {
		this.categorie = refCat;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
}
