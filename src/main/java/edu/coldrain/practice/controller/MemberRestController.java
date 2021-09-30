package edu.coldrain.practice.controller;

import edu.coldrain.practice.domain.Member;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MemberRestController {

      /*
            모든 회원 조회: GET /members
            특정 회원 조회: GET /members/{memberId}
            회원 한 명 등록: POST /members
            회원 한 명 수정: PUT, PATCH /members/{memberId}
            회원 한 명 삭제: DELETE /members/{memberId}
       */

    @GetMapping(value = "/members", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Member>> findbyAll() {
        //모든 회원 정보 데이터를 데이터베이스 조회해서 JSON 으로 반환한다.
        final List<Member> memberList = new ArrayList<>();
        memberList.add(new Member(1L, "kim", 20));
        memberList.add(new Member(2L, "min", 31));

        return new ResponseEntity<>(memberList, HttpStatus.OK);
    }

    // /members/1
    // /members/2
    @GetMapping("/members/{memberId}")
    public void findOne(@PathVariable Long memberId) {
        //회원 아이디로 회원 아이디에 해당하는 회원을 데이터베이스에서 조회하여 JSON 으로 반환한다.
    }

    @PostMapping(value = "/members", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> registration(@RequestBody Member member) {
        //회원 객체를 받아서 데이터베이스에 등록한다.
        final boolean success = mapper.registration(member);
        if (success) {
            return new ResponseEntity<>("success", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/members/{memberId}")
    public void modify(@PathVariable Long memberId) {
        //회원 객체를 받아서 해당 아이디에 해당하는 회원의 정보를 데이터베이스에 수정한다.
    }

    @DeleteMapping("/members/{memberId}")
    public void remove(@PathVariable Long memberId) {
        //회원 아이디에 해당하는 회원의 정보를 데이터베이스에서 삭제한다.
    }

}
