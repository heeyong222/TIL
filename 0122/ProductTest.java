

public class ProductTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ProductMgr mgr = new ProductMgr();
		System.out.println("==================상품 등록==================");
		mgr.add(new Product(1,"Java",10000,2));
		mgr.add(new Product(2,"Python",20000,4));
		mgr.add(new Product(3,"JavaScript",30000,8));
		mgr.add(new Product(4,"c++",40000,4));
		mgr.add(new Product(5,"PHP",50000,5));
		System.out.println("==================상품 검색==================");
		Product[] pd = mgr.list();
		for(Product products : pd) {
			System.out.println(products);
		}
		System.out.println("==================상품 번호로 검색:4==================");
		System.out.println(mgr.list(4));
		System.out.println("==================상품 번호로 삭제:4==================");
		mgr.delete(4);
		Product[] pd2 = mgr.list();
		for(Product products : pd2) {
			if(products != null) {
				System.out.println(products);
			}
			
		}
		System.out.println("===============특정 가격 이하 상품 검색 : 30000===============");
		mgr.priceList(30000);
	}

}
