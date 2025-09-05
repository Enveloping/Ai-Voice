package com.voice.tts.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AudioInfoRequestVO {
  public String audioName;
  public String audioDuration;
  public int speed;
  public int emotion;
}
