package com.org.ecommerce.modal;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name= "product")   
public class Product { 


	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "price")
	private BigDecimal price;
	
	@Column(name = "dateAdded")
	private String dateAdded;  

	@Column(name = "cusineId")
	private long cusineId;  
	
	@Column(name = "viewable")
	private int viewable;

	public long getID() {return this.id; }  
	public String getName() { return this.name;} 
	public BigDecimal getPrice() { return this.price;} 
	public long getCusineId() { return this.cusineId;}
	public String getDateAdded() { return this.dateAdded;}
	public int getViewable() { return this.viewable;}

	
	public void setID(long id) { this.id = id;}
	public void setName(String value) { this.name = value;}
	public void setPrice(BigDecimal value) { this.price = value;}
	public void setCusine(long value) { this.cusineId = value;}
	public void setDateAdded(String date) { this.dateAdded = date;}
	public void setViewable(int value) { this.viewable = value;}
}
