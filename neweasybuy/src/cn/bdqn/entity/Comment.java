package cn.bdqn.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 
 * @author clack 留言表
 */
public class Comment implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer ecId;//编号
	private String ecContent;// 发表留言的内容
	private Timestamp ecCreateTime;// 创建时间
	private String ecReply;// 针对留言的回复
	private Timestamp ecReplyTime;//回复时间
	private String ecNickName;// 留言用户的昵称

	public Integer getEcId() {
		return ecId;
	}

	public void setEcId(Integer ecId) {
		this.ecId = ecId;
	}

	public String getEcContent() {
		return ecContent;
	}

	public void setEcContent(String ecContent) {
		this.ecContent = ecContent;
	}

	public Timestamp getEcCreateTime() {
		return ecCreateTime;
	}

	public void setEcCreateTime(Timestamp ecCreateTime) {
		this.ecCreateTime = ecCreateTime;
	}

	public String getEcReply() {
		return ecReply;
	}

	public void setEcReply(String ecReply) {
		this.ecReply = ecReply;
	}

	public Timestamp getEcReplyTime() {
		return ecReplyTime;
	}

	public void setEcReplyTime(Timestamp ecReplyTime) {
		this.ecReplyTime = ecReplyTime;
	}

	public String getEcNickName() {
		return ecNickName;
	}

	public void setEcNickName(String ecNickName) {
		this.ecNickName = ecNickName;
	}

	public Comment(Integer ecId, String ecContent, Timestamp ecCreateTime,
			String ecReply, Timestamp ecReplyTime, String ecNickName) {
		super();
		this.ecId = ecId;
		this.ecContent = ecContent;
		this.ecCreateTime = ecCreateTime;
		this.ecReply = ecReply;
		this.ecReplyTime = ecReplyTime;
		this.ecNickName = ecNickName;
	}

	public Comment() {
		super();
	}

}
