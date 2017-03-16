package com.niit.shoppingcart.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.*;
//import org.hibernate.validator.constraints.NotBlank;
//import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

//import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="USER")
@Component
	public class User implements Serializable
	{
	
		 @Id
		 @GeneratedValue(strategy=GenerationType.AUTO)
		 @Column(name="id")
	     private int id;	
		 
		 @NotNull
		 @Size(min=2,max=30,message="Name Must be more than 2 letters")
		 @Column(name="name")
	     private String name;
		 
				 
		 @NotNull
		 @Size(min=2,max=30)
		 @Column(name="mail")
	     private String mail;
		 
		 @NotNull
		 @Size(min=10,max=12)
		 @Column(name="phone")
	     private String phone;
			 
		 @NotNull
		 @Size(min=2,max=30)
		 @Column(name="password")
	     private String password;
		 
		 @NotNull
		 @Size(min=2,max=30)
		 @Column(name="confirmpassword")
	     private String confirmpassword; 
		     
		 @NotNull
		 @Size(min=2,max=30)
		 @Column(name="streetName")
		    private String streetName;
		 @NotNull
		 @Size(min=2,max=30)
		 @Column(name="apartmentNumber")
		    private String apartmentNumber;
		 @NotNull
		 @Size(min=2,max=30)
		 @Column(name="city")
		    private String city;
		 @NotNull
		 @Size(min=2,max=30)
		 @Column(name="state")
		    private String state;
		 @NotNull
		 @Size(min=2,max=30)
		 @Column(name="country")
		    private String country;
		 @NotNull
		 @Size(min=2,max=30)
		 @Column(name="zipCode")
		private String zipCode;	
		 @NotNull
		 @Size(min=2,max=30)
		 @Column(name="role")
		 private String role="ROLE_USER";
		private boolean status=true;
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
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getConfirmpassword() {
			return confirmpassword;
		}
		public void setConfirmpassword(String confirmpassword) {
			this.confirmpassword = confirmpassword;
		}
		public String getStreetName() {
			return streetName;
		}
		public void setStreetName(String streetName) {
			this.streetName = streetName;
		}
		public String getApartmentNumber() {
			return apartmentNumber;
		}
		public void setApartmentNumber(String apartmentNumber) {
			this.apartmentNumber = apartmentNumber;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getZipCode() {
			return zipCode;
		}
		public void setZipCode(String zipCode) {
			this.zipCode = zipCode;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public boolean isStatus() {
			return status;
		}
		public void setStatus(boolean status) {
			this.status = status;
		}
		
	}
			