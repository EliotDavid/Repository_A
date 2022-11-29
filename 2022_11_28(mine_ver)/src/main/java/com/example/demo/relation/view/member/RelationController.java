package com.example.demo.relation.view.member;

import com.example.demo.relation.domain.academy.Academy;
import com.example.demo.relation.domain.academy.AcademyRepository;
import com.example.demo.relation.domain.member.Member;
import com.example.demo.relation.domain.service.MemberService;
import com.example.demo.relation.view.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import java.util.List;

@RequestMapping("/members")
@RequiredArgsConstructor
@Controller
public class RelationController {


    private final MemberService memberService;
    private final AcademyRepository academyRepository;

    @GetMapping("/new")
    public String insert(@ModelAttribute("form") MemberDto dto) { // BindingReusult : 1번째 인자의 값을 blindingresult가 들고 있는데 어떻게 들고 있냠ㄴ @valid라는 애가 들어가있으니까 @valid는 notempty인지 아닌지 확인하는 애인데, 그 비어있는지 아닌지의 값을 blindingreuslt가 들고 있음
        return "members/newMemberForm";
    }

    @PostMapping("/new") // ** 기존에 있던 기능들을 합쳐놓은 공간
    public String save(@Valid @ModelAttribute("form") MemberDto dto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){ // ** 얘가 에러가 생기면 다시 되돌리는 애임.
                                        // ** 로그인 할 때 값이 비워져있는게 있어서 정상적인 처리과정이 아닐 때(하나라도 비워져있는 에러상황일때) DB로 안넘어가게(다음 페이지로 안 넘어가게도 해줌) 해주는 걸 얘가 해줌
            return "member/newMemberForm";
        }

        List<Academy> academies = academyRepository.findByName(dto.getAcademyName());


        Academy academy = null;


        if (!academies.isEmpty()) { // **학원명 이름
            academy = academies.get(0);
        } else {
            academy = new Academy(dto.getAcademyName());
        }

        List<Member> members = memberService.findByName(dto.getLoginId()); // ** 아이디 중복체크
        
        if(!members.isEmpty()){
            System.out.println("Error Message!!!!!");
            return "members/newMemberForm";
        } else {
            memberService.insert(
                    new Member(
                            dto.getLoginId(),
                            dto.getMemberName(),
                            dto.getPassword(),
                            dto.getUserEmail(),
                            academy));

        }






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

        return "redirect:/"; // **만약에 이걸 완료했어? 그럼 다른 페이지로 넘어가 이러면 다른 페이지의 위치를 적어주면 됨
                                // ** 그럼 뷰에서 그 페이지로 넘어감
    }



    }
