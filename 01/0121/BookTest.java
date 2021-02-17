

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Book book;
		book = new Book();
		System.out.println(book);
		
		Book book2 = new Book("1111","자바가 좋아","동글양","멀캠",30000,"자바 기초");
		System.out.println(book2);

		System.out.println(book.equals(book2));//this에 들어가는건 book, 비교대상은 book2
		

	}
}
