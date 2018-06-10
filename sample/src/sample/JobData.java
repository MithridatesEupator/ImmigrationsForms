package sample;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JobData
{
    JobNode Root;
    DateFormat dateFormat;
    Date date;
    DateValue TEMPORARYDATE;
    int FirstForeignLevel;
    JobNode check;
    static JobNode lastNode;
    public JobData()
    {
        dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        date = new Date();
        TEMPORARYDATE = new DateValue(dateFormat.format(date));
        FirstForeignLevel = -1;
        Root = null;
    }

    public void addNode(String AddressStreet, String AddressAddInfo, String AddressNumber, String AddressCity, String State, String Zipcode, String Country,
                        String Employer, String Occupation, DateValue StartDate, DateValue EndDate)
    {
        if(getLastNode().Employer.toUpperCase().trim().equals("UNEMPLOYED") && getLastNode().Level.intValue() != 0)
            deleteLastNode();
        if(Root == null)
        {
            if(EndDate.Value.equals(TEMPORARYDATE.Value) || EndDate.Value.equals("PRESENT"))
            {
                if(!Country.equals("USA") && FirstForeignLevel == -1)
                    FirstForeignLevel = 0;
                Root = new JobNode(AddressStreet, AddressAddInfo, AddressNumber, AddressCity, State, Zipcode, Country, Employer, Occupation, StartDate, EndDate, Integer.valueOf(0), null);
            } else
            {
                if(!Country.equals("USA") && FirstForeignLevel == -1)
                    FirstForeignLevel = 1;
                Root = new JobNode("", "", "", "", "", "", "", "UNEMPLOYED", "NONE", EndDate, new DateValue("PRESENT"), Integer.valueOf(0), null);
                addNode(AddressStreet, AddressAddInfo, AddressNumber, AddressCity, State, Zipcode, Country, Employer, Occupation, StartDate, EndDate);
                if(TEMPORARYDATE.IntMinusFiveValue < StartDate.IntValue)
                    addNode("", "", "", "", "", "", "", "UNEMPLOYED", "NONE", new DateValue(TEMPORARYDATE.StringMinusFiveValue), StartDate);
            }
        } else
        {
            addNodeHelper(AddressStreet, AddressAddInfo, AddressNumber, AddressCity, State, Zipcode, Country, Employer, Occupation, StartDate, EndDate, Integer.valueOf(1), Root);
        }
    }

    public void addNodeHelper(String AddressStreet, String AddressAddInfo, String AddressNumber, String AddressCity, String State, String Zipcode, String Country,
                              String Employer, String Occupation, DateValue StartDate, DateValue EndDate, Integer Level, JobNode Node)
    {
        if(Node.NextNode == null)
        {
            if(!Node.StartDate.Value.equals(EndDate.Value) && !Node.StartDate.Value.trim().isEmpty())
            {
                addNodePure("", "", "", "", "", "", "", "UNEMPLOYED", "NONE", EndDate, Node.StartDate, Level, Node);
                if(Level.intValue() != 2)
                {
                    if(getLastNode().Level.intValue() > 2 && !Country.toUpperCase().trim().equals("USA") && !Country.toUpperCase().isEmpty() && Root.NextNode.NextNode.Occupation.trim().isEmpty())
                    {
                        Root.NextNode.NextNode.AddressStreet = AddressStreet;
                        Root.NextNode.NextNode.AddressAddInfo = AddressAddInfo;
                        Root.NextNode.NextNode.AddressNumber = AddressNumber;
                        Root.NextNode.NextNode.AddressCity = AddressCity;
                        Root.NextNode.NextNode.State = State;
                        Root.NextNode.NextNode.Zipcode = Zipcode;
                        Root.NextNode.NextNode.Country = Country;
                        Root.NextNode.NextNode.Employer = Employer;
                        Root.NextNode.NextNode.Occupation = Occupation;
                        Root.NextNode.NextNode.StartDate = StartDate;
                        Root.NextNode.NextNode.EndDate = EndDate;
                        Root.NextNode.NextNode.Level = Integer.valueOf(2);
                    } else
                    {
                        Level = Integer.valueOf(Level.intValue() + 1);
                        addNodePure(AddressStreet, AddressAddInfo, AddressNumber, AddressCity, State, Zipcode, Country, Employer, Occupation, StartDate, EndDate, Level, Node.NextNode);
                    }
                    Level = Integer.valueOf(Level.intValue() + 1);
                    if(!Country.equals("USA") && FirstForeignLevel == -1)
                        FirstForeignLevel = Level.intValue();
                } else
                {
                    Level = Integer.valueOf(Level.intValue() + 2);
                    if(!Country.equals("USA") && FirstForeignLevel == -1)
                        FirstForeignLevel = Level.intValue();
                    addNodePure(AddressStreet, AddressAddInfo, AddressNumber, AddressCity, State, Zipcode, Country, Employer, Occupation, StartDate, EndDate, Level, Node.NextNode.NextNode);
                }
                if(TEMPORARYDATE.IntMinusFiveValue < StartDate.IntValue)
                    addNode("", "", "", "", "", "", "", "UNEMPLOYED", "NONE", new DateValue(TEMPORARYDATE.StringMinusFiveValue), StartDate);
            } else
            {
                addNodePure(AddressStreet, AddressAddInfo, AddressNumber, AddressCity, State, Zipcode, Country, Employer, Occupation, StartDate, EndDate, Level, Node);
            }
        } else
        {
            addNodeHelper(AddressStreet, AddressAddInfo, AddressNumber, AddressCity, State, Zipcode, Country, Employer, Occupation, StartDate, EndDate, Integer.valueOf(Level.intValue() + 1), Node.NextNode);
        }
    }

    public void addNodePure(String AddressStreet, String AddressAddInfo, String AddressNumber, String AddressCity, String State, String Zipcode, String Country,
                            String Employer, String Occupation, DateValue StartDate, DateValue EndDate, Integer Level, JobNode Node)
    {
        if(Level.intValue() != 2 || Level.intValue() == 2 && !Country.toUpperCase().trim().equals("USA") && !Country.trim().isEmpty() && FirstForeignLevel < 2 || Level.intValue() == 2 && !Country.toUpperCase().trim().equals("USA") && !Country.trim().isEmpty() && FirstForeignLevel < 2)
            Node.NextNode = new JobNode(AddressStreet, AddressAddInfo, AddressNumber, AddressCity, State, Zipcode, Country, Employer, Occupation, StartDate, EndDate, Level, null);
        else
        if(Level.intValue() == 2 && (Country.toUpperCase().trim().equals("USA") || Country.trim().isEmpty()) && (FirstForeignLevel == -1 || FirstForeignLevel == 2))
        {
            Node.NextNode = new JobNode("", "", "", "", "", "", "", "", "", new DateValue(), new DateValue(), Integer.valueOf(2), null);
            addNodeHelper(AddressStreet, AddressAddInfo, AddressNumber, AddressCity, State, Zipcode, Country, Employer, Occupation, StartDate, EndDate, Integer.valueOf(Level.intValue() + 1), Node.NextNode);
        } else
        if(Level.intValue() == 2 && (Country.toUpperCase().trim().equals("USA") || Country.trim().isEmpty()) && FirstForeignLevel < 2)
        {
            Node.NextNode = new JobNode("", "", "", "", "", "", "", "SEE ABOVE", "", new DateValue(), new DateValue(), Integer.valueOf(2), null);
            addNodeHelper(AddressStreet, AddressAddInfo, AddressNumber, AddressCity, State, Zipcode, Country, Employer, Occupation, StartDate, EndDate, Integer.valueOf(Level.intValue() + 1), Node.NextNode);
        } else
        if(Level.intValue() == 2 && Country.toUpperCase().trim().equals("USA") && FirstForeignLevel == 2)
            Node.NextNode = new JobNode(AddressStreet, AddressAddInfo, AddressNumber, AddressCity, State, Zipcode, Country, Employer, Occupation, StartDate, EndDate, Integer.valueOf(2), Node.NextNode);
        else
            Node.NextNode = new JobNode(AddressStreet, AddressAddInfo, AddressNumber, AddressCity, State, Zipcode, Country, Employer, Occupation, StartDate, EndDate, Level, null);
    }

    public JobNode getNode(int levelValue)
    {
        if(levelValue == 0)
            return Root;
        else
            return getNodeHelper(levelValue, Root);
    }

    private JobNode getNodeHelper(int levelValue, JobNode Node)
    {
        if(Node.NextNode.Level.intValue() == levelValue)
            return Node.NextNode;
        else
            return getNodeHelper(levelValue, Node.NextNode);
    }

    public JobNode getLastNode()
    {
        if(Root == null)
            return new JobNode("", "", "", "", "", "", "", "", "", new DateValue(""), new DateValue(""), Integer.valueOf(0), null);
        else
            return getLastNodeHelper(Root);
    }

    private JobNode getLastNodeHelper(JobNode Node)
    {
        if(Node.NextNode == null)
            return Node;
        else
            return getLastNodeHelper(Node.NextNode);
    }

    public void printAll()
    {
        if(Root == null)
            System.out.println("THIS OBJECT IS EMPTY");
        else
            printAllHelper(Root);
    }

    private void printAllHelper(JobNode Node)
    {
        System.out.println(Node.display());
        if(Node.NextNode != null)
            printAllHelper(Node.NextNode);
    }

    public void deleteLastNode()
    {
        if(Root == null)
            System.out.println("THIS OBJECT IS EMPTY");
        else
            deleteLastNodeHelper(Root);
    }

    private void deleteLastNodeHelper(JobNode Node)
    {
        if(Node.NextNode.NextNode == null)
            Node.NextNode = null;
        else
            deleteLastNodeHelper(Node.NextNode);
    }

    public void checkYourself(int Scale)
    {
        if(Root == null)
            Root = new JobNode();
        checkYourselfHelper(Root, 1, Scale);
    }

    private void checkYourselfHelper(JobNode Node, int Level, int Scale)
    {
        if(Node.NextNode == null)
            Node.NextNode = new JobNode(Level);
        if(Node.Level.intValue() < Scale)
            checkYourselfHelper(Node.NextNode, Level + 1, Scale);
    }

}

class JobNode
{
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

    public JobNode(String AddressStreet, String AddressAddInfo, String AddressNumber, String AddressCity, String State, String Zipcode, String Country,
                   String Employer, String Occupation, DateValue StartDate, DateValue EndDate, Integer Level, JobNode NextNode)
    {
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

    public JobNode()
    {
        AddressStreet = "";
        AddressAddInfo = "";
        AddressNumber = "";
        AddressCity = "";
        State = "";
        Zipcode = "";
        Country = "";
        Occupation = "";
        StartDate = new DateValue("");
        Employer = "";
        EndDate = new DateValue("");
        Level = Integer.valueOf(0);
        NextNode = null;
    }

    public JobNode(int Level)
    {
        AddressStreet = "";
        AddressAddInfo = "";
        AddressNumber = "";
        AddressCity = "";
        State = "";
        Zipcode = "";
        Country = "";
        Occupation = "";
        StartDate = new DateValue("");
        Employer = "";
        EndDate = new DateValue("");
        this.Level = Integer.valueOf(Level);
        NextNode = null;
    }

    public String display()
    {
        return (new StringBuilder()).append(AddressStreet).append(" : ").append(AddressAddInfo).append(" : ").append(AddressCity).append(" : ").append(State).append(" : ").append(Zipcode).append(" : ").append(Country).append(" : ").append(Employer).append(" : ").append(Occupation).append(" : ").append(StartDate.Value).append(" : ").append(EndDate.Value).append(" : ").append(Level).toString();
    }
}