package com.Lph.admin.Utils;

import java.util.Random;

/**
 * 生成不重复随机id
 */
public class IdUtil {
    public static String nextId() {
        // 取当前时间的长整形值包含毫秒
        long millis = System.currentTimeMillis();
        // long millis = System.nanoTime();
        // 加上三位随机数
        Random random = new Random();
        int end3 = random.nextInt(999);
        // 如果不足三位前面补0
        String str = millis + String.format("%03d", end3);
        return str;
    }

    public static void main(String[] args) {
        for (int i = 0; i< 5; i++){
            System.out.println(nextId());
        }


    }
}
