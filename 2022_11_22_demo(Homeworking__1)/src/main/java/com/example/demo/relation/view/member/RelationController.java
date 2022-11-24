package com.example.demo.relation.view.member;

import com.example.demo.relation.domain.academy.Academy;
import com.example.demo.relation.domain.academy.AcademyRepository;
import com.example.demo.relation.domain.member.Member;
import com.example.demo.relation.domain.service.MemberService;
import com.example.demo.relation.domain.service.OrderService;
import com.example.demo.relation.view.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/members") // ** 이렇게 해주는 이유는 도엠인 설계 구조로 만들기 위해서임 // 어떤 기능은 어디에 어떤 기능은 어디에 이렇게 나눠서 보관함
                            // ** 이 html이름이 왜 똑같아야 하냐면 /members는 실제로 template에이 있는 members와 같은 애가 아니라고함
                            // ** 근데 /members는 templates에 있는 members란 이름의 directory를 가르키는 건 맞음
                            // ** 여기에 적힌 members는 url에서만 사용하는 이름이라고 함 
                            // ** 밑에 겟멥핑에서 리턴해주는 members/newMemberForm하고는 상관없다고 함
@RequiredArgsConstructor
@Controller
public class RelationController{


    //private final Member member;
    private final MemberService memberService;
    private final AcademyRepository academyRepository;

   // @GetMapping("/new")
    //public String insert() { // ** html에 있는 form하고 이름이 같음
        //return "members/newMemberForm"; // ** 만약에 html파일이 templates안에 또 다른 디렉토리를 만든 곳 안에 들어있다면 이렇게 그 디렉토리명까지 적어야한다고 함
    //}

    @GetMapping("/new")
    public String insert(@ModelAttribute("form") MemberDto dto) { // ** html에 있는 form하고 이름이 같음
        // ** 근데 여기서 아직 뷰로 들어오지도 않았는데 어떻게 왜 dto를 인자로 넘기는거지?
        return "members/newMemberForm"; // ** resources/members/newMemberForm.html을 가르키는 말임
                                        // ** RequestMapping("/members") 해뒀다고 여기 @GetMapping()안에
   }
    
    
    // ** ===== 아직 회원가입 단계이기 떄문에 학원명을 담는 건 없다고 함 // 그리고 학원명(다른 테이블임)은 그냥 이 테이블에서 연결되는 테이블이라서 이 테이블에 연결되어 학원테이블에 있는 내용이 떠야한다고 함
    @PostMapping("/new")
    public String save(@Valid @ModelAttribute("form") MemberDto dto) { // ** @Valid, @Validated 둘이 똑같은거라고 함 어떤걸 써도 상관없다고 함
        //memberService.insert(
                //new Member( dto.getMemberName()) );
        // 위 코드는 Member member = new Member(dto.getMemberName(), academy)랑 같은 코드임

        List<Academy> all = academyRepository.findAll();
        System.out.println(all.size());




        boolean check = true;

        // List<Academy> all에 아무것도 없으면 이 반복문을 통해 DB에 아무것도 안 들어가짐
        for(Academy element : all){
            if(element.getAcademyName().equals(dto.getAcademyName())) // ** 객체 안의 값이 같나요? 하고 물어보는 메서드
            { // ** 아카데미 엔티티에 있는 값과 뷰에서 받은 겂을 memberdto로 저장한 아카데미이름과 같냐고 묻는 의도임
                //System.out.println("element : " + element.getAcademyName());
                //System.out.println("dto : " + dto.getAcademyName());
                //check = false;
            }
        }


        if(check){ // ** 안 같으면 dto로 받은 아카데미이름을 아카데미 엔티티에 집어넣어라/ 같으면 집어넣어라인데?
            Academy academy = new Academy(dto.getAcademyName());// ** dto에서 저장된 값을 아카데미 엔티티에 넣었으므로 정보 보존성 지켜짐
            memberService.insert(new Member(dto.getMemberName(), dto.getLoginId(), dto.getPassword(), academy)); // ** 얘가 그러면 memberEntity에 다 넣는거네
            // ** 멤버 레파지토리에 넣는 코드임
        }


        return "redirect:/"; // ** 그리고 레파지토리에 넣고 메인 홈으로 빠지는 코드
        //List<Academy> academies = academyRepository.findByName(dto.getAcademyName());
        // ** 사실 이거를 리스트로 받아올 필요없는데 동일한 학원이 존재할 수 있으니까 이렇게 받아온거임
        // ** 예를 들면 받아왔는데 얘가
        //if(!academies.isEmpty()) // ** 아무것도 없는 상태라면
        //{
            //Academy academy = new Academy(dto.getMemberName());
            //memberService.insert(new Member(dto.getMemberName(), academy));
       // }

        //Academy byId = academyRepository.findById(2L); // ** 멤버가 2가 되고 아마케디가 1이 됨
        //System.out.println(byId.getId() + ": " + byId.getAcademyName());


    }

    public String checkId(){
        // academy = academies.get(0); : get(0) 뜻 : 아무것도 안 넣겠다는 뜻이라는데
        List<Member> members = new ArrayList<>();

        for(Member element : members) {
            for(int a = 0; a < members.size(); ++a){
                for(int b = 1; a < members.size(); ++b){
                    if (members.){

                    }
                }


                System.out.println("이미 존재하는 아이디입니다.");
            } else if (members.equals(a) != members.equals(b)) {
                System.out.println("정상적으로 등록 가능한 아이디입니다.");
            }
        }
        // ======
        return "redirect:/";
    }



}
