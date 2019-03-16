package cn.bdqn.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 
 * @author clack订单表
 */
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	private String eoId;// 订单号，使用UUId
	private String eoUserId;// 用户id
	private Timestamp eoCreateTTime;// 创建时间
	private Integer eoStatus;// 状态 1：下单 2：审核通过 3：配货 4：送货中 5：收获并确认
	private String eoUserAddress;// 用户地址
	private Integer eoIsdelete;// 是否删除
	private Double eoCost;//总计，计算订单的总价值

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

	public Timestamp getEoCreateTTime() {
		return eoCreateTTime;
	}

	public void setEoCreateTTime(Timestamp eoCreateTTime) {
		this.eoCreateTTime = eoCreateTTime;
	}

	public Integer getEoStatus() {
		return eoStatus;
	}

	public void setEoStatus(Integer eoStatus) {
		this.eoStatus = eoStatus;
	}

	public String getEoUserAddress() {
		return eoUserAddress;
	}

	public void setEoUserAddress(String eoUserAddress) {
		this.eoUserAddress = eoUserAddress;
	}

	public Integer getEoIsdelete() {
		return eoIsdelete;
	}

	public void setEoIsdelete(Integer eoIsdelete) {
		this.eoIsdelete = eoIsdelete;
	}

	public Double getEoCost() {
		return eoCost;
	}

	public void setEoCost(Double eoCost) {
		this.eoCost = eoCost;
	}

	public Order(String eoId, String eoUserId, Timestamp eoCreateTTime,
			Integer eoStatus, String eoUserAddress, Integer eoIsdelete,
			Double eoCost) {
		super();
		this.eoId = eoId;
		this.eoUserId = eoUserId;
		this.eoCreateTTime = eoCreateTTime;
		this.eoStatus = eoStatus;
		this.eoUserAddress = eoUserAddress;
		this.eoIsdelete = eoIsdelete;
		this.eoCost = eoCost;
	}

	public Order() {
		super();
	}

}
