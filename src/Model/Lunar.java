package Model;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;

public class Lunar {
	private int current_month;
	private int current_year;
	private int current_date;
	private ArrayList<LocalDate> allDaysOfTheCurrentMonth;
	private Calendar calendar = Calendar.getInstance();
	
	public static Lunar InitNewCalendar(){
		Lunar lunar = new Lunar();
		lunar.prepareCalendar();		
		return lunar;
	}
	
	protected void prepareCalendar(){
		setYear();
		setMonth();
		setCurrentDate();
		setAllDaysOfTheCurrentMonth();
	}
	
	
	//Set Session of the class
	
	protected void setYear(){
		current_year = calendar.get(Calendar.YEAR);
	}
	
	protected void setMonth(){
		current_month = calendar.get(Calendar.MONTH) + 1;
	}
	
	protected void setCurrentDate(){
		current_date = calendar.get(Calendar.DAY_OF_MONTH);
	}	
	
	protected void setAllDaysOfTheCurrentMonth(){
		YearMonth yearMonthObject = YearMonth.of(current_year, current_month);
		int daysOfCurrentMonth = yearMonthObject.lengthOfMonth();

		allDaysOfTheCurrentMonth = new ArrayList<LocalDate>();
		for(int i = 1; i <= daysOfCurrentMonth; i++){
			allDaysOfTheCurrentMonth.add(yearMonthObject.atDay(i));
		}
	}
	
	//Get Session of the class.
	public ArrayList<LocalDate> getAllDaysOfTheCurrentMonth(){
		return allDaysOfTheCurrentMonth;
	}
	
	public int getCurrentDate(){
		return current_date;
	}
	
	public int getCurrentYear(){
		return current_year;
	}
	
	public int getCurrentMonth(){
		return current_month;
	}
}
