package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository respository = new MemoryMemberRepository();

    //테스트 끝날때마다 클리어
    @AfterEach
    public  void afterEach(){
        respository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        respository.save(member);

        Member result = respository.findById(member.getId()).get();
        //System.out.println("result = " + result);
        //Assertions.assertThat static 써서 Assertions 생략 (alt + enter -> add ~)
        assertThat(member).isEqualTo(result);
    }
    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        respository.save(member1);

        Member member2 = new Member();  //shift + F6 rename
        member2.setName("spring2");
        respository.save(member2);
        
        //respository.findByName("spring1"); 에서 alt+enter -> intro~ ->replace
        Member result = respository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        respository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        respository.save(member2);

        List<Member> result = respository.findAll();

        assertThat(result.size()).isEqualTo(2);

    }


}
