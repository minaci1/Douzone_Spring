package DI;

//������ ����ϴ� Ŭ����
public class NewRecordView {
	//NewRecordView�� ������ ���� ���ؼ� NewRecord�� �ʿ��մϴ�.
	//��� : ���� **
	
	private NewRecord record; //member field NewRecord ��ü�� �ּҸ� �����ڴ�.
	//����(���տ���) 
	public NewRecordView(int kor,int eng,int math) {
		record = new NewRecord(kor,eng,math); // �����ڿ��� �����ߴ�.(�ּҸ�) 
	}
	
	public void print() {
		System.out.println(record.total()+" / "+record.avg());
	}
	
	
	
}
