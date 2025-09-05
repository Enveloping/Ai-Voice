package com.voice.tts.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;

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
  public Date audioDuration;
  public int speed;
  public int emotion;
}
