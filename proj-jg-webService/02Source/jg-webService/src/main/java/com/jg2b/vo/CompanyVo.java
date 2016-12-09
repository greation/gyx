package com.jg2b.vo;

/**
 * <p>[描述信息：供应商详情页请求参数定义]</p>
 *
 * @author 刘毅 
 * @version 1.0 Created on 2016年6月30日 下午1:42:11
 */
public class CompanyVo {
	/**供应商uuid*/
	private String companyUuid;
	/**供应商入驻状态*/
	private Integer status;
	/**供应商经营模式*/
	private Integer managementModel;
	
	public String getCompanyUuid() {
		return companyUuid;
	}

	public void setCompanyUuid(String companyUuid) {
		this.companyUuid = companyUuid;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getManagementModel() {
		return managementModel;
	}

	public void setManagementModel(Integer managementModel) {
		this.managementModel = managementModel;
	}
	
	@Override
	public String toString() {
		StringBuffer goodsVoSB=new StringBuffer();
		goodsVoSB.append("companyVo[").append("companyUuid:").append(this.companyUuid)
			.append(",status:").append(this.status).append(",managementModel:")
				.append(this.managementModel).append("]");
		return goodsVoSB.toString();
	}
}
