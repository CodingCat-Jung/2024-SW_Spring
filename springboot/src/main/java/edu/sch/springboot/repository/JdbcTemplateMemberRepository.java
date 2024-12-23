package edu.sch.springboot.repository;

import edu.sch.springboot.domain.Member;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcTemplateMemberRepository implements MemberRepository{

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateMemberRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /** 회원 가입 */
    @Override
    public Member save(Member member) {
        String sql = "insert into member (name, sdate) VALUES (?, now())";
        jdbcTemplate.update(sql, member.getName());
        return member;
    }

    /** 회원  조회 */
    @Override
    public Optional<Member> findById(Long id) {
        String sql = "select * from member where id = ?";
        List<Member> result = jdbcTemplate.query(sql, memberRowMapper(), id);
        return result.stream().findAny();
    }

    /** 회원 이름 조회 */
    @Override
    public Optional<Member> findByName(String name) {
        String sql = "select * from member where name = ?";
        List<Member> result = jdbcTemplate.query(sql, memberRowMapper(), name);
        return result.stream().findAny();
    }

    /** 회원 리스트 조회 */
    @Override
    public List<Member> findAll() {
        String sql = "select * from member";
        return jdbcTemplate.query(sql, memberRowMapper());
    }

    /** 반환 타입 정의 객체 */
    private RowMapper<Member> memberRowMapper() {
        return ((rs, rowNum) -> {
            Member member = new Member();
            member.setId(rs.getLong("id"));
            member.setName(rs.getString("name"));
            return member;
        });
    }
}