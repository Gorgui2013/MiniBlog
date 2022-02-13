package com.gdil.donnee;

public class Article {
	private int idArticle;
	private String sujet;
	private String message;
	private String ip;
	
	public Article() {
	}
	
	public Article(int idArticle, String sujet, String message) {
		this.idArticle = idArticle;
		this.sujet = sujet;
		this.message = message;
	}
	
	public int getIdArticle() {
		return idArticle;
	}
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}
	public String getSujet() {
		return sujet;
	}
	public void setSujet(String sujet) {
		this.sujet = sujet;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}
