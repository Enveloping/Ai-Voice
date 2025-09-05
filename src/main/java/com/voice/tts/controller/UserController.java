package com.voice.tts.controller;

import com.voice.tts.common.BaseResult;
import com.voice.tts.pojo.vo.UserLoginVO;
import com.voice.tts.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
  @Resource
  UserService userService;

  /**
   * 登录返回token和用户名
   * @param userName 用户名
   * @param password 密码
   * @return jwt
   */
  @GetMapping("/login")
  public BaseResult<?> login(@RequestParam("userName") String userName,@RequestParam("password") String password){
    String token = userService.login(userName, password);
    return new BaseResult<>(new UserLoginVO(token,new UserLoginVO.UserInfo(userName)),HttpStatus.OK);
  }

  @GetMapping("/logout")
  public BaseResult<?> logout(){
    return new BaseResult<>(HttpStatus.ACCEPTED);
  }
}
