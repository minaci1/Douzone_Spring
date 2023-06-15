package com.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieController {
	
	@RequestMapping("/cookie/make.do")
	public String make(HttpServletResponse response) { //생성된 객체를 자동으로 받는다
		
		response.addCookie(new Cookie("auth", "1004"));//	
		return "cookie/CookieMake";
	}
	
	//public String view(HttpServletRequest request) {}// 전통적인 방법
	@RequestMapping("/cookie/view.do")
	public String view(@CookieValue(value="auth", defaultValue="1007")String auth) {
		
		System.out.println("클라이언에서 read한 쿠키값 : "+auth);
		return "cookie/CookieView";
		
	}
	
}
