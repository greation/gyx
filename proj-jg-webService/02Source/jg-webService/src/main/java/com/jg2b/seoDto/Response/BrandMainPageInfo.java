package com.jg2b.seoDto.Response;

import java.io.Serializable;

import com.jg2b.seoPojo.BrandPojo;
import com.jg2b.seoPojo.KindPojo;

public class BrandMainPageInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8798787656126793908L;
	//入驻供应商数
	private int enteringSupplierNum;
	//询价次数
	private int enquiryNum;
	//撮合订单数
	private int matchBillNum;
	//感兴趣
	private int interestedNum;
	//采购过
	private int purchasedNum;
	//品牌信息
	BrandPojo brandPojo;
	//分类信息
	KindPojo kindPojo;
	
	private int orderNum;//撮合订单数
	
	public KindPojo getKindPojo() {
		return kindPojo;
	}
	public void setKindPojo(KindPojo kindPojo) {
		this.kindPojo = kindPojo;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public BrandPojo getBrandPojo() {
		return brandPojo;
	}
	public void setBrandPojo(BrandPojo brandPojo) {
		this.brandPojo = brandPojo;
	}
	public int getEnteringSupplierNum() {
		return enteringSupplierNum;
	}
	public void setEnteringSupplierNum(int enteringSupplierNum) {
		this.enteringSupplierNum = enteringSupplierNum;
	}
	public int getEnquiryNum() {
		return enquiryNum;
	}
	public void setEnquiryNum(int enquiryNum) {
		this.enquiryNum = enquiryNum;
	}
	public int getMatchBillNum() {
		return matchBillNum;
	}
	public void setMatchBillNum(int matchBillNum) {
		this.matchBillNum = matchBillNum;
	}
	public int getInterestedNum() {
		return interestedNum;
	}
	public void setInterestedNum(int interestedNum) {
		this.interestedNum = interestedNum;
	}
	public int getPurchasedNum() {
		return purchasedNum;
	}
	public void setPurchasedNum(int purchasedNum) {
		this.purchasedNum = purchasedNum;
	}
	
}
