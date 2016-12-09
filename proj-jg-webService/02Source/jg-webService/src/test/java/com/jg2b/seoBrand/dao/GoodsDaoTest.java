package com.jg2b.seoBrand.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.jg2b.seoPojo.GoodsInfoPojo;
import com.jg2b.seoPojo.GoodsPojo;

public class GoodsDaoTest extends BaseDaoTest{
	
	@Autowired
	GoodsDao goodsDao;
	//配置事务可回滚测试执行的SQL操作
	@Transactional
	@Test
	public void queryGoodsAttributesByUuid(){
		GoodsInfoPojo goodsInfoPojo=new GoodsInfoPojo();
		goodsInfoPojo.setGoodsUuid("000e552657e34882b8c5f5e16daa7f59");;
		List<GoodsInfoPojo> list=goodsDao.queryGoodsAttributesByUuid(goodsInfoPojo);
	}
	
	@Test
	public void queryGoodsPojoByUuid(){
		GoodsPojo goodsPojo=new GoodsPojo();
		goodsDao.queryGoodsByUuid(goodsPojo);
	}
	
	
	@Test
	public void queryGoodsList(){
		GoodsPojo goodsPojo=new GoodsPojo();
		goodsDao.queryGoodsList(goodsPojo, 1, 0);
	}
}
