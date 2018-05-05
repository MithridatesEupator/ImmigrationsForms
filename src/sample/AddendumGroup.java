package sample;

public class AddendumGroup {
    AddendumObject Root;
    public void addAddendum(String line1, String line2, String line3, String line4,
                            String pageNum, String partNum, String itemNum, Boolean protectedAddendum) {
        if(this.Root == null) {
            this.Root = new AddendumObject(line1, line2, line3, line4, pageNum, partNum, itemNum, protectedAddendum, 0);
        }
        else {
            this.addAddendumHelper(line1, line2, line3, line4, pageNum, partNum, itemNum, Root, protectedAddendum, 1);
        }
    }
    private void addAddendumHelper(String line1, String line2, String line3, String line4,
                                   String pageNum, String partNum, String itemNum, AddendumObject object, Boolean protectedAddendum, int Level) {
        if(object.nextAddendumObject == null) {
            object.nextAddendumObject = new AddendumObject(line1, line2, line3, line4, pageNum, partNum, itemNum, protectedAddendum, Level);
        }
        else {
            this.addAddendumHelper(line1, line2, line3, line4, pageNum, partNum, itemNum, object.nextAddendumObject, protectedAddendum, Level + 1);
        }
    }
    public void printAll() {
        if (Root == null) {
            System.out.println("OBJECT IS EMPTY");
        }
        else {
            this.printAllHelper(Root);
        }
    }
    private void printAllHelper(AddendumObject object) {
        System.out.println(object.line1 + " " + object.line2 + " " + object.line3 + " " + object.line4 + " : " + object.pageNum + " : " + object.partNum + " : " + object.itemNum);
        if (object.nextAddendumObject != null) {
            printAllHelper(object.nextAddendumObject);
        }
    }
    public void clearObject() {
        if (Root == null) {
            System.out.println("OBJECT IS EMPTY");
        }
        else {
            clearObjectHelper(Root);
        }
    }
    private void clearObjectHelper(AddendumObject object) {
        if(!object.protectedAddendum) {
            object.clearCurrentObject();
        }
        if(object.nextAddendumObject != null) {
            this.clearObjectHelper(object.nextAddendumObject);
        }
    }

    public void checkYourSelf() {
        if(this.Root == null) {
            this.Root = new AddendumObject("", "", "", "", "", "", "", false, 0);
        }
        this.checkYourSelfHelper(Root, 1);

    }

    private void checkYourSelfHelper(AddendumObject object, int Level) {
        if (object.nextAddendumObject == null) {
            object.nextAddendumObject = new AddendumObject("", "", "", "", "", "", "", false, Level);
        }
        if (object.Level <= 2) {
            Level += 1;
            this.checkYourSelfHelper(object.nextAddendumObject, Level);
        }
    }
}

class AddendumObject {
    public String line1 = "";
    public String line2 = "";
    public String line3 = "";
    public String line4 = "";
    public String pageNum = "";
    public String partNum = "";
    public String itemNum = "";
    public Boolean protectedAddendum = false;
    public AddendumObject nextAddendumObject;
    public int Level = 0;

    public AddendumObject(String line1, String line2, String line3, String line4, String pageNum, String
            partNum, String itemNum, Boolean protectedAddendum, int Level) {

        this.line1 = line1;
        this.line2 = line2;
        this.line3 = line3;
        this.line4 = line4;
        this.pageNum = pageNum;
        this.partNum = partNum;
        this.itemNum = itemNum;
        this.protectedAddendum = protectedAddendum;
        this.Level = Level;


    }
    public AddendumObject(String line1, String line2, String line3, String line4, String pageNum, String
            partNum, String itemNum, Boolean protectedAddendum, AddendumObject object) {

        this.line1 = line1;
        this.line2 = line2;
        this.line3 = line3;
        this.line4 = line4;
        this.pageNum = pageNum;
        this.partNum = partNum;
        this.itemNum = itemNum;
        this.protectedAddendum = protectedAddendum;
        this.nextAddendumObject = object;
    }
    public void clearCurrentObject() {
        this.line1 = "";
        this.line2 = "";
        this.line3 = "";
        this.line4 = "";
        this.pageNum = "";
        this.partNum = "";
        this.itemNum = "";
        this.protectedAddendum = false;
    }
}