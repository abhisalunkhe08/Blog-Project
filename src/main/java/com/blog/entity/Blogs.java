package com.blog.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Blogs {
	
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;

		private String title;
		@Column(name = "description",length = 1000)
		private String desc;
		private Date date;

		public Blogs(String title, String desc, Date date) {
			super();
			this.title = title;
			this.desc = desc;
			this.date = date;
		}

		public Blogs() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Blogs(int blogId, String title2, String content) {
			// TODO Auto-generated constructor stub
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		@Override
		public String toString() {
			return "Blogs [id=" + id + ", title=" + title + ", desc=" + desc + ", date=" + date + "]";
		}

	}



