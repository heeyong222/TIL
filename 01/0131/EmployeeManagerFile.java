

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import com.ssafy.employee.model.dto.Employee;
import com.ssafy.employee.*;
public class EmployeeManagerFile extends EmployeeManagerList {
	private String fileName = "employee.csv";
	
	public EmployeeManagerFile() {
		load();
	}
	
	public void save() {
		try(BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "MS949"))){
			List<Employee> emps = searchAll();
			for(Employee employee : emps) {
				out.write(employee.toString());
				out.newLine();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void load() {
		File file = new File(fileName);
		if(file.exists() && file.canRead()) {
			try(BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "MS949"))){
				String line = null;
				LinkedList<Employee> emps = new LinkedList<Employee>();
				while((line = in.readLine()) != null) {
					String[] info = line.split(",");
					emps.add(new Employee(info[0], info[1], Integer.parseInt(info[2])));
				}
				setEmps(emps);
				}catch(Exception e) {
				e.printStackTrace();
				}
			}
		}
	
	@Override
	public void add(Employee emp) {
		super.add(emp);
		save();
	}
	
	@Override
	public void update(Employee emp) {
		super.update(emp);
		save();
	}
	@Override
	public void remove(String empno) {
		super.remove(empno);
		save();
	}
		
}
