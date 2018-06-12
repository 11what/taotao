package com.taotao.content.service;

import java.util.List;

import com.taotao.pojo.EasyUITreeNode;
import com.taotao.pojo.TaotaoResult;

public interface ContentCategoryService {
	
	public List<EasyUITreeNode> getContentCategoryList(long parentId);
	
	public TaotaoResult addContentCategory(long parentId, String name);
	
	public TaotaoResult updateContentCategory(long id, String name);
	
	public TaotaoResult deleteContentCategory(long id);
}
