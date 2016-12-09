package com.jg2b.conts;

/**
 * <p>[描述信息：基础常量定义]</p>
 *
 * @author 刘毅 
 * @version 1.0 Created on 2016年6月27日 下午2:54:30
 */
public class BaseConts {
	/**基础数据配置START*/
	/*****************/
	//数据有效性(0已经删除,1未删除)
	public static final int DELETE_VALID=0;

	public static final int DELETE_INVALID=1;
	/*****************/
	/**基础数据配置END*/
	  
	
	/**供应商基础常量 START*/
	/*****************/
	//审核状态(1审核通过 ,0未审核)
	public static final int IS_AUDIT_PASS=1;

	public static final int NOT_AUDIT_PASS=0;
	
	//注册来路(pc,system,mobile,app）
	public static final String REGISTER_FROM_PC="pc";
	
	public static final String REGISTER_FROM_SYSTEM="system";
	
	public static final String REGISTER_FROM_MOBILE="mobile";
	
	public static final String REGISTER_FROM_APP="app";
	
	//是否推荐(0不推荐,1推荐 )
	public static final int IS_COMMEND=1;
	
	public static final int NOT_COMMEND=0;
	/*****************/
	/**供应商基础常量 END*/
	
	
	
}
