package DI_06_Spring;

public class ArticleService {
	//ActicleService �� ArticleDao�� �����Ѵ�
	//ActicleService �� ArticleDao �� �ּҰ� �ʿ��ϴ�
	
	//2���� (������, setter) ����
	private ArticleDao articledao;
	public ArticleService(ArticleDao articledao) { //oracle, mysqldao ������ 
		this.articledao=articledao;
		System.out.println("ArticleService ������ ȣ�� ");
	}
	
	 //�۾��� ���� 
	public void write(Article article) {
		this.articledao.insert(article);
	}
	
}
