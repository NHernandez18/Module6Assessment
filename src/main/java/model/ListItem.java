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
	@Column(name="TITLE")
	private String title;
	@Column(name="YEAR")
	private String year;
	
	public ListItem() {
		super();
	}

	public ListItem(String title, String year) {
		super();
		this.title = title;
		this.year = year;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public	String	returnItemDetails(	)	{
		return	this.title	+	":"	+	this.year;
		}
}
