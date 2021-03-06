package com.taotao.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * easyui-datagrid接收数据格式
 * @author yzwangc
 *
 */
public class EasyUIDataGridResult implements Serializable{

	private static final long serialVersionUID = 1L;

	private long total;
	
	private List<?> rows;

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}
}
