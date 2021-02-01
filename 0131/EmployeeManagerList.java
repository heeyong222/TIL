

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.ssafy.employee.model.dto.Employee;
import com.ssafy.employee.model.dto.EmployeeException;

public class EmployeeManagerList implements EmployeeManager {
	private LinkedList<Employee> emps;
	
	public EmployeeManagerList() {
		emps = new LinkedList<Employee>();
	}
	
	public List<Employee> getEmps() {
		return emps;
	}

	public void setEmps(List<Employee> emps) {
		this.emps = (LinkedList<Employee>)emps;
	}

	private int findIndex(String empno) {
		if(empno != null) {
			for (int i = 0, size = emps.size(); i < size; i++) {
				if(empno.equals(emps.get(i).getEmpno())) {
					return i;
				}
			}
		}
		return -1;
	}
	
	//상속때 exception은 더 ~작or or 안던져도됨
	@Override
	public void add(Employee emp) {
		
		if(emp != null) {
			String empno = emp.getEmpno();
			int index = findIndex(empno);
			
			if(index > -1) {
				throw new EmployeeException(String.format("%s번은 이미 등록된 상태입니다.", empno));
				
			}
			emps.add(emp);
			
		}else {
			throw new EmployeeException("등록할 사원 정보가 부정확합니다. 다시 입력해주세요.");
		}
	}

	@Override
	public void update(Employee emp)  {
		if(emp != null) {
			String empno = emp.getEmpno();
			int index = findIndex(empno);
			
			if(index == -1) {
				throw new EmployeeException(String.format("%s번은 등록되지 않은 사원입니다.", empno));
				
			}
			emps.set(index, emp);
			
		}else {
			throw new EmployeeException("수정할 사원 정보가 부정확합니다. 다시 입력해주세요.");
		}

	}

	@Override
	public void remove(String empno) {
		if(empno != null) {
			int index = findIndex(empno);
			
			if(index == -1) {
				throw new EmployeeException(String.format("%s번은 삭제할 수 없습니다.", empno));
				
			}
			emps.remove(index);
			
		}else {
			throw new EmployeeException("삭제할 사원 번호를 입력해주세요.");
		}

	}

	@Override
	public Employee search(String empno) {
		if(empno != null) {
			int index = findIndex(empno);
			
			if(index == -1) {
				throw new EmployeeException(String.format("%s번은 등록되어 있지 않아 조회가 불가능합니다.", empno));
				
			}
			return emps.get(index);
			
		}else {
			throw new EmployeeException("조회할 사원 번호를 입력해주세요.");
		}
		
		
	}

	@Override
	public List<Employee> searchAll()  {
		
		return (List<Employee>)emps.clone();
	}

}
