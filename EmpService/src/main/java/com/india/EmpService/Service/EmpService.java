package com.india.EmpService.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.india.EmpService.Dto.EmployeeRequestDTO;
import com.india.EmpService.Dto.EmployeeResponseDTO;
import com.india.EmpService.Dto.ServiceResponse;

public class EmpService {

	private final static String BASE_URL="http://localhost:8181/Employee/";
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	
	public ServiceResponse<EmployeeResponseDTO> addNewEmployee(EmployeeRequestDTO employeeRequestDTO){
		return restTemplate.postForObject(BASE_URL+"save", employeeRequestDTO, ServiceResponse.class);
	}
	
	public ServiceResponse<EmployeeResponseDTO> findByNameAndSal(String name,float sal){
		Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("name", name);
        requestMap.put("sal", sal);
		return restTemplate.getForObject(BASE_URL+"findByNameAndSal/{name}/By/{sal}",ServiceResponse.class,requestMap);
	}
	
	public void updateEmpSal(int id,EmployeeRequestDTO empRequestDTO){
		restTemplate.put(BASE_URL+"updateEmployee/"+id, empRequestDTO);;
	}
	
}
