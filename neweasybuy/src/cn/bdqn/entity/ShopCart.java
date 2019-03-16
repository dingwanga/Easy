package cn.bdqn.entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author clack创建购物车类
 * 
 */
public class ShopCart implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<CartLine> lines = new LinkedList<CartLine>();
	private Double total;

	public ShopCart() {
		super();
	}

	public ShopCart(List<CartLine> lines, Double total) {
		super();
		this.lines = lines;
		this.total = total;
	}

	public List<CartLine> getLines() {
		return lines;
	}

	public void setLines(List<CartLine> lines) {
		this.lines = lines;
	}

	public Double getTotal() {
		double temp = 0;
		for (CartLine cl : lines) {
			temp += cl.getSum();
		}
		total = temp;
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	// 创建添加购物车的方法类
	public void addCart(CartLine sl) {
		for (CartLine cl : lines) {
			// 如果添加的商品信息相同
			if (cl.getProduct().getEpId().equals(sl.getProduct().getEpId())) {
				cl.setCount(cl.getCount() + 1);
				// 整个方法结束，没有必要再添加购物车的商品类
				return;
			}
		}
		lines.add(sl);
	}

	// 更新商品数量
	public void updateNum(int id, int num) {
		for (CartLine cl : lines) {
			if (cl.getProduct().getEpId() == id) {
				cl.setCount(num);
				break;
			}
		}

	}
	//删除购物车的商品
	public void delCart(int id){
		for (CartLine cl : lines) {
			if (cl.getProduct().getEpId() == id) {
				lines.remove(cl);
				break;
			}
		}
	}
	
	//清空购物车
	public void clearCart(){
		lines.clear();
	}
}
