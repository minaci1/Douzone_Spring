package AOP_Basic_01;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

/**
 * 간단한 사칙 연산기 프로그램
 * - 주업무(주관심) : 사칙연산(ADD, MUL) >> 주요기능
 * - 요구사항(연산에 걸린 시간) : 보조기능(공통관심)
 * - log 출력(
 * 
 * 시간이 지나고 유지보수 시간 ..
 * 100개의 함수 시간 체크..
 */
public class Calc {
	public int Add(int x, int y) {
		// 시간처리 로직(시작시간)
		Log log = LogFactory.getLog(this.getClass()); // 현재 돌고 있는 객체를 가지고 와서 해당 객체의 정보를 찍어준다
		StopWatch sw = new StopWatch();
		sw.start();
		log.info("[타이머 시작]");
		
		// 주업무
		int result = x + y;
		
		// 시간처리 로직(종료시간)
		sw.stop();
		log.info("[타이머 종료]");
		log.info("[Time log Method : ADD]");
		log.info("[Time log Method : " + sw.getTotalTimeMillis());
		
		return result;
	}
	
	public int Mul(int x, int y) {
		// 시간처리 로직(시작시간)
		Log log = LogFactory.getLog(this.getClass()); // 현재 돌고 있는 객체를 가지고 와서 해당 객체의 정보를 찍어준다
		StopWatch sw = new StopWatch();
		sw.start();
		log.info("[타이머 시작]");
		
		// 주업무
		int result = x * y;
		
		// 시간처리 로직(종료시간)
		sw.stop();
		log.info("[타이머 종료]");
		log.info("[Time log Method : MUL]");
		log.info("[Time log Method : " + sw.getTotalTimeMillis());
		return result;
	}
}
