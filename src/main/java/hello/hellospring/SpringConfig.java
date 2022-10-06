package hello.hellospring;

import hello.hellospring.repository.MemberRespository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration      //한 개 이상의 @Bean을 제공하는 클래스에 명시하는 어노테이션으로,
                    // IOC Container 에게 해당 클래스가 Bean 으로 구성된 클래스라는 것을 알려줍니다.
public class SpringConfig {
/*    스프링 빈 등록 이미지
       -------스프링 컨테이너-------------------------------------
      |  helloController -> memberService -> memberRepository  |
       --------------------------------------------------------
       memberService 와 memberRepository 가 스프링 컨테이너에 스프링 빈으로 등록되었다.
*/

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRespository());
    }

    @Bean
    public MemberRespository memberRespository(){
        return new MemoryMemberRepository();
    }



}
