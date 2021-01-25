

import java.util.Arrays;

public class ProductMgr {
	
	private static int size;
	private int MAX_SIZE = 5;
	
	private Product products[];
	
	public ProductMgr() {
		products = new Product[MAX_SIZE];
	}
	
	//상품 저장
	public void add(Product p) {
		if(size < MAX_SIZE) {
			products[size++] = p;
		}else {
			System.out.println("더 이상 물건을 등록할 공간이 없습니다.");
		}
	}
	//저장된 상품들 검색
	public Product[] list() {
		return Arrays.copyOfRange(products, 0, size);
		
	}
	//상품 번호로 검색
	public Product list(int num) {
		for(int i = 0; i < size; i++) {
			if(products[i].getNum() == num) {
				return products[i];
			}
		}
		return null;
	}
	//상품 삭제
	public void delete(int num) {
//		System.out.println(products.length);
		for(int i = 0; i < products.length; i++) {
			if(products[i].getNum() == num) {
				products[i] = products[products.length-1];
				products[products.length-1] = null;
				size--;
				break;
			}
		}
		
	}
	//특정 가격 이하의 상품만 검색하는 기능
	public Product[] priceList(int price) {
		for(int i = 0; i < size; i++) {
			if(products[i].getPrice() <= price) {
				System.out.println(products[i]);
			}
		}
		return null;
	}

}
