package edu.sch.springboot.repository;

import edu.sch.springboot.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository2 {
    Optional<Member> findByName(String name);               // 사용자 정의
}
// Jpa Repository가 안만들어주는 메서드만 정의