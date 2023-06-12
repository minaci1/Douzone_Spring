package DI_06_Spring;

public class ArticleService {
	//ActicleService 는 ArticleDao에 의존한다
	//ActicleService 은 ArticleDao 의 주소가 필요하다
	
	//2가지 (생성자, setter) 주입
	private ArticleDao articledao;
	public ArticleService(ArticleDao articledao) { //oracle, mysqldao 다형성 
		this.articledao=articledao;
		System.out.println("ArticleService 생성자 호출 ");
	}
	
	 //글쓰기 서비스 
	public void write(Article article) {
		this.articledao.insert(article);
	}
	
}
