package edu.coldrain.practice.domain;


import lombok.*;

@Data //Getter Setter ToString
@NoArgsConstructor //기본 생성자(빈 생성자)
@AllArgsConstructor //모든 필드를 매개변수로 받는 생성자
@Builder //빌더패턴 자동 생성
public class Event {

    private Long id;
    private String name;
    private Integer limit;

}
