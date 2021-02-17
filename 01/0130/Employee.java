

public class Employee implements Cloneable,  Comparable<Employee>{
	private String empno;
	private String name;
	private int salary;
	public Employee() {}
	public Employee(String empno, String name, int salary) {
		this.empno = empno;
		this.name = name;
		this.salary = salary;
	}
	public int compareTo(Employee o) {
//		if(empno != null && o !=null && o.empno !=null) {
////			오름 차순 : 현재 객체 - 인자로 전달된 객체 
////			return empno.compareTo(o.empno);
////			내림 차순 : 인자로 전달된 객체 - 현재 객체 
//			return o.empno.compareTo(empno);
//		}
//		급여를 기준으로 
		if(o != null) {
//		오름 차순
//			return salary - o.salary;
//		내림 차순
			return o.salary - salary;
		}
		return 0;
	}
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		if(salary>=1000000) {
			this.salary = salary;
		}else {
			this.salary = 1000000;
		}
	}
	/**
	 * 객체의 내용을 문자열로 리턴하는 기능 
	 *  - System.out으로 객체를 출력할 때 toString()가 호출된다. 
	 *  - 문자열 + 객체    => 객체의 toString()가 호출되서 문자열에 연결된다.
	 *  - Override 하지않으면  클래스이름@hashcode가 리턴된다. 
	 *  - 필요시에 Override
	 */
	public String toString() {
		StringBuilder builder = new StringBuilder(50);
		builder.append(empno).append(",").append(name).append(",")
				.append(salary);
		return builder.toString();
	}
	
	/**
	 * 객체의 내용을 비교하는 기능 
	 * - 반드시 Override를 해야 객체 내용을 비교할 수 있다. 
	 */
	public boolean equals(Object obj) {
		if (obj !=null && obj instanceof Employee) {
			Employee emp = (Employee) obj;
			if( empno != null && empno.equals(emp.empno)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * hashcode  : 객체의 참조값을 리턴하는 기능 
	 * 
	 * - 필요시 Override 
	 * - Override를 해도 객체의 실제 hashcode는 변하지 않는다.
	 */
	public int hashCode() {
		int empnoHash = empno !=null ? empno.hashCode() : 1;
		int nameHash = name !=null ? name.hashCode() : 1;
		return empnoHash + nameHash + salary;
	}
	

	/**
	 *  객체의 내용이 똑같은 객체를 생성해서 리턴 
	 *  - Object에서  protected로 선언했기 때문에 함수를 사용할려면 반드시 Override 해야한다. 
	 *  - Cloneable 인터페이스를 구현해야 한다.
	 *    => Cloneable 인터페이스를 구현하지 않으면  CloneNotSupportedException이 발생한다. 
	 *  */
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}










