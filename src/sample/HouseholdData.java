package sample;

public class HouseholdData {

    int householdSize = 0;
    HouseholdNode Root;
    HouseholdData() {
        this.Root = null;
    }

    public void addNode(String Name, DateValue DOBDate, String Relationship, String MarriedStatus, String FullStudent,
                        String IncomeContribution) {
        if (this.Root == null) {
            this.Root = new HouseholdNode(Name, DOBDate, Relationship, MarriedStatus, FullStudent, IncomeContribution, 0);
        }
        else {
            this.addNodeHelper(Name, DOBDate, Relationship, MarriedStatus, FullStudent, IncomeContribution, Root, 1);
        }
    }
    private void addNodeHelper(String Name, DateValue DOBDate, String Relationship, String MarriedStatus, String FullStudent,
                               String IncomeContribution, HouseholdNode Node, int Level ) {
        if(Node.NextNode == null) {
            Node.NextNode = new HouseholdNode(Name, DOBDate, Relationship, MarriedStatus, FullStudent, IncomeContribution, Level);
        }
        else {
            this.addNodeHelper(Name, DOBDate, Relationship, MarriedStatus, FullStudent, IncomeContribution, Node.NextNode, Level + 1);
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

    private void printAllHelper(HouseholdNode Node) {
        System.out.println(Node.display());
        if (Node.NextNode != null) {
            this.printAllHelper(Node.NextNode);
        }
    }
}


class HouseholdNode {
    String Name;
    DateValue DOBDate;
    String Relationship;
    String MarriedStatus;
    String FullStudent;
    String IncomeContribution;
    int Level;
    HouseholdNode NextNode;

    HouseholdNode(String Name, DateValue DOBDate, String Relationship, String MarriedStatus, String FullStudent,
                  String IncomeContribution, int Level) {
        this.Name = Name;
        this.DOBDate = DOBDate;
        this.Relationship = Relationship;
        this.MarriedStatus = MarriedStatus;
        this.FullStudent = FullStudent;
        this.IncomeContribution = IncomeContribution;
        this.Level = Level;
    }
    public String display() {
        return (Name + " : " + DOBDate.Value + " : " + Relationship + " : " + MarriedStatus + " : " + FullStudent + " : " + IncomeContribution + " : " + Level);
    }
}