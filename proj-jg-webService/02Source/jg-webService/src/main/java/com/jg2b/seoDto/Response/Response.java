package com.jg2b.seoDto.Response;

public  class Response {

	public static int ErrorState = 0;
	public static int IsOkState = 1;
	
	private int state;// 响应状态
	private String message;// 响应信息

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
