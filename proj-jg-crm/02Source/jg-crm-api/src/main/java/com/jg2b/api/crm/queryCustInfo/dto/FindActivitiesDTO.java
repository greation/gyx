package com.jg2b.api.crm.queryCustInfo.dto;

import java.util.List;

public class FindActivitiesDTO {
	private String nowDate;//日期--年月日
	private List<ServiceNotesDTO> snts;
	
	public String getNowDate() {
		return nowDate;
	}
	
	public void setNowDate(String nowDate) {
		this.nowDate = nowDate;
	}
	public List<ServiceNotesDTO> getSnts() {
		return snts;
	}
	public void setSnts(List<ServiceNotesDTO> snts) {
		this.snts = snts;
	}
	
}
