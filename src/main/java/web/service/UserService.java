package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    void createUser(User user);

    void editUser(User user);

    void deleteUser(long id);

    User getUserByID(long id);
}
