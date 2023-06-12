package DI_Annotation_04_javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //DI.xml ���� ������ �մϴ�.(��ü ������ ����) �ڹ����Ϸ�...
public class ConfigContext {
	
	//xml <bean id="user" class="DI_Annotation_02_javaconfig.User" /> //���Ž� 
	//�ڹ��ڵ忡���� �Լ��� ��ü�� �����ϰ� ������
	
	@Bean //��������Ʈ�� �� 
	public User user() {
		
		return new User();
	}
	
	//xml <bean id="user2" class="DI_Annotation_02_javaconfig.User2" /> //���Ž�
	@Bean
	public User2 user2() {
		return new User2();
	}
	
}
