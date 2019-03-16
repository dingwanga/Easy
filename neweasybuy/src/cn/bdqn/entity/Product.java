package cn.bdqn.entity;

import java.io.Serializable;

/**
 * 
 * @author clack 商品表
 * 
 */
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer epId;
	private String epName;
	private String epDescription;
	private Double epPrice;
	private Integer epStock;
	private Integer epcId;
	private Integer epcChildId;
	private String epFileName;

	public Integer getEpId() {
		return epId;
	}

	public void setEpId(Integer epId) {
		this.epId = epId;
	}

	public String getEpName() {
		return epName;
	}

	public void setEpName(String epName) {
		this.epName = epName;
	}

	public String getEpDescription() {
		return epDescription;
	}

	public void setEpDescription(String epDescription) {
		this.epDescription = epDescription;
	}

	public Double getEpPrice() {
		return epPrice;
	}

	public void setEpPrice(Double epPrice) {
		this.epPrice = epPrice;
	}

	public Integer getEpStock() {
		return epStock;
	}

	public void setEpStock(Integer epStock) {
		this.epStock = epStock;
	}

	public Integer getEpcId() {
		return epcId;
	}

	public void setEpcId(Integer epcId) {
		this.epcId = epcId;
	}

	public Integer getEpcChildId() {
		return epcChildId;
	}

	public void setEpcChildId(Integer epcChildId) {
		this.epcChildId = epcChildId;
	}

	public String getEpFileName() {
		return epFileName;
	}

	public void setEpFileName(String epFileName) {
		this.epFileName = epFileName;
	}

	public Product(Integer epId, String epName, String epDescription,
			Double epPrice, Integer epStock, Integer epcId, Integer epcChildId,
			String epFileName) {
		super();
		this.epId = epId;
		this.epName = epName;
		this.epDescription = epDescription;
		this.epPrice = epPrice;
		this.epStock = epStock;
		this.epcId = epcId;
		this.epcChildId = epcChildId;
		this.epFileName = epFileName;
	}

	public Product() {
		super();
	}
	
	
}
