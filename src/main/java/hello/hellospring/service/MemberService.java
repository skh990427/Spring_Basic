package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public Long join(Member member) {
        //같은 이름이 있는 중복 회원 X 원래는 같은 이름이 있을수는 있지만 예시니깐 임의로 정함
        validataDuplicateMember(member); //중복회원 검증

        memberRepository.save(member); //중복회원 검증이 통과하면 검증
        return member.getId();
    }

    private void validataDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }


    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() { //전체회원 조회
        return memberRepository.findAll();
    }

    
    public Optional<Member> findOne(Long memberId) { //멤버 아이디를 반환해서 찾기
        return memberRepository.findById(memberId);
    }
}
