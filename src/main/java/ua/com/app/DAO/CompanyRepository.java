package ua.com.app.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.app.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

  Company findById(Long id);

}
