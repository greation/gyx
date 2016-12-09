package com.jg2b.common.baseBean;

/**
 * <p>
 * [描述信息：通用上传附件类]
 * </p>
 * 
 * @author 林雨竹 - linyuzhu@jg2b.com
 * @version 1.0 Created on 2016年5月3日 下午1:59:46  
 */
public class AttachmentBaseBean extends BaseBean {
	// 原始名称
	private String primitiveName;
	// 存储名称
	private String storageName;
	// 存储路径
	private String storagePath;
	// 文件扩展名
	private String extensions;
	// 文件字节数
	private int bytes;
	// 文件校验码
	private String checkNo;
	// 算法(0:CRC,1:MD5,2:SHA1,3:其它)
	private String algorithm;
	
	private int deleted;
	
	
	
	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
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

	public String getExtensions() {
		return extensions;
	}

	public void setExtensions(String extensions) {
		this.extensions = extensions;
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

	public String getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}

}
