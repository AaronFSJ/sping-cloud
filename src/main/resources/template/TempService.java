package ${packageName}.service;

import org.apache.log4j.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.patient.core.system.base.BaseService;

import ${packageName}.dao.mybatis.${className}Dao;

/**
 * 
 * <br>
 * <b>功能：</b>${className}Service<br>
 * <b>作者：</b>Aaron<br>
 * <b>日期：</b> ${currentDate} <br>
 */
@Service("$!{lowerName}Service")
public class ${className}Service<T> extends BaseService<T> {
	private final static Logger log= Logger.getLogger(${className}Service.class);
	
	@Autowired
    private ${className}Dao<T> mapper;

	public ${className}Dao<T> getMapper() {
		return mapper;
	}

}
