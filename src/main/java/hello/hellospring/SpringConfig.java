package hello.hellospring;

import hello.hellospring.repository.JdbcMemberRepository;
import hello.hellospring.repository.JdbcTemplateMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration      //한 개 이상의 @Bean을 제공하는 클래스에 명시하는 어노테이션으로,
                    // IOC Container 에게 해당 클래스가 Bean 으로 구성된 클래스라는 것을 알려줍니다.
public class SpringConfig {
/*    스프링 빈 등록 이미지
       -------스프링 컨테이너-------------------------------------
      |  helloController -> memberService -> MemberRepository  |
       --------------------------------------------------------
       memberService 와 MemberRepository 가 스프링 컨테이너에 스프링 빈으로 등록되었다.
*/

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Bean
    public MemberService memberService(){
        return new MemberService(MemberRepository());
    }

    @Bean
    public MemberRepository MemberRepository(){

//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }



}
