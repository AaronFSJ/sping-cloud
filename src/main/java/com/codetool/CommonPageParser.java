package com.codetool;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;


/**
 * <br>
 * <b>功能：</b>详细的功能描述<br>
 * <b>作者：</b>Aaron<br>
 * <b>日期：</b> 2017-07-31 10:51 <br>
 * <b>更新者：</b><br>
 * <b>日期：</b> <br>
 * <b>更新内容：</b><br>
 */
public class CommonPageParser {
	
	private static VelocityEngine ve;// = VelocityEngineUtil.getVelocityEngine();
	
	private static Properties properties;
	
	private final static String CONTENT_ENCODING ="UTF-8";
	
	private static final Logger log = Logger.getLogger(CommonPageParser.class);
	
	
	private static boolean isReplace = true;  //是否可以替换文件 true =可以替换，false =不可以替换
	
	/**
	 * 获取项目的路径
	 * @return
	 */
	public static String getRootPath(){
		String rootPath ="";
		try{
			 File file = new File(CommonPageParser.class.getResource("/").getFile());
			 rootPath = file.getParentFile().getParent();
			 rootPath = java.net.URLDecoder.decode(rootPath,"utf-8");
			 return rootPath;
		}catch(Exception e){
			e.printStackTrace();
		}
		return rootPath;
	}
	
	public static void main(String[] args) {
		System.out.println(getRootPath());
	}
	
	
	static{
		try{
			//获取文件模板根路径
			String  templateBasePath = getRootPath()+"/template" ;
			Properties properties = new Properties();
			properties.setProperty(Velocity.RESOURCE_LOADER,"file");
			properties.setProperty("file.resource.loader.description","Velocity File Resource Loader");
			properties.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH,  templateBasePath);
			properties.setProperty(Velocity.FILE_RESOURCE_LOADER_CACHE, "true");
	        properties.setProperty("file.resource.loader.modificationCheckInterval", "30");
	        properties.setProperty(Velocity.RUNTIME_LOG_LOGSYSTEM_CLASS,  "org.apache.velocity.runtime.log.Log4JLogChute");
	        properties.setProperty("runtime.log.logsystem.log4j.logger", "org.apache.velocity");
	        properties.setProperty("directive.set.null.allowed", "true");
			VelocityEngine velocityEngine = new VelocityEngine();
			velocityEngine.init(properties);
			ve = velocityEngine;
		}catch(Exception e){
			log.error(e);
		}
	}
	
	/**
	 * <br>
	 * <b>功能：</b>生成页面文件<br>
	 * <b>作者：</b>Aaron<br>
	 * <b>日期：</b> 2017-07-31 10:53 <br>
	 * @param context 内容上下文
	 * @param templateName 模板文件路径（相对路径）article\\article_main.html
	 */
	public static void WriterPage(VelocityContext context, String templateName, String fileDirPath, String targetFile){
		try{
			String path = fileDirPath+targetFile;
			path = path.replace("\\", "/");
			File file = new File(path);
			if(!file.exists()){
				new File(file.getParent()).mkdirs();
			}else{
				if(isReplace){
					System.out.println("替换文件"+file.getAbsolutePath());
				}else{
					System.out.println("页面生成失败"+file.getAbsolutePath()+"文件已存在");
					return;
				}
			}
			
			Template template = ve.getTemplate(templateName, CONTENT_ENCODING);
			FileOutputStream fos = new FileOutputStream(file);  
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos,CONTENT_ENCODING));
			template.merge(context, writer);
			writer.flush();  
		    writer.close();  
	    	fos.close();  
	    	System.out.println("页面生成成功"+file.getAbsolutePath());
		}catch (Exception e) {
			log.error(e);
		}
	} 

}
