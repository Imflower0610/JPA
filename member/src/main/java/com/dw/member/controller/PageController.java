package com.dw.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	
	@GetMapping("/member")
	public String callmemberpage() {
		return "member";
	}
	
	@GetMapping("/login")
	public String callloginpage() {
		return "login";
	}
}
