package controllers.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.NoticeDao;
import vo.Notice;

/*
 나중에는 컨트롤러 하나 만들고 어노테이션 해서 클래스끼리 나눠쓸 수 있는 메소드를 만든다....
 
 
게시판 목록 조회 

controller  -> Model의존  (DAO , DTO) 가 필요

NoticeController 는   NoticeDao에 의존한다
필요하면 값을 받아야 해요 ... (DI , injection (생성자 , 함수(setter) 통해서 주입 받는다
*/
@Controller
@RequestMapping("/customer/*")
public class NoticeController  {
	Notice notice = null;
	
	
	public NoticeController() {
		 System.out.println("[NoticeController]");
	}
	
	private NoticeDao noticsdao;
	
	
	@Autowired
	public void setNoticsdao(NoticeDao noticsdao) {
		this.noticsdao = noticsdao;
	}

	@GetMapping("notice.do") ///customer/notice.do 이거다~ 
	public ModelAndView handleRequest(@RequestParam(value="pg" ,defaultValue="1")String pg,
			@RequestParam(value="f" ,defaultValue="TITLE")String f,
			@RequestParam(value="p" ,defaultValue="%%")String p) throws Exception {
	     //DAO 객체 사용
		//public List<Notice> getNotices(int page, String field, String query)
		System.out.println("customer/notice.do 진입 ");
		 
		
		
		//리스트 보여주기 
		//DAO 작업
		List<Notice>  list = noticsdao.getNotices(Integer.parseInt(pg), f, p);
		
		
		//Spring  적용
		ModelAndView   mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("customer/notice");
 
		return mv;
		
		//만약 String으로 할 경우 데이터 저장이 안된다. 그니까 ModelAndView 사용~
		
 
	}
	
	@GetMapping("noticeDetail.do")
	//noticeDetail.do?seq=${n.seq}"파라미터가 같아야 한다. 
	public ModelAndView handleRequest(String seq) throws Exception {
		
		//public Notice getNotice(String seq)
		
		ModelAndView  mv = new ModelAndView();
		Notice  notice = noticsdao.getNotice(seq);
		

		mv.addObject("notice", notice);
		mv.setViewName("customer/noticeDetail");
		
		return mv;
	}
	
	
	//@GetMapping (화면) : select
	//@Posting 	  (처리) : insert
	//<a class="btn-write button" href="noticeReg.do">글쓰기</a>
	
	
	@GetMapping(value="noticeReg.do") //customer/noticeReg.do >> 전송 >> GET
	public String noticeReg() {
		
		return "customer/noticeReg";
		
	}
	@PostMapping(value="noticeReg.do")
	public String noticeReg(Notice n) {
		System.out.println(n.toString());
		//글쓰기 완료 >> 목록 >> location.href ="" or response.sendRedirect
		//Spring redirect:notice.do
		return "redirect:notice.do";
		
	}
	
	
	//form method = "post" action="" 현재 주소창에 있는 주소
	//customer/noticeReg.do 전송 >> POST으로 들어옴 
	
	//글 수정하기 (화면이면서 데이터 처리)GET
	// <a class="btn-edit button" href="noticeEdit.do?seq=${notice.seq}">수정</a>
	//<a class="btn-del button" href="noticeDel.do?eq=${notice.seq}">삭제</a>
	
	@GetMapping(value="noticeEdit.do")  // /customer/noticeEdit.do
	public String noticeEdit(String seq, Model model) {
		Notice notice =null;
		
		try {
			notice = noticsdao.getNotice(seq);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		model.addAttribute("notice",notice);
		return "customer/noticeEdit";
	}
	
	//form method ="post"
	@PostMapping("noticeEdit.do")
	public String noticeEdit(Notice n) {
		
		return "redirect:noticeDetail.do?seq=1";
	}
	

}
