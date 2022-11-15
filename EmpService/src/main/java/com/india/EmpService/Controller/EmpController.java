package com.india.EmpService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/find/{name}/by/{sal}")
	public ServiceResponse<EmployeeResponseDTO> save(@PathVariable String name,@PathVariable float sal){
		return empService.findByNameAndSal(name, sal);
	}
	
	@PutMapping("/update/{id}")
	public void Update(@PathVariable int id,@RequestBody EmployeeRequestDTO employeeRequestDTO ) {
		empService.updateEmpSal(id, employeeRequestDTO);
	}
	
	
}
