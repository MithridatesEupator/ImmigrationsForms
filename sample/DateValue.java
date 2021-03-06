package sample;

import java.util.Arrays;
import java.util.Date;
import java.util.stream.Stream;

public class DateValue {
    int Month;
    int Day;
    int Year;
    int IntValue;
    int IntMinusFiveValue;
    String Value;
    String StringMinusFiveValue;

    DateValue(String DateVar) {
        try {
            int[] DateArray = Stream.of(DateVar.split("/")).mapToInt(Integer::parseInt).toArray();
            this.Month = DateArray[0];
            this.Day = DateArray[1];
            this.Year = DateArray[2];
            this.IntValue = Day + (Month * 100) +  + (Year * 10000);
            this.IntMinusFiveValue = this.IntValue - 50000;
            if (0 < this.Month && this.Month < 10) {

                if (0 < this.Day && this.Day < 10) {
                    this.StringMinusFiveValue = ("0" + this.Month + "/" + "0" + this.Day + "/" + (this.Year - 5));
                } else {
                    this.StringMinusFiveValue = ("0" + this.Month + "/" + this.Day + "/" + (this.Year - 5));
                }
            } else {
                if (0 < this.Day && this.Day < 10) {
                    this.StringMinusFiveValue = (this.Month + "/" + "0" + this.Day + "/" + (this.Year - 5));
                } else {
                    this.StringMinusFiveValue = (this.Month + "/" + this.Day + "/" + (this.Year - 5));
                }
            }
            if (0 < this.Month && this.Month < 10) {

                if (0 < this.Day && this.Day < 10) {
                    this.Value = ("0" + this.Month + "/" + "0" + this.Day + "/" + this.Year);
                } else {
                    this.Value = ("0" + this.Month + "/" + this.Day + "/" + this.Year);
                }
            } else {
                if (0 < this.Day && this.Day < 10) {
                    this.Value = (this.Month + "/" + "0" + this.Day + "/" + this.Year);
                } else {
                    this.Value = (this.Month + "/" + this.Day + "/" + this.Year);
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException | NumberFormatException ex) {
            this.Value = DateVar.trim();
        }
    }
    public void PrintMonth() {
        String[] Monthes = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        System.out.println(Monthes[this.Month - 1]);
    }
    public void PrintDay() {
        System.out.println(this.Day);
    }
    public void PrintYear() {
        System.out.println(this.Year);
    }
    public static void main(String[] args) {
        DateValue v = new DateValue("12/20/2013");
        String[] b = {"a", "b", v.Value};
        System.out.println(Arrays.toString(b));
    }
}