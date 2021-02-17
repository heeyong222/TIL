

import java.util.Arrays;
import java.util.ArrayList;

public class ProductMgrImpl implements IProductMgr {
	
	private int size;
	private int MAX_SIZE = 10;
//	private Product products[];
	ArrayList<Product> products;
	public ProductMgrImpl() {
		products = new ArrayList<Product>();
		
	}
	//상품 정보 저장
	public void add(Product p) {
		products.add(p);
//		if(size < MAX_SIZE) {
//			products[size++] = p;
//		}else {
//			System.out.println("더 이상 물건을 등록할 공간이 없습니다.");
//		}
	}
	//상품 전체 검색
	public void list() {
		for(int i = 0; i < products.size(); i++) {
			System.out.println(products.get(i));
		}
		
	}
	//상품 번호로 검색
	public ArrayList<Product> listbyNum(int num) {
		ArrayList<Product> tmp = new ArrayList<Product>();
		
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i).getNum() == num) {
				tmp.add(products.get(i));
				
			}
		}
		return tmp;
	}
	//상품명으로 검색
	public ArrayList<Product> listbyName(String name) {
		ArrayList<Product> tmp = new ArrayList<Product>();
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i).getName() == name) {
				tmp.add(products.get(i));
				
			}
		}
		return tmp;
	}
	//tv,냉장고만 검색
	public ArrayList<Product> showlist(String type) {
		ArrayList<Product> tmp = new ArrayList<Product>();
		
		if(type == "TV") {
			for(int i = 0; i < products.size(); i++) {
				if(products.get(i) instanceof TV) {
					tmp.add(products.get(i)); 
				}
				
			}
		}else if(type == "Refrigerator") {
			for(int i = 0; i < products.size(); i++) {
				if(products.get(i) instanceof Refrigerator) {
					tmp.add(products.get(i)); 
				}
			}
		}
		return tmp;
	}
	//50인치 이상 TV
	public void SearchTV() {
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i) instanceof TV && ((TV)products.get(i)).getInch() >= 50)
				System.out.println(products.get(i));
		}
	}
	//400L 이상 냉장고
	public void SearchRF() {
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i) instanceof Refrigerator && ((Refrigerator)products.get(i)).getSize() >= 400)
				System.out.println(products.get(i));
		}
	}
	//상품번호와 가격을 입력받아 가격 변경
	public void updatePrice(int num, int price) {
		for(int i=0; i<products.size() ; i++) {
			if(products.get(i).getNum() == num) {
				products.get(i).setPrice(price);
			}
		}
	}
	//상품번호로 삭제
	public void remove(int num) {
		for(int i=0; i<products.size() ; i++) {
			if(products.get(i).getNum() == num) {
				products.remove(i);
			}
		}
	}
	public int totalprice() {
		int total = 0;
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i) != null) 
				total += products.get(i).getPrice()*products.get(i).getCount();			
		}
		return total;
	}
	
}
