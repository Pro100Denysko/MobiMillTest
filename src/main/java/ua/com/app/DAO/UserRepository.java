package ua.com.app.DAO;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.app.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findById(Long id);
}
