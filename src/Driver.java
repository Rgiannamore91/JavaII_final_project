import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import java.util.Calendar;
import java.util.List;

public class Driver extends JFrame implements Buffer {
    private static String selectedValue;
    private static int year;
    private final int[] buffer = {-1, -1, -1};
    private int occupiedBuffer = -0;
    private int writeIndex = 0;
    private int readIndex = 0;

    public Driver() throws InterruptedException { // constructor
    }

    public static void SelectionScreen() throws InterruptedException {
        JFrame frame = new JFrame();
        frame.setTitle("Which month would you like to view?");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComboBox<String> yearSelect = new JComboBox<>(new String[]{"2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"});

        JButton[] monthSelect = {
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


        yearSelect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                for (JButton month : monthSelect) {
                    month.setEnabled(true);
                }


                yearSelect.setEnabled(false);
                selectedValue = (String) yearSelect.getSelectedItem();
                year = Integer.parseInt(selectedValue);

            }

        });

        try {
            Driver put = new Driver();
            put.blockingPut(year);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        for (int i = 0; i < monthSelect.length; i++) {
            monthSelect[i].setEnabled(false);
        }
        monthSelect[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayCalendar("January", year);
            }
        });
        monthSelect[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayCalendar("February", year);
            }
        });
        monthSelect[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayCalendar("March", year);
            }
        });
        monthSelect[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayCalendar("April", year);
            }
        });
        monthSelect[4].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayCalendar("May", year);
            }
        });
        monthSelect[5].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayCalendar("June", year);
            }
        });
        monthSelect[6].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayCalendar("July", year);
            }
        });
        monthSelect[7].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayCalendar("August", year);
            }
        });
        monthSelect[8].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayCalendar("September", year);
            }
        });
        monthSelect[9].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayCalendar("October", year);
            }
        });
        monthSelect[10].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayCalendar("November", year);
            }
        });
        monthSelect[11].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayCalendar("December", year);
            }
        });
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(yearSelect);
        for (JButton month : monthSelect) {
            panel.add(month);
        }

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void displayCalendar(String input, int year) {

        Month[] months = {
                new Month(1, "January", 31),
                new Month(2, "February", 28),
                new Month(3, "March", 31),
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

        java.util.List<Month> monthList = new ArrayList<Month>();
        for (Month month : months) {
            monthList.add(month);
        }
        Month targetMonth = null;

        int index = monthList.indexOf(new Month(0, input, 0));
        if (index >= 0) {
            targetMonth = monthList.get(index);
        }

        List<Day> days = new ArrayList<Day>();
        for (int i = 1; i <= targetMonth.getNumberOfDays(); i++) {
            days.add(new Day(targetMonth.getMonthNumber(), i, year));

        }

        //GUI Framework
        JFrame CalenderView = new JFrame(String.format("%d %s Calendar", year, targetMonth.getMonthName()));
        CalenderView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CalenderView.setLayout(new GridLayout(0, 7));

        final int monthNumber = targetMonth.getMonthNumber() - 1;
        days.forEach(day -> {
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
    } // end DisplayCalendar method

    private static int getWeekDay(int year, int month, int date) {
        Calendar calendar_object = Calendar.getInstance();
        calendar_object.set(year, month, date);
        return calendar_object.get(Calendar.DAY_OF_WEEK);
    } // end getWeekDay method

    private static String getWeekDayString(int weekDay) {
        switch (weekDay) {
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
    } // end getWeekDayString method

    // Producer
    @Override
    public synchronized void blockingPut(int value) throws InterruptedException {
        // occupied buffer
        while (occupiedBuffer == buffer.length) {
            wait(); // wait until the buffer is free
        }

        // year will be the first element in array
        buffer[writeIndex] = value;
        ++occupiedBuffer;
        ++writeIndex;
        notifyAll(); // notify threads waiting to read the buffer
    }

    // Consumer
    @Override
    public synchronized int blockingGet() throws InterruptedException {
        // unoccupied buffer
        while (occupiedBuffer == 0) {
            wait(); // wait until the buffer is filled
        }

        // move on to next value by reading the current value
        int readValue = buffer[readIndex];
        --occupiedBuffer;

        notifyAll(); // notify threads waiting to write the buffer
        return readValue;
    }


}
