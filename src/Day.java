public class Day {
    private int month;
    private int date;
    private int year;

    public Day (int month, int date, int year){
        this.month = month;
        this.date = date;
        this.year = year;
    }

    public int getMonth(){
        return month;
    }
    public final void setMonth(int month){
        this.month = month;
    }
    
    public int getDate(){
        return date;
    }
    public final void setDate(int date){
        this.date = date;
    }


    public int getYear(){
        return year;
    }
    public final void setYear(int year){
        this.year = year;
    }
    @Override
    public String toString(){
        return String.format("%d/%d/%d", month, date, year);
    }
}

