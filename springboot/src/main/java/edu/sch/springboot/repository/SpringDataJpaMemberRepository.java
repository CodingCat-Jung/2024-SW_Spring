package edu.sch.springboot.repository;

import edu.sch.springboot.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository2 {
    // interface간 상속은 extends
    // JpaRepository > ListCrudRepository > CrudResository: save, findAll, find by ID (상속)

    /*
     * Crud Repository에 정의되지 않은 메서드 별도 정의 하는 경우
     * Member Repository2.java(findByName 메서드 별도 정의) 인터페이스를
     * SpringDataJpaMemberRepository 인터페이스가 상속받는다
     */

    @Override
    public Optional<Member> findByName(String name);
}
