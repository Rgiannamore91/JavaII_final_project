import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CalendarDriver{
	public static void main (String[] args) {
		int year = 2023;
		String input = "February";
		Month[] months = {
			new Month(1, "January", 31),
			new Month(2, "February", 28),
			new Month(3,"March", 31),
			new Month(4, "April", 30),
			new Month(5, "May", 31),
			new Month(6, "June", 30),
			new Month(7, "July", 31),
			new Month(8, "August", 31),
			new Month(9, "September", 30),
			new Month(10, "October", 31),
			new Month(11, "November", 30),
			new Month(12, "December", 31),
		};
		List<Month> monthList = new ArrayList<Month>();

		for(Month month : months){
			monthList.add(month);
		}
		Month targetMonth = null;
		if(input == monthList.get(0).getMonthName()){
			targetMonth = monthList.get(0);
		}
		if(input == monthList.get(1).getMonthName()){
			targetMonth = monthList.get(1);
		}
		if(input == monthList.get(2).getMonthName()){
			targetMonth = monthList.get(2);
		}
		if(input == monthList.get(3).getMonthName()){
			targetMonth = monthList.get(3);
		}
		if(input == monthList.get(4).getMonthName()){
			targetMonth = monthList.get(4);
		}
		if(input == monthList.get(5).getMonthName()){
			targetMonth = monthList.get(5);
		}
		if(input == monthList.get(6).getMonthName()){
			targetMonth = monthList.get(6);
		}
		if(input == monthList.get(7).getMonthName()){
			targetMonth = monthList.get(7);
		}
		if(input == monthList.get(8).getMonthName()){
			targetMonth = monthList.get(8);
		}
		if(input == monthList.get(9).getMonthName()){
			targetMonth = monthList.get(9);
		}
		if(input == monthList.get(10).getMonthName()){
			targetMonth = monthList.get(10);
		}
		if(input == monthList.get(11).getMonthName()){
			targetMonth = monthList.get(11);
		}
		List<Day> days = new ArrayList<Day>();

		for(int i =1; i <= targetMonth.getNumberOfDays(); i++){
			days.add(new Day(targetMonth.getMonthNumber(),i, year));
		}

		for(Day day: days){
			System.out.println(day);
		}

	} 
}