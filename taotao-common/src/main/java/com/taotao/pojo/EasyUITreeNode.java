package com.taotao.pojo;

import java.io.Serializable;

/**
 * easyuitree接收数据格式
 * @author yzwangc
 *
 */
public class EasyUITreeNode implements Serializable{

	private static final long serialVersionUID = 1L;

	private long id;
	
	private String state;
	
	private String text;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
