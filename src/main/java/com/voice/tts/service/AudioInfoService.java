package com.voice.tts.service;

import com.voice.tts.pojo.entity.AudioInfoDo;
import com.voice.tts.pojo.vo.AudioInfoRequestVO;
import com.voice.tts.pojo.vo.AudioInfoResponseVO;
import java.util.List;

public interface AudioInfoService {
  public int deleteAudio(int audioId);
  public int addAudio(AudioInfoRequestVO processedAudio);
  public List<AudioInfoResponseVO> getAudioList(int userId);
}
