package sample;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class jobData {
    jobNode Root;
    Integer NumLevels = 0;
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    Date date = new Date();
    String TEMPORARYDATE = dateFormat.format(date);
    public jobData() {
        this.Root = null;
    }
    public void addNode(String AddressStreet, String AddressAddInfo, String AddressNumber, String AddressCity, String State,
                        String Zipcode, String Country, String Employer, String Occupation, DateValue StartDate, DateValue EndDate) {
        if (this.Root == null) {
            if (EndDate.Value.equals(TEMPORARYDATE)||EndDate.Value.equals("PRESENT")) {
                Root = new jobNode(AddressStreet, AddressAddInfo, AddressNumber, AddressCity, State, Zipcode, Country, Employer, Occupation, StartDate, EndDate, 0, null);
                NumLevels = 1;
            }
            else {
                Root = new jobNode("", "", "", "", "",
                        "", "", "UNEMPLOYED", "NONE", EndDate, new DateValue("PRESENT"), 0, null);
                Root.NextNode = new jobNode(AddressStreet, AddressAddInfo, AddressNumber, AddressCity, State, Zipcode, Country, Employer, Occupation,
                        StartDate, EndDate, 1, null);
                NumLevels = 2;
            }
        } else {
            this.addNodeHelper(AddressStreet, AddressAddInfo, AddressNumber, AddressCity, State,
                    Zipcode, Country, Employer, Occupation, StartDate, EndDate, 1, Root);
        }
    }
    public void addNodeHelper(String AddressStreet, String AddressAddInfo, String AddressNumber, String AddressCity, String State,
                              String Zipcode, String Country, String Employer, String Occupation, DateValue StartDate, DateValue EndDate, Integer Level, jobNode Node) {
        if (Node.NextNode == null) {
            NumLevels = Level + 1;
            if (Node.StartDate.Value.equals(EndDate.Value)||EndDate.Value.equals("")) {
                Node.NextNode = new jobNode(AddressStreet, AddressAddInfo, AddressNumber, AddressCity, State,
                        Zipcode, Country, Employer, Occupation, StartDate, EndDate, Level, null);
            }
            else {
                Node.NextNode = new jobNode("", "", "", "", "",
                        "", "", "UNEMPLOYED", "NONE", EndDate, Node.StartDate, Level, null);
                this.addNodeHelper(AddressStreet, AddressAddInfo, AddressNumber, AddressCity, State,
                        Zipcode, Country, Employer, Occupation, StartDate, EndDate, Level + 1, Node.NextNode);
            }
        }
        else {
            NumLevels = Level + 1;
            this.addNodeHelper(AddressStreet, AddressAddInfo, AddressNumber, AddressCity, State,
                    Zipcode, Country, Employer, Occupation, StartDate, EndDate, Level + 1, Node.NextNode);
        }
    }
}

class jobNode {
    public String AddressStreet;
    public String AddressAddInfo;
    public String AddressNumber;
    public String AddressCity;
    public String State;
    public String Zipcode;
    public String Country;
    public String Employer;
    public String Occupation;
    public DateValue StartDate;
    public DateValue EndDate;
    public Integer Level;
    public jobNode NextNode;

    public jobNode(String AddressStreet, String AddressAddInfo, String AddressNumber, String AddressCity, String State, String Zipcode, String Country, String Employer, String Occupation, DateValue StartDate, DateValue EndDate, Integer Level, jobNode NextNode) {
        this.AddressStreet = AddressStreet;
        this.AddressAddInfo = AddressAddInfo;
        this.AddressNumber = AddressNumber;
        this.AddressCity = AddressCity;
        this.State = State;
        this.Zipcode = Zipcode;
        this.Country = Country;
        this.Occupation = Occupation;
        this.StartDate = StartDate;
        this.Employer = Employer;
        this.EndDate = EndDate;
        this.Level = Level;
        this.NextNode = NextNode;

    }
    public String display() {
        return (AddressStreet + " : " + AddressAddInfo + " : " + AddressCity + " : " + State + " : " + Zipcode + " : " + Country + " : " + Employer + " : " + Occupation + " : " + StartDate.Value + " : " + EndDate.Value + " : " + Level);
    }
}