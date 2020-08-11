package com.sboot.wrestle.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="wrestlers")
public class Wrestlers {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	 
	@Column(name="email")
	private String mail;
	
	@Column(name="city")
	private String city;
	
	
	public Wrestlers()
	{
		
	}


	public Wrestlers(String name, String mail, String city) {
		//super();
		this.name = name;
		this.mail = mail;
		this.city = city;
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


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	@Override
	public String toString() {
		return "Wrestlers [id=" + id + ", name=" + name + ", mail=" + mail + ", city=" + city + "]";
	}
	
	

}
