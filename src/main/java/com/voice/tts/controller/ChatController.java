//package com.voice.tts.controller;
//
//import org.springframework.ai.chat.client.ChatClient;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/ai")
//public class ChatController {
//
//  private final ChatClient chatClient;
//
//  public ChatController(ChatClient.Builder chatClientBuilder) {
//    this.chatClient = chatClientBuilder.build();
//  }
//
//  @GetMapping("/chat")
//  public ResponseEntity<?> chat(@RequestParam("message") String message){
//    chatClient.prompt()
//        .user(message)
//        .call()
//        .content();
//    return new ResponseEntity<>(HttpStatus.ACCEPTED);
//  }
//}
