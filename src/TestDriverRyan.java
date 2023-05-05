
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
public class TestDriverRyan extends JFrame {
     
    private static String selectedValue;
    private static int year;   

    public static void SelectionScreen(){
        JFrame frame = new JFrame();
        frame.setTitle("Which month would you like to view?");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComboBox<String> yearSelect = new JComboBox<>(new String[] {"2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"});
        JButton [] monthSelect = {
            new JButton("January"),
            new JButton("February"),
            new JButton("March"),
            new JButton("April"),
            new JButton("May"),
            new JButton("June"),
            new JButton("July"),
            new JButton("August"),
            new JButton("September"),
            new JButton("October"),
            new JButton("November"),
            new JButton("December"),
        };
        yearSelect.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                for(JButton month : monthSelect){
                    month.setEnabled(true);
                }
                yearSelect.setEnabled(false);

                selectedValue = (String) yearSelect.getSelectedItem();
                year = Integer.parseInt(selectedValue);
            }
        });

        for (int i=0; i<monthSelect.length; i++){
            monthSelect[i].setEnabled(false);
        }
        monthSelect[0].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                displayCalendar("January", year);
            }
        });
        monthSelect[1].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                displayCalendar("February", year);
            }
        });
        monthSelect[2].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                displayCalendar("March", year);
            }
        });
        monthSelect[3].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                displayCalendar("April", year);
            }
        });
        monthSelect[4].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                displayCalendar("May", year);
            }
        });
        monthSelect[5].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                displayCalendar("June", year);
            }
        });
        monthSelect[6].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                displayCalendar("July", year);
            }
        });
        monthSelect[7].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                displayCalendar("August", year);
            }
        });
        monthSelect[8].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                displayCalendar("September", year);
            }
        });
        monthSelect[9].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                displayCalendar("October", year);
            }
        });
        monthSelect[10].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                displayCalendar("November", year);
            }
        });
        monthSelect[11].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                displayCalendar("December", year);
            }
        });
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(yearSelect);
        for (JButton month : monthSelect){
            panel.add(month);
        }

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void displayCalendar(String input, int year){
        // int year = 2022;
		// String input = "December";
		
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
		

        JFrame CalenderView = new JFrame(String.format("%d %s Calendar", year, targetMonth.getMonthName()));
        CalenderView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CalenderView.setLayout(new GridLayout(0,7));

        final int monthNumber = targetMonth.getMonthNumber()-1;
		days.forEach(day->{
			int dayOfMonth = day.getDate();
			
			int weekDay = getWeekDay(year, monthNumber, dayOfMonth);
			// System.out.println(getWeekDayString(weekDay) + " " + day); 
            JLabel dayLabel = new JLabel("<html><div style='text-align: center;'>" + getWeekDayString(weekDay) + "</div><div style='text-align: center;'>" + day + "</div></html>");
            dayLabel.setBorder(BorderFactory.createRaisedBevelBorder());
            CalenderView.add(dayLabel);
			dayOfMonth++;
		});
        CalenderView.pack();
        CalenderView.setLocationRelativeTo(null);
        CalenderView.setVisible(true);
    }
    public static void main (String[] args) {    
        SelectionScreen();
	} 
	private static int getWeekDay(int year, int month, int date) {
		Calendar calendar_object = Calendar.getInstance();
		calendar_object.set(year, month, date);
		return calendar_object.get(Calendar.DAY_OF_WEEK);
	}
	private static String getWeekDayString(int weekDay){
		switch (weekDay){
			case Calendar.SUNDAY:
				return "Sunday";
			case Calendar.MONDAY:
				return "Monday";
			case Calendar.TUESDAY:
				return "Tuesday";
			case Calendar.WEDNESDAY:
				return "Wednesday";
			case Calendar.THURSDAY:
				return "Thursday";
			case Calendar.FRIDAY:
				return "Friday";
			case Calendar.SATURDAY:
				return "Saturday";
			default:
				return "";

		}
	}
}
