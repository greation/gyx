package com.jg2b.common.baseBean;

import java.sql.Time;

/**
 * <p>
 * [描述信息：流文件附件类，该类ID属性逻辑上与AttachmentBaseBean ID关联]
 * </p>
 * 
 * @author 林雨竹 - linyuzhu@jg2b.com
 * @version 1.0 Created on 2016年5月3日 下午2:01:14
 */
public class StreamAttachsBaseBean extends BaseBean {
	// 媒体时长
	private Time length;
	// 媒体帧数
	private int frames;
	// 编码器
	private String encoder;

	public Time getLength() {
		return length;
	}

	public void setLength(Time length) {
		this.length = length;
	}

	public int getFrames() {
		return frames;
	}

	public void setFrames(int frames) {
		this.frames = frames;
	}

	public String getEncoder() {
		return encoder;
	}

	public void setEncoder(String encoder) {
		this.encoder = encoder;
	}
	
}
