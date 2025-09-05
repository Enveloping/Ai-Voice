package com.voice.tts.pojo.vo;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AudioInfoResponseVO {
  public int audioId;
  public String audioName;
  public Date createTime;
  public String audioDuration;
  public int speed;
  public int emotion;
}
