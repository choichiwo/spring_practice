package edu.coldrain.practice.controller;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EventController.class)
public class EventControllerTest {

    //의존성 자동 주입
    //MockMvc 는 MVC 웹 테스트를 위한 최소한의 기능들이 구현되어 있다.

    @Autowired
    private MockMvc mockMvc;

    // localhost:8080/events/list
    // status code:
    // 404 NOT FOUND
    // 500 INTERNAL SERVER ERROR
    // 200 OK

    @Test
    public void exist() {
        Assertions.assertThat(mockMvc).isNotNull();
    }

    @Test
    public void getList() throws Exception {

        // perform : GET 방식으로 /events/list
        // andDo(print()) : 요청과 응답을 모두 확인할 수 있다.
        mockMvc.perform(get("/events/list"))
                .andDo(print())
                .andExpect(status().isOk()); //200
    }

}