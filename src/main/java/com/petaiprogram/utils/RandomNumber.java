package com.petaiprogram.utils;

import java.util.Map;
import java.util.Random;

public class RandomNumber {
    public static String getRandom(int n){
        // 创建Random对象
        Random random = new Random();


// 生成n位随机数字
        int min = (int) Math.pow(10, n - 1);  // 最小的n位数
        int max = (int) Math.pow(10, n) - 1;  // 最大的n位数
        int randomNumber = random.nextInt(max - min + 1) + min;

// 将随机数字转换为字符串
        String randomString = String.valueOf(randomNumber);
        return randomString;
    }
}
