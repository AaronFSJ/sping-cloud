package ${packageName}.dto;

import java.util.ArrayList;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.patient.core.system.base.BaseJsonDTO;

/**
 * 
 * <br>
 * <b>功能：</b>${className}JsonDTO<br>
 * <b>作者：</b>Aaron<br>
 * <b>日期：</b> ${currentDate} <br>
 */
@XmlRootElement(name="${className}JsonDTO")
public class ${className}JsonDTO extends BaseJsonDTO {
	public ${className}JsonDTO() {
		super();
	}
	
	private static final long serialVersionUID = ${serialUID}L;
	
	private List<${className}DTO> ${lowerName}s = new ArrayList<${className}DTO>();

	public List<${className}DTO> get${className}s() {
		return ${lowerName}s;
	}

	public void set${className}s(List<${className}DTO> ${lowerName}s) {
		this.${lowerName}s = ${lowerName}s;
	}
	
}
