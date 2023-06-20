package main;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.bit.dto.User;
import kr.or.bit.service.SqlMapClient;

public class program {
	public static void main(String[] args) {
		//method scope
	    SqlSessionFactory sqlsession=SqlMapClient.getSqlSession();
	    
	    SqlSession session= sqlsession.openSession(); //연결 객체 생성
	    
	    //session.selectOne("Emp.getone", arg1)

	    User user = (User)session.selectOne("Emp.getone", "ALLEN");//하나의 객체를 주겟다.// DTO로 리턴 받는다
	    System.out.println(user.getEmpno());
	    System.out.println(user.getEname());
	    session.close(); //session은 메소드 로 메듭지어라 / 일 끝나면 닫아
	    //1.설정파일 SqlMapConfig
	    //2. 사용할 매퍼파일 (실제 경로 명시) , 
	    //3.Use.xml 셀렉테그로 쿼리 작업 . 리절트 타입 정해준다. 자동으로
	    //4. sqlMapCkuent라는 팩토리를 잘 사용할 수 있게 한다. 
	    //5. 메인와서 Mapper 가 가지고 있는걸 dto에 반환한다.

	}

}



