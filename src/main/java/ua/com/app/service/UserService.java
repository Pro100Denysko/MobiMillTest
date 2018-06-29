package ua.com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.app.DAO.UserRepository;
import ua.com.app.model.User;

@Service
public class UserService {

  private UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User save(User user) {
    return userRepository.save(user);
  }

  public void delete(User user) {
    userRepository.delete(user);
  }

  public User getById(Long id) {
    return userRepository.findById(id).orElseThrow(() ->
        new RuntimeException("Requested entity was not found"));
  }

  public User updateName(User userToUpdate, String newName) {
    userToUpdate.setName(newName);
    return userRepository.save(userToUpdate);
  }

}
