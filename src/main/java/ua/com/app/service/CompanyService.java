package ua.com.app.service;

import java.util.List;
import ua.com.app.model.Company;

public interface CompanyService {

  List<Company> getAllCompanies();

  Company getById(Long id);

}
