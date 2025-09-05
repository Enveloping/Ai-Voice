package com.voice.tts.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.voice.tts.pojo.entity.AudioInfoDo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AudioInfoMapper extends BaseMapper<AudioInfoDo> {
}
