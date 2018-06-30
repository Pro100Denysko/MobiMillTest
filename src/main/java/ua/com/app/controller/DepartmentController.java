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
import ua.com.app.model.User;
import ua.com.app.service.CompanyService;
import ua.com.app.service.DepartmentService;
import ua.com.app.service.UserService;

@RestController
@RequestMapping("/api")
public class DepartmentController {

  private DepartmentService departmentService;
  private CompanyService companyService;
  private UserService userService;

  public DepartmentController(DepartmentService departmentService,
      CompanyService companyService, UserService userService) {
    this.departmentService = departmentService;
    this.companyService = companyService;
    this.userService = userService;
  }

  @Autowired
  public DepartmentController(DepartmentService departmentService,
      CompanyService companyService) {
    this.departmentService = departmentService;
    this.companyService = companyService;
  }

  @Deprecated
  @RequestMapping(value = "/users/{id}/departments/{depId}", method = RequestMethod.POST)
  public ResponseEntity<User> addNewUserToDepartment(@PathVariable("id") Long userId,
      @PathVariable("depId") Long depId) {
    User user = userService.getById(userId);
    Department department = departmentService.getById(depId);
     userService.bindUserToDepartment(department, user);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  @Deprecated
  @RequestMapping(value = "/company/{id}/departments/{depId}", method = RequestMethod.POST)
  public ResponseEntity<Company> addDepartmentToCompany(@PathVariable("id") Long compId,
      @PathVariable("depId") Long depId) {
    Department newDepartment = departmentService.getById(depId);
    Company company = companyService.getById(compId);
    departmentService.addDepartment(company, newDepartment);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  @Deprecated
  @RequestMapping(value = "/delete/company/{id}/departments/{depId}", method = RequestMethod.POST)
  public ResponseEntity<Department> deleteDepartmentFromCompany(@PathVariable("id") Long compId,
      @PathVariable("depId") Long depId) {
    Department departmentToDelete = departmentService.getById(depId);
    Company company = companyService.getById(compId);
    departmentService.deleteDepartment(company, departmentToDelete);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }
}
