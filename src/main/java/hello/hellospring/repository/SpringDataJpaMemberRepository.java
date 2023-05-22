package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    //JPQL select m from Member m where m.name = ? <<이런식으로 SQL을 짜줌 메서드 이름만으로도..
    @Override
    Optional<Member> findByName(String name);
}

//스프링 데이터 JPA 제공 기능
//인터페이스를 통한 기본 CRUD
