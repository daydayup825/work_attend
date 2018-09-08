package com.coder520.common.utils;

import com.alibaba.druid.util.Base64;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author: fanbopeng
 * @Date: 2018/9/5 12:38
 * @Description:安全工具类
 */
public class SecurityUtils {

    public   static String encrptyPassword(String password) throws NoSuchAlgorithmException {
        /**
         *
         * 功能描述:  MD5加密
         *
         * @param: [password]
         * @return: java.lang.String
         * @auther: fanbopeng
         * @date: 2018/9/5 12:39
         */


            MessageDigest md5 =MessageDigest.getInstance("MD5");
            BASE64Encoder base64Encoder = new BASE64Encoder();
            String result = base64Encoder.encode(md5.digest(password.getBytes()));




        return  result;
    }

    public static boolean checkPassword(String inputPwd,String dbPwd) throws NoSuchAlgorithmException {
        /**
         *
         * 功能描述:  与数据库中的密码进行比对
         *
         * @param: [inputPwd, dbPwd]
         * @return: boolean
         * @auther: fanbopeng
         * @date: 2018/9/5 12:47
         */
            String result = encrptyPassword(inputPwd);

            if (result.equals(dbPwd)){

                return true;
            }else {

                return  false;
            }
    }

}
