package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author jaiba - jaibarra
 * CIS175 - Fall 2021
 * Sep 15, 2021
 */
@Entity
@Table(name="cars")
public class Car {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;
	@Column(name = "Model")
	private String model;
	@Column(name ="Color")
	private String color;
	@Column(name= "Year")
	private int year;


	public Car(){
		super();

	}

	public Car(String model, String color, int year) {
		super();
		this.model = model;
		this.color = color;
		this.year = year;

	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	public String returnCarDetails( ) {
		return this.model + " " + this.color + " " + this.year;
	}
}
