/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author TM080522
 */
public class item {
	private product product;
	private int quantity;
	private int price;

	public item() {
	}

	public item(product product, int quantity, int price) {
		this.product = product;
		this.quantity = quantity;
		this.price = price;
	}

	public product getProduct() {
		return product;
	}

	public void setProduct(product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "item{" + "product=" + product.getProductname() + ", quantity=" + quantity + ", price=" + price + '}';
	}
	
}
