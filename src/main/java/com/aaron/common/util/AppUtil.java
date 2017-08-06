package com.aaron.common.util;

import java.io.File;
import javax.servlet.ServletContext;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
/**
 * 服务应用工具类
* Copyright  aaron All right reserved.
* @ClassName: AppUtil 
* @author aaron
* @since 2014-2-17 下午3:07:04 
* Description:  // 用于读写spring的上下文，servlet 上下文，获取Bean，类路径等等
* Modify History: // 修改历史记录列表，每条修改记录应包括修改日期、修改者及内容简述
 */
public class AppUtil  implements ApplicationContextAware{
 /**
  *  spring 上下文
  */
  private static ApplicationContext applicationContext;
  /**
   * servlet 上下文
   */
  private static ServletContext servletContext;

  /**
   * 初始化
   * @param _servletContext
   */
  public static void init(ServletContext _servletContext)
  {
    servletContext = _servletContext;
  }

  public void setApplicationContext(ApplicationContext contex)
    throws BeansException
  {
    applicationContext = contex;
  }
  /**
   * 获取spring的上下文
  * Copyright  jeisai All right reserved.
  * @Title: getContext  
  * @author dengwm
  * @since 2014-2-17 下午3:11:38
  * @return ApplicationContext    返回类型  
  * Description:  // 获取spring的上下文
  * Modify History: // 修改历史记录列表，每条修改记录应包括修改日期、修改者及内容简述
   */
  public static ApplicationContext getContext()
  {
    return applicationContext;
  }
  /**
   * 获取servlet的上下文
  * Copyright  jeisai All right reserved.
  * @Title: getServletContext  
  * @author dengwm
  * @since 2014-2-17 下午3:12:10
  * @throws Exception  
  * @return ServletContext    返回类型  
  * Description:  // 获取servlet的上下文
  * Modify History: // 修改历史记录列表，每条修改记录应包括修改日期、修改者及内容简述
   */
  public static ServletContext getServletContext()
    throws Exception
  {
    return servletContext;
  }
  /**
   * 通过类获取spring的工厂Bean
  * Copyright  jeisai All right reserved.
  * @Title: getBean  
  * @author dengwm
  * @since 2014-2-17 下午3:13:16
  * @param cls bean类
  * @return Object    返回类型  
  * Description:  // 通过类获取spring的工厂Bean
  * Modify History: // 修改历史记录列表，每条修改记录应包括修改日期、修改者及内容简述
   */
  public static Object getBean(Class cls)
  {
    return applicationContext.getBean(cls);
  }

  /**
   * 通过BeanId获取spring的工厂Bean
  * Copyright  jeisai All right reserved.
  * @Title: getBean  
  * @author dengwm
  * @since 2014-2-17 下午3:15:23
  * @param beanId  
  * @return Object    返回类型  
  * Description:  // 通过BeanId获取spring的工厂Bean
  * Modify History: // 修改历史记录列表，每条修改记录应包括修改日期、修改者及内容简述
   */
  public static Object getBean(String beanId)
  {
    return applicationContext.getBean(beanId);
  }
  /**
   * 获取当前绝对路径
  * Copyright  jeisai All right reserved.
  * @Title: getAppAbsolutePath  
  * @author dengwm
  * @since 2014-2-17 下午3:15:27
  * @return String    返回类型  
  * Description:  // 获取当前绝对路径
  * Modify History: // 修改历史记录列表，每条修改记录应包括修改日期、修改者及内容简述
   */
  public static String getAppAbsolutePath()
  {
    return servletContext.getRealPath("/");
  }
  /**
   * 获取当前的相对路径
  * Copyright  jeisai All right reserved.
  * @Title: getRealPath  
  * @author dengwm
  * @since 2014-2-17 下午3:15:32
  * @param path
  * @return String    返回类型  
  * Description:  // 获取当前的相对路径
  * Modify History: // 修改历史记录列表，每条修改记录应包括修改日期、修改者及内容简述
   */
  public static String getRealPath(String path)
  {
    return servletContext.getRealPath(path);
  }
  /**
   * 获取当前类路径
  * Copyright  jeisai All right reserved.
  * @Title: getClasspath  
  * @author dengwm
  * @since 2014-2-17 下午3:15:41
  * @return String    返回类型  
  * Description:  // 获取当前类路径
  * Modify History: // 修改历史记录列表，每条修改记录应包括修改日期、修改者及内容简述
   */
  public static String getClasspath(){
    String classPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    String rootPath = "";

    if ("\\".equals(File.separator)) {
      rootPath = classPath.substring(1);
      rootPath = rootPath.replace("/", "\\");
    }

    if ("/".equals(File.separator)) {
      rootPath = classPath.substring(1);
      rootPath = rootPath.replace("\\", "/");
    }
    return rootPath;
  }

  public static void main(String[] args) {
    System.out.println("path:" + getClasspath());
  }
}