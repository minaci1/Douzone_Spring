package DI_03_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {
	public static void main(String[] args) {		
		// ���� ���� ������.. ó������ 2���� ������..
		// �������̽� ������ �Ʒ�ó��(������ + ������)
//		MessageBean messageBean = new MessageBean_kr();
//		messageBean.sayHello("hong");
		
		// spring�� ���ؼ� �����̳ʸ� ����� �޸� �ȿ� ��ü�� �����ϰ� ����(����)�Ѵ�
		// GenericXmlApplicationContext -> �ڵ����� ����ȯ�� ���ش�
		// classpath : ��ӵ� ǥ��(root -> src)
		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_03_Spring/DI_03.xml");
		
		// ����(����)�� ��ü ������
		// �ι�° �Ķ���� >> MessageBean.class : MessageBean Ŭ������ ������ ��ȯ���ش�
		MessageBean messageBean = (MessageBean)context.getBean("messageBean", MessageBean.class);
		messageBean.sayHello("��ȣ");
	}
}
/*
 * �䱸����
 * 1. �ѱ۹���(hong) >> �ȳ� hong
 * 2. ��������(hong) >> hello hong
 * 
 * MessageBean_kr
 * MessageBean_en
 * 
 * interface ������ ����
 */