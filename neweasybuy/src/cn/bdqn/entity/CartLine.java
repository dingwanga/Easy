package cn.bdqn.entity;

import java.io.Serializable;

/**
 * 
 * @author clack创建购物商品条目类
 * 
 */
public class CartLine implements Serializable {
	private static final long serialVersionUID = 1L;
	private Product product;// 商品信息
	private Integer count=1;// 商品数量，商品初始数量为1
	private Double sum;// 小计

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Double getSum() {
		sum=product.getEpPrice()*count;
		return sum;
	}

	public void setSum(Double sum) {
		this.sum = sum;
	}

	public CartLine() {
		super();
	}

	public CartLine(Product product, Integer count, Double sum) {
		super();
		this.product = product;
		this.count = count;
		this.sum = sum;
	}

}
