package com.jg2b.common.pojo;

import com.jg2b.common.baseBean.AttachmentBaseBean;

/**
 * <p>
 * [描述信息：通用上传附件类]
 * </p>
 * 
 * @author 林雨竹 - linyuzhu@jg2b.com
 * @version 1.0 Created on 2016年5月3日 下午1:59:46
 */
public class AttachmentPojo extends AttachmentBaseBean {
	
	//附件类型(0:图片,1:视频,2:音频,3:其它文档)
	private int attaType;
	//订阅者类型
	private String subScriberType;
	//订阅者ID
	private String subScriberID;
	//附件分组ID
	private String group;
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

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}
}
