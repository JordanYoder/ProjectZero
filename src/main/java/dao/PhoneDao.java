package dao;

import pojo.PhonePojo;

import java.util.List;

public interface PhoneDao {
    boolean addPhone(PhonePojo phone);
    PhonePojo updatePhone();
    boolean deletePhone(int imei);
    PhonePojo getAPhone(PhonePojo phone);
    List<PhonePojo> getAllPhones();

}
