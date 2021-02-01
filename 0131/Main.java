

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import com.ssafy.employee.model.dto.*;
import com.ssafy.employee.model.dao.EmployeeManager;
import com.ssafy.employee.model.dao.EmployeeManagerFile;
import com.ssafy.employee.model.dao.EmployeeManagerList;

public class Main {
	private Scanner s = new Scanner(System.in);
//	private EmployeeManager mgr = new EmployeeManagerList();
	private EmployeeManager mgr = new EmployeeManagerFile();
	
	public  int menu() {
		int result = 0;
		System.out.println("==================================");
		System.out.println("========== 교육생 관리 프로그램 ==========");
		System.out.println("==================================");
		System.out.println("1. 사원 등록");
		System.out.println("2. 사원 목록 보기");
		System.out.println("3. 사원 검색");
		System.out.println("4. 교육생 수정");
		System.out.println("5. 교육생 삭제");
		System.out.println("0. 종료");
		System.out.println("원하는 번호를 선택 하세요.");

		result = s.nextInt();

		return result;
	}
	
	private void insert() throws SQLException{
		System.out.println("사원 정보를 입력하세요. 형식:사원번호,이름,급여");
		String[] info = s.next().split(",");
		mgr.add(new Employee(info[0],info[1], Integer.parseInt(info[2])));
	}
	
	private void search() throws SQLException{
		System.out.println(">>>>>>>>>>>>>>>>>사원 목록 보기");
		List<Employee> emps = mgr.searchAll();
		for(Employee employee : emps) {
			System.out.println(employee);
		}
	}
	
	private void searchNum() throws SQLException{
		System.out.println(">>>>>>>>>>>>>>>>>검색할 사원의 번호를 입력해주세요. ");
		String empno = s.next();
		System.out.println(mgr.search(empno));
	}
	
	private void update() throws NumberFormatException, SQLException{
		System.out.println(">>>>>>>>>>>>>>>>>사원 정보 수정 ");
		System.out.println(">>>>>>>>>>>>>>>>>수정할 사원의 번호를 입력해주세요.(형식:사원번호,이름,급여) ");
		String[] info = s.next().split(",");
		mgr.update(new Employee(info[0], info[1], Integer.parseInt(info[2])));
	}
	
	private void delete() throws SQLException{
		System.out.println(">>>>>>>>>>>>>>>>>사원 정보 삭제 ");
		System.out.println(">>>>>>>>>>>>>>>>>삭제할 사원 번호를 입력해 주세요.");
		String empno = s.next();
		mgr.remove(empno);
	}
	public static void main(String[] args) {
		Main m = new Main();
		int num = 0;
		while (true) {
			num = m.menu();
			if (num == 0)
				break;
			try {
				switch (num) {
				case 1:
					m.insert();
					break;
				case 2:
					m.search();
					break;
				case 3:
					m.searchNum();
					break;
				case 4:
					m.update();
					m.search();
					break;
				case 5:
					m.delete();
					m.search();
					break;
				default:
					System.err.println("메뉴 번호를 정확히 입력해 주세요.");
					continue;
				}
			}catch(NumberFormatException e) {
				System.err.println("메뉴 번호를 정확히 입력해 주세요.");
				continue;
			}catch(Exception e) {
				System.err.println(e.getMessage());
			}

		}
	}

	
}
