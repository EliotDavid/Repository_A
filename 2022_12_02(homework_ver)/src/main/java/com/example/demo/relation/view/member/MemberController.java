package com.example.demo.relation.view.member;

import com.example.demo.relation.domain.academy.Academy;
import com.example.demo.relation.domain.academy.AcademyRepository;
import com.example.demo.relation.domain.member.Address;
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
                        // ** @Valid라는거에의해서 값이 html파일의 입력란에 값이 채워져야지만 넘어갈수있도록 만듬
        if(bindingResult.hasErrors()) {
            return "members/newMemberForm";
        }

        List<Academy> academies = academyRepository.findByName(dto.getAcademyName());
        // ** 해당하는 학원이름이 존재하는지 확인하는 의미라고 함
        Academy academy = null; // ** 클래스가 null이라는 말은 필드는 유지하고 있는데 그 필드의 값들이 모두 0, 즉 null이라는 말이고
        Address address = null; // ** null값이 되어있지 않고 클래스가 선언만 되어있는 경우는 인스턴스 자체가 할당되지 않은 상태이기 때문에 그 클래스 안에 어떤 필드들도 없는 상태임
        if(!academies.isEmpty()) {
            academy = academies.get(0);
        }  else {
            academy = new Academy(dto.getAcademyName());
            address = new Address(
                    dto.getAddress1(),
                    dto.getAddress2(),
                    dto.getZipcode(),
                    dto.getCountry(),
                    dto.getCity());
            Member member = new Member(
                    dto.getLoginId(),
                    dto.getMemberName(),
                    dto.getPassword(),
                    academy,
                    address
                    );
            relationService.insert(member);
        }






            /*for(int i = 0; i <= academies.size(); i++){
                if(dto.getAcademyName().equals(academies.get(i))){

                    String AcademyNameFromDb = academies.get(i).getAcademyName();
                    System.out.println(AcademyNameFromDb);
                    break;
                }
                */
            //}

            //academy = academies.indexOf()
            //academy = academies.get(0);
        /*
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
