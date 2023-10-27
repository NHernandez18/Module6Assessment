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
@Table(name="items2")
public class ListItem2 {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="MAKE")
	private String make;
	@Column(name="MODEL")
	private String model;
	
	public ListItem2() {
		super();
	}

	public ListItem2(String make, String model) {
		super();
		this.make = make;
		this.model = model;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	public	String	returnItemDetails(	)	{
		return	this.make	+	":"	+	this.model;
		}
}
