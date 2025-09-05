package com.voice.tts.controller;

import com.voice.tts.common.BaseResult;
import com.voice.tts.context.BaseContext;
import com.voice.tts.pojo.entity.AudioDataDo;
import com.voice.tts.pojo.vo.AudioInfoRequestVO;
import com.voice.tts.service.AudioDataService;
import com.voice.tts.service.AudioInfoService;
import jakarta.annotation.Resource;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("/processedAudio")
public class AudioController {
  @Resource
  AudioInfoService audioInfoService;
  @Resource
  AudioDataService audioDataService;

  @GetMapping("delete")
  public BaseResult<?> deleteAudio(@RequestParam("audioId")int audioId ){
    try {
      //先删文件
      audioDataService.deleteAudio(audioId);
      //再删文件信息
      audioInfoService.deleteAudio(audioId);
      return new BaseResult<>(HttpStatus.OK);
    } catch (Exception e) {
      log.error(e.getMessage()+"\n"+"cause by :"+e.getCause().toString());
      return new BaseResult<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping("/add")
  public BaseResult<?> addAudio(@RequestParam("audio") MultipartFile audio,@ModelAttribute AudioInfoRequestVO audioInfo){
    log.info(audioInfo.toString()+audio.toString());
    try {
      int audioId=audioInfoService.addAudio(audioInfo);
      AudioDataDo audioDataDo = new AudioDataDo(audioId,audio.getBytes());
      audioDataService.addAudio(audioDataDo);
      return new BaseResult<>(HttpStatus.OK);
    } catch (IOException e) {
      log.error(e.getMessage()+"\n"+"cause by :"+e.getCause().toString());
      return new BaseResult<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/getList")
  public BaseResult<?> getAudioList(){
    return new BaseResult<>(audioInfoService.getAudioList(BaseContext.getCurrentUserId()),HttpStatus.OK);
  }
}
