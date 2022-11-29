package company.service;

import company.model.User;

public interface UserService {
    void addUsers(User user);

    User getById(int id);

    String deleteById(int id);

    void getAllUsers();
}
