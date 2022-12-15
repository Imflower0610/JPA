package com.dw.member.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

// vo기능 + 테이블 생성
// 테이블이름은 소문자로
@Data
@Entity
@Table(name ="dw_member")
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long id;
	@Column
	private String name;
	@Column
	private int age;
//	@Column(name="dept_id")
//	private int deptId;
//	
	// @JoinColumn => member테이블에 dept_id라는 컬럼(fk)생성
	@ManyToOne
	@JoinColumn(name="dept_id")
	private Dept dept;
	
	
}
