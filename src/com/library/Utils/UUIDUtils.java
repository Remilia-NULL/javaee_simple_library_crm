package com.library.Utils;
/*
* 各种UUID的随机生成。
* */

import java.util.UUID;

public class UUIDUtils {
    public static String make() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
