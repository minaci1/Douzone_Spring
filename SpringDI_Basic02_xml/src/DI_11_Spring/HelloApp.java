package DI_11_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		
		
		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_11_Spring/DI_11.xml");
		DataSourceFactory factorty = context.getBean("dataSourceFactory",DataSourceFactory.class);
		System.out.println(factorty.toString());
		
		
		
	}

}
