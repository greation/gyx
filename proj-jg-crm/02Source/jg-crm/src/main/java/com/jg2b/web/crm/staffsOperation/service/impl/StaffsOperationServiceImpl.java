package com.jg2b.web.crm.staffsOperation.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jg2b.api.crm.staffsOperation.dao.IStaffsOperationDAO;
import com.jg2b.api.crm.staffsOperation.pojo.DepartmentsPojo;
import com.jg2b.api.crm.staffsOperation.pojo.StaffsPojo;
import com.jg2b.api.crm.staffsOperation.service.IStaffsOperationService;

@Service("staffsOperationService")
public class StaffsOperationServiceImpl implements IStaffsOperationService {
	@Autowired
	IStaffsOperationDAO staffsOperationDAO;
	
	@Override
	public List<StaffsPojo> findUnderlingInfo(String userId,String name) {
		StaffsPojo sp = staffsOperationDAO.findStaffsOperationByCustId(userId);
		List<DepartmentsPojo> DPS = new ArrayList<DepartmentsPojo>();
		DepartmentsPojo dp = new DepartmentsPojo();
		dp.setCode(sp.getDepartment());
		findChildList(dp,DPS);
		//统计前部门的编码以及所有下属部门的编码
		List<String> DpsCodes = new ArrayList<String>();
		DpsCodes.add(sp.getDepartment());
		for (DepartmentsPojo dep : DPS) {
			DpsCodes.add(dep.getCode());
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("DpsCodes", DpsCodes);
		map.put("name", name);
		return staffsOperationDAO.findStaffsPojoByDepartmentsIdList(map);
	}
	
	/** 
	 * 查询部门下的所有下级部门(递归)
	 * @author  作者：zhangyaotang
	 * @date 创建时间：2016年5月12日 下午1:16:04 
	 * @version 1.0 
	 * @param dp 当前部门实体
	 * @param list 存放下级部门的list
	 */
	private void findChildList(DepartmentsPojo dp,List<DepartmentsPojo> list){
		List<DepartmentsPojo> childList = staffsOperationDAO.findAllSubordinatesDepartmentsByID(dp.getCode());
		int size = childList.size();
		if(childList.size()>0){
			list.addAll(childList);
			for(int i = 0; i < size; i++){
				findChildList(childList.get(i),list);
			}
		}
    }

}
