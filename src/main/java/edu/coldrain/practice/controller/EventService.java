package edu.coldrain.practice.controller;

import edu.coldrain.practice.domain.Event;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service //자동으로 스프링이 스프링 빈으로 IoC 컨테이너에 등록 (@Component 붙인거랑 같음)
public class EventService {

    public List<Event> getEvents() {
        final Event event1 = Event.builder()
                .id(1L)
                .name("스프링 MVC 스터디 1차")
                .limit(5)
                .build();
        final Event event2 = Event.builder()
                .id(2L)
                .name("스프링 MVC 스터디 2차")
                .limit(5)
                .build();
        // event1 과 event2 객체를 저장하고 있는 리스트를 반환한다.
        return Arrays.asList(event1, event2);
    }
}
