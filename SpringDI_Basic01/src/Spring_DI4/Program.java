package Spring_DI4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {

	public static void main(String[] args) {
		/*
		//NewRecordView view = new NewRecordView(100, 50, 40);
		//view.print();
		NewRecordView view = new NewRecordView();
		//��ٰ�
		//���� �ϰ� �ʿ��� NewRecord ��ü �ּҰ�
		NewRecord record = new NewRecord(100, 100, 100);
		view.setRecord(record); //������ü�� �ּҸ� ���� �޴´� (DI) > spring �ڵ�ȭ ...
		view.print();
		*/
		/*	
		  �������� �ڽŸ��� �޸� ������ ������..
		  1. SpringFrameWork �����̳ʸ� ���� (�޸� ���� : �����̳� (IOC �����̳�))
		  	 ApplicationContext context = new ClassPathXmlApplicationContext("DIConfig.xml");
		  	 ApplicationContext �޸� ������ ����µ� ������ ����� DIConfig.xml ������ �ϰ� read �׸��� ���� 
		  	 
		  2. �����̳� ����� �� �޸𸮿� �ʿ��� [��ü�� ����]�ϰ� ��ü���� ����(����:DI)... ���߿� �ڵ� �Ҹ�
		  	>> �����̳� �����ǰ� DIConfig.xml read ... 
		  	>> DIConfig.xml ��ü ������ ���� xml �ڵ尡 �־��....
		  	>> ������ ��ü�� bean �̶� �մϴ�.
		 */
		//���α׷��� ��ü(������ �޸� ����)
		ApplicationContext context = new ClassPathXmlApplicationContext("DIConfig.xml");
		//Spring �ʿ��� �޸� ������ �����ϰ� ������ �޸𸮿� "DIConfig.xml" �о ��ü�� �����ϰ� �����ߴ�. 

		//�����̳� �ȿ��� �ʿ��� ��ü�� �ִٸ� ������ ���� �ǿ�
		RecordView view =(RecordView)context.getBean("view"); //�츮�� ��� id �� �ָ� �ȴ�. return Object �ϱ� �������̽��� �ް� �ٿ� ĳ����
		view.input();
		view.print();
	}

}
