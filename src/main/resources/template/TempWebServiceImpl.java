package ${interfacePackageName}.impl;

import java.util.Date;
import javax.ws.rs.core.HttpHeaders;
import com.patient.core.system.base.BaseJsonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import com.patient.core.login.service.intf.AccessTokenService;

import ${interfacePackageName}.${className}WebService;
import ${packageName}.service.${className}Service;


public class ${className}WebServiceImpl implements ${className}WebService {

	@Autowired private ${className}Service ${lowerName}Ser;
	@Autowired private AccessTokenService accessTokenSer;
	
	@Override
	public BaseJsonDTO test(HttpHeaders headers) {
		BaseJsonDTO json = new BaseJsonDTO();
		try {
			json.setMsg("测试访问${className}WebServiceImpl类成功，共有("+${lowerName}Ser.selectByModelCount(null)+")条数据");
			json.setSuccess(true);
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg(e.getMessage());
			e.printStackTrace();
		}
		return json;
	}
}
