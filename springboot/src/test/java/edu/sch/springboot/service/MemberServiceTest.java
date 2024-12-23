package edu.sch.springboot.service;

import edu.sch.springboot.domain.Member;
import edu.sch.springboot.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class MemberServiceTest {
    MemberService memberService ;

    @Autowired
    public MemberServiceTest(MemberService memberService) {
        this.memberService = memberService;
    }

    @Test
    void join() {
        //1. 객체 생성
        Member member = new Member();
        member.setName("spring");

        //2. store에 저장
        Long saveId = memberService.join(member);

        //3. store에 저장된 객체를 id를 통해 가져오기
        Member findMember = memberService.findMemberId(saveId).get();

        //4. 생성된 객체의 name과 store에서 가져온 객체의 name 비교
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());

        // 넘어오는 parameter가 정확해야 하고, return 값이 또 정확해야 좋은 테스트 //
    }

    @Test
    public void duplicateMemberCheck() {
        //1. 객체 생성
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //2. join 메소드 호출
        memberService.join(member1);
        //memberService.join(member2);    //중복 예외 발생함

        //3. 중복체크 결과의 Exception 객체를 통해 테스트 처리
        org.junit.jupiter.api.Assertions
                .assertThrows(IllegalStateException.class, () -> memberService.join(member2));
    }
}