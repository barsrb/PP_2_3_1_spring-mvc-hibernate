package web.repository;

import web.model.User;

import java.util.List;


public interface UserRepository {

    List<User> findAll();

    void save(User user);

    User findById(Long id);

    void delete(User user);
}
