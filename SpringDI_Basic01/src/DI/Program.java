package DI;

//di : 의존성 주입 
public class Program {

	public static void main(String[] args) {
		NewRecordView view = new NewRecordView(100, 50, 40);
		view.print();
	}

}
