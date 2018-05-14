package sample;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JobData {
    JobNode Root;
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    Date date = new Date();
    DateValue TEMPORARYDATE = new DateValue(dateFormat.format(date));
    int FirstForeignLevel = -1;
    JobNode check;
    static JobNode lastNode;


    public JobData() {
        this.Root = null;
    }

    public void addNode(String AddressStreet, String AddressAddInfo, String AddressNumber, String AddressCity, String State,
                        String Zipcode, String Country, String Employer, String Occupation, DateValue StartDate, DateValue EndDate) {
        if(this.getLastNode().Employer.toUpperCase().trim().equals("UNEMPLOYED") && this.getLastNode().Level != 0) {
            this.deleteLastNode();
        }
        if(this.Root == null) {
            if(EndDate.Value.equals(TEMPORARYDATE.Value) || EndDate.Value.equals("PRESENT")) {
                if (!Country.equals("USA") && FirstForeignLevel == -1) {
                    FirstForeignLevel = 0;
                }
                Root = new JobNode(AddressStreet, AddressAddInfo, AddressNumber, AddressCity, State, Zipcode, Country, Employer, Occupation, StartDate, EndDate, 0, null);
            }
            else {
                if (!Country.equals("USA") && FirstForeignLevel == -1) {
                    FirstForeignLevel = 1;
                }
                this.Root = new JobNode("", "", "", "", "", "", "", "UNEMPLOYED", "NONE",
                        EndDate, new DateValue("PRESENT"), 0, null);
                this.addNode(AddressStreet, AddressAddInfo, AddressNumber, AddressCity, State,
                        Zipcode, Country, Employer, Occupation, StartDate, EndDate);
                if (TEMPORARYDATE.IntMinusFiveValue < StartDate.IntValue) {
                    this.addNode("","","","","","","","UNEMPLOYED","NONE",
                            new DateValue(TEMPORARYDATE.StringMinusFiveValue), StartDate);
                }
            }
        }
        else {
            this.addNodeHelper(AddressStreet, AddressAddInfo, AddressNumber, AddressCity, State,
                    Zipcode, Country, Employer, Occupation, StartDate, EndDate, 1, Root);
        }
    }

    public void addNodeHelper(String AddressStreet, String AddressAddInfo, String AddressNumber, String AddressCity, String State,
                              String Zipcode, String Country, String Employer, String Occupation, DateValue StartDate, DateValue EndDate, Integer Level, JobNode Node) {
        if(Node.NextNode == null) {

            if (!Node.StartDate.Value.equals(EndDate.Value) && !Node.StartDate.Value.trim().isEmpty()) {
                this.addNodePure("", "", "", "", "",
                        "", "", "UNEMPLOYED", "NONE", EndDate, Node.StartDate, Level, Node);
                if (Level != 2) {
                    if(this.getLastNode().Level > 2 && !Country.toUpperCase().trim().equals("USA") && !Country.toUpperCase().isEmpty() && this.Root.NextNode.NextNode.Occupation.trim().isEmpty()) {
                        this.Root.NextNode.NextNode.AddressStreet = AddressStreet;
                        this.Root.NextNode.NextNode.AddressAddInfo = AddressAddInfo;
                        this.Root.NextNode.NextNode.AddressNumber = AddressNumber;
                        this.Root.NextNode.NextNode.AddressCity = AddressCity;
                        this.Root.NextNode.NextNode.State = State;
                        this.Root.NextNode.NextNode.Zipcode = Zipcode;
                        this.Root.NextNode.NextNode.Country = Country;
                        this.Root.NextNode.NextNode.Employer = Employer;
                        this.Root.NextNode.NextNode.Occupation = Occupation;
                        this.Root.NextNode.NextNode.StartDate = StartDate;
                        this.Root.NextNode.NextNode.EndDate = EndDate;
                        this.Root.NextNode.NextNode.Level = 2;
                    }
                    else {
                        Level += 1;
                        this.addNodePure(AddressStreet, AddressAddInfo, AddressNumber, AddressCity, State, Zipcode, Country, Employer, Occupation, StartDate, EndDate, Level, Node.NextNode);
                    }
                    Level += 1;
                    if (!Country.equals("USA") && FirstForeignLevel == -1) {
                        FirstForeignLevel = Level;
                    }
                }
                else {
                    Level += 2;
                    if (!Country.equals("USA") && FirstForeignLevel == -1) {
                        FirstForeignLevel = Level;
                    }
                    this.addNodePure(AddressStreet, AddressAddInfo, AddressNumber, AddressCity, State, Zipcode, Country, Employer, Occupation, StartDate, EndDate, Level, Node.NextNode.NextNode);
                }
                if (TEMPORARYDATE.IntMinusFiveValue < StartDate.IntValue) {
                    this.addNode("","","","","","","","UNEMPLOYED","NONE",
                            new DateValue(TEMPORARYDATE.StringMinusFiveValue), StartDate);
                }
            } else {
                this.addNodePure(AddressStreet, AddressAddInfo, AddressNumber, AddressCity, State, Zipcode, Country, Employer, Occupation, StartDate, EndDate, Level, Node);
            }

        }
        else {
            this.addNodeHelper(AddressStreet, AddressAddInfo, AddressNumber, AddressCity, State, Zipcode, Country, Employer, Occupation, StartDate, EndDate, Level + 1, Node.NextNode);
        }
    }

    public void addNodePure(String AddressStreet, String AddressAddInfo, String AddressNumber, String AddressCity, String State,
                            String Zipcode, String Country, String Employer, String Occupation, DateValue StartDate, DateValue EndDate, Integer Level, JobNode Node) {
        if ((Level != 2) || (Level == 2 && !(Country.toUpperCase().trim().equals("USA") || Country.trim().isEmpty()) && FirstForeignLevel < 2) || (Level == 2 && !(Country.toUpperCase().trim().equals("USA") || Country.trim().isEmpty()) && FirstForeignLevel < 2)) {
            Node.NextNode = new JobNode(AddressStreet, AddressAddInfo, AddressNumber, AddressCity, State, Zipcode, Country, Employer, Occupation, StartDate, EndDate, Level, null);
        }
        else if (Level == 2 && (Country.toUpperCase().trim().equals("USA") || Country.trim().isEmpty()) && (FirstForeignLevel == -1 || FirstForeignLevel == 2)) {
            Node.NextNode = new JobNode("", "", "", "", "", "", "", "", "", new DateValue(), new DateValue(), 2, null);
            this.addNodeHelper(AddressStreet, AddressAddInfo, AddressNumber, AddressCity, State, Zipcode, Country, Employer, Occupation, StartDate, EndDate, Level + 1, Node.NextNode);
        }
        else if (Level == 2 && (Country.toUpperCase().trim().equals("USA") || Country.trim().isEmpty()) && FirstForeignLevel < 2) {
            Node.NextNode = new JobNode("", "", "", "", "", "", "", "SEE ABOVE", "", new DateValue(), new DateValue(), 2, null);
            this.addNodeHelper(AddressStreet, AddressAddInfo, AddressNumber, AddressCity, State, Zipcode, Country, Employer, Occupation, StartDate, EndDate, Level + 1, Node.NextNode);
        }
        else if (Level == 2 && (Country.toUpperCase().trim().equals("USA")) && FirstForeignLevel == 2) {
            Node.NextNode = new JobNode(AddressStreet, AddressAddInfo, AddressNumber, AddressCity, State, Zipcode, Country, Employer, Occupation, StartDate, EndDate, 2, Node.NextNode);
        }
        else {
            Node.NextNode = new JobNode(AddressStreet, AddressAddInfo, AddressNumber, AddressCity, State, Zipcode, Country, Employer, Occupation, StartDate, EndDate, Level, null);
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