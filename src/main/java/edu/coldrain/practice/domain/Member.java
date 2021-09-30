package edu.coldrain.practice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class Member {

    private Long id;
    private String name;
    private Integer age;
}
