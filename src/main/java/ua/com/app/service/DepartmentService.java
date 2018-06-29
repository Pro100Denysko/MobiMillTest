package ua.com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.app.DAO.DepartmentRepository;
import ua.com.app.model.Department;

@Service
public class DepartmentService {

  private DepartmentRepository departmentRepository;

  @Autowired
  public DepartmentService(DepartmentRepository departmentRepository) {
    this.departmentRepository = departmentRepository;
  }

  public Department getById(Long id) {
    return departmentRepository.getById(id).orElseThrow(() ->
        new RuntimeException("Requested entity was not found"));
  }
}
