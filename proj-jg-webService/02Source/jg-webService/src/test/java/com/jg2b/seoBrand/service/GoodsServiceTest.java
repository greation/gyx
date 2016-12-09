package com.jg2b.seoBrand.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jg2b.seoBrand.dao.BaseDaoTest;
import com.jg2b.seoBrand.dao.CompanyDao;
import com.jg2b.seoBrand.dao.GoodsDao;

public class GoodsServiceTest extends BaseDaoTest{
	@Autowired
	GoodsDao goodsDao;
	
	@Autowired
	GoodsService goodsService;
	
	//@Autowired
	@Test
	public void test(){
		System.out.println(goodsService);
		goodsService.queryGoodsByUuid("220c85afbd1142239b33ccb0df8fdfcf");
	}
}
