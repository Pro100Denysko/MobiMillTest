package ua.com.app.DAO;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.app.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

  Optional<Company> findById(Long id);

}
