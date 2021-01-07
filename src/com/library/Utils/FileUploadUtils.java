package com.library.Utils;

/*
*判断操作系统，用于上传文件时的临时目录的创建。
**/
import java.io.File;

public class FileUploadUtils {

    private static final String systemUserName = System.getProperty("user.name");

    public static int checkSystem() {
        String whatSystem = System.getProperty("os.name");
        if (whatSystem.contains("Mac") || whatSystem.contains("mac")) {
            return 1;
        } else if (whatSystem.contains("Linux") || whatSystem.contains("linux")) {
            return 2;
        } else if (whatSystem.contains("Windows") || whatSystem.contains("windows")) {
            return 3;
        } else {
            return 0;
        }
    }

    public static String uploadPath() {
        String path = "";
        if (checkSystem() == 1) {
            path = File.separator + "Users" + File.separator + systemUserName + File.separator + "Temp" + File.separator + "productImg" + File.separator + "TempFolder";
        } else if (checkSystem() == 2) {
            path = File.separator + "home" + File.separator + systemUserName + File.separator + "Temp" + File.separator + "productImg" + File.separator + "TempFolder";
        } else if (checkSystem() == 3) {
            path = "C:" + File.separator + "Users" + File.separator + systemUserName + File.separator + "Temp" + File.separator + "productImg" + File.separator + "TempFolder";
        } else {
            return path;
        }
        return path;
    }
}
