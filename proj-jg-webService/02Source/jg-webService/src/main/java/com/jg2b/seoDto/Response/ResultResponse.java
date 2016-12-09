package com.jg2b.seoDto.Response;

/**
 * <p>[接口统一返回实体]</p>
 *
 * @author 刘毅 
 * @version 1.0 Created on 2016年6月23日 上午11:53:24
 */
public  class ResultResponse {

	public static int ErrorState = 0;
	public static int IsOkState = 1;
	
	private int state;// 		响应状态
	private String message;// 	响应信息
	private Object data;//		业务接口响应实体

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
