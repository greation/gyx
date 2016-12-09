package com.jg2b.h5.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;








import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.jg2b.h5.respons.PicUploadResult;
import com.jg2b.utils.ReadPropertiesUtils;

@Controller
@RequestMapping("/upload")
public class Jg2bUploadController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Jg2bUploadController.class);


	// 允许上传的格式
	private static final String[] IMAGE_TYPE = new String[] { ".bmp", ".jpg", ".jpeg", ".gif", ".png" };


	/**
	 * 
	 * @param uploadFile
	 * @param response
	 * @return
	 * @throws Exception
	 * @author gongjp
	 * @date 2016-07-04 下午 16:18:21
	 */
	@RequestMapping(value="/uploadPic",produces = "application/json;charset=UTF-8", method ={ RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public List<PicUploadResult> upload( HttpServletResponse response, HttpServletRequest request) throws Exception {
		List<PicUploadResult> list=new ArrayList<PicUploadResult>();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultiValueMap<String,MultipartFile> map = multipartRequest.getMultiFileMap();
		List<MultipartFile> list2=new ArrayList<MultipartFile>();
		List<MultipartFile> list3=new ArrayList<MultipartFile>();
		Set<String> sets = map.keySet();
		for (String string : sets) {
			 list3 = map.get(string);
			 list2.addAll(list3);
		}
		PicUploadResult fileUploadResult=null;
		for(MultipartFile myfile : list2){  
            if(myfile.isEmpty()){  
                System.out.println("文件未上传"); 
                LOGGER.debug("文件未上传");
            }else{
        		// 校验图片格式
        		boolean isLegal = false;
        		for (String type : IMAGE_TYPE) {
        			if (StringUtils.endsWithIgnoreCase(myfile.getOriginalFilename(), type)) {
        				isLegal = true;
        				break;
        			}
        		}
        		// 封装Result对象，并且将文件的byte数组放置到result对象中
        		fileUploadResult = new PicUploadResult();
        		// 状态
        		fileUploadResult.setError(isLegal ? 0 : 1);
        		// 文件新路径
        		String filePath = getFilePath(myfile.getOriginalFilename());
        		if (LOGGER.isDebugEnabled()) {
        			LOGGER.debug("Pic file upload .[{}] to [{}] .", myfile.getOriginalFilename(), filePath);
        		}
        		// 生成图片的绝对引用地址
        		String picUrl = StringUtils.replace(StringUtils.substringAfter(filePath, ReadPropertiesUtils.readProp("REPOSITORY_PATH")), "\\", "/");
        		fileUploadResult.setUrl(picUrl);
        		File newFile = new File(request.getSession().getServletContext().getRealPath("/"+picUrl));
        		// 写文件到磁盘
        		myfile.transferTo(newFile);
        		// 校验图片是否合法
        		isLegal = false;
        		try {
        			BufferedImage image = ImageIO.read(newFile);
        			if (image != null) {
        				fileUploadResult.setWidth(image.getWidth() + "");
        				fileUploadResult.setHeight(image.getHeight() + "");
        				isLegal = true;
        			}
        		} catch (IOException e) {
        			LOGGER.info("上传文件失败", e);
        		}
        		// 状态
        		fileUploadResult.setError(isLegal ? 0 : 1);
        		if (!isLegal) {
        			// 不合法，将磁盘上的文件删除
        			newFile.delete();
        		}
        		response.setContentType(MediaType.TEXT_HTML_VALUE);
            	list.add(fileUploadResult);
            }
          }
		
		return list;
	}

	private String getFilePath(String sourceFileName) {
		String baseFolder =ReadPropertiesUtils.readProp("REPOSITORY_PATH") + File.separator + "image";
		Date nowDate = new Date();
		// yyyy/MM/dd
		String fileFolder = baseFolder
				+ File.separator + new DateTime(nowDate).toString("yyyy") + File.separator + new DateTime(nowDate).toString("MM") + File.separator
				+ new DateTime(nowDate).toString("dd");
		File file = new File(fileFolder);
		if (!file.isDirectory()) {
			// 如果目录不存在，则创建目录
			file.mkdirs();
		}
		// 生成新的文件名
		String fileName = new DateTime(nowDate).toString("yyyyMMddhhmmssSSSS") + RandomUtils.nextInt(100, 9999) + "." + StringUtils.substringAfterLast(sourceFileName, ".");
		return baseFolder + File.separator + fileName;
	}
}

