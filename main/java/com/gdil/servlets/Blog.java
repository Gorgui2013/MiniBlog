package com.gdil.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gdil.donnee.Article;
import com.gdil.donnee.SessionCounter;

/**
 * Servlet implementation class Blog
 */
@WebServlet(name="BlogListe.path", urlPatterns= {"/", "*.path"})
public class Blog extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
	List<Article> articles;
	String path;
	String alert;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Blog() {
		super();
		this.articles = new ArrayList<Article>();
		this.alert = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.path = request.getServletPath();
		this.session = request.getSession(true);
		this.session.setAttribute("id", this.session.getId());
		int nbSession = SessionCounter.getActiveSessions();
		this.session.setAttribute("nb", nbSession);
		request.setAttribute("path", path);
		//request.setAttribute("idSession", this.session.getId());
		if(this.path.equals("/Blog.path")) {
			Article article = new Article();
			if(request.getParameter("editArticle") != null) {
				int idArticle = Integer.parseInt(request.getParameter("editArticle"));
				article = this.obtenir(this.articles, idArticle);
			}
			request.setAttribute("article", article);
		} else if(this.path.equals("/BlogListe.path")) {
			if(request.getParameter("deleteArticle") != null) {
				int idArticle = Integer.parseInt(request.getParameter("deleteArticle"));
				this.supprimer(articles, idArticle);
			}
			if(this.session.getAttribute("articles") == null) {
				this.session.setAttribute("articles", this.articles);
			} else {
				this.articles = (List<Article>) this.session.getAttribute("articles");
			}
			this.alert = null;
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	public Article obtenir(List<Article> articles, int idArticle) {
		for(int i = 0; i < articles.size(); i++) {
			if(articles.get(i).getIdArticle() == idArticle) {
				return articles.get(i);
			}
		}
		return null;
	}

	public void supprimer(List<Article> articles, int idArticle) {
		for(int i = 0; i < articles.size(); i++) {
			if(articles.get(i).getIdArticle() == idArticle) {
				articles.remove(i);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Article article = new Article(); 
		if(this.path.equals("/Blog.path")) {
			if(request.getParameter("editArticle") != null) {
				int idArticle = Integer.parseInt(request.getParameter("editArticle"));
				article = this.obtenir(this.articles, idArticle);
				article.setSujet(request.getParameter("sujet"));
				article.setMessage(request.getParameter("message"));
				article.setIp(request.getRemoteAddr());
			} else {
				if(this.articles == null) {
					article.setIdArticle(1);
				} else {
					article.setIdArticle(this.articles.size()+1);
				}
				article.setSujet(request.getParameter("sujet"));
				article.setMessage(request.getParameter("message"));
				article.setIp(request.getRemoteAddr());
				this.articles.add(article);
			}
		}
		response.sendRedirect("BlogListe.path");
		//doGet(request, response);
	}

}
