package DI_02;

public class HelloApp {

	public static void main(String[] args) {
	//����
	// MessageBean_en en = new MessageBean_en();
	// en.sayHello("hello");

	// MessageBean_kr kr = new MessageBean_kr();
	// kr.sayHello("hello");
	
		//�������̽�
		MessageBean messagebean = new MessageBean_kr();
		((MessageBean_kr) messagebean).sayHello("hong");
	
	}

}
/*
�䱸����
1. �ѱ۹��� (hong) >> �ȳ� hong
2. �������� (hong) >> hello hong

MessageBean_kr 
MessageBean_en

interface ������ ����
*/