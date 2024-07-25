package com.blog.contrller;




import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import javax.transaction.Transaction;

import org.hibernate.cfg.Configuration;

import com.blog.entity.Blogs;
import com.mysql.cj.Session;
import com.mysql.cj.xdevapi.SessionFactory;

/**
 * Servlet implementation class DeletServelt
 */
public class DeleteServlet extends HttpServlet{
	
	public DeleteServlet() {
		super();
	}
	

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    int blogid=Integer.parseInt(request.getParameter("id"));
		    Configuration cfg=new Configuration().configure();
		    org.hibernate.SessionFactory factory=cfg.buildSessionFactory();
		    org.hibernate.Session s=factory.openSession();
		    org.hibernate.Transaction tx=s.beginTransaction();
		    Blogs blog=s.get(Blogs.class, blogid);
		    s.delete(blog);
		    tx.commit();
		    response.sendRedirect("showdata.jsp");
		}


	}



