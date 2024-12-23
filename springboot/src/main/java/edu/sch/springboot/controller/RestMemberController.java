package edu.sch.springboot.controller;

import edu.sch.springboot.domain.Member;
import edu.sch.springboot.dto.MemberDto;
import edu.sch.springboot.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000") // React 개발 서버 주소
public class RestMemberController {

    private final MemberService memberService;          // 서비스 객체 생성

    @Autowired          // 의존성 주입 (외우기)
    public RestMemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /**
     * 회원 등록
     */
    @PostMapping("/members/signup")             // Post: Param, Get: Request Body
    public String signup(@RequestBody MemberDto memberDto /*데이터 받기*/) {
        System.out.println(memberDto.getName());
        Member member = new Member();               // member 객체 생성 (domain)
        member.setName(memberDto.getName());        // name 추가
        member.setAddr(memberDto.getAddr());        // name 추가

        memberService.join(member);                 // 서비스.join

        return "ok";
    }

    /**
     * 회원 리스트 조회
     */
    @GetMapping("/members")
    public ResponseEntity<List<Member>> list(Model model) {
        List<Member> members = memberService.findMembers();
        return ResponseEntity.ok(members);
    }
}
