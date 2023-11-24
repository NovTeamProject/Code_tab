package com.example.team_project.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encrypt {
  public static String getEncrypt(String pwd) {

    String result = "";
    String salt = "";
    try {
      // SHA256 알고리즘 객체 생성
      MessageDigest md = MessageDigest.getInstance("SHA-256");

      // 비밀번호와 salt 합친 문자열에 SHA 256 적용
      md.update((pwd+salt).getBytes());
      byte[] pwdsalt = md.digest();

      // byte To String (10진수의 문자열로 변경)
      StringBuffer sb = new StringBuffer();
      for (byte b : pwdsalt) {
        sb.append(String.format("%02x", b));
      }
      result=sb.toString();

    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }

    return result;
  }
}