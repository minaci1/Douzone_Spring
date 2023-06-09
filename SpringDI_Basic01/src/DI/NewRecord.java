package DI;

//DTO Ŭ����
public class NewRecord {
	private int kor;
	private int eng;
	private int math;
	
	public NewRecord() {
		
	}

	public NewRecord(int kor, int eng, int math) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}
	
	//�ʿ信 ���� �߰����� �Լ� ����
	public int total() {
		return this.kor+this.eng+this.math;
	}
	
	public float avg() {
		return total()/3.0f;
	}
	
	@Override
	public String toString() {
		return "NewRecord [kor=" + kor + ", eng=" + eng + ", math=" + math + "]";
	}
}