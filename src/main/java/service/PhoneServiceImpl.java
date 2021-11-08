package service;

import dao.PhoneDao;
import dao.PhoneDaoImpl;
import pojo.PhonePojo;

import java.util.List;

public class PhoneServiceImpl implements PhoneService {
    PhoneDao phoneDao;

    public PhoneServiceImpl() {
        this.phoneDao = new PhoneDaoImpl();
    }

    @Override
    public boolean addPhone(PhonePojo phone) {
        return this.phoneDao.addPhone(phone);
    }

    @Override
    public PhonePojo updatePhone() {
        return null;
    }

    @Override
    public boolean deletePhone(int imei) {
        return false;
    }

    @Override
    public PhonePojo getAPhone(PhonePojo phone) {
        return null;
    }

    @Override
    public List<PhonePojo> getAllPhones() {
        List<PhonePojo> allPhones = this.phoneDao.getAllPhones();
        return allPhones;
    }
}
