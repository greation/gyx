package com.jg2b.api.crm.contants;

/**
 * <p>[描述信息：CRM公共常量类]</p>
 *
 * @author 林雨竹 - linyuzhu@jg2b.com
 * @version 1.0 Created on 2016年5月4日 上午11:06:09
 */
public class CrmCommCtants {
	
	/** 返回消息-成功*/
	public static final String RESULT_SUCC_MSG="执行成功";
	/** 返回消息-失败*/
	public static final String RESULT_FLASE_MSG="执行成功";

	/**
	 * <p>[描述信息：订阅者类型]</p>
	 *
	 * @author 林雨竹 - linyuzhu@jg2b.com
	 * @version 1.0 Created on 2016年5月4日 上午11:31:33
	 */
	public enum COMM_SUBSCRIBERTYPE { 
		
		COMM_CUSTOMER_SUBTYPE("CUSTOMER","订阅者类型-客户"),
		COMM_CONTACTS_SUBTYPE("CONTACTS","订阅者类型-联系人");
		 
		
		private String code;
		private String name;
		
		private COMM_SUBSCRIBERTYPE(String code,String name){
			this.code=code;
			this.name=name;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
}
