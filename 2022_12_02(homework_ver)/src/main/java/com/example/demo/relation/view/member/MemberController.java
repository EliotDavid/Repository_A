package com.example.demo.relation.view.member;

import com.example.demo.relation.domain.academy.Academy;
import com.example.demo.relation.domain.academy.AcademyRepository;
import com.example.demo.relation.domain.member.Member;
import com.example.demo.relation.domain.service.RelationService;
import com.example.demo.relation.view.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/members")
@RequiredArgsConstructor
@Controller
public class MemberController {
    private final RelationService relationService;
    private final AcademyRepository academyRepository;

    @GetMapping("/new")
    public String insert(@ModelAttribute("form") MemberDto dto) {
        return "members/newMemberForm";
    }

    @PostMapping("/new")
    public String save(@Valid @ModelAttribute("form") MemberDto dto, BindingResult bindingResult) {

        if(bindingResult.hasErrors())
            return "members/newMemberForm";


        List<Academy> academies = academyRepository.findByName(dto.getAcademyName());
        // ** 해당하는 학원이름이 존재하는지 확인하는 의미라고 함

        Academy academy = null;

        if(!academies.isEmpty())
            for(int i = 0; i <= academies.size(); i++){
                if(dto.getAcademyName().equals(academies.get(i))){
                    academy = academies.get(0);
                    String AcademyNameFromDb = academies.get(i).getAcademyName();
                    System.out.println(AcademyNameFromDb);
                    break;
                }
            }

            //academy = academies.indexOf()
            //academy = academies.get(0);

        else
            System.out.println("There is no the academy you wrote in Db. I'll add it. ");
            academy = new Academy(dto.getAcademyName());

        List<Member> members = relationService.findById(dto.getLoginId());

        if(!members.isEmpty())
        {
            System.out.println("Error Message!!!!");
            return "members/newMemberForm";
        }
        else
            relationService.insert(
                    new Member(
                            dto.getLoginId(),
                            dto.getMemberName(),
                            dto.getPassword(),
                            academy) );

        /*
        List<Academy> all = academyRepository.findAll();
        if(all.isEmpty())
        {
            Academy academy = new Academy(dto.getAcademyName());
            memberService.insert(
                    new Member( dto.getMemberName(), academy));
        }
        else
        {
            for (Academy element : all) {
                if(element.getAcademyName().equals(dto.getAcademyName())) {
                    Academy academy = academyRepository.findById(element.getId());
                    memberService.insert(
                            new Member( dto.getMemberName(), academy));
                }
            }
        }
        */

        return "redirect:/";
    }
}
