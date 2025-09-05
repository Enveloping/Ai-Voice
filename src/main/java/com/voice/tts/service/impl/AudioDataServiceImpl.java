package com.voice.tts.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.voice.tts.mapper.AudioDataMapper;
import com.voice.tts.pojo.entity.AudioDataDo;
import com.voice.tts.service.AudioDataService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class AudioDataServiceImpl implements AudioDataService {

  @Resource
  AudioDataMapper audioDataMapper;
  @Override
  public int deleteAudio(int audioId) {
    QueryWrapper<AudioDataDo> wrapper = new QueryWrapper<>();
    wrapper.eq("audio_id",audioId);
    return audioDataMapper.delete(wrapper);
  }

  @Override
  public int addAudio(AudioDataDo audioData) {
    return audioDataMapper.insert(audioData);
  }

  @Override
  public byte[] getAudio(int audioId) {
    QueryWrapper<AudioDataDo> wrapper = new QueryWrapper<>();
    wrapper.eq("audio_id",audioId);
    AudioDataDo audioDataDo = audioDataMapper.selectOne(wrapper);
    return audioDataDo.getAudioData();
  }
}
