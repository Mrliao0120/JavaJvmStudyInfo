package com.liao.util.utils;

import static java.lang.Integer.parseInt;
import static java.lang.System.currentTimeMillis;
import static java.util.UUID.randomUUID;
import static org.apache.commons.lang3.RandomStringUtils.randomAscii;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

/**
 * 随机数工具类
 */
public class RandomNumberUtil {

    /**
     * 生成短信验证码随机数
     */
    public static Integer genValCode() {
        Integer numeric = parseInt(randomNumeric(6));
        return (numeric + "").length() < 6 ? genValCode() : numeric;
    }

    public static String genSerialNo() {
        return "" + currentTimeMillis() + genValCode();
    }

    public static String genInitPwd() {
        return "" + genValCode();
    }

    public static String genSalt() {
        return randomAscii(6);
    }

    public static String randomUUIDString() {
        //返回32位的唯一id，用于混淆展现给外部调用的原自增id，防止太简单的爬数据和猜测到数据量。
        return randomUUID().toString().replaceAll("-", "");
    }

    public static String advertisementCode(Long id) {
        return "AD" + String.format("%05d", id);
    }

    /**
     * 随机指定范围内N个不重复的数
     * 最简单最基本的方法
     *
     * @param min 指定范围最小值
     * @param max 指定范围最大值
     * @param n   随机数个数
     */
    public static Integer[] randomCommon(Integer min, Integer max, Integer n) {
        if (n > (max - min + 1) || max < min) {
            return null;
        }
        Integer[] result = new Integer[n];
        int count = 0;
        while (count < n) {
            int num = (int) (Math.random() * (max - min)) + min;
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (num == result[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result[count] = num;
                count++;
            }
        }
        return result;
    }

}

