package com.dw.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.DefaultSingleSelectionModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dw.member.model.Member;
import com.dw.member.repository.MemberRepo;

@RestController
public class MemberController {

	@Autowired
	MemberRepo repo;

	@PostMapping("/api/v1/login")
	public boolean callloginpage(@RequestBody Member member, HttpServletRequest request) {
		Member m = repo.findByuserIdAndUserPassword(member.getUserId(), member.getUserPassword());
		if (m != null) {
			HttpSession session = request.getSession();
			session.setAttribute( "userId",member.getUserId());
			return true;
		}
		else {
			return false;
		}
		
	}


	// 전체조회
	@GetMapping("api/v1/member")
	public List<Member> callAllMember() {
		// findAll == select * from <테이블 이름>
		return repo.findAll();
	}
	//입력
	@PostMapping("api/v1/member")
	public Member callSaveMember(@RequestBody Member member) {
		// save == insert
		member = repo.save(member);
		return member;
	}
	//삭제
	@DeleteMapping("api/v1/member/{id}")
	public boolean callDeleteMember(@PathVariable long id) {
		// deleteById == delete
		// by ==where
		try {// deleteById는 리턴타입이 void라서 try catch문으로
			repo.deleteById(id);//try 성공하면 삭제되고
			return true;
		} catch (Exception e) {// 실패하면 catch문 실행됨
			return false;
		}
	}
	//상세조회
	@GetMapping("api/v1/member/{id}")
	public Member callMemberById(@PathVariable long id) {
		return repo.findById(id).get();
	}
	//수정
	@PatchMapping("api/v1/member")
	public Member updateMember(@RequestBody Member member) {
		//save == update or insert
		//동일한 pk값이 있으면 update!
		//동일한 pk값이 없으면 insert!
		member = repo.save(member);
		return member;
	}

}
