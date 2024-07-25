package com.blog.service;


import java.util.List;

import com.blog.dao.BlogDao;
import com.blog.entity.Blogs;
public class BlogService {
	
		BlogDao bd = new BlogDao();

		public void saveBlog(Blogs bb) {
			try {
				bd.saveBlogs(bb);
				System.out.println("Blog saved successfully!");
			} catch (Exception e) {
				System.err.println("Error occurred while saving the blog: " + e.getMessage());
				// Handle the exception according to your application's requirements
			}

		}
		
		 public Blogs getBlogById(int id) {
		        return bd.getBlogById(id);
		    }

		    public void updateBlog(Blogs blog) {
		    	bd.updateBlog(blog);
		    }

	}



