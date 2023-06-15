package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


import com.aspect.UserPassEnc;
import com.dao.UserDAO;
import com.service.UserService;
import com.service.UserServiceImpl;



// @Aspect 어노테이션을 붙인 클래스를 공통 기능으로 적용하기 위해 붙여줌
// 이 어노테이션을 추가하면 스프링은 @Aspect 어노테이션이 붙은 빈 객체를 찾아서 빈 객체의 @Pointcut 설정과 @Around 설정 사용
// 빈 객체가 인터페이스를 상속할 때 인터페이스가 아닌 클래스를 이용해서 프록시를 생성하고 싶다면
// proxyTargetClass 속성을 true로 지정하면 됨
//@EnableAspectJAutoProxy(proxyTargetClass = true)

@Configuration
public class AopConfig {


	
	
	@Bean
	public UserDAO userDAO() {
		return new UserDAO();
	}
	
    @Bean
    public UserPassEnc aspectTime() {
        return new UserPassEnc();
    }
    
    

    @Bean
    // AOP 적용 시 RecCalculator가 상속받은 Calculator 인터페이스를 이용해서 프록시 생성
    public UserService calcService() {
        return new UserServiceImpl();
    }
    
    
    
  
   

}