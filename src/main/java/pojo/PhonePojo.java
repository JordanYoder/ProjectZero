package pojo;

import java.math.BigDecimal;

public class PhonePojo {
    private int phoneID;
    private String phoneBrand;
    private String phoneModel;
    private BigDecimal phoneMsrp;
    private boolean phoneRemove;
    private String phoneNotes;
    private String phoneStatus;

    public PhonePojo() {

    }

    public PhonePojo(int phoneID, String phoneBrand, String phoneModel, BigDecimal phoneMsrp, boolean phoneRemove, String phoneNotes, String phoneStatus) {
        this.phoneID = phoneID;
        this.phoneBrand = phoneBrand;
        this.phoneModel = phoneModel;
        this.phoneMsrp = phoneMsrp;
        this.phoneRemove = phoneRemove;
        this.phoneNotes = phoneNotes;
        this.phoneStatus = phoneStatus;
    }

    public int getPhoneID() {
        return phoneID;
    }

    public void setPhoneID(int phoneID) {
        this.phoneID = phoneID;
    }

    public String getPhoneBrand() {
        return phoneBrand;
    }

    public void setPhoneBrand(String phoneBrand) {
        this.phoneBrand = phoneBrand;
    }

    public String getPhoneModel() {
        return phoneModel;
    }

    public void setPhoneModel(String phoneModel) {
        this.phoneModel = phoneModel;
    }

    public BigDecimal getPhoneMsrp() {
        return phoneMsrp;
    }

    public void setPhoneMsrp(BigDecimal phoneMsrp) {
        this.phoneMsrp = phoneMsrp;
    }

    public boolean isPhoneRemove() {
        return phoneRemove;
    }

    public void setPhoneRemove(boolean phoneRemove) {
        this.phoneRemove = phoneRemove;
    }

    public String getPhoneNotes() {
        return phoneNotes;
    }

    public void setPhoneNotes(String phoneNotes) {
        this.phoneNotes = phoneNotes;
    }

    public String getPhoneStatus() {
        return phoneStatus;
    }

    public void setPhoneStatus(String phoneStatus) {
        this.phoneStatus = phoneStatus;
    }

    @Override
    public String toString() {
        return "Brand: " + phoneBrand + "\t\t" + "Model: " +phoneModel + "\t\t" + "MSRP: $" + phoneMsrp + "\t\t" + "Status: " + phoneStatus + "\n" + phoneNotes;
    }
}
