/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.*;

/**
 *
 * @author TM080522
 */
public class cart {

	private List<item> items;

	public cart() {
		items = new ArrayList<>();
	}

	public List<item> getItemsInCart() {
		return items;
	}

	public List<item> getItems() {
		return items;
	}

	public void setItems(List<item> items) {
		this.items = items;
	}
	
	

	private item getItembyID(String id) {
		for (item item : items) {
			if (item.getProduct().getProductid().equals(id)) {
				return item;
			}
		}
		return null;
	}

	public int getItemQuantity(String id) {
		return getItembyID(id).getQuantity();
	}

	public void addtocart(item toadd) {
		if (getItembyID(toadd.getProduct().getProductid()) != null) {
			item existed = getItembyID(toadd.getProduct().getProductid());
			existed.setQuantity(existed.getQuantity() + toadd.getQuantity());
		} else {
			items.add(toadd);
		}
	}

	public void removeItem(String id) {
		if (getItembyID(id) != null) {
			items.remove(getItembyID(id));
		}
	}

	public int getTotal() {
		int total = 0;
		for (item item : items) {
			total += (item.getQuantity() * item.getPrice());
		}
		return total;
	}

	private product getProductByID(String id, List<product> productList) {
		for (product product : productList) {
			if (product.getProductid().equals(id)) {
				return product;
			}
		}
		return null;
	}

	public cart(String cartCookie, List<product> productList) {
		items = new ArrayList<>();
		try {
			if (cartCookie != null && cartCookie.trim().length() != 0) {
				String[] cart = cartCookie.split("/");
				for (String item : cart) {
					String[] detail = item.split(":");
					String id = detail[0];
					int quantity = Integer.parseInt(detail[1]);
					product p = getProductByID(id, productList);
					item i = new item(p, quantity, p.getDiscountprice());
					addtocart(i);
				}
			}
		}catch(NumberFormatException e){
			
		}
	}

	@Override
	public String toString() {
		String cartToString = "Total: " + getTotal() + " ";
		for(item i: items){
			cartToString = cartToString + "|" + i.toString();
		}
		return cartToString;
	}
	
}
