package com.jg2b.common.baseBean;

/**
 * <p>
 * [描述信息：媒体文件附件类，该类ID属性逻辑上与AttachmentBaseBean ID关联]
 * </p>
 * 
 * @author 林雨竹 - linyuzhu@jg2b.com
 * @version 1.0 Created on 2016年5月3日 下午2:00:57
 */
public class MediaAttachsBaseBean extends BaseBean {
	// 宽度
	private int width;
	// 高度
	private int height;

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
