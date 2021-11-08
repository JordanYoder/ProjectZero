package dao;

import pojo.UserPojo;

import java.util.List;

public interface UserDao {
    UserPojo addCustomer(UserPojo userPojo);
    UserPojo updateUser(UserPojo userPojo);
    UserPojo getUser( UserPojo userLogin);
    boolean deleteUSer(int user_id);
}
