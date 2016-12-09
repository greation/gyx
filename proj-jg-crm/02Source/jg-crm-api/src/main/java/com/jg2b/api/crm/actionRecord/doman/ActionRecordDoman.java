package com.jg2b.api.crm.actionRecord.doman;
import com.jg2b.api.crm.actionRecord.dto.AttachmentDto;
import java.util.Date;
import java.util.List;
public class ActionRecordDoman {
	private static final long serialVersionUID = 1L;
	/**行动记录ID*/
	private int id;
	/**行动记录gID*/ 
	private String gid;
	/** 客户名称*/
	private String cusName;
	/**客户GID*/
	private String cusGid;
	/**客户ID*/
	private String cusId;
	/**联系人*/
	private String recepter;
	/**联系人id*/
	private String rcptID;
	/**职位*/
	private String rcptTitle;
	/**联系人电话*/
	private String rcptPhone;
	/**访问方式*/
	private int method;
	/**访问内容*/
	private String content;
	/**访问开始时间*/
	private Date  beginTime;
    /**访问结束时间*/
	private Date endTime;
	/**用户id*/
	private String csId;
	/**用户姓名*/
	private String csName;
	/**访问结果*/
	private String results;
	/**创建时间*/
	private Date createTime;
	/***描述*/
	private String desription ;
	/**是否有效*/
	private int deleted;
	/**图片**/
	private List<AttachmentDto> attachmentDto;
	
	
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public List<AttachmentDto> getAttachmentDto() {
		return attachmentDto;
	}
	public void setAttachmentDto(List<AttachmentDto> attachmentDto) {
		this.attachmentDto = attachmentDto;
	}
	/***描述*/
	private String address ;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public String getCsName() {
		return csName;
	}
	public void setCsName(String csName) {
		this.csName = csName;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getRcptID() {
		return rcptID;
	}
	public void setRcptID(String rcptID) {
		this.rcptID = rcptID;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public String getCsId() {
		return csId;
	}
	public void setCsId(String csId) {
		this.csId = csId;
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
	public String getCusGid() {
		return cusGid;
	}
	public void setCusGid(String cusGid) {
		this.cusGid = cusGid;
	}
	public String getCusId() {
		return cusId;
	}
	public void setCusId(String cusId) {
		this.cusId = cusId;
	}


}
