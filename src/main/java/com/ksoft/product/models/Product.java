package com.ksoft.product.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Product {

	@Id
	@SequenceGenerator(name="prodseq", initialValue=1, allocationSize=10)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="prodseq")
	private int prodId;
	private String productName;
	private int[] productImg;
	
	private int deptId;
	
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public int[] getProductImg() {
		return productImg;
	}
	public void setProductImg(int[] productImg) {
		this.productImg = productImg;
	}
	
	
	
}
