package com.jg2b.api.crm.customerManage.dao;

import java.util.List;

import com.jg2b.api.crm.customerManage.pojo.CodesPojo;
import com.jg2b.api.crm.login.pojo.UserPojo;

public interface CodeDao {

	List<CodesPojo> queryCodesAndIndustry();

	List<CodesPojo> queryCodesAndCorpKind();

	List<CodesPojo> queryCodeAndRegion();

	List<CodesPojo> queryCodeAndChannel();

	List<UserPojo> queryCodesAndUser();

	List<CodesPojo> queryCodeAndsource();

}
