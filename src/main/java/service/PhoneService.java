package service;

import pojo.PhonePojo;

import java.util.List;

public interface PhoneService {
    boolean addPhone(PhonePojo phone);
    PhonePojo updatePhone();
    boolean deletePhone(int imei);
    PhonePojo getAPhone(PhonePojo phone);
    List<PhonePojo> getAllPhones();
}
