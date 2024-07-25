package com.blog.contrller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;


import com.blog.entity.Blogs;
import com.blog.service.BlogService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SaveServlet extends HttpServlet{

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String title = req.getParameter("title1");
			String description = req.getParameter("decription");

			// System.out.println(title+" \n "+description);
			Blogs bb = new Blogs(title, description, new Date());
			BlogService bs = new BlogService();
			bs.saveBlog(bb);
			PrintWriter writer = resp.getWriter();
			writer.println("<h1 style='text-align:center'>Data Saved Sucessfully </h1>");

		}

	}


