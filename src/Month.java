import java.util.Objects;
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
    public boolean equals(Object other){
        if (this == other){
            return true;
        }
        if(!(other instanceof Month)){
            return false;
        }
        Month otherMonth = (Month) other;
        return this.monthName.equals(otherMonth.monthName);
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(monthName);
    }

    @Override
    public String toString(){
        return String.format("%d : %s \nNumber of days: %d", monthNumber, monthName, numberOfDays);
    }
}
