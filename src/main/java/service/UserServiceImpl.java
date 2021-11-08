package service;

import dao.UserDao;
import dao.UserDaoImpl;
import pojo.UserPojo;

public class UserServiceImpl implements UserService {

    UserDao userDao;

    public UserServiceImpl() {
        this.userDao =  new UserDaoImpl();
    }

    @Override
    public UserPojo addCustomer(UserPojo userPojo) {
        return this.userDao.addCustomer(userPojo);
    }

    @Override
    public UserPojo updateUser(UserPojo userPojo) {
        return null;
    }

    @Override
    public boolean deleteUser(int bookID) {
        return false;
    }

    @Override
    public UserPojo getUser( UserPojo userLogin) {
        return this.userDao.getUser(userLogin);
    }

    @Override
    public void exitApplication() {

    }
}
