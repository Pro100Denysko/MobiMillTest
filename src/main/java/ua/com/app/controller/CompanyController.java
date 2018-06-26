package ua.com.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.com.app.model.Company;
import ua.com.app.model.Department;
import ua.com.app.model.User;
import ua.com.app.service.CompanyServiceImpl;

@RestController
@RequestMapping("/api")
public class CompanyController {

  private CompanyServiceImpl companyService;

  @Autowired
  public CompanyController(CompanyServiceImpl companyService) {
    this.companyService = companyService;
  }

  @RequestMapping(value = "/company", method = RequestMethod.POST)
  public ResponseEntity<Company> addNewCompany(@RequestBody Company company) {
    Company newCompany = companyService.save(company);
    if (newCompany != null) {
      return ResponseEntity.status(HttpStatus.CREATED).build();
    } else {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
  }

  @RequestMapping(value = "/company/{id}", method = RequestMethod.GET)
  public ResponseEntity<Company> getCompanyById(@PathVariable("id") Long id) {
    Company company = companyService.getById(id);

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
    return new ResponseEntity<>(company, HttpStatus.OK);
  }

  @RequestMapping(value = "/companies", method = RequestMethod.GET)
  public ResponseEntity<List<Company>> getAllCompanies() {
    List<Company> listOfCompanies = companyService.getAllCompanies();
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
    return ResponseEntity.status(HttpStatus.OK).body(listOfCompanies);
  }
}
