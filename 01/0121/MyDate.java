
import java.util.Calendar;

public class MyDate {
	private int year, month, date;
	//default값
	public MyDate() {
		Calendar cal = Calendar.getInstance();
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH)+1;
		date = cal.get(Calendar.DATE);
	}

	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		if(month >= 0 && month < 13) {
			if(isValid(month)) {
				this.month = month;
			}else {
				System.out.printf("%d월에 %d일을 설정할 수 없습니다.", month, date);
			}
		}else {
			System.out.println("잘못된 월을 설정했습니다.");
		}
	}
	private boolean isValid(int month) {
		if((month == 2 && date > 28)||
				(month ==4||month==6||month==9||month == 11) && date >30) {
			return false;
		}
		return true;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		if(date>0 && date < 32) {
			this.date = date;
		}else {
			System.out.println("잘못된 일자입니다. 다시 설정하세요");
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(year).append("년 ").append(month).append("월 ").append(date)
				.append("일");
		return builder.toString();
	}
	
	

	
}
