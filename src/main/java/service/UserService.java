package service;
import java.util.List;

import pojo.UserPojo;

public interface UserService {
    UserPojo addCustomer(UserPojo userPojo);
    UserPojo updateUser(UserPojo userPojo);
    boolean deleteUser(int userID);
    UserPojo getUser( UserPojo userLogin);
    void exitApplication();
}