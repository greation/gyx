package com.jg2b.web.crm.traces.service.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jg2b.api.crm.login.pojo.UserPojo;
import com.jg2b.api.crm.traces.dao.ICommonTracesDAO;
import com.jg2b.api.crm.traces.pojo.TracesPojo;
import com.jg2b.api.crm.traces.service.ICommonTracesService;

@Service("commonTracesService")
public class CommonTracesServiceImpl implements ICommonTracesService {

	@Autowired
	private ICommonTracesDAO commonTracesDAO;

	/**
	 * 日志操作类
	 */
	private static Logger logger = Logger.getLogger(CommonTracesServiceImpl.class);


	

	
	/** 
	 * @author  作者：zhangyaotang
	 * @date 创建时间：2016年5月11日 上午10:03:13 
	 * @version 1.0 
	 * @param tabeName 表名
	 * @param dataId 数据的ID
	 * @param old 旧数据
	 * @param now 更改后的数据
	 * @param act 操作类型0：新增，1：修改，2：删除
	 * @param user 登陆用户
	 * @throws Exception
	 * @return 无
	 */
	@Override
	public <T> void saveTraces(String tabeName, String dataId, T old, T now,
			String act,UserPojo user) throws Exception {
		if(null!=old&&null!=now){
			if (old.getClass() != now.getClass()) {
				throw new Exception("新旧数据类型不一致,请检查!:" + "旧数据的类型为" + old.getClass()
						+ ",新数据的类型为" + now.getClass());
			}
		}
		List<TracesPojo> list = compile(old, now, dataId, tabeName, act, String.valueOf(user.getGID()));
		commonTracesDAO.saveTracesPojoS(list);
	}

	
	/** 
	 * @author  作者：zhangyaotang
	 * @date 创建时间：2016年5月11日 上午10:06:55 
	 * @version 1.0 
	 * @param source
	 * @param target
	 * @param dataId
	 * @param tableName
	 * @param act
	 * @param userId
	 * @return
	 * @since  
	 */
	private List<TracesPojo> compile(Object source, Object target,
			String dataId, String tableName, String act, String userId) {
		String serialNo = UUID.randomUUID().toString().replace("-", "");//获取操作流水号
		List<TracesPojo> tps = new ArrayList<TracesPojo>();
		if (act.equals("0") || act.equals("2")) {// 新增or删除操作
			TracesPojo tp = new TracesPojo();
			tp.setSubscriberType(tableName);
			tp.setSubscriberID(dataId);
			tp.setAction(act);
			tp.setCreator(userId);
			tp.setSerialNo(serialNo);
			tp.setDeleted(false);
			tps.add(tp);
			return tps;
		}
		if (source instanceof Map || source instanceof List
				|| source instanceof Set) {
			throw new IllegalArgumentException("不能对集合或者MAP进行操作");
		}
		Class<?> srcClass = source.getClass();
		Field[] fields = srcClass.getDeclaredFields();
		
		for (Field field : fields) {
			String nameKey = field.getName();
			if (nameKey.equalsIgnoreCase("ID")
					|| nameKey.equalsIgnoreCase("UpdateTime")) {// 过滤掉ID跟更新时间字段
				continue;
			}
			field.setAccessible(true);
			try {
				String beforeV = field.get(source)== null ? "" : field.get(source).toString();
				String afterV = field.get(target)== null ? "" : field.get(target).toString();
				if (!beforeV.equals(afterV)) {
					TracesPojo tp = new TracesPojo();
					tp.setSubscriberType(tableName);
					tp.setSubscriberID(dataId);
					tp.setAction(act);
					tp.setFields(nameKey);
					tp.setBefore(beforeV);
					tp.setAfter(afterV);
					tp.setCreator(userId);
					tp.setDeleted(false);
					tp.setSerialNo(serialNo);
					tps.add(tp);
				}

			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
				logger.error(e.getMessage());
				throw new RuntimeException("数据对比出错", e);
			}
		}
		return tps;
	}

}
