/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author TM080522
 */
public class collection {
	private String collectionid;
	private String collectionname;
	private int discount;
	private String collectionimg;

	public collection() {
	}

	public collection(String collectionid, String collectionname, int discount, String img) {
		this.collectionid = collectionid;
		this.collectionname = collectionname;
		this.discount = discount;
		this.collectionimg = img;
	}

	public String getCollectionid() {
		return collectionid;
	}

	public void setCollectionid(String collectionid) {
		this.collectionid = collectionid;
	}

	public String getCollectionname() {
		return collectionname;
	}

	public void setCollectionname(String collectionname) {
		this.collectionname = collectionname;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getCollectionimg() {
		return collectionimg;
	}

	public void setCollectionimg(String collectionimg) {
		this.collectionimg = collectionimg;
	}
	
	

	@Override
	public String toString() {
		return "collection{" + "collectionid=" + collectionid + ", collectionname=" + collectionname + ", discount=" + discount + '}';
	}
	
	
}
