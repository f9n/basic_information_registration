package io.f9n.basicinformationregistration.models;

public class User {
    private String name, surname, tc, email, phone;

    public User(String name, String surname, String tc, String email, String phone) {
        this.name = name;
        this.surname = surname;
        this.tc = tc;
        this.email = email;
        this.phone = phone;
    }

    public boolean isValid() {
        return this.name == "" || this.surname == "" || this.tc == "" ||  this.email == "" ||  this.phone == "";
    }

    public String toString() {
        return String.format("<User name: '%s', surname: '%s', tc: '%s', email: '%s', phone: '%s', isValid: %s>",this.name, this.surname, this.tc, this.email, this.phone, this.isValid());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
