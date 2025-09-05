package com.voice.tts.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginVO {
  String token;
  UserInfo userInfo;
  @Data
  @AllArgsConstructor
  public static class UserInfo{
    String userName;
  }
}
