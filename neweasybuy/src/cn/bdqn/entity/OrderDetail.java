package cn.bdqn.entity;

import java.io.Serializable;

/**
 * 
 * @author clack 订单详情表
 * 
 */
public class OrderDetail implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer eodId;// 编号
	private String eoId;// 订单ID
	private Integer epId;// 商品ID
	private Integer eodQuantity;// 数量
	private Double eodisdelete;// 金额

	// 商品信息，两表连接查询
	private String name;// 商品名称
	private String pic;// 图片路径
	private Double price;// 商品价格
	private Double total;// 小计

	public Integer getEodId() {
		return eodId;
	}

	public void setEodId(Integer eodId) {
		this.eodId = eodId;
	}

	public String getEoId() {
		return eoId;
	}

	public void setEoId(String eoId) {
		this.eoId = eoId;
	}

	public Integer getEpId() {
		return epId;
	}

	public void setEpId(Integer epId) {
		this.epId = epId;
	}

	public Integer getEodQuantity() {
		return eodQuantity;
	}

	public void setEodQuantity(Integer eodQuantity) {
		this.eodQuantity = eodQuantity;
	}

	public Double getEodisdelete() {
		return eodisdelete;
	}

	public void setEodisdelete(Double eodisdelete) {
		this.eodisdelete = eodisdelete;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getTotal() {
		total=price*eodQuantity;
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public OrderDetail(Integer eodId, String eoId, Integer epId,
			Integer eodQuantity, Double eodisdelete, String name, String pic,
			Double price, Double total) {
		super();
		this.eodId = eodId;
		this.eoId = eoId;
		this.epId = epId;
		this.eodQuantity = eodQuantity;
		this.eodisdelete = eodisdelete;
		this.name = name;
		this.pic = pic;
		this.price = price;
		this.total = total;
	}

	public OrderDetail() {
		super();
	}

}