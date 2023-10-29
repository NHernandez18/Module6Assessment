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
	@Column(name="TITLE")
	private String title;
	@Column(name="AUTHOR")
	private String author;
	
	public ListItem2() {
		super();
	}
	
	public ListItem2(String title, String author) {
		super();
		this.title = title;
		this.author = author;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public	String	returnItemDetails(	)	{
		return	this.title	+	":"	+	this.author;
		}
}
