package com.example.demo.relation.view;

import com.example.demo.relation.view.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class HomeController {

    @GetMapping("/")
   public String home(){
        return "home";
    }

}
