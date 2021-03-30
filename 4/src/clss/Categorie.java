package clss;

public class Categorie {
	private String idCat;
	private String nom;
	
	
	public Categorie(String idCat, String nom) {
		super();
		this.idCat = idCat;
		this.nom = nom;
	}
	public String getIdCat() {
		return idCat;
	}
	public void setIdCat(String idCat) {
		this.idCat = idCat;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

}
