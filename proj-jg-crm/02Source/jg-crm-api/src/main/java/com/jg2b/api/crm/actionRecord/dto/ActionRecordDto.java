package com.jg2b.api.crm.actionRecord.dto;
import java.io.Serializable;
import java.util.Date;
public class ActionRecordDto implements Serializable{
	private static final long serialVersionUID = 1L;
	/**行动记录ID*/
	private int id;
	/**行动记录GID*/
	private String gid;
	/** 客户名称*/
	private String cusName;
	/**联系人id*/
	private String rcptId;
	/**客户gid*/
	private String ower;
	/**客户id*/
	private int cusId;
	/**联系人id*/
	private String rcpCid;
	/**联系人*/
	private String recepter;
	/**职位*/
	private String rcptTitle;
	/**联系人电话*/
	private String rcptPhone;
	/**访问方式*/
	private int method;
	/**访问内容*/
	private String content;
	/**访问开始时间*/
	private String beginTime;
    /**访问结束时间*/
	private String endTime;
	/**访问地址*/
	private String address;
	/**服务人员*/
	private String csId;
	/**服务姓名*/
	private String csName;
	/**访问结果*/
	private String results;
	/**创建时间*/
	private Date createTime;
	/***描述*/
	private String desription;
	/**是否有效*/
	private int deleted;
	
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public int getCusId() {
		return cusId;
	}
	public void setCusId(int cusId) {
		this.cusId = cusId;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getRcpCid() {
		return rcpCid;
	}
	public void setRcpCid(String rcpCid) {
		this.rcpCid = rcpCid;
	}
	public String getCsName() {
		return csName;
	}
	public void setCsName(String csName) {
		this.csName = csName;
	}
	public String getRcptId() {
		return rcptId;
	}
	public void setRcptId(String rcptId) {
		this.rcptId = rcptId;
	}
	public String getRecepter() {
		return recepter;
	}
	public void setRecepter(String recepter) {
		this.recepter = recepter;
	}
	public String getRcptTitle() {
		return rcptTitle;
	}
	public void setRcptTitle(String rcptTitle) {
		this.rcptTitle = rcptTitle;
	}
	public String getRcptPhone() {
		return rcptPhone;
	}
	public void setRcptPhone(String rcptPhone) {
		this.rcptPhone = rcptPhone;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public int getMethod() {
		return method;
	}
	public void setMethod(int method) {
		this.method = method;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOwer() {
		return ower;
	}
	public void setOwer(String ower) {
		this.ower = ower;
	}
	public String getCsId() {
		return csId;
	}
	public void setCsId(String csId) {
		this.csId = csId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getResults() {
		return results;
	}
	public void setResults(String results) {
		this.results = results;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getDesription() {
		return desription;
	}
	public void setDesription(String desription) {
		this.desription = desription;
	}
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
}
