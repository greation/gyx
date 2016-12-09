package com.jg2b.api.crm.queryCustInfo.dao;

import java.util.List;

import com.jg2b.api.crm.queryCustInfo.dto.QueryCustInfoDTO;
import com.jg2b.api.crm.queryCustInfo.dto.ServiceNotesDTO;

public interface IQueryCustInfoDao {
	List<QueryCustInfoDTO> findCustomerInfo(QueryCustInfoDTO dto);
	List<QueryCustInfoDTO> findContactInfo(QueryCustInfoDTO dto);
	List<ServiceNotesDTO> findActivities(QueryCustInfoDTO dto);
}
