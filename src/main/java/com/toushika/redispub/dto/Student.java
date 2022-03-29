package com.toushika.redispub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student implements Serializable {
    private String id;
    private String name;
    private String dob;
}
