package DI_07_Spring;

import java.util.List;

public class ProtocolHandler {
	//�������� filter
	List<MyFilter> filters; //setter �����ϰ� �ִ� 
	
	//setter
	public void setFilters(List<MyFilter> filters) {
		this.filters = filters;
	}
	
	//getter
	public List<MyFilter> getFilters() {
		return this.filters;
	}
	
	//�����Լ�
	public int filter_Length() {
		return this.filters.size();
	}
}
