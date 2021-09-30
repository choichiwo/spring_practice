package edu.coldrain.practice.domain;


import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data //Getter Setter ToString
@NoArgsConstructor //기본 생성자(빈 생성자)
@AllArgsConstructor //모든 필드를 매개변수로 받는 생성자
@Builder //빌더패턴 자동 생성
public class Event {

    @NotNull
    private Long id;

    @NotBlank
    private String name;

    @Range(min = 1, max = 5)
    private Integer limit;

}
