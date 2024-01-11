package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.User;
import web.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public void createUser(User user) {
        userRepository.addOrUpdateUser(user);
    }

    public void deleteUser(long id) {
        userRepository.deleteUser(new User(id, null, null));
    }

    public User getUserByID(long id) {
        return userRepository.getById(id);
    }
}
