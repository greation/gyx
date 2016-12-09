package com.jg2b.common.contants;


public class GlobalContants {

	public static final String P_CRM_UPLOAD_ABSOLUTEPATH = "/usr/local/apache-tomcat-7.0.57/webapps/upload/crm/";

	public static final String P_CRM_DOWNLOAD_ABSOLUTEPATH = "http://192.168.1.109:8080/upload/crm/";

	public static final String P_OPERATE_SIGN = "/";
	
	public static final String P_OPERATE_POINT = ".";

	/**
	 * <p>
	 * [描述信息：订阅者类型]
	 * </p>
	 * 
	 * @author 林雨竹 - linyuzhu@jg2b.com
	 * @version 1.0 Created on 2016年5月4日 上午11:31:33
	 */
	public enum ENUM_SUBSCRIBERTYPE {

		COMM_CUSTOMER_SUBTYPE("CUSTOMER", "订阅者类型-客户");

		private String code;
		private String name;

		private ENUM_SUBSCRIBERTYPE(String code, String name) {
			this.code = code;
			this.name = name;
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
