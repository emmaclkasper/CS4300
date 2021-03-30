package controllers;

import java.util.ArrayList;

import clss.Article;
import clss.Panier;

public class Information {
private Article detail;
private String categori;
private String msgpanier;
private ArrayList<Panier> cart=new ArrayList<>();
public ArrayList<Panier> getCart() {
	return cart;
}

public void setCart(ArrayList<Panier> cart) {
	this.cart = cart;
}

public String getMsgpanier() {
	return msgpanier;
}

public void setMsgpanier(String msgpanier) {
	this.msgpanier = msgpanier;
}

public String getCategori() {
	return categori;
}

public void setCategori(String categori) {
	this.categori = categori;
}

public Article getDetail() {
	return detail;
}

public void setDetail(Article detail) {
	this.detail = detail;
}
}
