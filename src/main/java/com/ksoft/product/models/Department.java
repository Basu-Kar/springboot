package com.ksoft.product.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Department {

	@Id
	@SequenceGenerator(name="dept_seq",allocationSize=10,initialValue=1)
	@GeneratedValue(generator="dept_seq",strategy=GenerationType.SEQUENCE)
	private int deptId;
	private String deptName;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="product",joinColumns=@JoinColumn(referencedColumnName="deptId",name="prodId"),
	inverseJoinColumns=@JoinColumn(referencedColumnName="deptId",name="deptId",table="department"))	
	private List<Product> productList;

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
	
	
}
