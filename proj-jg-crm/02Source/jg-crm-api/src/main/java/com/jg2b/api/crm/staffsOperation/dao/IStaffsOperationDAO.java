package com.jg2b.api.crm.staffsOperation.dao;

import java.util.List;
import java.util.Map;

import com.jg2b.api.crm.staffsOperation.pojo.DepartmentsPojo;
import com.jg2b.api.crm.staffsOperation.pojo.StaffsPojo;

public interface IStaffsOperationDAO {
	/** 
	 * 根据部门ID找到当前部门所有下级(仅直属下级)部门信息
	 * @author  作者：zhangyaotang
	 * @date 创建时间：2016年5月11日 下午4:22:49 
	 * @version 1.0 
	 * @param depId
	 * @return
	 */
	List<DepartmentsPojo> findAllSubordinatesDepartmentsByID(String depId);
	
	/** 
	 * 根据员工编号查询到所在部门
	 * @author  作者：zhangyaotang
	 * @date 创建时间：2016年5月11日 下午7:01:51 
	 * @version 1.0 
	 * @param scode
	 * @return
	 */
	DepartmentsPojo findDepartmentsByStaffsCode(String scode);
	
	
	/** 
	 * 根据登陆用户ID获得当前用户对应的员工信息
	 * @author  作者：zhangyaotang
	 * @date 创建时间：2016年5月11日 下午4:33:10 
	 * @version 1.0 
	 * @param userId
	 * @return
	 */
	StaffsPojo findStaffsOperationByCustId(String userId);

	/** 
	 * 根据部门code列表，获取到所有部门下的员工信息
	 * @author  作者：zhangyaotang
	 * @date 创建时间：2016年5月11日 下午5:14:40 
	 * @version 1.0 
	 * @param dpsIds
	 * @return
	 */
	List<StaffsPojo> findStaffsPojoByDepartmentsIdList(Map map);
}
