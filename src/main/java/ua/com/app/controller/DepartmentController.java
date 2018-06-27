package ua.com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.com.app.model.Company;
import ua.com.app.model.Department;
import ua.com.app.service.CompanyService;
import ua.com.app.service.DepartmentService;

@RestController
@RequestMapping("/api")
public class DepartmentController {

  private DepartmentService departmentService;
  private CompanyService companyService;

  @Autowired
  public DepartmentController(DepartmentService departmentService,
      CompanyService companyService) {
    this.departmentService = departmentService;
    this.companyService = companyService;
  }

  @RequestMapping(value = "/company/{id}/departments/{depId}", method = RequestMethod.PUT)
  public ResponseEntity<Company> addDepartmentToCompany(@PathVariable("id") Long compId,
      @PathVariable("depId") Long depId) {

    Department newDepartment = departmentService.getById(depId);
    System.out.println(newDepartment.getId());
    Company company = companyService.getById(compId);
    System.out.println(company.getId());

    return ResponseEntity.status(HttpStatus.OK)
        .body(companyService.addDepartment(company, newDepartment));
  }
}
