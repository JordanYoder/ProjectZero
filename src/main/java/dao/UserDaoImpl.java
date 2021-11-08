package dao;

import pojo.UserPojo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDaoImpl implements UserDao {
    @Override
    public UserPojo addCustomer(UserPojo userPojo) {
        Connection conn = DBUtil.openConnection();
        int rowsAffected = 0;

        try {
            Statement insert = conn.createStatement();
            String insertQuery = "INSERT INTO user_details " +
                    "(user_account_type, " +
                    "user_email, " +
                    "user_password, " +
                    "user_first_name, " +
                    "user_last_name, " +
                    "user_address, " +
                    "user_city, " +
                    "user_zip, " +
                    "user_delete, " +
                    "user_state" +
                    ") " +
                    "VALUES" +
                    "('customer', " +
                    "'" + userPojo.getUserEmail() + "', " +
                    "'" + userPojo.getUserPassword() + "', " +
                    "'" + userPojo.getUserFirstName() + "', " +
                    "'" + userPojo.getUserLastName() + "', " +
                    "'" + userPojo.getUserAddress() + "', " +
                    "'" + userPojo.getUserCity() + "', " +
                    "'" + userPojo.getUserDelete() + "', " +
                    "false, " +
                    "'" + userPojo.getUserState() + "');";
            rowsAffected = insert.executeUpdate(insertQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userPojo;
    }

    @Override
    public UserPojo updateUser(UserPojo userPojo) {
        return userPojo;
    }

    @Override
    public UserPojo getUser( UserPojo userLogin) {
        UserPojo userPojo = new UserPojo();
        Connection conn = DBUtil.openConnection();
        String selectQuery = "SELECT * FROM user_details WHERE user_email='" + userLogin.getUserEmail() + "' AND user_password='" + userLogin.getUserPassword() + "';";

        try {
            Statement select = conn.createStatement();
            ResultSet result = select.executeQuery(selectQuery);
            result.next();
            if(result.getBoolean("user_delete") == false) {
                userPojo.setUserID(result.getInt("user_id"));
                userPojo.setAccountType(result.getString("user_type"));
                userPojo.setUserEmail(result.getString("user_email"));
                userPojo.setUserPassword(result.getString("user_password"));
                userPojo.setUserFirstName(result.getString("user_first_name"));
                userPojo.setUserLastName(result.getString("user_last_name"));
                userPojo.setUserAddress(result.getString("user_address"));
                userPojo.setUserCity(result.getString("user_city"));
                userPojo.setUserZip(result.getString("user_zip"));
                return userPojo;

            } else {
                System.out.println("User does not exist");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userPojo;
    }

    @Override
    public boolean deleteUSer(int user_id) {
        return false;
    }
}
