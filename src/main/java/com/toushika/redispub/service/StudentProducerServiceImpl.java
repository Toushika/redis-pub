package com.toushika.redispub.service;

import com.toushika.redispub.dto.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentProducerServiceImpl implements StudentProducer {

    private final RedisPublisher redisPublisher;

    @Override
    public void sendMessage(Student student) {
        redisPublisher.sendMessage(student);
    }
}
