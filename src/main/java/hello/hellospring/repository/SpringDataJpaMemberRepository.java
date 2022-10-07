package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//인터페이스끼리 받을 때는 extends / 인터페이스는 다중상속이 됨
//스프링 데이터 JPA가 SpringDataJpaMemberRepository 를 스프링 빈으로 자동 등록해준다. 구현체를 자동으로 만들어 등록함
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository{

    // JPQL select m from Member m  where m.name = ?
    @Override
    Optional<Member> findByName(String name);
}
