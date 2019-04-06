package io.f9n.basicinformationregistration.models;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private String name, surname, tc, email, phone;

    public User(String name, String surname, String tc, String email, String phone) {
        this.name = name;
        this.surname = surname;
        this.tc = tc;
        this.email = email;
        this.phone = phone;
    }

    public boolean isNotValid() {
        return this.name == "" || this.surname == "" || this.tc == "" ||  this.email == "" ||  this.phone == "";
    }

    public String toString() {
        return String.format("<User name: '%s', surname: '%s', tc: '%s', email: '%s', phone: '%s', isNotValid: %s>",this.name, this.surname, this.tc, this.email, this.phone, this.isNotValid());
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


    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.surname);
        dest.writeString(this.tc);
        dest.writeString(this.phone);
        dest.writeString(this.email);
    }

    protected User(Parcel in) {
        this.name = in.readString();
        this.surname = in.readString();
        this.tc = in.readString();
        this.phone = in.readString();
        this.email = in.readString();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
