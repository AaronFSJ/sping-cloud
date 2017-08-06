package com.aaron.common.util;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

/**
 * 
* @ClassName: PublicUtil 
* @Description: TODO(通用检查工具类) 
* @author  Aaron
* @date 2017年3月28日 下午2:15:38 
*
 */
public class PublicUtil {
	
   /**
    * 
   * @Title: checkEmptyList 
   * @Description: TODO(检查是否是空的list) 
   * @param @param list
   * @param @return    设定文件 
   * @return boolean    返回类型 
   * @author Aaron
   * @throws
    */
   public static boolean checkEmptyList (List list) {
       if ((list == null) || (list.size() == 0)) {
           return true;
       }
       else {
           return false;
       }
   }

   /**
    * 
   * @Title: checkEmptyString 
   * @Description: TODO(检查字符串是否为空) 
   * @param @param str
   * @param @return    设定文件 
   * @return boolean    返回类型 
   * @author Aaron
   * @throws
    */
   public static boolean checkEmptyString (String str) {
       if(((str == null) || (str.trim().length() == 0))||"null".equals(str)) {
           return true;
       }else{
           return false;
       }
   }

   /**
    * 
   * @Title: convertStringEncode 
   * @Description: TODO(转换字符串编码) 
   * @param @param str
   * @param @param encode
   * @param @return    设定文件 
   * @return String    返回类型 
   * @author Aaron
   * @throws
    */
   public static String convertStringEncode (String str, String encode) {
       // Not in use but interesting
       try {
           byte bytes[] = str.getBytes(encode);    // "ISO-8859-1");
           String UTFtekst = new String(bytes);
           return UTFtekst;
       }
       catch (UnsupportedEncodingException w) {
           System.out.println("cannot get this charset");
           return "error";
       }
   }

   /**
    * 
   * @Title: formatFloat 
   * @Description: TODO(格式化float型数据) 
   * @param @param source
   * @param @return    设定文件 
   * @return String    返回类型 
   * @author Aaron
   * @throws
    */
   public static String formatFloat (float source) {
       return new DecimalFormat("######0.00").format(source);
   }
   
   /**
    * 
   * @Title: leftFillPosition 
   * @Description: TODO(左补) 
   * @param @param count
   * @param @param data
   * @param @return    设定文件 
   * @return String    返回类型 
   * @author Aaron
   * @throws
    */
   public static String leftFillPosition(int count,int data){
   	//得到一个NumberFormat的实例
       NumberFormat nf = NumberFormat.getInstance();
       //设置是否使用分组
       nf.setGroupingUsed(false);
       //设置最大整数位数
       nf.setMaximumIntegerDigits(count);
       //设置最小整数位数   
       nf.setMinimumIntegerDigits(count);
   	return nf.format(data);
   }
}
