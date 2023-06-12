package DI_Annotation_03;
import javax.annotation.Resource;

public class MonitorViewer {
	private Recorder recorder;
	
	public Recorder getRecorder() {
		return this.recorder;
	}
	
	//@Autowired  by type
	@Resource(name="yy") //���� Ÿ���� ��ü�� ������ name ������ �O�´�
	public void setRecorder(Recorder recorder) {
		this.recorder = recorder;
		System.out.println("setRecorder : " + this.recorder);
	}
	
	
}
