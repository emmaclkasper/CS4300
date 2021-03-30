package clss;

public class Commande {
	private int numCmd;
	private int numClient;
	private int numArticle;
	private String nomc;
	private String date;
	private String design;
	private String mail;
	private int qte;
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public String getNomc() {
		return nomc;
	}
	public void setNomc(String nomc) {
		this.nomc = nomc;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDesign() {
		return design;
	}
	public void setDesign(String design) {
		this.design = design;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getNumCmd() {
		return numCmd;
	}
	public void setNumCmd(int numCmd) {
		this.numCmd = numCmd;
	}
	public int getNumClient() {
		return numClient;
	}
	public void setNumClient(int numClient) {
		this.numClient = numClient;
	}
	public int getNumArticle() {
		return numArticle;
	}
	public void setNumArticle(int numArticle) {
		this.numArticle = numArticle;
	}
	public Commande(int numCmd, int numClient, int numArticle) {
		super();
		this.numCmd = numCmd;
		this.numClient = numClient;
		this.numArticle = numArticle;
	}
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}
}
