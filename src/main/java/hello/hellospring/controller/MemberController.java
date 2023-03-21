package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;

    /**
     * 생성자 주입
     */
    @Autowired //생성자에 @Autowired 라고 되어있으면 이 멤버 서비스를 스프링이 스프링빈에 있는 멤버 서비스를 가져다가 연결 시켜준다
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /**
     * setter 주입
     */
/*
    private MemberService memberService;

    @Autowired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }
*/

    //@Autowired private MemberService memberService; 이거는 필드 주입이라고 한다. 근데 스프링에서는 별로 안좋아함


}
