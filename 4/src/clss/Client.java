package clss;

public class Client {
	private String email;
	private String nom;
	private String adresse;
	private String tel;
	private String motpasse;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMotpasse() {
		return motpasse;
	}
	public void setMotpasse(String passe) {
		this.motpasse = passe;
	}
	public Client(String nom,String email, String adresse, String tel,String passe) {
		super();
		this.email = email;
		this.nom = nom;
		this.adresse = adresse;
		this.tel = tel;
		this.motpasse = passe;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
}
