package edu.ucalgary.oop;

public class Inquirer {
    final private String FIRST_NAME, LAST_NAME, INFO, SERVICES_PHONE;

    public Inquirer(String firstName, String lastName, String phone, String info) {
        this.FIRST_NAME = firstName;
        this.LAST_NAME = lastName;
        this.SERVICES_PHONE = phone;
        this.INFO = info;
    }

    public String getFirstName() {
        return (FIRST_NAME);
    }

    public String getLastName() {
        return (LAST_NAME);
    }

    public String getServicesPhoneNum() {
        return (SERVICES_PHONE);
    }

    public String getInfo() {
        return (INFO);
    }
}
