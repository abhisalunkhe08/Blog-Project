package com.blog.contrller;

import jakarta.servlet.http.HttpServlet;


import java.io.IOException;

import com.blog.entity.Blogs;
import com.blog.service.BlogService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class UpdateServlet extends HttpServlet{
    
		 
		private static final long serialVersionUID = 1L;
	    
	    private BlogService blogService;

	    public UpdateServlet() {
	        super();
	        blogService = new BlogService();
	    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			int blogId = Integer.parseInt(request.getParameter("id").trim());
			Blogs blog = blogService.getBlogById(blogId);
			request.setAttribute("blog", blog);
			request.getRequestDispatcher("/update.jsp").forward(request, response);
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int blogId = Integer.parseInt(request.getParameter("id").trim());
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			Blogs blog = new Blogs(blogId, title, content);
			blogService.updateBlog(blog);
			
			response.sendRedirect("blogList"); // Assuming there is a servlet to list blogs
		}
		 

	}


