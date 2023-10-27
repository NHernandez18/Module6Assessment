package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Nicholas Hernandez - NHernandez6
 * CIS175 - Fall 2023
 * Oct 20, 2023
 */
@Entity
@Table(name="items")
public class ListItem {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="BRAND")
	private String brand;
	@Column(name="SHOE")
	private String shoe;
	
	public ListItem() {
		super();
	}
	
	public ListItem(String brand, String shoe) {
		super();
		this.brand = brand;
		this.shoe = shoe;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getShoe() {
		return shoe;
	}

	public void setShoe(String shoe) {
		this.shoe = shoe;
	}
	
	public	String	returnItemDetails(	)	{
		return	this.brand	+	":"	+	this.shoe;
		}
}
