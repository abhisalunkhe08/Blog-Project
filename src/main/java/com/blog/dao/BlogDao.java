package com.blog.dao;


import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.blog.entity.Blogs;

public class BlogDao {
		Configuration cfg = null;
		SessionFactory factory = null;

		Session se = null;
		Transaction tx = null;

		public void saveBlogs(Blogs bb) {

			cfg = new Configuration();
			cfg.configure();
			factory = cfg.buildSessionFactory();
			se = factory.openSession();
			tx = se.beginTransaction();
			se.save(bb);
			tx.commit();
			se.close();

		}

		public List<Blogs> getblogs() {
			cfg = new Configuration();
			cfg.configure();
			List<Blogs> bloglist = null;
			try {
				factory = cfg.buildSessionFactory();
				se = factory.openSession();
				tx = se.beginTransaction();

				Criteria criteria = se.createCriteria(Blogs.class);
				bloglist = criteria.list();
				for (Blogs b : bloglist) {
					System.out.println(b.getId());
					System.out.println(b.getTitle());
					System.out.println(b.getDesc());
					System.out.println(b.getDate());
				}
			} catch (HibernateException e) {
				e.printStackTrace();
			}

			se.close();
			return bloglist;

		}
		public Blogs getBlogById(int id) {
			factory = cfg.buildSessionFactory();
			se = factory.openSession();
			tx = se.beginTransaction();
	            return se.get(Blogs.class, id);
	        
	    }
		public void updateBlog(Blogs blog) {
			factory.openSession();
	        Transaction transaction = null;
	        try {
	            transaction = se.beginTransaction();
	            se.update(blog);
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }
		


	}



