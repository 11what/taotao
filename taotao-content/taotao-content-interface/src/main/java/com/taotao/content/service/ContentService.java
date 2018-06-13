package com.taotao.content.service;


import java.util.List;

import com.taotao.pojo.EasyUIDataGridResult;
import com.taotao.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;

public interface ContentService {
	
	public EasyUIDataGridResult getContentList(long categoryId, int page, int rows);
	
	TaotaoResult addContent(TbContent content);
	
	TaotaoResult updateContent(TbContent content);
	
	TaotaoResult deleteContent(String ids);
		
	TaotaoResult getContent(long id);
	
	List<TbContent> getContentListByCid(long cid);
}
