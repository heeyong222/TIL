

import java.util.ArrayList;

public class ProductTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ProductMgrImpl mgr = new ProductMgrImpl();
		System.out.println("==================상품 등록==================");
		mgr.add(new TV(1,"65인치",10000,2, 65));
		mgr.add(new TV(2,"34인치",20000,4, 34));
		mgr.add(new TV(3,"50인치",30000,8, 50));
		mgr.add(new TV(4,"17인치",40000,4, 17));
		mgr.add(new Refrigerator(5,"400L",50000,3, 400));
		mgr.add(new Refrigerator(6,"300L",60000,7, 300));
		mgr.add(new Refrigerator(7,"550L",70000,5, 550));
		
		System.out.println("==================상품 검색==================");
		mgr.list();

		System.out.println("==================상품 번호로 검색:3==================");
		System.out.println(mgr.listbyNum(3));
//		
		System.out.println("==================상품 명으로 검색:17인치==================");
		System.out.println(mgr.listbyName("17인치"));
		System.out.println("==================TV만 검색==================");
		for(int i = 0; i < mgr.showlist("TV").size(); i++) {
			System.out.println(mgr.showlist("TV").get(i));
		}
		
		System.out.println("==================냉장고만 검색==================");
		for(int i = 0; i < mgr.showlist("Refrigerator").size(); i++) {
			System.out.println(mgr.showlist("Refrigerator").get(i));
		}
		System.out.println("==================50인치 이상 TV만 검색==================");
		mgr.SearchTV();
		System.out.println("==================400L 이상 냉장고만 검색==================");
		mgr.SearchRF();
		System.out.println("==================가격 변경==================");
		mgr.updatePrice(3, 600000);
		
		System.out.println("==================상품 로 삭제:4==================");
		mgr.remove(4);
		mgr.list();
		System.out.println("=========================전체 재고 총액 =========================");
		int total = mgr.totalprice();
		System.out.println(total+"원");


	}
}
