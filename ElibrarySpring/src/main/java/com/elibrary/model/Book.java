package com.elibrary.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String callno, name, author, publisher;
	int quantity, issued;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int id, String callno, String name, String author, String publisher, int quantity, int issued) {
		super();
		this.id = id;
		this.callno = callno;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.quantity = quantity;
		this.issued = issued;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCallno() {
		return callno;
	}

	public void setCallno(String callno) {
		this.callno = callno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getIssued() {
		return issued;
	}

	public void setIssued(int issued) {
		this.issued = issued;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", callno=" + callno + ", name=" + name + ", author=" + author + ", publisher="
				+ publisher + ", quantity=" + quantity + ", issued=" + issued + "]";
	}

}
