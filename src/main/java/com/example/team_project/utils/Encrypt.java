package com.example.team_project.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encrypt {
  public static String getEncrypt(String pwd) {

    String result = "";    // 암호화된 결과를 저장할 문자열 변수 선언
    String salt = "codetab";  // salt 문자열 선언
    try {

      MessageDigest md = MessageDigest.getInstance("SHA-256");    // MessageDigest 인스턴스를 SHA-256 알고리즘으로 생성

      md.update((pwd+salt).getBytes());   // 비밀번호와 salt를 합친 후, 그 문자열의 바이트 배열을 SHA-256 알고리즘으로 갱신
      byte[] pwdsalt = md.digest();   // 최종 해시값을 계산하여 byte 배열로 반환

      StringBuffer sb = new StringBuffer();  // StringBuffer 객체 생성
      for (byte b : pwdsalt) {
        sb.append(String.format("%02x", b));    // byte를 16진수 문자열로 변환하여 StringBuffer에 추가
      }
      result=sb.toString();    // StringBuffer의 내용을 문자열로 변환하여 result에 저장

    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }

    return result;
  }
}