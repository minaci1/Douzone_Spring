package kr.or.kosa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public class IntroController {
//핸들 리퀘스트
//hello와 똑같이 원하는 데이터 담고
	//view에 화면 출력 
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("IntroController 요청 실행 : handleRequest 자동 실행");
		 
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("age","22");
		mav.setViewName("Intro");
		return mav;
		
	}
	
}
