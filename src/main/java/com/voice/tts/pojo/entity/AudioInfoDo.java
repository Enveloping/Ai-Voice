package com.voice.tts.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("audio_info")
public class AudioInfoDo {
  @TableId(type = IdType.AUTO)
  public int audioId;
  public int userId;
  public String audioName;
  public Date createTime;
  public String audioDuration;
  public int speed;
  public int emotion;
}
