package ua.com.app.service;

import java.util.List;
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

  public List<Department> getAllDepartments() {
    return departmentRepository.findAll();
  }
}
