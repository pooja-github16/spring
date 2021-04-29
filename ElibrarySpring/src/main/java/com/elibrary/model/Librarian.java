package com.elibrary.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Librarian {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String name,email,password;
	long mob;
	public Librarian() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Librarian(int id, String name, String email, String password, long mob) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.mob = mob;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getMob() {
		return mob;
	}
	public void setMob(long mob) {
		this.mob = mob;
	}
	@Override
	public String toString() {
		return "Librarian [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", mob=" + mob
				+ "]";
	}
}
