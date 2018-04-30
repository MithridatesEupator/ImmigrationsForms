package sample;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class jobData {
    jobNode Root;
    Integer NumLevels = 0;
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    Date date = new Date();
    DateValue TEMPORARYDATE = new DateValue(dateFormat.format(date));
    Integer FirstForeignLevel = 0;

    public jobData() {
        this.Root = null;
    }

    public void addNode(String AddressStreet, String AddressAddInfo, String AddressNumber, String AddressCity, String State,
                        String Zipcode, String Country, String Employer, String Occupation, DateValue StartDate, DateValue EndDate) {
        jobNode check = this.getLastNode();
        if (this.getLastNode().Level != 0 && this.getLastNode().Employer.toUpperCase().trim().equals("UNEMPLOYED")) {
            check = null;
        }
        if (this.Root == null) {
            if (EndDate.Value.equals(TEMPORARYDATE.Value) || EndDate.Value.equals("PRESENT")) {
                Root = new jobNode(AddressStreet, AddressAddInfo, AddressNumber, AddressCity, State, Zipcode, Country, Employer, Occupation, StartDate, EndDate, 0, null);
                NumLevels = 1;
            } else {
                if (TEMPORARYDATE.IntMinusFiveValue > EndDate.IntValue) {
                    Root.NextNode = new jobNode("", "", "", "", "", "", "", "", "",
                            new DateValue(""), new DateValue(""), 1, null);
                } else {
                    Root = new jobNode("", "", "", "", "",
                            "", "", "UNEMPLOYED", "NONE", EndDate, new DateValue("PRESENT"), 0, null);
                    Root.NextNode = new jobNode(AddressStreet, AddressAddInfo, AddressNumber, AddressCity, State, Zipcode, Country, Employer, Occupation,
                            StartDate, EndDate, 1, null);
                    NumLevels = 2;
                }
            }
        } else {
            this.addNodeHelper(AddressStreet, AddressAddInfo, AddressNumber, AddressCity, State,
                    Zipcode, Country, Employer, Occupation, StartDate, EndDate, 1, Root);
        }
    }

    private void addNodeHelper(String AddressStreet, String AddressAddInfo, String AddressNumber, String AddressCity, String State,
                               String Zipcode, String Country, String Employer, String Occupation, DateValue StartDate, DateValue EndDate, Integer Level, jobNode Node) {
        if (Node.NextNode == null) {
            NumLevels = Level + 1;
            if (TEMPORARYDATE.IntMinusFiveValue > EndDate.IntValue) {
                Node.NextNode = new jobNode("", "", "", "", "", "", "", "", "",
                        new DateValue(""), new DateValue(""), 1, null);

            } else {
                if (Node.StartDate.Value.equals(EndDate.Value) || EndDate.Value.equals("")) {
                    Node.NextNode = new jobNode(AddressStreet, AddressAddInfo, AddressNumber, AddressCity, State,
                            Zipcode, Country, Employer, Occupation, StartDate, EndDate, Level, null);
                    if(StartDate.IntValue > TEMPORARYDATE.IntMinusFiveValue) {
                        Node.NextNode.NextNode = new jobNode("", "", "", "", "",
                                "", "", "UNEMPLOYED", "NONE", new DateValue(TEMPORARYDATE.StringMinusFiveValue), StartDate, Level + 1, null);
                    }
                } else {
                    Node.NextNode = new jobNode("", "", "", "", "",
                            "", "", "UNEMPLOYED", "NONE", EndDate, Node.StartDate, Level, null);
                    this.addNodeHelper(AddressStreet, AddressAddInfo, AddressNumber, AddressCity, State,
                            Zipcode, Country, Employer, Occupation, StartDate, EndDate, Level + 1, Node.NextNode);
                }
            }
        } else {
            NumLevels = Level + 1;
            this.addNodeHelper(AddressStreet, AddressAddInfo, AddressNumber, AddressCity, State,
                    Zipcode, Country, Employer, Occupation, StartDate, EndDate, Level + 1, Node.NextNode);
        }
    }

    public Integer getFirstForeignLevel() {
        if (!Root.Country.toUpperCase().trim().equals("USA") && !Root.Country.isEmpty()) {
            return 0;
        } else {
            return this.getFirstForeignLevelHelper(Root);
        }
    }

    private Integer getFirstForeignLevelHelper(jobNode Node) {
        if (Node.NextNode != null && !Node.NextNode.Country.toUpperCase().trim().equals("USA") && !Node.NextNode.Country.isEmpty()) {
            return Node.NextNode.Level;
        } else {
            if (Node.NextNode != null) {
                return this.getFirstForeignLevelHelper(Node.NextNode);
            }
            else {
                return -1;
            }
        }
    }

    public jobNode getNode(int levelValue) {
        if (levelValue == 0) {
            return this.Root;
        }
        else {
            return this.getNodeHelper(levelValue, Root);
        }
    }

    private jobNode getNodeHelper(int levelValue, jobNode Node) {
        if (Node.NextNode.Level == levelValue) {
            return Node.NextNode;
        }
        else {
            return this.getNodeHelper(levelValue, Node.NextNode);
        }
    }
    public jobNode getLastNode() {
        if (Root == null) {
            return new jobNode("", "", "", "", "",
                    "", "", "", "", new DateValue(""), new
                    DateValue(""), -1, null);
        } else {
            return getLastNodeHelper(Root);
        }

    }
    private jobNode getLastNodeHelper(jobNode Node) {
        if (Node.NextNode != null) {
            return getLastNodeHelper(Node.NextNode);
        }
        else {
            return Node;
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