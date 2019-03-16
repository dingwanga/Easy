 package cn.bdqn.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 
 * @author clack 新闻表
 */
public class News implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer enId; // 新闻id
	private String enTitle;// 新闻标题
	private String enContent;//新闻内容
	private Timestamp enCreateTime;// 创建时间

	public Integer getEnId() {
		return enId;
	}

	public void setEnId(Integer enId) {
		this.enId = enId;
	}

	public String getEnTitle() {
		return enTitle;
	}

	public void setEnTitle(String enTitle) {
		this.enTitle = enTitle;
	}

	public String getEnContent() {
		return enContent;
	}

	public void setEnContent(String enContent) {
		this.enContent = enContent;
	}

	public Timestamp getEnCreateTime() {
		return enCreateTime;
	}

	public void setEnCreateTime(Timestamp enCreateTime) {
		this.enCreateTime = enCreateTime;
	}

	public News() {
		super();
		// TODO Auto-generated constructor stub
	}

	public News(Integer enId, String enTitle, String enContent,
			Timestamp enCreateTime) {
		super();
		this.enId = enId;
		this.enTitle = enTitle;
		this.enContent = enContent;
		this.enCreateTime = enCreateTime;
	}

	
	
}
