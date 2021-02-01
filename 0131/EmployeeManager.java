
import java.sql.SQLException;
import java.util.List;

import com.ssafy.employee.model.dto.Employee;
public interface EmployeeManager {
	public void add(Employee emp) throws SQLException;
	public void update(Employee emp) throws SQLException;
	public void remove(String empno) throws SQLException;
	public Employee search(String empno) throws SQLException;
	public List<Employee> searchAll() throws SQLException;
	
	
}
