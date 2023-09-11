package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    void edit(User user);

    void delete(long id);

    User userById(long id);

    List<User> listUsers();
}
