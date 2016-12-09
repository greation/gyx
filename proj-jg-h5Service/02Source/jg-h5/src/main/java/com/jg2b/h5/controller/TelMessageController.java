package com.jg2b.h5.controller;

import java.util.HashMap;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jg2b.h5.service.impl.CCPRestSDK;
import com.jg2b.h5.vo.UserVo;
import com.jg2b.utils.GeneratorRandomUtils;
import com.jg2b.utils.ReadPropertiesUtils;

/**
 * 发送手机验证码接口
 * @author gongjp
 * 当statusCode不等于000000时代表发送失败
 */
@Controller
@RequestMapping("/message")
public class TelMessageController {
	private static Logger LOGGER = LoggerFactory.getLogger(TelMessageController.class);
	
	/**
	 * 发送手机验证码
	 * @param telphone
	 * @return HashMap<String,Object>
	 * @author gongjp
	 * @date 2016-07-05 上午 10:58:23
	 */
	@RequestMapping(value="/sendMessage",produces = "application/json;charset=UTF-8",method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String,Object> sendMessage(@RequestBody UserVo requestPara){
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
			        templateSMS = ccpRestSDK.sendTemplateSMS(requestPara.getMobile(),
					ReadPropertiesUtils.readProp("templateId"),
					new String[]{GeneratorRandomUtils.createRandom(false,6),
				    ReadPropertiesUtils.readProp("validTime")});
			if("000000".equals(templateSMS.get("statusCode"))){
				//正常返回输出data包体信息（map）
				@SuppressWarnings("unchecked")
				HashMap<String,Object> data = (HashMap<String, Object>) templateSMS.get("data");
				Set<String> keySet = data.keySet();
				for(String key:keySet){ 
				Object object = data.get(key); 
				System.out.println();
				LOGGER.error("发送验证码响应结果:"+key+"= "+object);
			   }
			  }   
			else{
				//异常返回输出错误码和错误信息
			  System.out.println("错误码=" + templateSMS.get("statusCode") +" 错误信息= "+templateSMS.get("statusMsg"));
			  LOGGER.error("发送手机验证码异常","错误码=" + templateSMS.get("statusCode") +" 错误信息= "+templateSMS.get("statusMsg"));
			  templateSMS.put("statusMsg","send fail");
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("发送手机验证码异常",e);
		}
		return templateSMS;
	}
}
