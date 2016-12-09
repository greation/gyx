package com.jg2b.common.baseBean;
/**
 * <p>[描述信息：上传文件公共实体类]</p>
 *
 * @author 林雨竹 - linyuzhu@jg2b.com
 * @version 1.0 Created on 2016年5月3日 下午2:14:01
 */
public class UploadCommonBean {
	//一般附件信息
	private AttachmentBaseBean attachMentBean;
	//媒体文件信息
	private MediaAttachsBaseBean mAttachMentBean;
	//流文件信息
	private StreamAttachsBaseBean sAttachMentBean;

	public AttachmentBaseBean getAttachMentBean() {
		return attachMentBean;
	}

	public void setAttachMentBean(AttachmentBaseBean attachMentBean) {
		this.attachMentBean = attachMentBean;
	}

	public MediaAttachsBaseBean getmAttachMentBean() {
		return mAttachMentBean;
	}

	public void setmAttachMentBean(MediaAttachsBaseBean mAttachMentBean) {
		this.mAttachMentBean = mAttachMentBean;
	}

	public StreamAttachsBaseBean getsAttachMentBean() {
		return sAttachMentBean;
	}

	public void setsAttachMentBean(StreamAttachsBaseBean sAttachMentBean) {
		this.sAttachMentBean = sAttachMentBean;
	}
}
