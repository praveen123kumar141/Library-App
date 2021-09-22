package com.oktay.model;

import javax.persistence.Entity;
import javax.validation.constraints.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="issuebook")
public class Issuebook {
		@Id
		
		int bookid;
		int studentid;
		String bookname;
		String authorname;
		String deportment;
		public int getBookid() {
			return bookid;
		}
		public void setBookid(int bookid) {
			this.bookid = bookid;
		}
		public int getStudentid() {
			return studentid;
		}
		public void setStudentid(int studentid) {
			this.studentid = studentid;
		}
		public String getBookname() {
			return bookname;
		}
		public void setBookname(String bookname) {
			this.bookname = bookname;
		}
		public String getAuthorname() {
			return authorname;
		}
		public void setAuthorname(String authorname) {
			this.authorname = authorname;
		}
		public String getDeportment() {
			return deportment;
		}
		public void setDeportment(String deportment) {
			this.deportment = deportment;
		}
}
