package com.dw.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dw.member.model.Member;

//jap는 이미 작성된 쿼리를 상속받는다
//mapper라는 어노테이션을 쓰지 않는다.
public interface MemberRepo extends JpaRepository<Member, Long>{

}
