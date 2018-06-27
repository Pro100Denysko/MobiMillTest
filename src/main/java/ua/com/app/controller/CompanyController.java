package ua.com.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.com.app.model.Company;
import ua.com.app.service.CompanyService;

@RestController
@RequestMapping("/api")
public class CompanyController {

  private CompanyService companyService;

  @Autowired
  public CompanyController(CompanyService companyService) {
    this.companyService = companyService;
  }

  @RequestMapping(value = "/company/{id}", params = "name", method = RequestMethod.PUT)
  public ResponseEntity<Company> updateName(@PathVariable("id") Long id,
      @RequestParam String name) {
    Company companyToUpdate = companyService.getById(id);
    if (companyToUpdate == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    } else {
      return new ResponseEntity<>(companyService.updateName(companyToUpdate, name), HttpStatus.OK);
    }
  }


  @RequestMapping(value = "/company/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Company> deleteCompanyById(@PathVariable("id") Long id) {
    Company companyToDelete = companyService.getById(id);
    if (companyToDelete == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    } else {
      companyService.delete(companyToDelete);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
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
    return new ResponseEntity<>(companyService.getById(id), HttpStatus.OK);
  }

  @RequestMapping(value = "/companies", method = RequestMethod.GET)
  public ResponseEntity<List<Company>> getAllCompanies() {
    return ResponseEntity.status(HttpStatus.OK).body(companyService.getAll());
  }
}
