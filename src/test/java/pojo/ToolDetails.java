package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ToolDetails {
	
	private int id;
	private String category;
	private String name;
	private String manufacturer;
	private double price;
	
	@JsonProperty("current-stock")
	private int currentStock;
	
	private boolean inStock;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getCurrentStock() {
		return currentStock;
	}
	
	public void setCurrentStock(int currentStock) {
		this.currentStock = currentStock;
	}
	
	public boolean isInStock() {
		return inStock;
	}
	
	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}
	


}
