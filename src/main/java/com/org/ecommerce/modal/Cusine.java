package com.org.ecommerce.modal;
import jakarta.persistence.*;

@Entity
@Table(name= "cusine")   
public class Cusine { 


	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "name")
	private String name;
	
	
	public long getID() {return this.id; }
	public String getName() { return this.name;}
	
	public void setID(long id) { this.id = id;}
	public void setName(String value) { this.name = value;}
	
}
