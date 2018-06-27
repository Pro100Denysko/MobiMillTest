package ua.com.app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.app.DAO.CompanyRepository;
import ua.com.app.model.Company;
import ua.com.app.model.Department;
import ua.com.app.model.User;

@Service
public class CompanyService {

  private CompanyRepository companyRepository;

  @Autowired
  public CompanyService(CompanyRepository companyRepository) {
    this.companyRepository = companyRepository;
  }

  public Company save(Company company) {
    return companyRepository.save(company);
  }

  public void delete(Company company) {
    companyRepository.delete(company);
  }

  public Company updateName(Company companyToUpdate, String newName) {
    companyToUpdate.setName(newName);
    return companyRepository.save(companyToUpdate);
  }

  public List<Company> getAll() {
    List<Company> listOfCompanies = companyRepository.findAll();
    for (Company company : listOfCompanies) {
      //This fields are null because the company data enters the loop
      for (Department department : company.getDepartments()) {
        department.setCompanies(null);
      }
      for (User user : company.getUsers()) {
        user.setCompany(null);
        user.getPosition().setUser(null);
        for (Department department : user.getDepartments()) {
          department.setCompanies(null);
        }
      }
    }
    return listOfCompanies;
  }

  public Company getById(Long id) {
    Company company = companyRepository.findById(id).orElseThrow(() ->
        new RuntimeException("Requested entity was not found"));
    //This fields are null because the company data enters the loop
    for (Department department : company.getDepartments()) {
      department.setCompanies(null);
    }
    for (User user : company.getUsers()) {
      user.getPosition().setUser(null);
      user.setCompany(null);
      for (Department department : user.getDepartments()) {
        department.setCompanies(null);
      }
    }
    return company;
  }
}
