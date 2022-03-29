package com.toushika.redispub.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.toushika.redispub.dto.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class RedisPublisher {

    private final RedisTemplate<String, String> redisTemplate;
    private final ObjectMapper objectMapper;

    @Value("${redis.general.topic}")
    private String messageTopic;

    public <T> void sendMessage(T t) {

        try {
            var messageJson = objectMapper.writeValueAsString(t);
            log.info("RedisPublisher: sendMessage:: msg: {}", messageJson);
            redisTemplate.convertAndSend(messageTopic, messageJson);
        } catch (JsonProcessingException e) {
            log.error("RedisPublisher:: sendMessage:: ERROR: {}",e);
        }

    }
}
