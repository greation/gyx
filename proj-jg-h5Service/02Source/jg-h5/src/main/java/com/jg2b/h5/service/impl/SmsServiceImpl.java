package com.jg2b.h5.service.impl;

import java.util.HashMap;
import java.util.Random;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jg2b.h5.pojo.UserPojo;
import com.jg2b.h5.service.SmsService;
import com.jg2b.utils.ReadPropertiesUtils;

@Service
public class SmsServiceImpl implements SmsService {
	private static Logger LOGGER = LoggerFactory.getLogger(SmsServiceImpl.class); 
	@Autowired
	private com.jg2b.h5.dao.UserDao userDao;
	/**
	 * <p>向短信服务平台发送手机验证码</p>
	 * 
	 * @param phone(发送手机号)
	 * @return String 返回验证码信息
	 * @author:刘毅 
	 * @date: Created on 2016年7月4日 下午1:55:38
	 */
	public String sendVerificationCode(String phone) {
		String verificationCode=getVerificationCode();
		//发送短信start
		this.sendMsgToPhone(phone,verificationCode);
		//发送短信end
		return this.sendMsgToPhone(phone,verificationCode)?verificationCode:null;
	}

	/**
	 * <p>
	 * 随机生成四位数字验证码
	 * </p>
	 * 
	 * @return
	 * @author:刘毅
	 * @date: Created on 2016年7月4日 下午1:59:27
	 */
	private String getVerificationCode(){
		int intCount = 0;
		intCount = (new Random()).nextInt(9999);//
		if (intCount < 1000)
			intCount += 1000;
		return intCount + "";
	}
	
	
	private boolean sendMsgToPhone(String mobile,String verificationCode){
		boolean sendResult=false;
		
		HashMap<String, Object> templateSMS = new HashMap<String, Object>();
		CCPRestSDK ccpRestSDK=new CCPRestSDK();
		try {
			// 初始化应用ID，请使用自己创建应用的APPID
			ccpRestSDK.setAppId(ReadPropertiesUtils.readProp("appId"));
			// 初始化服务器地址和端口
			ccpRestSDK.init(ReadPropertiesUtils.readProp("serverIP"), ReadPropertiesUtils.readProp("serverPort"));
			// 初始化主账号名称和主账号令牌，登陆云通讯网站后，可在“控制台-应用”中看到开发者主账号ACCOUNT SID和主账号令牌AUTH TOKEN。
			ccpRestSDK.setAccount(ReadPropertiesUtils.readProp("accountSid"),
					ReadPropertiesUtils.readProp("accountToken"));
			        templateSMS = ccpRestSDK.sendTemplateSMS(mobile,
					ReadPropertiesUtils.readProp("templateId"),
					/*new String[]{GeneratorRandomUtils.createRandom(false,6),
				    ReadPropertiesUtils.readProp("validTime")});*/
					new String[]{verificationCode,
							ReadPropertiesUtils.readProp("validTime") });
			        
			//针对平台返回频繁发送的情况了默认为成功
			if ("160038".equals(templateSMS.get("statusCode"))) {
				LOGGER.info("错误码=" + templateSMS.get("statusCode") +" 错误信息= "+templateSMS.get("statusMsg"));
				  LOGGER.error("发送手机验证码异常","错误码=" + templateSMS.get("statusCode") +" 错误信息= "+templateSMS.get("statusMsg"));
				  templateSMS.put("statusMsg","send fail");
				  sendResult = true;
			}
			if ("000000".equals(templateSMS.get("statusCode"))) {
				// 正常返回输出data包体信息（map）
				@SuppressWarnings("unchecked")
				HashMap<String, Object> data = (HashMap<String, Object>) templateSMS
						.get("data");
				Set<String> keySet = data.keySet();
				for (String key : keySet) {
					Object object = data.get(key);
					LOGGER.error("发送验证码响应结果:" + key + "= " + object);
					sendResult = true;
				}
			}
			else{
				//异常返回输出错误码和错误信息
				LOGGER.info("错误码=" + templateSMS.get("statusCode") +" 错误信息= "+templateSMS.get("statusMsg"));
			  LOGGER.error("发送手机验证码异常","错误码=" + templateSMS.get("statusCode") +" 错误信息= "+templateSMS.get("statusMsg"));
			  templateSMS.put("statusMsg","send fail");
			}
		}catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("发送手机验证码异常",e);
		}
		return sendResult;
	}

	@Override
	public String checkUser(String mobile) {
		return userDao.checkUser(mobile);
	}
}
