/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author TM080522
 */
public class category {
	private String catid;
	private String catname;
	private String catdes;

	public category() {
	}

	public category(String catid, String catname, String catdes) {
		this.catid = catid;
		this.catname = catname;
		this.catdes = catdes;
	}

	public String getCatid() {
		return catid;
	}

	public void setCatid(String catid) {
		this.catid = catid;
	}

	public String getCatname() {
		return catname;
	}

	public void setCatname(String catname) {
		this.catname = catname;
	}

	public String getCatdes() {
		return catdes;
	}

	public void setCatdes(String catdes) {
		this.catdes = catdes;
	}

	@Override
	public String toString() {
		return "category{" + "catid=" + catid + ", catname=" + catname + ", catdes=" + catdes + '}';
	}
	
	
}
