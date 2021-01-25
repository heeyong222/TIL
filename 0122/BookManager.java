
import java.util.Arrays;

public class BookManager {
	
	private Book[] books;
	private int size;
	private static int MAX_SIZE = 100;
	
	
	public BookManager() {
		books = new Book[MAX_SIZE];
	}
	
	public void add(Book book) {
		if(size < MAX_SIZE) {
			books[size++] = book;
		}else {
			System.out.println("더이상 등록할 공간이 없습니다.");
		}
	}
	public void remove(String isbn) {
		for(int i = 0; i<size;i++) {
			if(isbn.equals(books[i].getIsbn())) {
				books[i] = books[size-1];
				books[size-1] = null;
				size--;
				break;
			}
		}
	}
	public Book[] getList() {
		return Arrays.copyOfRange(books, 0, size);
	}
	
	public Book searchByIsbn(String isbn) {
		for(int i = 0; i<size;i++) {
			if(isbn.equals(books[i].getIsbn())) {
				return books[i];
			}
		}
		return null;
		
	}
}
