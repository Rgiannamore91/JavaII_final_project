public class TestObjects {
    public static void main(String[] args){
        Month month = new Month(5, "May", 31);
        System.out.println(month);
        Day day = new Day(month.getMonthNumber(), 1,2023);
        System.out.println(day);
    }
}
