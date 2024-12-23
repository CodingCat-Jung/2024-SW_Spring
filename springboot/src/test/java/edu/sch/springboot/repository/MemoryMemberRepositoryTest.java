
package edu.sch.springboot.repository;


import edu.sch.springboot.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;


public class MemoryMemberRepositoryTest {
    // 객체 이름은 DAO (인터페이스와 구분하기 위함)
    MemoryMemberRepository memberDao = new MemoryMemberRepository();

    /**
     * save 메소드 테스트 케이스
     */
    @Test
    public void saveTest() {
        Member member = new Member();
        member.setName("spring");

        memberDao.save(member);

        Member result = memberDao.findById(member.getId()).get();
        //System.out.println("result : " + (result == member));

        org.junit.jupiter.api.Assertions.assertEquals(member, result);
        org.assertj.core.api.Assertions.assertThat(member).isEqualTo(result);
    }



    /** findByName 메소드 테스트 케이스 */
    @Test
    public void findByNameTest() {
        Member member1 = new Member();
        member1.setName("spring1");
        memberDao.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        memberDao.save(member2);

        // Memory: spring1, spring2 ( 2 item )

        Member result = memberDao.findByName("spring1").get(); // store 저장된 객체 갖고옴
        org.assertj.core.api.Assertions.assertThat(result).isEqualTo(member1);
        //잘 실행이 되었다면 result와 member1이 같아야 함
    }

    /** findAll 메소드 테스트 케이스 */
    @Test
    public void findAllTest() {
        Member member1 = new Member();
        member1.setName("spring1");
        memberDao.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        memberDao.save(member2);

        List<Member> result = memberDao.findAll();
        org.assertj.core.api.Assertions.assertThat(result.size()).isEqualTo(2);
    }

    @AfterEach
    public void afterEach(){
        memberDao.clearStore();
    }
}