package edu.sch.springboot.service;

import edu.sch.springboot.domain.Member;
import edu.sch.springboot.repository.JdbcTemplateMemberRepository;
import edu.sch.springboot.repository.JpaMemberRepository;
import edu.sch.springboot.repository.MemberRepository;
import edu.sch.springboot.repository.SpringDataJpaMemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class MemberService {
    private final SpringDataJpaMemberRepository memberDao;

    @Autowired
    public MemberService(SpringDataJpaMemberRepository memberDao) {
        this.memberDao = memberDao;

        // log test
        //System.out.println("SpringDataJpaMemberRepository");
    }

    /**
     * 회원 가입
     * */
    public Long join(Member member) {
        //동일한 이름의 중복회원 X
        duplicatedMemberCheck(member);

        memberDao.save(member);


        // log test
        //System.out.println("Register");

        return member.getId();
    }

    private void duplicatedMemberCheck(Member member) {
        memberDao.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        // log test
        //System.out.println("findMembers");

        return memberDao.findAll();
    }

    /**
     * 회원 ID 조회
     **/
    public Optional<Member> findMemberId(Long memberId) {
        return memberDao.findById(memberId);
    }

}
