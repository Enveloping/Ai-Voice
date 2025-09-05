package com.voice.tts.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.voice.tts.mapper.UserMapper;
import com.voice.tts.pojo.entity.UserDo;
import com.voice.tts.properties.JwtProperties;
import com.voice.tts.service.UserService;
import com.voice.tts.utils.JwtUtil;
import jakarta.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class UserServiceImpl implements UserService {
  @Resource
  UserMapper userMapper;
  @Resource
  JwtProperties jwtProperties;

  /**
   * 登录，接收用户名和密码再比对数据库
   * @param userName 用户名
   * @param password 密码
   * @return jwt ,里面包含用户名和用户id
   */
  @Override
  public String login(String userName, String password) {
    //比对数据库
    QueryWrapper<UserDo> wrapper = new QueryWrapper<>();
    wrapper.allEq(Map.of("user_name",userName,"password",password));
    try{
      UserDo user = userMapper.selectOne(wrapper);
      //若用户不存在，则直接注册
      if(ObjectUtils.isEmpty(user)){
        register(userName,password);
        user = userMapper.selectOne(wrapper);
      }
      //构造并返回token
      Map<String, Object> claims = new HashMap<>();
      claims.put("userId", user.getUserId());
      System.out.println("登录时的密钥："+jwtProperties.getSecretKey());
      return JwtUtil.createJWT(jwtProperties.getSecretKey(), jwtProperties.getTtl(),
          claims);
    }catch (Exception e) {
      throw new RuntimeException("构造token时出现错误",e);
    }
  }

  /**
   * 注册，若用户已存在则无任何变更
   * @param userName 用户名
   * @param password 密码
   */
  @Override
  public void register(String userName, String password) {
    QueryWrapper<UserDo> wrapper = new QueryWrapper<>();
    wrapper.allEq(Map.of("user_name",userName));
    Long count = userMapper.selectCount(wrapper);
    if(count == 0){
      userMapper.insert(new UserDo(userName,password,0));
    }
  }
}
