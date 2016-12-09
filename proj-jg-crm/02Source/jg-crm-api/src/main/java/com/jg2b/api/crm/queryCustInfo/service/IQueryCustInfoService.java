package com.jg2b.api.crm.queryCustInfo.service;


import java.util.List;

import com.jg2b.api.crm.login.pojo.UserPojo;
import com.jg2b.api.crm.queryCustInfo.dto.FindActivitiesDTO;
import com.jg2b.api.crm.queryCustInfo.dto.QueryCustInfoDTO;


public interface IQueryCustInfoService {

    public List<QueryCustInfoDTO> findCustomerInfo(QueryCustInfoDTO dto, UserPojo userPojo);
        
    public Integer checkCustomerByName(String name);

	public List<QueryCustInfoDTO> findContactInfo(QueryCustInfoDTO dto, UserPojo userPojo);

	public List<FindActivitiesDTO> findActivities(QueryCustInfoDTO dto, UserPojo userPojo);
}
