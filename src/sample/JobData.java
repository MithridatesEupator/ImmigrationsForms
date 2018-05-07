package sample;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JobData {
    JobNode Root;
    Integer NumLevels = 0;
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    Date date = new Date();
    DateValue TEMPORARYDATE = new DateValue(dateFormat.format(date));
    Integer FirstForeignLevel = 0;
    JobNode check;
    static JobNode lastNode;


    public JobData() {
        this.Root = null;
    }

    public void addNode(String AddressStreet, String AddressAddInfo, String AddressNumber, String AddressCity, String State,
                        String Zipcode, String Country, String Employer, String Occupation, DateValue StartDate, DateValue EndDate) {
        check = this.getLastNode();
        lastNode = this.getLastNode();
        if (this.getLastNode().Level != 0 && this.getLastNode().Employer.toUpperCase().trim().equals("UNEMPLOYED")) {
            this.deleteLastNode();
        }
        if (this.Root == null) {
            if (EndDate.Value.equals(TEMPORARYDATE.Value) || EndDate.Value.equals("PRESENT")) {
                Root = new JobNode(AddressStreet, AddressAddInfo, AddressNumber, AddressCity, State, Zipcode, Country, Employer, Occupation, StartDate, EndDate, 0, null);
                NumLevels = 1;
            } else {
                if (TEMPORARYDATE.IntMinusFiveValue > EndDate.IntValue) {
                    Root.NextNode = new JobNode("", "", "", "", "", "", "", "", "",
                            new DateValue(""), new DateValue(""), 1, null);
                } else {
                    Root = new JobNode("", "", "", "", "",
                            "", "", "UNEMPLOYED", "NONE", EndDate, new DateValue("PRESENT"), 0, null);
                    Root.NextNode = new JobNode(AddressStreet, AddressAddInfo, AddressNumber, AddressCity, State, Zipcode, Country, Employer, Occupation,
                            StartDate, EndDate, 1, null);
                    NumLevels = 2;
                    if (TEMPORARYDATE.IntMinusFiveValue < StartDate.IntValue) {
                        Root.NextNode.NextNode = new JobNode("", "", "", "", "", "", "", "UNEMPLOYED", "NONE",
                                new DateValue(TEMPORARYDATE.StringMinusFiveValue), StartDate, 2, null);
                    }
                }
            }
        } else {
            this.addNodeHelper(AddressStreet, AddressAddInfo, AddressNumber, AddressCity, State,
                    Zipcode, Country, Employer, Occupation, StartDate, EndDate, 1, Root);
        }
    }

    public void addNodeHelper(String AddressStreet, String AddressAddInfo, String AddressNumber, String AddressCity, String State,
                              String Zipcode, String Country, String Employer, String Occupation, DateValue StartDate, DateValue EndDate, Integer Level, JobNode Node) {
        if (Node.NextNode == null) {
            NumLevels = Level + 1;
            if (TEMPORARYDATE.IntMinusFiveValue > EndDate.IntValue) {
                Node.NextNode = new JobNode("", "", "", "", "", "", "", "", "",
                        new DateValue(""), new DateValue(""), 1, null);

            } else {
                if (Node.StartDate.Value.equals(EndDate.Value) || EndDate.Value.equals("")) {
                    Node.NextNode = new JobNode(AddressStreet, AddressAddInfo, AddressNumber, AddressCity, State,
                            Zipcode, Country, Employer, Occupation, StartDate, EndDate, Level, null);
                    if (StartDate.IntValue > TEMPORARYDATE.IntMinusFiveValue) {
                        Node.NextNode.NextNode = new JobNode("", "", "", "", "",
                                "", "", "UNEMPLOYED", "NONE", new DateValue(TEMPORARYDATE.StringMinusFiveValue), StartDate, Level + 1, null);
                    }
                } else {
                    Node.NextNode = new JobNode("", "", "", "", "",
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

    private Integer getFirstForeignLevelHelper(JobNode Node) {
        if (Node.NextNode != null && !Node.NextNode.Country.trim().toUpperCase().equals("USA") && !Node.NextNode.Country.isEmpty()) {
            return Node.NextNode.Level;
        } else if (Node.NextNode != null) {
            return this.getFirstForeignLevelHelper(Node.NextNode);
        } else {
            return -1;
        }
    }

    public JobNode getNode(int levelValue) {
        if (levelValue == 0) {
            return this.Root;
        } else {
            return this.getNodeHelper(levelValue, Root);
        }
    }

    private JobNode getNodeHelper(int levelValue, JobNode Node) {
        if (Node.NextNode.Level == levelValue) {
            return Node.NextNode;
        } else {
            return this.getNodeHelper(levelValue, Node.NextNode);
        }
    }

    public JobNode getLastNode() {
        if (this.Root == null) {
            return new JobNode("", "", "", "", "", "", "",
                    "", "", new DateValue(""), new DateValue(""), 0, null);
        } else {
            return this.getLastNodeHelper(Root);
        }
    }

    private JobNode getLastNodeHelper(JobNode Node) {
        if (Node.NextNode == null) {
            return Node;
        } else {
            return this.getLastNodeHelper(Node.NextNode);
        }
    }

    public void printAll() {
        if (this.Root == null) {
            System.out.println("THIS OBJECT IS EMPTY");
        }
        else {
            this.printAllHelper(Root);
        }
    }

    private void printAllHelper(JobNode Node) {
        System.out.println(Node.display());
        if (Node.NextNode != null) {
            this.printAllHelper(Node.NextNode);
        }
    }

    public void deleteLastNode() {
        if(this.Root == null) {
            System.out.println("THIS OBJECT IS EMPTY");
        }
        else {
            this.deleteLastNodeHelper(Root);
        }
    }

    private void deleteLastNodeHelper(JobNode Node) {
        if(Node.NextNode.NextNode == null) {
            Node.NextNode = null;
        }
        else {
            deleteLastNodeHelper(Node.NextNode);
        }
    }

    public void checkYourself(int Scale) {
        if (this.Root == null) {
            this.Root = new JobNode();
        }
        checkYourselfHelper(Root,1, Scale);
    }

    private void checkYourselfHelper(JobNode Node, int Level, int Scale) {
        if(Node.NextNode == null) {
            Node.NextNode = new JobNode(Level);
        }
        if (Node.Level < Scale) {
            this.checkYourselfHelper(Node.NextNode, Level + 1, Scale);
        }
    }
}

class JobNode {

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
    public JobNode NextNode;

    public JobNode(String AddressStreet, String AddressAddInfo, String AddressNumber, String AddressCity, String State, String Zipcode, String Country, String Employer, String Occupation, DateValue StartDate, DateValue EndDate, Integer Level, JobNode NextNode) {
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
    public JobNode() {
        this.AddressStreet = "";
        this.AddressAddInfo = "";
        this.AddressNumber = "";
        this.AddressCity = "";
        this.State = "";
        this.Zipcode = "";
        this.Country = "";
        this.Occupation = "";
        this.StartDate = new DateValue("");
        this.Employer = "";
        this.EndDate = new DateValue("");
        this.Level = 0;
        this.NextNode = null;
    }
    public JobNode(int Level) {
        this.AddressStreet = "";
        this.AddressAddInfo = "";
        this.AddressNumber = "";
        this.AddressCity = "";
        this.State = "";
        this.Zipcode = "";
        this.Country = "";
        this.Occupation = "";
        this.StartDate = new DateValue("");
        this.Employer = "";
        this.EndDate = new DateValue("");
        this.Level = Level;
        this.NextNode = null;
    }
    public String display() {
        return (AddressStreet + " : " + AddressAddInfo + " : " + AddressCity + " : " + State + " : " + Zipcode + " : " + Country + " : " + Employer + " : " + Occupation + " : " + StartDate.Value + " : " + EndDate.Value + " : " + Level);
    }
}