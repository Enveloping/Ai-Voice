package com.voice.tts.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.voice.tts.context.BaseContext;
import com.voice.tts.mapper.AudioInfoMapper;
import com.voice.tts.pojo.entity.AudioInfoDo;
import com.voice.tts.pojo.vo.AudioInfoRequestVO;
import com.voice.tts.pojo.vo.AudioInfoResponseVO;
import com.voice.tts.service.AudioInfoService;
import jakarta.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.spi.CalendarDataProvider;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class AudioInfoServiceImpl implements AudioInfoService {
  @Resource
  AudioInfoMapper audioInfoMapper;

  /**
   * 存储音频
   * @param audioInfoRequestVO 请求对象
   * @return 返回插入后自增生成的audio_id
   */
  @Override
  public int addAudio(AudioInfoRequestVO audioInfoRequestVO) {
    AudioInfoDo audioInfoDo = new AudioInfoDo();
    BeanUtils.copyProperties(audioInfoRequestVO,audioInfoDo);
    audioInfoDo.setCreateTime(new Date());
    audioInfoDo.setUserId(BaseContext.getCurrentUserId());
    audioInfoMapper.insert(audioInfoDo);
    return audioInfoDo.getAudioId();
  }
  @Override
  public int deleteAudio(int audioId) {
    QueryWrapper<AudioInfoDo> wrapper = new QueryWrapper<>();
    wrapper.eq("audio_id",audioId);
    return audioInfoMapper.delete(wrapper);
  }
  @Override
  public List<AudioInfoResponseVO> getAudioList(int userId) {
    QueryWrapper<AudioInfoDo> wrapper = new QueryWrapper<>();
    wrapper.eq("user_id",userId);
    List<AudioInfoDo> audioInfoDoList = audioInfoMapper.selectList(wrapper);
    ArrayList<AudioInfoResponseVO> res = new ArrayList<>();
    audioInfoDoList.forEach(items->{
      AudioInfoResponseVO audioInfoResponseVO = new AudioInfoResponseVO();
      BeanUtils.copyProperties(items,audioInfoResponseVO);
      res.add(audioInfoResponseVO);
    });
    return res;
  }
}
