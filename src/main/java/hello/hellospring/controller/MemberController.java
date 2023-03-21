package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired //생성자에 @Autowired 라고 되어있으면 이 멤버 서비스를 스프링이 스프링빈에 있는 멤버 서비스를 가져다가 연결 시켜준다
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
