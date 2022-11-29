package company.service.impl;

import company.MyException;
import company.dao.UserDao;
import company.model.User;
import company.service.UserService;

import java.util.ArrayList;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDao(new ArrayList<>());
    @Override
    public void addUsers(User user) {
        userDao.getUsers().add(user);

    }

    @Override
    public User getById(int id)throws MyException {
        return   userDao.getUsers().stream().filter(d->d.getId() == id).findFirst()
                .orElseThrow(()->new MyException("User with id "+ id + " not found"));


    }

    @Override
    public String deleteById(int id) {
        for (int i = 0; i < userDao.getUsers().size(); i++) {
            if (userDao.getUsers().get(i).getId() == id) {
                userDao.getUsers().remove(i);
            }
        }
        return "Successfully deleted";
    }
    @Override
    public void getAllUsers() {
        userDao.getUsers().stream().forEach(System.out::println);

    }
    @Override
    public String toString() {
        return "UserServiceImpl{" +
                "userDao=" + userDao +
                '}';
    }
}
