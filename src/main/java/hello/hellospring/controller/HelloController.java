package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";

    }

    @GetMapping("hello-mvc")    //@RequestParam(vaule = "name", required = false   / 기본으로 required 가 true로 되어 있음
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody       //HTTP의 BODY에 문자 내용을 직접 반환. viewResolver 대신에 HttpMessageConverter가 동작
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;     //@ResponseBody: 기본 문자는 String Converter로 처리
    }

    @GetMapping("hello-api")
    @ResponseBody       //return 값이 객체일 경우 json 방식으로 넘김 {"key":"value"}
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

    }




}
