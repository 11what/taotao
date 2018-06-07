package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.EasyUITreeNode;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.pojo.TbItemCatExample.Criteria;
import com.taotao.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService {
	@Autowired
	private TbItemCatMapper itemCatMapper;
	@Override
	public List<EasyUITreeNode> getItemCatList(long parentId) {
		
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		
		List<EasyUITreeNode> nodeList = new ArrayList<EasyUITreeNode>();
		for (TbItemCat itemCat : list) {
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(itemCat.getId());
			node.setState(itemCat.getIsParent() ? "closed" : "open");
			node.setText(itemCat.getName());
			nodeList.add(node);
		}
		
		return nodeList;
	}

}
