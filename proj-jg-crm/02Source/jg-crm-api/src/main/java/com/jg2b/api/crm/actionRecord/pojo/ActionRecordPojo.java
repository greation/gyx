package com.jg2b.api.crm.actionRecord.pojo;
import java.util.Date;

import com.jg2b.common.baseBean.BaseBean;


public class ActionRecordPojo extends BaseBean {
	    /**行动记录联系人职位**/
        private  String position;
		/**所属客户*/
		private String owners;
		/**联系id*/
		private String rcpCid;
		/**联系人*/
		private String recepter;
		/**职位*/
		private String rcptTitle;
		/**联系人电话*/
		private String rcptPhone;
		/**服务方式*/
		private int method;
		/**服务内容*/
		private String content;
		/**访问开始时间*/
		private Date beginTime;
	    /**访问结束时间*/
		private Date endTime;
		/**访问地址*/
		private String address;
		/**客服人员*/
		private String csName;
		/**访问结果*/
		private String results;
		/**创建时间*/
		private Date createTime;
		/***描述*/
		private String desription;
		/**是否有效*/
		private int deleted;
		
		private String csID;
		public String getPosition() {
			return position;
		}
		public void setPosition(String position) {
			this.position = position;
		}
		public String getCsID() {
			return csID;
		}
		public void setCsID(String csID) {
			this.csID = csID;
		}
		public String getRcpCid() {
			return rcpCid;
		}
		public void setRcpCid(String rcpCid) {
			this.rcpCid = rcpCid;
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
		public String getOwners() {
			return owners;
		}
		public void setOwners(String owners) {
			this.owners = owners;
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
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
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
		public String getCsName() {
			return csName;
		}
		public void setCsName(String csName) {
			this.csName = csName;
		}
			
}
