package sample;

public class jobData {


    public String AddressStreet;
    public String AddressAddInfoAddress;
    public String AddressNumber;
    public String AddressCity;
    public String State;
    public String Zipcode;
    public String Country;
    public String Employer;
    public String Occupation;
    public DateValue StartDate;
    public DateValue EndDate;

    public sample.jobData next;

    public jobData(String AddressStreet, String AddressAddInfoAddress, String AddressNumber, String AddressCity, String State, String Zipcode, String Country, String Employer, String Occupation, DateValue StartDate, DateValue EndDate) {
        this.AddressStreet = AddressStreet;
        this.AddressAddInfoAddress = AddressAddInfoAddress;
        this.AddressNumber = AddressNumber;
        this.AddressCity = AddressCity;
        this.State = State;
        this.Zipcode = Zipcode;
        this.Country = Country;
        this.Occupation = Occupation;
        this.StartDate = StartDate;
        this.Employer = Employer;
        this.EndDate = EndDate;
    }

    public void display() {
        System.out.println(AddressStreet);
        System.out.println(AddressAddInfoAddress);
        System.out.println(AddressCity);
        System.out.println(State);
        System.out.println(Zipcode);
        System.out.println(Country);
        System.out.println(Occupation);
        System.out.println(StartDate);
        System.out.println(EndDate);
    }
}

