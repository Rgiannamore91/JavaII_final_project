public class Month {
    private int monthNumber;
    private String monthName;
    private int numberOfDays;

    public Month(int monthNumber, String monthName, int numberOfDays){
        this.monthNumber = monthNumber;
        this.monthName = monthName;
        this.numberOfDays = numberOfDays;
    }

    public int getMonthNumber(){
        return monthNumber;
    }
    public final void setMonthNumber(int monthNumber){
        this.monthNumber = monthNumber;
    }

    public String getMonthName(){
        return monthName;
    }
    public final void setMonthName(String monthName){
        this.monthName = monthName;
    }

    public int getNumberOfDays(){
        return numberOfDays;
    }
    public final void setNumberOfDays(int numberOfDays){
        this.numberOfDays=numberOfDays;
    }
    
    @Override
    public String toString(){
        return String.format("%d : %s \nNumber of days: %d", monthNumber, monthName, numberOfDays);
    }
}
