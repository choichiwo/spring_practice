package edu.coldrain.practice.controller;

import edu.coldrain.practice.domain.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller // @Controller
@RequestMapping("/events/*")
//@RequiredArgsConstructor
public class EventController {

    //스프링 빈(Spring Bean): 스프링이 관리하는 객체를 스프링 빈이라고 한다.
    //스프링 빈을 IoC 컨테이너라는 공간에 보관한다.
    //스프링 빈은 별도의 설정을 하지 않음연 자동으로 싱글톤으로 관리한다.
    //별도의 scope 로 protoptype 설정을 해주면 프로토타입으로 관리된다.

    //의존성 주입 3가지 방법
    //필드 주입: 필드에 @Autowired 애노테이션을 사용 (실제로 사용 권장X)
    //셋터 주입: 셋터에 @Autowired 애노테이션을 사용
    //생성자 주입: 생성자에 @Autowired 애노테이션을 사용

    //필드주입은 권장X
    //@Autowired
    private final EventService eventService;

    //롬복에서 제공해 주는 @RequiredArgsConstructor 를 사용하면
    //final 키워드가 붙은 필드들을 가지고 생성자를 만들어 준다.
    //생성자가 1개만 있으면 자동으로 스프링이 생성자에 @Autowired 를 붙여주므로 편리하다.

    //생성자 주입
    //생성자는 1개만 있으면 스프링이 자동으로 생성자에 @Autowired 를 붙여준다.
    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    //컨트롤러의 메서드를 핸들러라 한다.
    @GetMapping("/list")
    public String list(Model model) {
        log.info("EventController.list()");
        //EventController 가 eventService 의 메서드를 호출하고 있다.
        //A가 B의 메서드를 호출하고 있다면 A가 B를 의존한다고 한다.
        //즉, EventController 가 eventService 를 의존한다.
        final List<Event> eventList = eventService.getEvents();
        model.addAttribute("eventList", eventList);
        return "events/eventList";
    }

    @GetMapping("/events/new")
    public String eventForm(Model model) {
        log.info("EventController.eventForm()");
        model.addAttribute("event", new Event());
        return "events/eventAdd";
    }

    @PostMapping("/events/new") //스프링 타입컨버터
    public String createEvent(@Validated @ModelAttribute Event event, BindingResult bindingResult) {
        // bindingResult 가 에러를 가지고 있다면
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(objectError -> log.info("error = {}", objectError));
            return "events/eventAdd";
        }
        log.info("EventController.createEvent()");
        log.info("event = {}", event);

        return "events/eventList";
    }
}