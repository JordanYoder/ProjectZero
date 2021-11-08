package dao;

import pojo.PhonePojo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneDaoImpl implements PhoneDao{
    List<PhonePojo> allPhones;

    public PhoneDaoImpl() {
        this.allPhones = new ArrayList<PhonePojo>();
    }

    @Override
    public boolean addPhone(PhonePojo phone) {
        Connection conn = DBUtil.openConnection();
        int rowsAffected = 0;
        String deleteQuery = "INSERT INTO phone_details (" +
                "phone_brand, " +
                "phone_model, " +
                "phone_msrp, " +
                "phone_remove, " +
                "phone_notes, " +
                "phone_status" +
                ") VALUES (" +
                "'" + phone.getPhoneBrand() + "', " +
                "'" + phone.getPhoneModel() + "', " +
                "'" + phone.getPhoneMsrp() + "', " +
                "false, " +
                "'" + phone.getPhoneNotes() + "', " +
                "'" + phone.getPhoneStatus() + "'" +
                ");";

        try {
            Statement add = conn.createStatement();
            rowsAffected = add.executeUpdate(deleteQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(rowsAffected > 0) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public PhonePojo updatePhone() {
        return null;
    }

    // We will not hard delete phone from inventory. Mark it as removed
    @Override
    public boolean deletePhone(int imei) {
        Connection conn = DBUtil.openConnection();
        int rowsAffected = 0;

        try {
            Statement delete = conn.createStatement();
            String deleteQuery = "UPDATE phone SET is_removed=true WHERE phone=" + imei + ";";
            rowsAffected = delete.executeUpdate(deleteQuery);
            System.out.println("Deleted " + " record..." );

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(rowsAffected == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public PhonePojo getAPhone(PhonePojo phone) {
        Connection conn = DBUtil.openConnection();

        try {
            Statement select = conn.createStatement();
            String selectQuery = "SELECT * FROM phone WHERE phone_id=" + phone.getPhoneID() + ";";

            ResultSet rs = select.executeQuery(selectQuery);

            while(rs.next()) {
                phone = new PhonePojo();

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return phone;
    }

    @Override
    public List<PhonePojo> getAllPhones() {
        Connection conn = DBUtil.openConnection();
        //List<PhonePojo> phoneList = new ArrayList<PhonePojo>();


        try {
            Statement select = conn.createStatement();
            String selectQuery = "SELECT * FROM phone_details;";

            ResultSet rs = select.executeQuery(selectQuery);

            while(rs.next()) {
                PhonePojo phone = new PhonePojo();
                if(rs.getBoolean("phone_remove") == false) {
                    phone.setPhoneID(rs.getInt("phone_id"));
                    phone.setPhoneBrand(rs.getString("phone_brand"));
                    phone.setPhoneModel(rs.getString("phone_model"));
                    phone.setPhoneMsrp(rs.getBigDecimal("phone_msrp"));
                    phone.setPhoneNotes(rs.getString("phone_notes"));
                    phone.setPhoneStatus(rs.getString("phone_status"));
                    allPhones.add(phone);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allPhones;
    }
}
