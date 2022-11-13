package com.india.EmpService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.india.EmpService.Dto.EmployeeRequestDTO;
import com.india.EmpService.Dto.EmployeeResponseDTO;
import com.india.EmpService.Dto.ServiceResponse;
import com.india.EmpService.Service.EmpService;

@RestController
@RequestMapping("/Virtusa")
public class EmpController {

	@Autowired
	private EmpService empService;
	
	@PostMapping("/save")
	public ServiceResponse<EmployeeResponseDTO> save(@RequestBody EmployeeRequestDTO employeeRequestDTO){
		return empService.addNewEmployee(employeeRequestDTO);
	}
}
