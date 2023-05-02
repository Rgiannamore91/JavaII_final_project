import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CalendarDriver{
	public static void main (String[] args) {
		int year = 2023;
		String input = "December";
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

		int index = monthList.indexOf(new Month(0, input, 0));
		if(index >=0){
			targetMonth = monthList.get(index);
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