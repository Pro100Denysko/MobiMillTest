package ua.com.app.DAO;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.app.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

  Optional<Department> getById(Long id);

}
