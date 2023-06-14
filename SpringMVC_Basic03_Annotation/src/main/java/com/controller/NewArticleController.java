package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.NewArticleCommand;
import com.service.ArticleService;

/*
 클라이언트 요청...
 1. 화면주세요 (글쓰기 , 로그인 화면 ): write.do
 2. 처리해 주세요(글쓰기 입력 처리, 로그인 완료 처리) : writeok.do
 
 요청주소가 : write.do 화면
 요청주소가 : writeok.do 처리
 
 spring
 클라이언트 요청
 요청을 method 단위로 처리
 * 1개의 요청 주소로 화면, 처리 판단 > 근거 > 전송방식(GET,POST)
 http:.../article/newArticle.do
 요청방식이
 GET : 화면 > view 제공
 POST : 서비스 처리 >> insert,update >> 화면 제공 


 */

@Controller
@RequestMapping("/article/newArticle.do") //메소드 처리되는데 
public class NewArticleController {
	
	//NewArticleCommand 업무수행을 위해서 ArticleService 필요해(주소가 필요해)
	// has-a 관점에서 보기 >> 연관
	private ArticleService articleService;

	@Autowired
	public void setArticleService(ArticleService articleService) { //ArticleService 이거를 찾는다.
		this.articleService = articleService;
	}

	//@RequestMapping(method=RequestMethod.GET)
	@GetMapping // 5.x.x 
	public String form() { // 화면 주세요
		System.out.println("GET 화면 주세요");
		//public String form() 함수의 리턴 타입이 String이면 ..뷰의 주소로 인지..
		//public ModelAndView form() >> return mav 과 똑같다  // 굳이 만들 필요 없다.
		return "article/newArticleForm";
		///WEB-INF/views/ + + .jsp
	}
	
	@PostMapping
	public String sumbit(@ModelAttribute("Articledata")NewArticleCommand command) { //처리 해 주세요 
		System.out.println("POST 처리해주세요");
		
		//1. 자동 DTO 객체 생성 : NewArticleCommand command = new NewArticleCommand();
		//2. 넘어온 parameter setter 함수를 통해서 자동 주입 => article.setParentId 자동
		//3. NewArticleCommand command 객체 자동 IOC 컨테이너 안에 등록 : id =newArticleCommand
		// <bean id ="newArticleCommand" class ="">
				
		this.articleService.writeArticle(command);
		//ModelAndView mv = new ModelAndView();
		//mv.addObject("newArticleCommand",command); // request.setAtrribute했다. //  NewArticleCommand 앞에 소문자
		//생략 자동 생성...
		
		//뷰 key : NewArticleCommand -> newArticleCommand 바껴줌 위에 파라미터에서 소문자로 바꿔줌 
 
		return "article/newArticleSubmitted";
		
	}
	
 
	
/*		
 	호랑이 담배 피던 시절에 했던 코드 ... HttpServletRequest reqeust >> spring 고민..
	//@RequestMapping(method=RequestMethod.POST) // 동기에서는 form태그 안에 post만 있다.
	@PostMapping
	public ModelAndView sumbit(HttpServletRequest request) { //처리 해 주세요 
		System.out.println("POST 처리해주세요");
		
		NewArticleCommand article = new NewArticleCommand();
		article.setParentId(Integer.parseInt(request.getParameter("parentId")));
		article.setTitle(request.getParameter("title"));
		article.setContent(request.getParameter("content"));
				
		this.articleService.writeArticle(article);
		ModelAndView mv = new ModelAndView();
		mv.addObject("newArticleCommand",article); // request.setAtrribute했다. //  NewArticleCommand 앞에 소문자
		mv.setViewName("article/newArticleSubmitted");
		
		
		return mv;
		
	}
	*/
	
	/*
	 2. Spring 엣 parameter DTO 객체로 받기
	 2.1 자동화 >> 선행조건 >> input 태그의 name 값이 DTO 객체의 memberfield 명과 동일 
	 */
	
 
}
