package DI_Annotation_02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MonitorViewer {
	private Recorder recorder;
	
	public Recorder getRecorder() {
		return this.recorder;
	}
	
	/*
	setter �� ���ؼ� RecorderŸ���� ��ü �ּ� ����
	<property name="recorder">
	  				<ref  bean="recorder" />
	</property>
	
	�����̳� �ȿ� Recorder Ÿ���� ��ü�� �����ϸ� �ڵ� ���� �߻� ... (By type)
	*/
	//@Autowired(required = true) default >> ������ injection �ϰڴ�
	//@Autowired(required = false) >> �����̳� �ȿ� ���ϴ� Ÿ�� ��ü�� ������ �� �ϸ� ����
	@Autowired
	@Qualifier("recoder_1") /* <qualifier value="recoder_1"></qualifier>  */
	public void setRecorder(Recorder recorder) {
		this.recorder = recorder;
		System.out.println("setRecorder : " + this.recorder);
	}
	
	//�Ϲ� �Լ�
	@Autowired
	@Qualifier("recoder_2")
	public void gMethod(Recorder rec) {
		System.out.println("Gmethod(rec) : " + rec);
	}
	
}