package com.service;
import com.model.NewArticleCommand;

/*
 @Service >> 너는 빈객체로 생성되어야 해
 public class ArticleService
 
 xml 파일에(설정) spring-servlet.xml
 <context:component-scan base-package="com.service>
 */


public class ArticleService {
	public ArticleService() {
		System.out.println("articleservice 생성자 호출");
	}
	
	public void writeArticle(NewArticleCommand command) {
		//DAO 가정하고
		//insert 가정하고
		System.out.println("글쓰기 작업 완료:"+command.toString());
	}
}
