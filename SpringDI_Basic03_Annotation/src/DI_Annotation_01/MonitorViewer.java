package DI_Annotation_01;

import org.springframework.beans.factory.annotation.Autowired;

public class MonitorViewer {
	private Recorder recorder;

	public Recorder getRecorder() {
		return recorder;
	}

	//MonitorViewer�� recorder �� �����մϴ�. ... �ʿ��մϴ�. �ּҰ� �ʿ��ؿ�
	
	
	/*
	 
	   
		<property name="recorder">
			<bean class="DI_Annotation_01.Recorder"/>	
		</property>
 	Annotation ���� 
 	@Autowired (by type)
 	�����̳� �ȿ� ��ü���� �����ǰ� ... ����... @Autowired ������ ... 
 	�����̳� �ȿ� Recorder Ÿ�� ��ü�� ã�� ������ �ڵ�����...
	
	>> aop jar ���� �߰�
	>> @Autowired ���� �������� �ʴ� ���
	@Autowired(required = true) >> default >> ������ injection
	@Autowired(required = false) >> �����̳� �ȿ� ���ϴ� Ÿ���� ��ü�� ������ ���� ���ϸ� ���� 
	  
	 */
	@Autowired
	public void setRecorder(Recorder recorder) {
		this.recorder = recorder;
	}
	
	
}
