package com.codetool;

import java.io.File;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.velocity.VelocityContext;

/**
 * <br>
 * <b>功能：</b>详细的功能描述<br>
 * <b>作者：</b>唐志圣<br>
 * <b>日期：</b> 2014-06-19 <br>
 * <b>更新者：</b><br>
 * <b>日期：</b> <br>
 * <b>更新内容：</b><br>
 */
public class CreateJava {
	private static ResourceBundle res = ResourceBundle.getBundle("application");
	//数据源1
	private static String url= res.getString("jdbc.url"); 
	private static String username =  res.getString("jdbc.username");
	private static String passWord = res.getString("jdbc.password");
	//数据源2
//	private static String url= res.getString("jdbc2.url"); 
//	private static String username =  res.getString("jdbc2.username");
//	private static String passWord = res.getString("jdbc2.password");

	public static void main(String[] args) {
		generateFile("movie","user","用户表","system");
		
	}
	
	/**
	 * 自动生成Java相关类
	 * @param tableName 表名
	 * @param codeName 表说明
	 * @param pckPath 包名
	 */
	public static void generateFile(String databaseName, String tableName,String codeName,String pckPath){
		
		String rootPath = getRootPath();
		tableName=tableName.toLowerCase(); //表名 
		String interfacePckPath = rootPath+"src/main/java/com/patient/core/interfaces/restful/"+pckPath+"/service/";
//		pckPath = rootPath + "src\\main\\java\\com\\patient\\core\\system\\"+pckPath+"\\";
		pckPath = rootPath + "crPatient/src/main/java/com/patient/core/system/"+pckPath+"/";
		 CreateBean createBean=new CreateBean();
		 createBean.setMysqlInfo(url, username, passWord);

		 String className= createBean.getTablesNameToClassName(tableName);
		 String lowerName =className.substring(0, 1).toLowerCase()+className.substring(1, className.length());
		 //根路径
		 //String srcPath = rootPath + "src\\";
		 //页面路径，放到WEB-INF下面是为了不让手动输入路径访问jsp页面，起到安全作用
		 //String webPath = rootPath + "WebRoot\\WEB-INF\\jsp\\"; 
		 
		 //File file=new File(pckPath);
		 //java,xml文件名称
		 String modelPath = "model/"+className+"Model.java";
		 String beanPath =  "bean/"+className+".java";
		 String mapperPath = "dao/mybatis/"+className+"Dao.java";
		 
		 String dtoPath = "dto/"+className+"DTO.java";
		 String jsonDtoPath = "dto/"+className+"JsonDTO.java";
		 
		 String servicePath = "service/"+className+"Service.java";
		 String controllerPath = "controller/"+className+"Controller.java";
		 String sqlMapperPath = ""+className+"Mapper.xml";
		 
		 String webServicePath = className+"WebService.java";
		 String webServiceImplPath = "impl/"+className+"WebServiceImpl.java";
		 
		 //String springPath="conf\\spring\\";
		 //String sqlMapPath="conf\\mybatis\\";
		 //jsp页面路径
		 //String pageEditPath = lowerName+"\\"+lowerName+"Edit.jsp";
		 //String pageListPath = lowerName+"\\"+lowerName+"List.jsp";
		 
		
		
		VelocityContext context = new VelocityContext();
		
		// 当前日期
		context.put("currentDate", DateUtils.getCurrDateForString());
		context.put("className", className); //
		context.put("lowerName", lowerName);
		context.put("codeName", codeName);
		context.put("tableName", tableName);
		context.put("packageName", pckPath.replaceAll("/", ".").subSequence(pckPath.indexOf("com"), pckPath.length()-1));
		context.put("serialUID", MethodUtil.getInit().getLongId());
		
		context.put("interfacePackageName", interfacePckPath.replaceAll("/", ".").subSequence(interfacePckPath.indexOf("com"), interfacePckPath.length()-1));
		
		/******************************生成bean字段*********************************/
		try{
			context.put("feilds",createBean.getBeanFeilds(tableName, databaseName)); //生成bean
		}catch(Exception e){
			e.printStackTrace();
		}

		/*******************************生成sql语句**********************************/
		try{
			Map<String,Object> sqlMap=createBean.getAutoCreateSql(tableName, databaseName);
			context.put("columnDatas",createBean.getColumnDatas(tableName, databaseName));//生成bean
			context.put("SQL",sqlMap);
		}catch(Exception e){
			e.printStackTrace();
			return;
		}
		
		//-------------------生成文件代码---------------------/
		CommonPageParser.WriterPage(context, "TempBean.java",pckPath, beanPath);  //生成实体Bean
		CommonPageParser.WriterPage(context, "TempModel.java",pckPath,modelPath); //生成Model
		CommonPageParser.WriterPage(context, "TempDao.java", pckPath,mapperPath); //生成MybatisMapper接口 相当于Dao
		CommonPageParser.WriterPage(context, "TempService.java", pckPath,servicePath);//生成Service
		CommonPageParser.WriterPage(context, "TempMapper.xml","src\\main\\resources\\mybatis\\",sqlMapperPath);//生成Mybatis xml配置文件
		CommonPageParser.WriterPage(context, "TempController.java",pckPath, controllerPath);//生成Controller 相当于接口
		CommonPageParser.WriterPage(context, "TempDTO.java", pckPath,dtoPath); //生成dto接口
		CommonPageParser.WriterPage(context, "TempJsonDTO.java", pckPath,jsonDtoPath); //生成dto接口
		
		//生成客户端接口访问入口
//		CommonPageParser.WriterPage(context, "TempWebService.java", interfacePckPath,webServicePath);
//		CommonPageParser.WriterPage(context, "TempWebServiceImpl.java", interfacePckPath,webServiceImplPath);
		
//		生JSP页面，如果不需要可以注释掉
//		CommonPageParser.WriterPage(context, "TempList.jsp",webPath, pageListPath);//生成Controller 相当于接口
//		CommonPageParser.WriterPage(context, "TempEdit.jsp",webPath, pageEditPath);//生成Controller 相当于接口

		
		/*************************修改xml文件*****************************/
//		WolfXmlUtil xml=new WolfXmlUtil();
//		Map<String,String> attrMap=new HashMap<String, String>();
//		try{
//		   /**  引入到 struts.xml  配置文件*/
//		   attrMap.put("file","com/wei/ssi/conf/struts2/struts2-ssi-"+lowerName+".xml");
//		   xml.getAddNode(srcPath+"struts.xml", "/struts", "include", attrMap, ""); 
//		   attrMap.clear();
//		   /**   引入到sqlmap-conf.xml 配置文件  */
//		   attrMap.put("resource", "com/wei/ssi/conf/sqlmap/"+className+"SQL.xml");
//		   xml.getAddNode(pckPath+sqlMapPath+"sqlmap-config.xml", "/sqlMapConfig", "sqlMap", attrMap, "");
//		   /**   引入到spring-dao.xml 配置文件 */
//		   attrMap.clear();
//		   attrMap.put("id", lowerName+"Dao");
//		   attrMap.put("class","com.wei.ssi.dao."+className+"Dao");
//		   xml.getAddNode(pckPath+springPath+"spring-dao.xml", "beans", "bean", attrMap, "");
//		   /**   引入到spring-service.xml 配置文件 */
//		   attrMap.clear();
//		   attrMap.put("id", lowerName+"Service");
//		   attrMap.put("class","com.wei.ssi.service."+className+"Service");
//		   xml.getAddNode(pckPath+springPath+"spring-service.xml", "beans", "bean", attrMap, "");

		   /**   引入到mybatis-config.xml 配置文件 */
			//attrMap.clear();
			//attrMap.put("resource","com/wei/ssi/conf/mybatis/"+className+"Mapper.xml");
		    //xml.getAddNode(pckPath+sqlMapPath+"mybatis-config.xml", "/configuration/mappers", "mapper", attrMap, "");
//		}catch(Exception e){
//			e.printStackTrace();
//		}
	}

	
	
	
	/**
	 * 获取项目的路径
	 * @return
	 */
	public static String getRootPath(){
		String rootPath ="";
		try{
			 File file = new File(CommonPageParser.class.getResource("/").getFile());
			 rootPath = file.getParentFile().getParentFile().getParent()+"\\";
			 rootPath = java.net.URLDecoder.decode(rootPath,"utf-8");
			 return rootPath;
		}catch(Exception e){
			e.printStackTrace();
		}
		return rootPath;
	}
}

