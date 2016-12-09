package com.jg2b.common.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.PrintWriter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 
 * <p>[描述信息：文件处理工具类]</p>
 *
 * @author 林雨竹 - linyuzhu@jg2b.com
 * @version 1.0 Created on 2016年4月22日 下午5:52:26
 */
public class FileUtil {

	private static final Log LOG = LogFactory.getLog(FileUtil.class);

	public static final String DEFAULT_file_IMGFILE_PATH = "files";

	/**
	 * 
	 * <p>创建目录</p>
	 * 
	 * @param dir
	 * @author: 林雨竹 - linyuzhu@jg2b.com 
	 * @date: Created on 2016年4月22日 下午6:18:43
	 */
	public static void mkdirs(String dir) {
		try {
			String dirTemp = dir;
			File dirPath = new File(dirTemp);
			if (!dirPath.exists()) {
				dirPath.mkdirs();
			}
		} catch (Exception e) {
			LOG.error("创建目录操作出错: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * <p>新建文件</p>
	 * 
	 * @param fileName  包含路径的文件名 如:D:\test\src\demo.txt
	 * @param content   文件内容
	 * @author: 林雨竹 - linyuzhu@jg2b.com 
	 * @date: Created on 2016年4月22日 下午6:18:59
	 */
	public static void createNewFile(String fileName, String content) {
		try {
			String fileNameTemp = fileName;
			File filePath = new File(fileNameTemp);
			if (!filePath.exists()) {
				filePath.createNewFile();
			}
			FileWriter fw = new FileWriter(filePath);
			PrintWriter pw = new PrintWriter(fw);
			String strContent = content;
			pw.println(strContent);
			pw.flush();
			pw.close();
			fw.close();
		} catch (Exception e) {
			LOG.error("新建文件操作出错: " + e.getMessage());
			e.printStackTrace();
		}

	}

	/**
	 * <p>删除文件</p>
	 * 
	 * @param fileName 包含路径的文件名
	 * @author: 林雨竹 - linyuzhu@jg2b.com 
	 * @date: Created on 2016年4月22日 下午6:19:29
	 */
	public static void delFile(String fileName) {
		try {
			String filePath = fileName;
			java.io.File delFile = new java.io.File(filePath);
			delFile.delete();
		} catch (Exception e) {
			LOG.error("删除文件操作出错: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * <p>删除文件夹,包含其所有文件</p>
	 * 
	 * @param folderPath
	 * @author: 林雨竹 - linyuzhu@jg2b.com 
	 * @date: Created on 2016年4月22日 下午6:19:44
	 */
	public static void delFolder(String folderPath) {
		try {
			// 删除文件夹里面所有内容
			delAllFile(folderPath);
			String filePath = folderPath;
			java.io.File myFilePath = new java.io.File(filePath);
			// 删除空文件夹
			myFilePath.delete();
		} catch (Exception e) {
			LOG.error("删除文件夹操作出错" + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * <p>删除文件夹里面的所有文件,不包含文件夹</p>
	 * 
	 * @param path
	 * @author: 林雨竹 - linyuzhu@jg2b.com 
	 * @date: Created on 2016年4月22日 下午6:20:05
	 */
	public static void delAllFile(String path) {
		File file = new File(path);
		if (!file.exists()) {
			return;
		}
		if (!file.isDirectory()) {
			return;
		}
		String[] childFiles = file.list();
		File temp = null;
		for (int i = 0; i < childFiles.length; i++) {
			// File.separator与系统有关的默认名称分隔符
			// 在UNIX系统上，此字段的值为'/'；在Microsoft Windows系统上，它为 '\'。
			if (path.endsWith(File.separator)) {
				temp = new File(path + childFiles[i]);
			} else {
				temp = new File(path + File.separator + childFiles[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delAllFile(path + "/" + childFiles[i]);// 先删除文件夹里面的文件
				delFolder(path + "/" + childFiles[i]);// 再删除空文件夹
			}
		}
	}

	/**
	 * <p>复制单个文件</p>
	 * 
	 * @param srcFile 包含路径的源文件 如：E:/phsftp/src/abc.txt
	 * @param dirDest 目标文件目录；若文件目录不存在则自动创建  如：E:/phsftp/dest
	 * @author: 林雨竹 - linyuzhu@jg2b.com 
	 * @date: Created on 2016年4月22日 下午6:20:39
	 */
	public static void copyFile(String srcFile, String dirDest) {
		try {
			FileInputStream in = new FileInputStream(srcFile);
			mkdirs(dirDest);
			FileOutputStream out = new FileOutputStream(dirDest + "/" + new File(srcFile).getName());
			int len;
			byte buffer[] = new byte[1024];
			while ((len = in.read(buffer)) != -1) {
				out.write(buffer, 0, len);
			}
			out.flush();
			out.close();
			in.close();
		} catch (Exception e) {
			LOG.error("复制文件操作出错:" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	

	/**
	 * <p>复制文件夹</p>
	 *  
	 * @param oldPath  源文件夹路径 如：E:/phsftp/src
	 * @param newPath 目标文件夹路径 如：E:/phsftp/dest
	 * @author: 林雨竹 - linyuzhu@jg2b.com 
	 * @date: Created on 2016年4月22日 下午6:20:58
	 */
	public static void copyFolder(String oldPath, String newPath) {
		try {
			// 如果文件夹不存在 则新建文件夹
			mkdirs(newPath);
			File file = new File(oldPath);
			String[] files = file.list();
			File temp = null;
			for (int i = 0; i < files.length; i++) {
				if (oldPath.endsWith(File.separator)) {
					temp = new File(oldPath + files[i]);
				} else {
					temp = new File(oldPath + File.separator + files[i]);
				}

				if (temp.isFile()) {
					FileInputStream input = new FileInputStream(temp);
					FileOutputStream output = new FileOutputStream(newPath + "/" + (temp.getName()).toString());
					byte[] buffer = new byte[1024 * 2];
					int len;
					while ((len = input.read(buffer)) != -1) {
						output.write(buffer, 0, len);
					}
					output.flush();
					output.close();
					input.close();
				}
				if (temp.isDirectory()) {// 如果是子文件夹
					copyFolder(oldPath + "/" + files[i], newPath + "/" + files[i]);
				}
			}
		} catch (Exception e) {
			LOG.error("复制文件夹操作出错:" + e.getMessage());
			e.printStackTrace();
		}
	}

	
	/**
	 * <p>移动文件到指定目录，会删除源文件</p>
	 * 
	 * @param oldPath 包含路径的文件名 如：E:/phsftp/src/ljq.txt
	 * @param newPath 目标文件目录 如：E:/phsftp/dest
	 * @author: 林雨竹 - linyuzhu@jg2b.com 
	 * @date: Created on 2016年4月22日 下午6:21:23
	 */
	public static void moveFile(String oldPath, String newPath) {
		copyFile(oldPath, newPath);
		delFile(oldPath);
	}


	
	/**
	 * <p>移动文件夹内所有文件到指定目录,会删除源文件</p>
	 * 
	 * @param oldPath E:/phsftp/src
	 * @param newPath
	 * @author: 林雨竹 - linyuzhu@jg2b.com 
	 * @date: Created on 2016年4月22日 下午6:23:07
	 */
	public static void moveFilesByFolder(String oldPath, String newPath) {
		copyFolder(oldPath, newPath);
		delAllFile(oldPath);
	}

	
	/**
	 * <p>移动文件夹所有内容，会删除源文件夹</p>
	 * 
	 * @param oldPath
	 * @param newPath
	 * @author: 林雨竹 - linyuzhu@jg2b.com 
	 * @date: Created on 2016年4月22日 下午6:22:23
	 */
	public static void moveFolder(String oldPath, String newPath) {
		copyFolder(oldPath, newPath);
		delFolder(oldPath);
	}



	/**
	 * 
	 * <p>读取数据</p>
	 * 
	 * @param inSream
	 * @param charsetName
	 * @return
	 * @throws Exception
	 * @author: 林雨竹 - linyuzhu@jg2b.com 
	 * @date: Created on 2016年4月22日 下午6:16:56
	 */
	public static String readData(InputStream inSream, String charsetName) throws Exception {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = -1;
		while ((len = inSream.read(buffer)) != -1) {
			outStream.write(buffer, 0, len);
		}
		byte[] data = outStream.toByteArray();
		outStream.close();
		inSream.close();
		return new String(data, charsetName);
	}


	/**
	 * <p>特殊字符替换</p>
	 * 
	 * @param str
	 * @return
	 * @author: 林雨竹 - linyuzhu@jg2b.com 
	 * @date: Created on 2016年4月22日 下午6:16:28
	 */
	public static String repaceSpecialChar(String str){
		if(str!= null && !str.equals("")){
			str = str.replace("#", "");
			str = str.replace("$", "");
			str = str.replace("%", "");
			str = str.replace("~", "");
			str = str.replace("^", "");
			str = str.replace("&", "");
			str = str.replace("`", "");
		}
		return str;
	}
	
}
