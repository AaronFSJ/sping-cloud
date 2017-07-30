package ${interfacePackageName};

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.patient.core.system.base.BaseJsonDTO;

/**
 * 
 * <br>
 * <b>功能：</b>给IPad,Android的获取${codeName}信息的接口<br>
 * <b>作者：</b>Aaron<br>
 * <b>日期：</b> ${currentDate} <br>
 */
@Path("/$!{lowerName}")
@Produces( { MediaType.APPLICATION_JSON })
public interface ${className}WebService {
	
	/**
	 * 测试获取${codeName}信息的接口
	 * @return BaseJsonDTO
	 */
	@GET
	@Path("/test")
	public BaseJsonDTO test(@Context HttpHeaders headers);
	
}
