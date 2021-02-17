

public class Book {
	private String isbn;
	private String title;
	private String author;
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		if(price > -1) {
			this.price = price;
		}else {
			System.out.println("책의 가격을 0원 이상 설정해주세요.");
		}
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	private String publisher;
	private int price;
	private String desc;
	
	public Book() {
		//this 사용법2 예시
		this("111","11111","11111","11",1000000,"화이팅");
		//this 사용법 1. 속성과 로컬 변수의 이름이 동일할 때 구별하기 위해서 속성 앞에 this.을 붙임
		//this 사용법 2. 코드의 재사용을 위해 인자가 다른 생성자를 만들때 this 사용
		//this 사용법 3. 현재 사용중인 객체를 필요로 할 때 this 사용
	}	
	public Book(String isbn, String title, String author, String publisher, int price, String desc) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(isbn).append("\t|").append(title).append("\t|").append(author)
				.append("\t|").append(publisher).append("\t|").append(price).append("\t|")
				.append(desc);
		return builder.toString();
	}
	//this 사용법3 예시
	public boolean equals(Book book) {
		return this == book;
	}
	
}
