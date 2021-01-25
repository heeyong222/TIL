
public class BookManagerTest {

	public static void main(String[] args) {
		BookManager mgr = new BookManager();
		
		mgr.add(new Book("21424","Java Pro","김하나","jean.kr",15000,"Java 기본 문법"));
		mgr.add(new Book("21425","Java Pro2","김하나","jean.kr",25000,"Java 응용"));
		mgr.add(new Book("35355","분석설계\t","소나무","jean.kr",30000,"SW 모델링"));
		System.out.println("****************************도서목록****************************");
		Book[] book1 = mgr.getList();
		for(Book book : book1) {
			System.out.println(book);
		}
		System.out.println("****************************도서조회:21424****************************");
		System.out.println(mgr.searchByIsbn("21424"));
		System.out.println("****************************도서삭제:21424****************************");
		mgr.remove("21424");
		System.out.println("****************************도서목록****************************");
		Book[] book2 = mgr.getList();
		for(Book book : book2) {
			System.out.println(book);
		}
	}

}
