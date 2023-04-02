/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author TM080522
 */
public class product {

	private String productid;
	private String productname;
	private String description;
	private String size;
	private int price;
	private int stock;
	private String image;
	private String catid;
	private int createid;
	private String collectionid;
	protected int discount;

	public product() {
		this.discountprice = (this.price / 100) * (100 - this.discount);
	}

	public product(String productid, String productname, String description, String size, int price, int stock, String image, String catid, int createid, String collectionID, int discount) {
		this.productid = productid;
		this.productname = productname;
		this.description = description;
		this.size = size;
		this.price = price;
		this.stock = stock;
		this.image = image;
		this.catid = catid;
		this.createid = createid;
		this.collectionid = collectionID;
		this.discount = discount;
		this.discountprice = (this.price / 100) * (100 - this.discount);
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCatid() {
		return catid;
	}

	public void setCatid(String catid) {
		this.catid = catid;
	}

	public int getCreateid() {
		return createid;
	}

	public void setCreateid(int createid) {
		this.createid = createid;
	}

	public String getCollectionid() {
		return collectionid;
	}

	public void setCollectionid(String collectionID) {
		this.collectionid = collectionID;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	private int discountprice;

	public int getDiscountprice() {
		return discountprice;
	}

	public void setDiscountprice(int discountprice) {
		this.discountprice = (this.price / 100) * (100 - this.discount);
	}

	@Override
	public String toString() {
		return "product{" + "productname=" + productname + ", price=" + price + ", image=" + image + ", catid=" + catid + ", collectionid=" + collectionid + ", discount=" + discount + ", discountprice=" + discountprice + '}';
	}

}
