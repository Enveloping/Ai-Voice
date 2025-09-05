package com.voice.tts.service;

import org.springframework.stereotype.Service;

public interface UserService {
  public String login(String userName, String password);
  public void register(String userName, String password);
}
