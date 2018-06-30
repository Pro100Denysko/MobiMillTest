package ua.com.app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.app.DAO.DepartmentRepository;
import ua.com.app.model.Company;
import ua.com.app.model.Department;
import ua.com.app.model.User;

@Service
public class DepartmentService {

  private DepartmentRepository departmentRepository;

  @Autowired
  public DepartmentService(DepartmentRepository departmentRepository) {
    this.departmentRepository = departmentRepository;
  }

  public Department getById(Long id) {
    return departmentRepository.findById(id).orElseThrow(() ->
        new RuntimeException("Requested entity was not found"));
  }

  @Deprecated
  public void deleteDepartment(Company company, Department departmentToDelete) {
    Department department = departmentRepository.findById(departmentToDelete.getId())
        .orElseThrow(() ->
            new RuntimeException("Requested entity was not found"));
    department.getCompanies().remove(company);
    departmentRepository.save(department);
  }

  @Deprecated
  public void addDepartment(Company companyToUpdate, Department newDepartment) {
    Department department = departmentRepository.findById(newDepartment.getId())
        .orElseThrow(() ->
            new RuntimeException("Requested entity was not found"));
    department.getCompanies().add(companyToUpdate);
  }


}
