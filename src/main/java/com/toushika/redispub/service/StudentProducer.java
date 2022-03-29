package com.toushika.redispub.service;

import com.toushika.redispub.dto.Student;

public interface StudentProducer {
    void sendMessage(Student student);
}
