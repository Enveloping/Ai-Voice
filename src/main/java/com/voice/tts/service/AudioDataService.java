package com.voice.tts.service;

import com.voice.tts.pojo.entity.AudioDataDo;

public interface AudioDataService {
  public int deleteAudio(int audioId);
  public int addAudio(AudioDataDo audioData);
  public byte[] getAudio(int audioId);
}
