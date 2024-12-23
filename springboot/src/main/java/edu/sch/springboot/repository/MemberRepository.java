package edu.sch.springboot.repository;

import edu.sch.springboot.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);               // 사용자 정의
    List<Member> findAll();
}

// save, findbyId, findAll은 CRUD Repository에 있음 (자동 매핑)