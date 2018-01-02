package com.aca.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "friend")
public class Friend {

	private String id;
	private String firstName;
	private String lastName;
	private String image;
	
	public Friend() {
		
	}
	
	public Friend(String id, String firstName, String lastName, String image) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.image = image;
	}
	
	@XmlElement
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	@XmlElement
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@XmlElement
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@XmlElement
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	@Override
	public String toString() {
		return  "\n first name: " + firstName +
				"\n last name: " + lastName +
				"\n id: " + id +
				"\n image: " + image;				
	}
	
	
}
