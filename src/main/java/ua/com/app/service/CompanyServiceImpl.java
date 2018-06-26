package ua.com.app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.app.DAO.CompanyRepository;
import ua.com.app.model.Company;

@Service
public class CompanyServiceImpl implements CompanyService {

  private CompanyRepository companyRepository;

  @Autowired
  public CompanyServiceImpl(CompanyRepository companyRepository) {
    this.companyRepository = companyRepository;
  }

  public Company save(Company company) {
    return companyRepository.save(company);
  }

  @Override
  public List<Company> getAllCompanies() {
    return companyRepository.findAll();
  }

  @Override
  public Company getById(Long id) {
    return companyRepository.findById(id);
  }
}
