package DI2;

//di : ������ ���� 
public class Program {

	public static void main(String[] args) {
		//NewRecordView view = new NewRecordView(100, 50, 40);
		//view.print();
		NewRecordView view = new NewRecordView();
		//��ٰ�
		//���� �ϰ� �ʿ��� NewRecord ��ü �ּҰ�
		NewRecord record = new NewRecord(100,100,100);
		view.setRecord(record); //������ü�� �ּҸ� ���� �޴´�.(DI) > spring �ڵ�ȭ...
		view.print();
	}
}
