package vvl.samishamoon.coffe_shop;

import vvl.samishamoon.sql.SQL_functions;
import vvl.samishamoon.users.Admin;

import java.sql.*;
import java.util.ArrayList;

public class Coffee_shop {
    private int csId;
    private String name;
    private String address;
    private String phoneNumber;


    public Coffee_shop(int csId, String name, String address, String phoneNumber){
        this.csId = csId;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getCsId() {
        return csId;
    }

    public void setCsId(int csId) {
        this.csId = csId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString (){
        return String.format("Coffee_shop{%d, %s, %s, %s}", this.getCsId(),this.getName(),this.getAddress(),this.getPhoneNumber());
    }
}
