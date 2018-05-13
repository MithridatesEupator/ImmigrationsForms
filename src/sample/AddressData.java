package sample;

public class AddressData {

    AddressNode Root;
    int FirstForeignLevel = -1;

    public AddressData() {
        this.Root = null;
    }

    public void addNode(String AddressStreet, String AddressAddInfo, String AddressNumber, String AddressCity, String State, String Zipcode, String Country, DateValue StartDate, DateValue EndDate) {
        if (this.Root == null) {
            this.Root = new AddressNode(AddressStreet, AddressAddInfo, AddressNumber, AddressCity, State, Zipcode, Country, StartDate, new DateValue("PRESENT"), 0, null);
            if (!Country.toUpperCase().equals("USA") && FirstForeignLevel == -1) {
                FirstForeignLevel = 0;
            }
        }
        else {
            this.addNodeHelper(AddressStreet, AddressAddInfo, AddressNumber, AddressCity, State, Zipcode, Country, StartDate, EndDate, Root, 1);
        }
    }

    private void addNodeHelper(String AddressStreet, String AddressAddInfo, String AddressNumber, String AddressCity, String State, String Zipcode, String Country, DateValue StartDate, DateValue EndDate, AddressNode Node, int Level) {
        if (Node.NextNode == null) {
            if (!Country.toUpperCase().equals("USA") && FirstForeignLevel == -1) {
                FirstForeignLevel = Level;
            }
            if ((Level != 2) || (Level == 2 && !Country.toUpperCase().equals("USA") && FirstForeignLevel == 2) || (Level == 2 && !Country.toUpperCase().equals("USA") && FirstForeignLevel < 2) ) {
                Node.NextNode = new AddressNode(AddressStreet, AddressAddInfo, AddressNumber, AddressCity, State, Zipcode, Country, StartDate, EndDate, Level, null);
            }
            else if (Level == 2 && Country.toUpperCase().equals("USA") && FirstForeignLevel == -1) {
                Node.NextNode = new AddressNode("", "", "", "", "", "", "", new DateValue(), new DateValue(), 2, null);
                this.addNodeHelper(AddressStreet, AddressAddInfo, AddressNumber, AddressCity, State, Zipcode, Country, StartDate, EndDate, Node.NextNode, Level + 1);
            }
            else if (Level == 2 && Country.toUpperCase().equals("USA") && FirstForeignLevel < 2) {
                Node.NextNode = new AddressNode("SEE ABOVE", "", "", "", "", "", "", new DateValue(), new DateValue(), 2, null);
                this.addNodeHelper(AddressStreet, AddressAddInfo, AddressNumber, AddressCity, State, Zipcode, Country, StartDate, EndDate, Node.NextNode, Level + 1);
            }
        }
        else {
            if ((!Country.toUpperCase().equals("USA") && Node.AddressStreet.toUpperCase().equals("SEE ABOVE")) || (!Country.toUpperCase().equals("USA") && Node.AddressStreet.toUpperCase().isEmpty())) {
                Node.AddressStreet = AddressStreet;
                Node.AddressAddInfo = AddressAddInfo;
                Node.AddressNumber = AddressNumber;
                Node.AddressCity = AddressCity;
                Node.State = State;
                Node.Zipcode = Zipcode;
                Node.Country = Country;
                Node.StartDate = StartDate;
                Node.EndDate = EndDate;
                Node.Level = 2;
            }
            else {
                this.addNodeHelper(AddressStreet, AddressAddInfo, AddressNumber, AddressCity, State, Zipcode, Country, StartDate, EndDate, Node.NextNode, Level + 1);
            }
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

    private void printAllHelper(AddressNode Node) {
        System.out.println(Node.display());
        if (Node.NextNode != null) {
            this.printAllHelper(Node.NextNode);
        }
    }

    public Integer getFirstForeignLevel() {
        if (!Root.Country.toUpperCase().trim().equals("USA") && !Root.Country.isEmpty()) {
            return 0;
        } else {
            return this.getFirstForeignLevelHelper(Root);
        }
    }

    private Integer getFirstForeignLevelHelper(AddressNode Node) {
        if (Node.NextNode != null && !Node.NextNode.Country.trim().toUpperCase().equals("USA") && !Node.NextNode.Country.isEmpty()) {
            return Node.NextNode.Level;
        } else if (Node.NextNode != null) {
            return this.getFirstForeignLevelHelper(Node.NextNode);
        } else {
            return -1;
        }
    }

    public AddressNode getLastNode() {
        if (this.Root == null) {
            return new AddressNode();
        } else {
            return this.getLastNodeHelper(this.Root);
        }
    }

    private AddressNode getLastNodeHelper(AddressNode Node) {
        if (Node.NextNode == null) {
            return Node;
        } else {
            return this.getLastNodeHelper(Node.NextNode);
        }
    }

    public void checkYourself(int Scale) {
        if (this.Root == null) {
            this.Root = new AddressNode(0);
        }
        checkYourselfHelper(Root,1, Scale);
    }

    private void checkYourselfHelper(AddressNode Node, int Level, int Scale) {
        if(Node.NextNode == null) {
            if (Level == 2 && FirstForeignLevel < 2 && FirstForeignLevel != -1) {
                Node.NextNode = new AddressNode("SEE ABOVE", "", "", "", "", "", "", new DateValue(), new DateValue(), 2, null);
            }
            else {
                Node.NextNode = new AddressNode(Level);
            }
        }
        if (Node.Level < Scale) {
            this.checkYourselfHelper(Node.NextNode, Level + 1, Scale);
        }
    }

    public AddressNode getNode(int levelValue) {
        if (levelValue == 0) {
            return this.Root;
        } else {
            return this.getNodeHelper(levelValue, Root);
        }
    }

    private AddressNode getNodeHelper(int levelValue, AddressNode Node) {
        if (Node.NextNode.Level == levelValue) {
            return Node.NextNode;
        } else {
            return this.getNodeHelper(levelValue, Node.NextNode);
        }
    }
}

class AddressNode {

    public String AddressStreet;
    public String AddressAddInfo;
    public String AddressNumber;
    public String AddressCity;
    public String State;
    public String Zipcode;
    public String Country;
    public DateValue StartDate;
    public DateValue EndDate;
    public Integer Level;
    public AddressNode NextNode;

    public AddressNode(String AddressStreet, String AddressAddInfo, String AddressNumber, String AddressCity, String State, String Zipcode, String Country, DateValue StartDate, DateValue EndDate, Integer Level, AddressNode NextNode) {
        this.AddressStreet = AddressStreet;
        this.AddressAddInfo = AddressAddInfo;
        this.AddressNumber = AddressNumber;
        this.AddressCity = AddressCity;
        this.State = State;
        this.Zipcode = Zipcode;
        this.Country = Country;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
        this.Level = Level;
        this.NextNode = NextNode;
    }
    public AddressNode() {
        this.AddressStreet = "";
        this.AddressAddInfo = "";
        this.AddressNumber = "";
        this.AddressCity = "";
        this.State = "";
        this.Zipcode = "";
        this.Country = "";
        this.StartDate = new DateValue();
        this.EndDate = new DateValue();
        this.Level = 0;
        this.NextNode = null;
    }
    public AddressNode(int Level) {
        this.AddressStreet = "";
        this.AddressAddInfo = "";
        this.AddressNumber = "";
        this.AddressCity = "";
        this.State = "";
        this.Zipcode = "";
        this.Country = "";
        this.StartDate = new DateValue();
        this.EndDate = new DateValue();
        this.Level = Level;
        this.NextNode = null;
    }
    public String display() {
        return (AddressStreet + " : " + AddressAddInfo + " : " + AddressCity + " : " + State + " : " + Zipcode + " : " + Country + " : " + StartDate.Value + " : " + EndDate.Value + " : " + Level);
    }
}