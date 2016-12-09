package com.jg2b.common.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.jg2b.common.baseBean.AttachmentBaseBean;
import com.jg2b.common.baseBean.MediaAttachsBaseBean;
import com.jg2b.common.baseBean.UploadCommonBean;
import com.jg2b.common.contants.GlobalContants;

/**
 * <p>
 * [描述信息：文件上传类]
 * </p>
 * 
 * @author 林雨竹 - linyuzhu@jg2b.com
 * @version 1.0 Created on 2016年5月3日 上午9:36:59
 */
public class FileUploadUtil {
	// 存放相对路径
	private String relativePath = null;
	// 获取的上传请求
	private HttpServletRequest fileuploadReq = null;
	// 设置最多只允许在内存中存储的数据,单位:字节，这个参数不要设置太大
	private int sizeThreshold = 4096;
	// 设置允许用户上传文件大小,单位:字节,共20M
	private long sizeMax = 1024 * 1024 * 20;
	
	/**
	 * 重载构造方法
	 * 
	 * @param relativePath
	 *            存放文件的相对路径，如: 20160503\customer\linyuzhu
	 * @param fileuploadRequest
	 *            request请求对象
	 * @author: 林雨竹 - linyuzhu@jg2b.com
	 * @date: Created on 2016年5月3日 下午4:11:00
	 */
	public FileUploadUtil(String relativePath,
			HttpServletRequest fileuploadRequest) {
		this.relativePath = relativePath;
		this.fileuploadReq = fileuploadRequest;
	}

	/**
	 * <p>
	 * 文件上传
	 * </p>
	 * 
	 * @return
	 * @author: 林雨竹 - linyuzhu@jg2b.com
	 * @date: Created on 2016年5月3日 下午3:21:59
	 */
	public List<UploadCommonBean> UploadFileByStream() {
		List<UploadCommonBean> list = new ArrayList<UploadCommonBean>();
		UploadCommonBean ucBean = null;
		DiskFileItemFactory factory = new DiskFileItemFactory();
		try {
			// 存放文件的绝对路径
			String dstPath = GlobalContants.P_CRM_UPLOAD_ABSOLUTEPATH + "\\"
					+ relativePath;
			// 上传文件时使用的临时路径
			String tempPath = dstPath + "\\temp";
			/*** 1.创建文件存放文件夹 ***/
			FileUtil.mkdirs(dstPath);
			FileUtil.mkdirs(tempPath);
			// 设置最多只允许在内存中存储的数据,单位:字节
			factory.setSizeThreshold(sizeThreshold);
			factory.setRepository(new File(tempPath));
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 设置允许用户上传文件大小,单位:字节
			upload.setSizeMax(sizeMax);
			/**** 2.开始读取上传信息 ***/
			List fileItems = upload.parseRequest(fileuploadReq);
			Iterator iter = fileItems.iterator();
			// 正则匹配，过滤路径取文件名
			String regExp = ".+\\\\(.+)$";
			Pattern p = Pattern.compile(regExp);
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();
				// 忽略非文件域的所有表单信息
				if (!item.isFormField()) {
					String fileName = item.getName();
					long size = item.getSize();
					// 有多个文件域时，只上传有文件的
					if ((fileName == null || fileName.equals("")) && size == 0) {
						continue;
					}
					Matcher m = p.matcher(fileName);
					boolean result = m.find();
					if (result) {
						String ext = fileName.substring(fileName
								.lastIndexOf("."));
						// 新文件名称
						String newFileName = UUID.randomUUID().toString()
								.replace("-", "");

						// 声明附件参数实体类，用于存放DB
						ucBean = new UploadCommonBean();
						AttachmentBaseBean aBean = new AttachmentBaseBean();
						aBean.setStoragePath(relativePath);
						aBean.setStorageName(newFileName);
						aBean.setExtensions(ext);
						ucBean.setAttachMentBean(aBean);

						try {
							// 保存上传的文件到指定的目录
							String uploadfilename = dstPath + "/" + newFileName
									+ ext;
							FileUtil.mkdirs(uploadfilename);
							item.write(new File(uploadfilename));

							list.add(ucBean);
						} catch (Exception e) {
							throw new IOException(e.getMessage());
						}
					} else {
						throw new IOException("fail to upload");
					}
				}
			}
		} catch (IOException e) {
			System.out.println(e);
		} catch (FileUploadException e) {
			System.out.println(e);
		}
		return list;
	}

	/**
	 * <p>spring解析器上传</p>
	 * 
	 * @return
	 * @author: 林雨竹 - linyuzhu@jg2b.com 
	 * @date: Created on 2016年5月5日 下午6:12:10
	 */
	public List<UploadCommonBean> UploadFile() {
		List<UploadCommonBean> list = new ArrayList<UploadCommonBean>();
		UploadCommonBean ucBean = null;
		try {
			// 存放文件的绝对路径
			String dstPath = GlobalContants.P_CRM_UPLOAD_ABSOLUTEPATH + relativePath;
			FileUtil.mkdirs(dstPath);
			// 创建一个通用的多部分解析器
			CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
					fileuploadReq.getSession().getServletContext());
			// 判断 request 是否有文件上传,即多部分请求
			if (multipartResolver.isMultipart(fileuploadReq)) {
				// 转换成多部分request
				MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) fileuploadReq;
				// 取得request中的所有文件名
				Iterator<String> iter = multiRequest.getFileNames();
				while (iter.hasNext()) {
					// 取得上传文件
					MultipartFile file = multiRequest.getFile(iter.next());
					if (file != null) {
						// 取得当前上传文件的文件名称
						String fileName = file.getOriginalFilename();
						// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
						if (fileName.trim() != "") {
							
							BufferedImage image = ImageIO.read(file.getInputStream());
							
							String ext = fileName.substring(fileName
									.lastIndexOf(".")+1);
							// 新文件名称
							String newFileName = UUID.randomUUID().toString()
									.replace("-", "");

							// 声明附件参数实体类，用于存放DB
							ucBean = new UploadCommonBean();
							AttachmentBaseBean aBean = new AttachmentBaseBean();
							aBean.setStoragePath(relativePath);
							aBean.setStorageName(newFileName);
							aBean.setExtensions(ext);
							aBean.setPrimitiveName(fileName.substring(0,fileName.lastIndexOf(".")));
							
							/**** 若为图片文件则获取宽高信息  
							 * linyuzhu 2016-5-16 14:41:06
							 ******/
							MediaAttachsBaseBean mBean = null;
							if(image!=null){
								mBean = new MediaAttachsBaseBean();
								mBean.setGID(aBean.getGID());
								mBean.setHeight(image.getHeight());
								mBean.setWidth(image.getWidth());							
							}
							
							ucBean.setAttachMentBean(aBean);
							ucBean.setmAttachMentBean(mBean);
							
							// 保存上传的文件到指定的目录
							String path = dstPath + GlobalContants.P_OPERATE_SIGN + newFileName+GlobalContants.P_OPERATE_POINT
									+ ext;
							File localFile = new File(path);
							try {
								file.transferTo(localFile);
								list.add(ucBean);
							} catch (IllegalStateException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}