package com.taotao.service;

import com.taotao.pojo.EasyUIDataGridResult;
import com.taotao.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

public interface ItemService {
	TbItem getItemById(long itemId);
	
	EasyUIDataGridResult getItemList(int page, int rows);
	
	public TaotaoResult createItem(TbItem tbItem, String desc) throws Exception;
}
