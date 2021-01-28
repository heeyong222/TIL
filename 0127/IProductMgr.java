

import java.util.ArrayList;

interface IProductMgr {
	
		//상품 정보 저장
		void add(Product p);
		public void list();
		//상품 번호로 검색
		public ArrayList<Product> listbyNum(int num) ;
		//상품명으로 검색
		public ArrayList<Product> listbyName(String name) ;
		//tv,냉장고만 검색
		public ArrayList<Product> showlist(String type) ;
		//50인치 이상 TV
		public void SearchTV();
		//400L 이상 냉장고
		public void SearchRF();
		//상품번호와 가격을 입력받아 가격 변경
		public void updatePrice(int num, int price) ;
		//상품번호로 삭제
		public void remove(int num) ;
		public int totalprice();

}
