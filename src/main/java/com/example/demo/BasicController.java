package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasicController {
    @GetMapping("/")
    //public : 접근제어자
    //String : return 타입
    // showMainPage : 메소드이름
    public String showMainPage(){

       return "index"; //리턴타입은 문자열
    }


}
