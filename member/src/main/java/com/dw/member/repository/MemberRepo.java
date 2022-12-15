package com.dw.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dw.member.model.Member;

//jap는 이미 작성된 쿼리를 상속받는다
//mapper라는 어노테이션을 쓰지 않는다.
public interface MemberRepo extends JpaRepository<Member, Long> {

    // SELECT * FROM dw_member WHERE user_id = 'dw';
    Member findByuserId(String userId);

    // SELECT * FROM dw_member WHERE user_id = 'dw' AND user_password = '123';
    Member findByuserIdAndUserPassword(String userId, String password);

    // SELECT * FROM dw_member WHERE name = '홍길동';
    Member findByname(String name);
}
