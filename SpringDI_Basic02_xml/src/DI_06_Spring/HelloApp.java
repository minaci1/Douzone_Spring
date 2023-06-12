package DI_06_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import DI_05_Spring.MyBean;

public class HelloApp {

	public static void main(String[] args) {
	
 
		//java �ڵ�
		//ArticleService service = new ArticleService(new OracleDao());
		//ArticleService service = new ArticleService(new MySqlDao());
		//Article article=new Article();
		//service.write(article);
		
		
		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_06_Spring/DI_06.xml");
		ArticleService service = context.getBean("service",ArticleService.class); 
		Article article = context.getBean("article",Article.class);
		
		service.write(article);
 
		
		/*
		  getBean()
		  1. �����̳� �ȿ� �ִ� ��ü�� ����  (new �� �ƴϿ���)
		  2. return type Object (Ÿ�Կ� �´� casting)
		  3. **������ �����̳� �ȿ� ��ü���� default singleton
		  4. **���������� getbean() �� new ��� �� �� �� �ִ� (���� ���� �ʴ´�)
		 */
	}

}
