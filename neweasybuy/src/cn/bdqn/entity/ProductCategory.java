package cn.bdqn.entity;

import java.io.Serializable;

/**
 * 
 * @author clack 商品分类表
 * 
 */
public class ProductCategory implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer epcId;
	private String epcName;
	private Integer epcParentId;

	public Integer getEpcId() {
		return epcId;
	}

	public void setEpcId(Integer epcId) {
		this.epcId = epcId;
	}

	public String getEpcName() {
		return epcName;
	}

	public void setEpcName(String epcName) {
		this.epcName = epcName;
	}

	public Integer getEpcParentId() {
		return epcParentId;
	}

	public void setEpcParentId(Integer epcParentId) {
		this.epcParentId = epcParentId;
	}

	public ProductCategory(Integer epcId, String epcName, Integer epcParentId) {
		super();
		this.epcId = epcId;
		this.epcName = epcName;
		this.epcParentId = epcParentId;
	}

	public ProductCategory() {
		super();
	}

	
}
