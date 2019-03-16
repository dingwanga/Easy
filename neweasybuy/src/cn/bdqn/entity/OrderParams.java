package cn.bdqn.entity;

import java.io.Serializable;

public class OrderParams implements Serializable {

	private static final long serialVersionUID = 1L;
	private String eoId;// 订单号，使用UUId
	private String eoUserId;// 用户id

	public String getEoId() {
		return eoId;
	}

	public void setEoId(String eoId) {
		this.eoId = eoId;
	}

	public String getEoUserId() {
		return eoUserId;
	}

	public void setEoUserId(String eoUserId) {
		this.eoUserId = eoUserId;
	}

	public OrderParams() {
		super();
	}

	public OrderParams(String eoId, String eoUserId) {
		super();
		this.eoId = eoId;
		this.eoUserId = eoUserId;
	}

}
