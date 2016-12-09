package com.jg2b.api.crm.queryCustInfo.pojo;

import java.util.Date;
import java.sql.Timestamp;

public class ServiceNotesPojo {
	private String id;
	private String owner;
	private String recepter;
	private String rcpttitle;
	private String rcptphone;
	private Integer method;
	private String content;
	private Date begintime;
	private Date endtime;
	private String csid;
	private String results;
	private Timestamp updatetime;
	private String description;
	private Integer deleted;
	private String createtime;

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getRecepter() {
		return recepter;
	}
	public void setRecepter(String recepter) {
		this.recepter = recepter;
	}
	public String getRcpttitle() {
		return rcpttitle;
	}
	public void setRcpttitle(String rcpttitle) {
		this.rcpttitle = rcpttitle;
	}
	public String getRcptphone() {
		return rcptphone;
	}
	public void setRcptphone(String rcptphone) {
		this.rcptphone = rcptphone;
	}
	public Integer getMethod() {
		return method;
	}
	public void setMethod(Integer method) {
		this.method = method;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getBegintime() {
		return begintime;
	}
	public void setBegintime(Date begintime) {
		this.begintime = begintime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public String getCsid() {
		return csid;
	}
	public void setCsid(String csid) {
		this.csid = csid;
	}
	public String getResults() {
		return results;
	}
	public void setResults(String results) {
		this.results = results;
	}
	public Timestamp getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getDeleted() {
		return deleted;
	}
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	
}
