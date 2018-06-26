package ua.com.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.com.app.model.Department;
import ua.com.app.service.DepartmentService;

@RestController
@RequestMapping("/api")
public class DepartmentController {

  private DepartmentService departmentService;

  @Autowired
  public DepartmentController(DepartmentService departmentService) {
    this.departmentService = departmentService;
  }

  @RequestMapping(value = "/departments", method = RequestMethod.GET)
  public ResponseEntity<List<Department>> getAllDepartments() {
    List<Department> listOfDepartments = departmentService.getAllDepartments();
    return ResponseEntity.status(HttpStatus.OK).body(listOfDepartments);
  }

}
