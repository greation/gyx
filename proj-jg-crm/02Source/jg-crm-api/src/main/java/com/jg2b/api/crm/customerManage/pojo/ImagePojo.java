package com.jg2b.api.crm.customerManage.pojo;

import java.util.Date;

public class ImagePojo {
	private int id;
	private String attaID;
	private int attaType;
	private String subScriberType;
	private String subScriberID;
	private String groudID;
	private String primitiveName;
	private String storageName;
	private String storagePath;
	private String eExtensions;
	private int bytes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAttaID() {
		return attaID;
	}

	public void setAttaID(String attaID) {
		this.attaID = attaID;
	}

	public int getAttaType() {
		return attaType;
	}

	public void setAttaType(int attaType) {
		this.attaType = attaType;
	}

	public String getSubScriberType() {
		return subScriberType;
	}

	public void setSubScriberType(String subScriberType) {
		this.subScriberType = subScriberType;
	}

	public String getSubScriberID() {
		return subScriberID;
	}

	public void setSubScriberID(String subScriberID) {
		this.subScriberID = subScriberID;
	}

	public String getGroudID() {
		return groudID;
	}

	public void setGroudID(String groudID) {
		this.groudID = groudID;
	}

	public String getPrimitiveName() {
		return primitiveName;
	}

	public void setPrimitiveName(String primitiveName) {
		this.primitiveName = primitiveName;
	}

	public String getStorageName() {
		return storageName;
	}

	public void setStorageName(String storageName) {
		this.storageName = storageName;
	}

	public String getStoragePath() {
		return storagePath;
	}

	public void setStoragePath(String storagePath) {
		this.storagePath = storagePath;
	}

	public String geteExtensions() {
		return eExtensions;
	}

	public void seteExtensions(String eExtensions) {
		this.eExtensions = eExtensions;
	}

	public int getBytes() {
		return bytes;
	}

	public void setBytes(int bytes) {
		this.bytes = bytes;
	}

	public String getCheckNo() {
		return checkNo;
	}

	public void setCheckNo(String checkNo) {
		this.checkNo = checkNo;
	}

	public int getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(int algorithm) {
		this.algorithm = algorithm;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	private String checkNo;
	private int algorithm;
	private Date createTime;
	private boolean deleted;

}
