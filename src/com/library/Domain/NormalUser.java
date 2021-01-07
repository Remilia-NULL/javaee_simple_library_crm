package com.library.Domain;

public class NormalUser {
    private String nor_uuid;
    private String nor_name;
    private String nor_password;
    private String nor_email;
    private int nor_static;

    public String getNor_uuid() {
        return nor_uuid;
    }

    public void setNor_uuid(String nor_uuid) {
        this.nor_uuid = nor_uuid;
    }

    public String getNor_name() {
        return nor_name;
    }

    public void setNor_name(String nor_name) {
        this.nor_name = nor_name;
    }

    public String getNor_password() {
        return nor_password;
    }

    public void setNor_password(String nor_password) {
        this.nor_password = nor_password;
    }

    public String getNor_email() {
        return nor_email;
    }

    public void setNor_email(String nor_email) {
        this.nor_email = nor_email;
    }

    public int getNor_static() {
        return nor_static;
    }

    public void setNor_static(int nor_static) {
        this.nor_static = nor_static;
    }
}
