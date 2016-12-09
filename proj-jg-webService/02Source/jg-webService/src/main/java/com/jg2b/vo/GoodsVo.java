package com.jg2b.vo;

/**
 * <p>[描述信息：商品详情页请求参数定义]</p>
 *
 * @author 刘毅 
 * @version 1.0 Created on 2016年6月30日 下午1:38:56
 */
public class GoodsVo {
	//商品uuid
	private String goodsUuid;

	public String getGoodsUuid() {
		return goodsUuid;
	}

	public void setGoodsUuid(String goodsUuid) {
		this.goodsUuid = goodsUuid;
	}
	@Override
	public String toString() {
		StringBuffer goodsVoSB=new StringBuffer();
		goodsVoSB.append("goodsVo[").append("goodsUuid:").append(this.goodsUuid).append("]");
		return goodsVoSB.toString();
	}
}
