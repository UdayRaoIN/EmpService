package com.india.EmpService.Service;

import org.springframework.beans.factory.annotation.Autowired;
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
}
