package com.library.Domain;


public class AdminUser {
    private String admin_uuid;
    private String admin_name;
    private String admin_password;
    private String admin_email;
    private int admin_static;

    public String getAdmin_uuid() {
        return admin_uuid;
    }

    public void setAdmin_uuid(String admin_uuid) {
        this.admin_uuid = admin_uuid;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }

    public String getAdmin_email() {
        return admin_email;
    }

    public void setAdmin_email(String admin_email) {
        this.admin_email = admin_email;
    }

    public int getAdmin_static() {
        return admin_static;
    }

    public void setAdmin_static(int admin_static) {
        this.admin_static = admin_static;
    }
}
