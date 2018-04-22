package sample;

import sample.jobData;
import sample.DateValue;

import com.sun.corba.se.spi.orbutil.threadpool.Work;
import com.sun.deploy.uitoolkit.impl.fx.HostServicesFactory;
import com.sun.javafx.application.HostServicesDelegate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.StageStyle;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.application.HostServices;

import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDCheckBox;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.pdfbox.tools.PDFMerger;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import static javafx.scene.effect.BlurType.GAUSSIAN;


public class Controller implements Initializable {

    @FXML
    public Button processButton;
    public TextField clientMiddleName;
    public TextField clientFamilyName;
    public TextField clientFirstName;
    public TextField clientANumber;
    public TextField clientSocialSecurity;
    public TextField clientBirthCity;
    public TextField clientBirthCountry;
    public TextField clientDOB;
    public CheckBox maleGender;
    public CheckBox femaleGender;
    public MenuItem pacific;
    public MenuItem amerindian;
    public MenuItem black;
    public MenuItem asian;
    public MenuItem white;
    public MenuItem latinoNo;
    public MenuItem latinoYes;
    public MenuItem asyleeBox;
    public MenuItem refugeeBox;
    public MenuItem paroleeBox;
    public MenuItem LPRBox;
    public TextField clientWeight;
    public TextField clientHeight;
    public TextField clientPhoneNum;
    public TextField clientEmail;
    public MenuButton hairColor;
    public MenuButton eyeColor;
    public MenuButton race;
    public MenuButton ethnicity;
    public MenuButton immigrationStatus;
    public TextField interpreterLanguage;
    public TextField interpreterFirstName;
    public TextField interpreterMiddleName;
    public TextField interpreterFamilyName;
    public TextField interpreterPhoneNumber;
    public TextField interpreterEmail;
    public TextField todayDate;
    public TextField countryMilitary;
    public TextField startDateMilitary;
    public TextField cityMilitary;
    public TextField endDateMilitary;
    public CheckBox welfarePast;
    public CheckBox welfarePresent;
    public TextField AddressCityTown;
    public TextField AddressStreetName;
    public TextField AddressNumber;
    public CheckBox AddressApt;
    public CheckBox AddressSte;
    public CheckBox AddressFlr;
    public TextField AddressState;
    public TextField AddressZipcode;
    public TextField AddressStartTime;
    public TextField AddressStreetName1;
    public TextField AddressNumber1;
    public CheckBox AddressApt1;
    public CheckBox AddressSte1;
    public TextField AddressCityTown1;
    public CheckBox AddressFlr1;
    public TextField AddressState1;
    public TextField AddressZipcode1;
    public TextField AddressCountry1;
    public TextField AddressStartTime1;
    public TextField AddressEndTime2;
    public TextField child1FamilyName;
    public TextField child1MiddleName;
    public TextField child1ANum;
    public TextField child1CountryOfBirth;
    public TextField child1FirstName;
    public TextField child1CityOfBirth;
    public TextField child2FamilyName;
    public TextField child2MiddleName;
    public TextField child2ANum;
    public TextField child2CountryOfBirth;
    public TextField child2FirstName;
    public TextField child2CityOfBirth;
    public TextField child3FamilyName;
    public TextField child3MiddleName;
    public TextField child3ANum;
    public TextField child3CountryOfBirth;
    public TextField child3FirstName;
    public TextField child3CityOfBirth;
    //public CheckBox childrenApplications;
    public TextField child1DOB;
    public TextField child2DOB;
    public TextField child3DOB;
    public CheckBox child1Apply;
    public CheckBox child2Apply;
    public CheckBox child3Apply;
    public AnchorPane mainWindow;
    public TextField AddressEndTime3;
    public CheckBox AddressApt2;
    public TextField AddressNumber2;
    public CheckBox AddressFlr2;
    public CheckBox AddressSte2;
    public TextField AddressStreetName2;
    public TextField AddressEndTime1;
    public TextField AddressStartTime2;
    public TextField AddressCountry2;
    public TextField AddressZipcode2;
    public TextField AddressState2;
    public TextField AddressCityTown2;
    public TextField jobAddressStreetName;
    public CheckBox jobAddressApt;
    public CheckBox jobAddressSte;
    public TextField jobAddressNumber;
    public CheckBox jobAddressFlr;
    public TextField jobAddressCityTown;
    public TextField jobAddressState;
    public TextField jobAddressZipcode;
    public TextField jobAddressStartTime;
    public TextField jobEmployer;
    public TextField jobAddressStreetName1;
    public CheckBox jobAddressApt1;
    public CheckBox jobAddressSte1;
    public CheckBox jobAddressFlr1;
    public TextField jobAddressCityTown1;
    public TextField jobAddressNumber1;
    public TextField jobAddressState1;
    public TextField jobAddressZipcode1;
    public TextField jobAddressCountry1;
    public TextField jobAddressStartTime1;
    public TextField jobAddressEndTime1;
    public TextField jobEmployer1;
    public TextField jobAddressStreetName2;
    public CheckBox jobAddressApt2;
    public CheckBox jobAddressSte2;
    public CheckBox jobAddressFlr2;
    public TextField jobAddressNumber2;
    public TextField jobAddressCityTown2;
    public TextField jobAddressState2;
    public TextField jobAddressZipcode2;
    public TextField jobAddressCountry2;
    public TextField jobAddressStartTime2;
    public TextField jobAddressEndTime2;
    public TextField jobEmployer2;
    public TextField jobAddressCountry;
    public TextField jobOccupation;
    public TextField jobOccupation1;
    public TextField jobOccupation2;
    public TextField jobAddressEndTime;
    public CheckBox child1Gender;
    public CheckBox child2Gender;
    public CheckBox child3Gender;
    public CheckBox SpouseApply;
    public CheckBox SpouseGender;
    public TextField SpouseDOB;
    public TextField SpouseCountryOfBirth;
    public TextField SpouseCityOfBirth;
    public TextField SpouseMiddleName;
    public TextField SpouseANum;
    public TextField SpouseFirstName;
    public TextField SpouseFamilyName;
    public CheckBox SpouseCoastGuard;
    public TextField SpouseMarriageDate;
    public TextField motherCurrentCity;
    public TextField motherCityOfBirth;
    public TextField motherCountryOfBirth;
    public TextField motherDOB;
    public TextField motherCurrentCountry;
    public TextField motherMiddleName;
    public TextField motherFirstName;
    public TextField motherFamilyName;
    public TextField fatherCurrentCountry;
    public TextField fatherCurrentCity;
    public TextField fatherDOB;
    public TextField fatherCountryOfBirth;
    public TextField fatherCityOfBirth;
    public TextField fatherMiddleName;
    public TextField fatherFirstName;
    public TextField fatherFamilyName;
    public TextField child4Info;
    public CheckBox child4Gender;
    public TextField child5Info;
    public CheckBox child5Gender;
    public TextField child6Info;
    public TextField child7Info;
    public CheckBox child6Gender;
    public CheckBox child7Gender;
    public TextField Spouse3Info;
    public TextField Spouse4Info;
    public TextField Spouse5Info;
    public TextField Spouse3MarriageDate;
    public TextField Spouse3DivorceDate;
    public TextField Spouse4MarriageDate;
    public TextField Spouse4DivorceDate;
    public TextField Spouse5MarriageDate;
    public TextField Spouse5DivorceDate;
    public TextField job4Info;
    public TextField Occupation7;
    public TextField Occupation6;
    public TextField Employer7;
    public TextField Employer6;
    public TextField Occupation5;
    public TextField Employer5;
    public TextField Occupation4;
    public TextField Employer4;
    public TextField Address7Info;
    public TextField Address6Info;
    public TextField Address5Info;
    public TextField Address4Info;
    public TextField job7Info;
    public TextField job6Info;
    public TextField job5Info;
    public TextField Spouse2Info;
    public TextField Spouse2MarriageDate;
    public TextField Spouse2DivorceDate;
    public CheckBox Widow;
    public TextField clientFamilyName1;
    public TextField clientFirstName1;
    public TextField clientMiddleName1;
    public TextField clientFamilyName3;
    public TextField clientFirstName3;
    public TextField clientMiddleName3;
    public TextField clientFamilyName2;
    public TextField clientFirstName2;
    public TextField clientMiddleName2;
    public Button closeButton;
    public TextField clientPassport;
    public TextField clientTravelDoc;
    public TextField documentCountry;
    public TextField clientPort;
    public TextField clientI94Number;
    public TextField clientI94Status;
    public TextField clientPortState;
    public TextField clientPortState1;
    public TextField clientI94Expiration;
    public TextField documentExpiration;
    public TextField clientPortDate;
    public Button buttonI90;
    public Button buttonI485;
    public Button buttonI765;
    public TextField Employer3;
    public TextField Occupation3;
    public TextField jobAddressStartTime3;
    public TextField jobAddressEndTime3;
    public TextField jobAddressStartTime4;
    public TextField jobAddressEndTime4;
    public TextField jobAddressStartTime5;
    public TextField jobAddressEndTime5;
    public TextField jobAddressStartTime6;
    public TextField jobAddressEndTime6;
    public TextField AddressStartTime3;
    public TextField AddressStartTime4;
    public TextField AddressStartTime5;
    public TextField AddressEndTime5;
    public TextField AddressEndTime4;
    public TextField AddressStartTime6;
    public TextField AddressEndTime6;
    public TextField Address3Info;
    public TextField job3Info;
    public TextField Spouse1Info;
    public TextField Spouse1DivorceDate;
    public TextField Spouse1MarriageDate;
    public TextField ClientC1FamilyName1;
    public TextField ClientC1MiddleName1;
    public TextField ClientC1FirstName1;
    public TextField ClientC1Weight;
    public TextField ClientC1Height;
    public MenuButton ClientC1Ethnicity;
    public MenuButton ClientC1Race;
    public MenuButton ClientC1EyeColor;
    public MenuButton ClientC1HairColor;
    public MenuItem C1latinoYes;
    public MenuItem C1latinoNo;
    public MenuItem C1white;
    public MenuItem C1asian;
    public MenuItem C1black;
    public MenuItem C1amerindian;
    public MenuItem C1pacific;
    public MenuButton ClientC1Parent;
    public MenuItem Spouse1Select;
    public MenuItem Spouse2Select;
    public MenuItem Spouse3Select;
    public MenuItem Spouse4Select;
    public TextField ClientC2FamilyName1;
    public MenuItem Spouse5Select;
    public MenuButton ClientC2Parent;
    public MenuButton ClientC2HairColor;
    public MenuButton ClientC2EyeColor;
    public MenuItem C2pacific;
    public MenuItem C2amerindian;
    public MenuItem C2black;
    public MenuItem C2asian;
    public MenuItem C2white;
    public MenuButton ClientC2Race;
    public MenuItem C2latinoNo;
    public MenuItem C2latinoYes;
    public MenuButton ClientC2Ethnicity;
    public TextField ClientC2Height;
    public TextField ClientC2Weight;
    public TextField ClientC2MiddleName1;
    public TextField ClientC2FirstName1;
    public TextField ClientC3FamilyName1;
    public TextField ClientC3FirstName1;
    public TextField ClientC3MiddleName1;
    public TextField ClientC3Weight;
    public TextField ClientC3Height;
    public MenuButton ClientC3Ethnicity;
    public MenuItem C3latinoYes;
    public MenuItem C3latinoNo;
    public MenuButton ClientC3Race;
    public MenuButton ClientC3EyeColor;
    public MenuButton ClientC3HairColor;
    public MenuButton ClientC3Parent;
    public TextField SpouseCityOfMarriage;
    public TextField SpouseMarriageCountry;
    public CheckBox C1Female;
    public CheckBox C2Female;
    public CheckBox C3Female;
    public CheckBox C4Female;
    public CheckBox C5Female;
    public CheckBox C6Female;
    public CheckBox C7Female;
    public CheckBox SpouseFemale;
    public CheckBox jobUnemployed;
    public CheckBox jobUnemployed1;
    public CheckBox jobUnemployed2;
    public Button minimizeButton;
    public AnchorPane mainMenu;
    public AnchorPane AddressMenu;
    public AnchorPane topBar;
    public Button addressButton;
    public Button mainOptionsButton;
    public MenuItem male;
    public MenuItem female;
    public MenuButton sex;
    public Button miscButton;
    public AnchorPane miscMenu;
    public Button marriageButton;
    public AnchorPane marriageMenu;
    public Text fileShow;
    public Button employmentButton;
    public Button childrenButton;
    public Button addButton;
    public AnchorPane childrenMenu;
    public AnchorPane employmentMenu;
    public AnchorPane addMenu;
    public AnchorPane parentsMenu;
    public Button parentButton;

    private Stage stage;

    static String ANum = new String();
    static String ANumChildren = ANum;
    String FamilyName = new String();
    String FirstName = new String();
    String MiddleName = new String();
    static String FamilyName1 = new String();
    static String FirstName1 = new String();
    static String MiddleName1 = new String();
    static String FamilyName2 = new String();
    static String FirstName2 = new String();
    static String MiddleName2 = new String();
    static String FamilyName3 = new String();
    static String FirstName3 = new String();
    static String MiddleName3 = new String();
    String Name = new String();
    String CityBirth = new String();
    DateValue DOBDate = new DateValue("");
    String CountryBirth = new String();
    String Nationality = new String();
    String SocialSecurity = new String();
    String AddressStreet = new String();
    String AddInfoAddress = new String();
    String AddressCity = new String();
    String State = new String();
    String Zipcode = new String();
    String PassportNum = new String();
    String TravelNum = new String();
    DateValue ExpirationDate = new DateValue("");
    String PassportCountry = new String();
    String EntryCity = new String();
    String EntryState = new String();
    DateValue LastArrivalDate = new DateValue("");
    String I94Num = new String();
    DateValue ExpirationDate1 = new DateValue("");
    String I94Status = new String();
    String CurrentImmigrationStatus = new String();
    String I94FamilyName = new String();
    String I94FirstName = new String();
    String I94MiddleName = new String();
    DateValue StartDate = new DateValue("");
    DateValue EndDate = new DateValue("");
    String AddressStreet1 = new String();
    String AddInfoAddress1 = new String();
    String AddressCity1 = new String();
    String State1 = new String();
    String Zipcode1 = new String();
    String Country1 = new String();
    DateValue StartDate1 = new DateValue("");
    DateValue EndDate1 = new DateValue("");
    String AddressStreet2 = new String();
    String AddInfoAddress2 = new String();
    String AddressCity2 = new String();
    String State2 = new String();
    String Zipcode2 = new String();
    String Country2 = new String();
    DateValue StartDate2 = new DateValue("");
    DateValue EndDate2 = new DateValue("");
    String Employer = new String();
    String WorkAddressStreet = new String();
    String WorkAddInfoAddress = new String();
    String WorkAddressCity = new String();
    String WorkState = new String();
    String WorkZipcode = new String();
    String WorkCountry = new String();
    String WorkOccupation = new String();
    DateValue WorkStartDate = new DateValue("");
    DateValue WorkEndDate = new DateValue("");
    String Employer1 = new String();
    String WorkAddressStreet1 = new String();
    String WorkAddInfoAddress1 = new String();
    String WorkAddressCity1 = new String();
    String WorkState1 = new String();
    String WorkZipcode1 = new String();
    String WorkCountry1 = new String();
    String WorkOccupation1 = new String();
    DateValue WorkStartDate1 = new DateValue("");
    DateValue WorkEndDate1 = new DateValue("");
    String Employer2 = new String();
    String WorkAddressStreet2 = new String();
    String WorkAddInfoAddress2 = new String();
    String WorkAddressCity2 = new String();
    String WorkState2 = new String();
    String WorkZipcode2 = new String();
    String WorkCountry2 = new String();
    String WorkOccupation2 = new String();
    DateValue WorkStartDate2 = new DateValue("");
    DateValue WorkEndDate2 = new DateValue("");
    String FFamilyName = new String();
    String FFirstName = new String();
    String FMiddleName = new String();
    String FFamilyNameB = new String();
    String FFirstNameB = new String();
    String FMiddleNameB = new String();
    DateValue FDOB = new DateValue("");
    String FCityBirth = new String();
    String FCountryBirth = new String();
    String FCityCurrent = new String();
    String FCountryCurrent = new String();
    String MFamilyName = new String();
    String MFirstName = new String();
    String MMiddleName = new String();
    String MFamilyNameB = new String();
    String MFirstNameB = new String();
    String MMiddleNameB = new String();
    DateValue MDOB = new DateValue("");
    String MCityBirth = new String();
    String MCountryBirth = new String();
    String MCityCurrent = new String();
    String MCountryCurrent = new String();
    String MarriageNum = new String();
    String SFamilyName = new String();
    String SMiddleName = new String();
    String SFirstName = new String();
    String SANum = new String();
    DateValue SDOBDate = new DateValue("");
    String SMarriageDate = new String();
    String SCityBirth = new String();
    String SCountryBirth = new String();
    String DFamilyName = new String();
    String DFirstName = new String();
    String DMiddleName = new String();
    DateValue DDOBDate = new DateValue("");
    DateValue DMarriageDate = new DateValue("");
    String DCityMarriage = new String();
    String DStateMarriage = new String();
    DateValue DMarriageEndDate = new DateValue("");
    String SCityEnd = new String();
    String SStateEnd = new String();
    String SCountryEnd = new String();
    String SCityMarriage = new String();
    String SCountryMarriage = new String();
    String ChildNum = new String();
    String C1FamilyName = new String();
    String C1MiddleName = new String();
    String C1FirstName = new String();
    String C1ANum = new String();
    DateValue C1DOBDate = new DateValue("");
    DateValue C1MarriageDate = new DateValue("");
    String C1CityBirth = new String();
    String C1CountryBirth = new String();
    String C2FamilyName = new String();
    String C2MiddleName = new String();
    String C2FirstName = new String();
    String C2ANum = new String();
    DateValue C2DOBDate = new DateValue("");
    DateValue C2MarriageDate = new DateValue("");
    String C2CityBirth = new String();
    String C2CountryBirth = new String();
    String C3FamilyName = new String();
    String C3MiddleName = new String();
    String C3FirstName = new String();
    String C3ANum = new String();
    DateValue C3DOBDate = new DateValue("");
    DateValue C3MarriageDate = new DateValue("");
    String C3CityBirth = new String();
    String C3CountryBirth = new String();
    String Feet = new String();
    String Inches = new String();
    String PD1 = new String();
    String PD2 = new String();
    String PD3 = new String();
    String NameOrganization = new String();
    String CityOrganization = new String();
    String StateOrganization = new String();
    String CountryOrganization = new String();
    String NatureOrganization = new String();
    DateValue OrganizationStartDate = new DateValue("");
    DateValue OrganizationEndDate = new DateValue("");
    String NameOrganization1 = new String();
    String CityOrganization1 = new String();
    String StateOrganization1 = new String();
    String CountryOrganization1 = new String();
    String NatureOrganization1 = new String();
    DateValue OrganizationStartDate1 = new DateValue("");
    DateValue OrganizationEndDate1 = new DateValue("");
    String NameOrganization2 = new String();
    String CityOrganization2 = new String();
    String StateOrganization2 = new String();
    String CountryOrganization2 = new String();
    String NatureOrganization2 = new String();
    DateValue OrganizationStartDate2 = new DateValue("");
    DateValue OrganizationEndDate2 = new DateValue("");
    String ADayTimeNum = new String();
    String AMobNum = new String();
    String AEmail = new String();
    DateValue SignatureDate = new DateValue("");
    String IFamilyName = new String();
    String IMiddleName = new String();
    String IFirstName = new String();
    String IOrganizationName = new String();
    String IAddressStreet = new String();
    String IAddInfoAddress = new String();
    String IAddressCity = new String();
    String IState = new String();
    String IZipcode = new String();
    String ICountry = new String();
    String IDayTimeNum = new String();
    String IMobNum = new String();
    String IEmail = new String();
    String Language = new String();
    String PFamilyName = new String();
    String PFirstName = new String();
    String POrganizationName = new String();
    String PAddressStreet = new String();
    String PAddInfoAddress = new String();
    String PAddressCity = new String();
    String PState = new String();
    String PZipcode = new String();
    String PDayTimeNum = new String();
    String PMobNum = new String();
    String PEmail = new String();
    String PN = new String();
    String PaN = new String();
    String IN = new String();
    String AddendumA = new String();
    String AddendumB = new String();
    String AddendumC = new String();
    String AddendumD = new String();
    String AddendumE = new String();
    String AddendumF = new String();
    String AddendumG = new String();
    String AddendumH = new String();
    String AddendumI = new String();
    String AddendumJ = new String();
    String PN1 = new String();
    String PaN1 = new String();
    String IN1 = new String();
    String Addendum1A = new String();
    String Addendum1B = new String();
    String Addendum1C = new String();
    String Addendum1D = new String();
    String Addendum1E = new String();
    String Addendum1F = new String();
    String Addendum1G = new String();
    String Addendum1H = new String();
    String Addendum1I = new String();
    String Addendum1J = new String();
    String PN2 = new String();
    String PaN2 = new String();
    String IN2 = new String();
    String Addendum2A = new String();
    String Addendum2B = new String();
    String Addendum2C = new String();
    String Addendum2D = new String();
    String Addendum2E = new String();
    String Addendum2F = new String();
    String Addendum2G = new String();
    String Addendum2H = new String();
    String Addendum2I = new String();
    String Addendum2J = new String();
    String PN3 = new String();
    String PaN3 = new String();
    String IN3 = new String();
    String Addendum3A = new String();
    String Addendum3B = new String();
    String Addendum3C = new String();
    String Addendum3D = new String();
    String Addendum3E = new String();
    String Addendum3F = new String();
    String Addendum3G = new String();
    String Addendum3H = new String();
    String Addendum3I = new String();
    String PN4 = new String();
    String PaN4 = new String();
    String IN4 = new String();
    String Addendum4A = new String();
    String Addendum4B = new String();
    String Addendum4C = new String();
    String Addendum4D = new String();
    String Addendum4E = new String();
    String Addendum4F = new String();
    String Addendum4G = new String();
    String Addendum4H = new String();
    String Addendum4I = new String();
    String Addendum4J = new String();
    String EntryInspectionStatus = new String();
    String EntryParoledStatus = new String();
    String OtherStatus = new String();
    String EntryI765 = new String();


    String AGender = "";
    String TenantInfo = "";
    String AltTenantInfo = "";
    String lastArrived = "";
    String ImmigrationStatus = "";
    String TenantInfo1 = "";
    String TenantInfo2 = "";
    String ETenantInfo = "";
    String ETenantInfo1 = "";
    String ETenantInfo2 = "";
    String MaritalStatus = "";
    String USGuard = "";
    String SApply = "";
    String C1status = "";
    String C2status = "";
    String C3status = "";
    String C4status = "";
    String C5status = "";
    String C6status = "";
    String C7status = "";
    static String Ethnicity = "";
    static String Race = "";
    static String EyeColor = "";
    static String HairColor = "";
    String OrgAnswer = "";
    String DisabilityAnswer = "";
    String InterpreterQuestion = "";
    String ITenantInfo = "";
    String PTenantInfo = "";
    String Q49 = "";
    String Q55 = "";
    String Q61 = "";
    String Q62 = "";
    String fileType = "i-485";
    String SocialSecurityBox = "";

    static String C1Gender = new String();
    static String C1FamilyName1 = new String();
    static String C1FirstName1 = new String();
    static String C1MiddleName1 = new String();
    static String C1PD1 = new String();
    static String C1PD2 = new String();
    static String C1PD3 = new String();
    static String C1Feet = new String();
    static String C1Inches = new String();
    static String C1Ethnicity = new String();
    static String C1Race = new String();
    static String C1HairColor = new String();
    static String C1EyeColor = new String();
    static String C1Weight = new String();
    static String C1Height = new String();
    static String C2Gender = new String();
    static String C2FamilyName1 = new String();
    static String C2FirstName1 = new String();
    static String C2MiddleName1 = new String();
    static String C2PD1 = new String();
    static String C2PD2 = new String();
    static String C2PD3 = new String();
    static String C2Feet = new String();
    static String C2Inches = new String();
    static String C2Ethnicity = new String();
    static String C2Race = new String();
    static String C2HairColor = new String();
    static String C2EyeColor = new String();
    static String C2Weight = new String();
    static String C2Height = new String();
    static String C3Gender = new String();
    static String C3FamilyName1 = new String();
    static String C3FirstName1 = new String();
    static String C3MiddleName1 = new String();
    static String C3PD1 = new String();
    static String C3PD2 = new String();
    static String C3PD3 = new String();
    static String C3Feet = new String();
    static String C3Inches = new String();
    static String C3Ethnicity = new String();
    static String C3Race = new String();
    static String C3HairColor = new String();
    static String C3EyeColor = new String();
    static String C3Weight = new String();
    static String C3Height = new String();
    static String SGender = new String();

    static String hairIdentifier = new String();
    static String eyeIdentifier = new String();
    static String C1SpouseNumber = new String();
    static String C2SpouseNumber = new String();
    static String C3SpouseNumber = new String();
    static String C4SpouseNumber = new String();
    static String C5SpouseNumber = new String();

    Boolean C1Files = false;
    Boolean C2Files = false;
    Boolean C3Files = false;
    Boolean protectAdd = false;
    Boolean protectAdd1 = false;
    Boolean needAddendum = false;

    String[] CNameList = new String[9];
    String[] CANumList = new String[3];
    String[] CGenderList = new String[3];
    String[] CDOBList = new String[3];
    String[] CCountryList = new String[3];
    Boolean[] CApplyList = new Boolean[3];

    String[] C4Info = new String[7];
    String[] C5Info = new String[7];
    String[] C6Info = new String[7];
    String[] C7Info = new String[7];

    String[] A3Info = new String[7];
    String[] A4Info = new String[7];
    String[] A5Info = new String[7];
    String[] A6Info = new String[7];

    String[] E3Info = new String[9];
    String[] E4Info = new String[9];
    String[] E5Info = new String[9];
    String[] E6Info = new String[9];

    String[] S1Info = new String[9];
    String[] S2Info = new String[9];
    String[] S3Info = new String[9];
    String[] S4Info = new String[9];

    static int CheckNum = 0;
    static int fileIteration = 0;

    String[] ethnicityArray = {"","","IRAQ","IRAQI","JORDAN","JORDANIAN","SYRIA","SYRIAN","CUBA","CUBAN","TURKEY","TURKISH","DEM REP OF CONGO","CONGOLESE","DEMOCRATIC REPUBLIC OF CONGO","CONGOLESE","NIGER","NIGERIEN","NIGERIA","NIGERIAN","IRAN","IRANIAN","AFGHANISTAN","AFGHAN","PAKISTAN","PAKISTANI","LEBANON","LEBANESE","JORDAN","JORDANIAN","YEMEN","YEMENI","HONDURAS","HONDURAN","EL SALVADOR","SALVADORAN",};

    static String C4FamilyName = "";
    static String C4FirstName = "";
    static String C4MiddleName = "";
    static String C4ANum = "";
    static DateValue C4DOBDate = new DateValue("");
    static String C4CountryBirth;
    static String C5FamilyName = "";
    static String C5FirstName = "";
    static String C5MiddleName = "";
    static String C5ANum = "";
    static DateValue C5DOBDate = new DateValue("");
    static String C5CountryBirth = "";
    static String C6FamilyName = "";
    static String C6FirstName = "";
    static String C6MiddleName = "";
    static String C6ANum = "";
    static DateValue C6DOBDate = new DateValue("");
    static String C6CountryBirth = "";
    static String C7FamilyName = "";
    static String C7FirstName = "";
    static String C7MiddleName = "";
    static String C7ANum = "";
    static DateValue C7DOBDate = new DateValue("");
    static String C7CountryBirth = "";

    static String AddressStreet3 = "";
    static String AddInfoAddress3 = "";
    static String AddressCity3 = "";
    static String State3 = "";
    static String Zipcode3 = "";
    static String Country3 = "";
    static DateValue StartDate3 = new DateValue("");
    static DateValue EndDate3 = new DateValue("");

    static jobData WorkInfoEntry = new jobData();
    static String methodAddressStreet = "";
    static String methodAddressAddInfo = "";
    static String methodAddressNumber = "";
    static String methodAddressCity = "";
    static String methodState = "";
    static String methodZipcode = "";
    static String methodCountry = "";
    static String methodEmployer = "";
    static String methodOccupation = "";
    static String methodAddressStreet1 = "";
    static String methodAddressAddInfo1 = "";
    static String methodAddressNumber1 = "";
    static String methodAddressCity1 = "";
    static String methodState1 = "";
    static String methodZipcode1 = "";
    static String methodCountry1 = "";
    static String methodEmployer1 = "";
    static String methodOccupation1 = "";
    static String methodAddressStreet2 = "";
    static String methodAddressAddInfo2 = "";
    static String methodAddressNumber2 = "";
    static String methodAddressCity2 = "";
    static String methodState2 = "";
    static String methodZipcode2 = "";
    static String methodCountry2 = "";
    static String methodEmployer2 = "";
    static String methodOccupation2 = "";




    @Override

    @FXML
    public void initialize(URL location, ResourceBundle resources) {

        try { ShowNameVars(); }
        catch (Exception ex) { }
        try { ShowC1InfoVars(); }
        catch (Exception ex) { }
        try { ShowC2InfoVars(); }
        catch (Exception ex) { }
        try { ShowC3InfoVars(); }
        catch (Exception ex) { }
        try { mainOptionsButton.getStyleClass().add("menuButtonChangeSelected"); }
        catch (Exception ex) { }
        try { buttonI485.setStyle("-fx-background-color: " + pressedColor + ";"); }
        catch (Exception ex) { }
        try {
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            Date date = new Date();
            String TEMPORARYDATE = dateFormat.format(date);
            todayDate.setText(TEMPORARYDATE);
        }
        catch (Exception ex) { }

    }

    private BorderPane mainLayout;

    //private Stage primaryStage;
    @FXML
    public void main(String[] args) {
    }


    String pressedColor = "#1570c0";
    String normalColor = "#2196f3";

    public void i90Select(ActionEvent event) {
        fileType = "i-90";
        buttonI90.setStyle("-fx-background-color: " + pressedColor + ";");
        buttonI485.setStyle("-fx-background-color: " + normalColor + ";");
        buttonI765.setStyle("-fx-background-color: " + normalColor + ";");
        fileShow.setText(" I-90");
    }

    public void i485Select(ActionEvent event) {
        fileType = "i-485";
        buttonI90.setStyle("-fx-background-color: " + normalColor + ";");
        buttonI485.setStyle("-fx-background-color: " + pressedColor + ";");
        buttonI765.setStyle("-fx-background-color: " + normalColor + ";");
        fileShow.setText("I-485");
    }

    public void i765Select(ActionEvent event) {
        fileType = "i-765";
        buttonI90.setStyle("-fx-background-color: " + normalColor + ";");
        buttonI485.setStyle("-fx-background-color: " + normalColor + ";");
        buttonI765.setStyle("-fx-background-color: " + pressedColor + ";");
        fileShow.setText("I-765");
    }
    public void goMainMenu(ActionEvent event) {
        addressButton.getStyleClass().remove("menuButtonChangeSelected");
        miscButton.getStyleClass().remove("menuButtonChangeSelected");
        childrenButton.getStyleClass().remove("menuButtonChangeSelected");
        marriageButton.getStyleClass().remove("menuButtonChangeSelected");
        addButton.getStyleClass().remove("menuButtonChangeSelected");
        employmentButton.getStyleClass().remove("menuButtonChangeSelected");
        parentButton.getStyleClass().remove("menuButtonChangeSelected");
        if (!mainOptionsButton.getStyleClass().contains("menuButtonChangeSelected")) {
            mainOptionsButton.getStyleClass().add("menuButtonChangeSelected");
        }
        mainMenu.toFront();
        topBar.toFront();

    }
    public void goMarriageMenu(ActionEvent event) {
        addressButton.getStyleClass().remove("menuButtonChangeSelected");
        childrenButton.getStyleClass().remove("menuButtonChangeSelected");
        mainOptionsButton.getStyleClass().remove("menuButtonChangeSelected");
        employmentButton.getStyleClass().remove("menuButtonChangeSelected");
        addButton.getStyleClass().remove("menuButtonChangeSelected");
        parentButton.getStyleClass().remove("menuButtonChangeSelected");
        if (!marriageButton.getStyleClass().contains("menuButtonChangeSelected")) {
            marriageButton.getStyleClass().add("menuButtonChangeSelected");
        }
        miscButton.getStyleClass().remove("menuButtonChangeSelected");
        marriageMenu.toFront();
        topBar.toFront();

    }
    public void goMiscMenu(ActionEvent event) {
        addressButton.getStyleClass().remove("menuButtonChangeSelected");
        mainOptionsButton.getStyleClass().remove("menuButtonChangeSelected");
        marriageButton.getStyleClass().remove("menuButtonChangeSelected");
        childrenButton.getStyleClass().remove("menuButtonChangeSelected");
        addButton.getStyleClass().remove("menuButtonChangeSelected");
        employmentButton.getStyleClass().remove("menuButtonChangeSelected");
        parentButton.getStyleClass().remove("menuButtonChangeSelected");
        if (!miscButton.getStyleClass().contains("menuButtonChangeSelected")) {
            miscButton.getStyleClass().add("menuButtonChangeSelected");
        }
        miscMenu.toFront();
        topBar.toFront();

    }
    public void goAddressMenu(ActionEvent event) {
        if (!addressButton.getStyleClass().contains("menuButtonChangeSelected")) {
            addressButton.getStyleClass().add("menuButtonChangeSelected");
        }
        mainOptionsButton.getStyleClass().remove("menuButtonChangeSelected");
        miscButton.getStyleClass().remove("menuButtonChangeSelected");
        marriageButton.getStyleClass().remove("menuButtonChangeSelected");
        childrenButton.getStyleClass().remove("menuButtonChangeSelected");
        employmentButton.getStyleClass().remove("menuButtonChangeSelected");
        addButton.getStyleClass().remove("menuButtonChangeSelected");
        parentButton.getStyleClass().remove("menuButtonChangeSelected");
        AddressMenu.toFront();
        topBar.toFront();
    }
    public void goChildrenMenu(ActionEvent event) {
        addressButton.getStyleClass().remove("menuButtonChangeSelected");
        mainOptionsButton.getStyleClass().remove("menuButtonChangeSelected");
        marriageButton.getStyleClass().remove("menuButtonChangeSelected");
        miscButton.getStyleClass().remove("menuButtonChangeSelected");
        employmentButton.getStyleClass().remove("menuButtonChangeSelected");
        addButton.getStyleClass().remove("menuButtonChangeSelected");
        parentButton.getStyleClass().remove("menuButtonChangeSelected");
        if (!childrenButton.getStyleClass().contains("menuButtonChangeSelected")) {
            childrenButton.getStyleClass().add("menuButtonChangeSelected");
        }
        childrenMenu.toFront();
        topBar.toFront();

    }
    public void goEmploymentMenu(ActionEvent event) {
        addressButton.getStyleClass().remove("menuButtonChangeSelected");
        mainOptionsButton.getStyleClass().remove("menuButtonChangeSelected");
        marriageButton.getStyleClass().remove("menuButtonChangeSelected");
        childrenButton.getStyleClass().remove("menuButtonChangeSelected");
        addButton.getStyleClass().remove("menuButtonChangeSelected");
        miscButton.getStyleClass().remove("menuButtonChangeSelected");
        parentButton.getStyleClass().remove("menuButtonChangeSelected");
        if (!employmentButton.getStyleClass().contains("menuButtonChangeSelected")) {
            employmentButton.getStyleClass().add("menuButtonChangeSelected");
        }
        employmentMenu.toFront();
        topBar.toFront();

    }
    public void goAddMenu(ActionEvent event) {
        addressButton.getStyleClass().remove("menuButtonChangeSelected");
        mainOptionsButton.getStyleClass().remove("menuButtonChangeSelected");
        marriageButton.getStyleClass().remove("menuButtonChangeSelected");
        childrenButton.getStyleClass().remove("menuButtonChangeSelected");
        employmentButton.getStyleClass().remove("menuButtonChangeSelected");
        miscButton.getStyleClass().remove("menuButtonChangeSelected");
        parentButton.getStyleClass().remove("menuButtonChangeSelected");
        if (!addButton.getStyleClass().contains("menuButtonChangeSelected")) {
            addButton.getStyleClass().add("menuButtonChangeSelected");
        }
        addMenu.toFront();
        topBar.toFront();

    }
    public void goParentMenu(ActionEvent event) {
        addressButton.getStyleClass().remove("menuButtonChangeSelected");
        mainOptionsButton.getStyleClass().remove("menuButtonChangeSelected");
        marriageButton.getStyleClass().remove("menuButtonChangeSelected");
        childrenButton.getStyleClass().remove("menuButtonChangeSelected");
        employmentButton.getStyleClass().remove("menuButtonChangeSelected");
        miscButton.getStyleClass().remove("menuButtonChangeSelected");
        addButton.getStyleClass().remove("menuButtonChangeSelected");
        if (!parentButton.getStyleClass().contains("menuButtonChangeSelected")) {
            parentButton.getStyleClass().add("menuButtonChangeSelected");
        }
        parentsMenu.toFront();
        topBar.toFront();

    }
    public void asyleeSelect(ActionEvent event) {
        ImmigrationStatus = "Asylum";
        immigrationStatus.setText("Asylum Seeker");
        lastArrived = "NoStatus";
        EntryI765 = "Asylum Seeker";
    }

    public void refugeeSelect(ActionEvent event) {
        ImmigrationStatus = "Refugee";
        immigrationStatus.setText("Refugee");
        EntryInspectionStatus = "";
        EntryParoledStatus = "";
        OtherStatus = "Refugee";
        EntryI765 = "Refugee";
        lastArrived = "Other";
    }

    public void paroleeSelect(ActionEvent event) {
        ImmigrationStatus = "Cuban1";
        immigrationStatus.setText("Parolee");
        lastArrived = "EntryParoled";
        EntryInspectionStatus = "";
        EntryParoledStatus = "Cuban Parole";
        EntryI765 = "Cuban Parole";
        OtherStatus = "";
        I94Status = "Paroled";
    }

    public void yesLatinoSelect(ActionEvent event) {
        Ethnicity = "Hispanic-yes";
        ethnicity.setText("Latino");
    }

    public void noLatinoSelect(ActionEvent event) {
        Ethnicity = "Hispanic-no";
        ethnicity.setText("Not Latino");
    }

    public void asianSelect(ActionEvent event) {
        Race = "Asian";
        race.setText("Asian");
    }

    public void whiteSelect(ActionEvent event) {
        Race = "White";
        race.setText("White");
    }

    public void blackSelect(ActionEvent event) {
        Race = "Black";
        race.setText("Black");
    }

    public void amerindianSelect(ActionEvent event) {
        Race = "Amerindian";
        race.setText("Amerindian");
    }

    public void pacificSelect(ActionEvent event) {
        Race = "Hawaii";
        race.setText("Pacific Islander");
    }

    public void baldHairSelect(ActionEvent event) {
        HairColor = "Bald";
        hairColor.setText("Bald");
    }

    public void brownHairSelect(ActionEvent event) {
        HairColor = "BrownHair";
        hairColor.setText("Brown");
    }

    public void sandyHairSelect(ActionEvent event) {
        HairColor = "SandyHair";
        hairColor.setText("Sandy");
    }

    public void blackHairSelect(ActionEvent event) {
        HairColor = "BlackHair";
        hairColor.setText("Black");
    }

    public void grayHairSelect(ActionEvent event) {
        HairColor = "GrayHair";
        hairColor.setText("Gray");
    }

    public void whiteHairSelect(ActionEvent event) {
        HairColor = "WhiteHair";
        hairColor.setText("White");
    }

    public void blondHairSelect(ActionEvent event) {
        HairColor = "BlondHair";
        hairColor.setText("Blond");
    }

    public void redHairSelect(ActionEvent event) {
        HairColor = "RedHair";
        hairColor.setText("Red");
    }

    public void unknownHairSelect(ActionEvent event) {
        HairColor = "UnknownHair";
        hairColor.setText("Other");
    }

    public void blueEyesSelect(ActionEvent event) {
        EyeColor = "BlueEyes";
        eyeColor.setText("Blue");
    }

    public void maroonEyesSelect(ActionEvent event) {
        EyeColor = "MaroonEyes";
        eyeColor.setText("Maroon");
    }

    public void greenEyesSelect(ActionEvent event) {
        EyeColor = "GreenEyes";
        eyeColor.setText("Green");
    }

    public void blackEyesSelect(ActionEvent event) {
        EyeColor = "BlackEyes";
        eyeColor.setText("Black");
    }

    public void grayEyesSelect(ActionEvent event) {
        EyeColor = "GrayEyes";
        eyeColor.setText("Gray");
    }

    public void pinkEyesSelect(ActionEvent event) {
        EyeColor = "PinkEyes";
        eyeColor.setText("Pink");
    }

    public void brownEyesSelect(ActionEvent event) {
        EyeColor = "BrownEyes";
        eyeColor.setText("Brown");
    }

    public void hazelEyesSelect(ActionEvent event) {
        EyeColor = "HazelEyes";
        eyeColor.setText("Hazel");
    }

    public void unknownEyesSelect(ActionEvent event) {
        EyeColor = "UnknownEyes";
        eyeColor.setText("Other");
    }
    public void C1yesLatinoSelect(ActionEvent event) {
        C1Ethnicity = "Hispanic-yes";
        ClientC1Ethnicity.setText("Latino");
    }

    public void C1noLatinoSelect(ActionEvent event) {
        C1Ethnicity = "Hispanic-no";
        ClientC1Ethnicity.setText("Not Latino");
    }

    public void C1asianSelect(ActionEvent event) {
        C1Race = "Asian";
        ClientC1Race.setText("Asian");
    }

    public void C1whiteSelect(ActionEvent event) {
        C1Race = "White";
        ClientC1Race.setText("White");
    }

    public void C1blackSelect(ActionEvent event) {
        C1Race = "Black";
        ClientC1Race.setText("Black");
    }

    public void C1amerindianSelect(ActionEvent event) {
        C1Race = "Amerindian";
        ClientC1Race.setText("Amerindian");
    }

    public void C1pacificSelect(ActionEvent event) {
        C1Race = "Hawaii";
        ClientC1Race.setText("Pacific Islander");
    }

    public void C1baldHairSelect(ActionEvent event) {
        C1HairColor = "Bald";
        ClientC1HairColor.setText("Bald");
        hairIdentifier = "Bald";
    }

    public void C1brownHairSelect(ActionEvent event) {
        C1HairColor = "BrownHair";
        ClientC1HairColor.setText("Brown");
        hairIdentifier = "Brown";
    }

    public void C1sandyHairSelect(ActionEvent event) {
        C1HairColor = "SandyHair";
        ClientC1HairColor.setText("Sandy");
        hairIdentifier = "Sandy";
    }

    public void C1blackHairSelect(ActionEvent event) {
        C1HairColor = "BlackHair";
        ClientC1HairColor.setText("Black");
        hairIdentifier = "Black";
    }

    public void C1grayHairSelect(ActionEvent event) {
        C1HairColor = "GrayHair";
        ClientC1HairColor.setText("Gray");
        hairIdentifier = "Gray";
    }

    public void C1whiteHairSelect(ActionEvent event) {
        C1HairColor = "WhiteHair";
        ClientC1HairColor.setText("White");
        hairIdentifier = "White";
    }

    public void C1blondHairSelect(ActionEvent event) {
        C1HairColor = "BlondHair";
        ClientC1HairColor.setText("Blond");
        hairIdentifier = "Blond";
    }

    public void C1redHairSelect(ActionEvent event) {
        C1HairColor = "RedHair";
        ClientC1HairColor.setText("Red");
        hairIdentifier = "Red";
    }

    public void C1unknownHairSelect(ActionEvent event) {
        C1HairColor = "UnknownHair";
        ClientC1HairColor.setText("Other");
        hairIdentifier = "Other";
    }

    public void C1blueEyesSelect(ActionEvent event) {
        C1EyeColor = "BlueEyes";
        ClientC1EyeColor.setText("Blue");
        eyeIdentifier = "Blue";
    }

    public void C1maroonEyesSelect(ActionEvent event) {
        C1EyeColor = "MaroonEyes";
        ClientC1EyeColor.setText("Maroon");
        eyeIdentifier = "Maroon";
    }

    public void C1greenEyesSelect(ActionEvent event) {
        C1EyeColor = "GreenEyes";
        ClientC1EyeColor.setText("Green");
        eyeIdentifier = "Green";
    }

    public void C1blackEyesSelect(ActionEvent event) {
        C1EyeColor = "BlackEyes";
        ClientC1EyeColor.setText("Black");
        eyeIdentifier = "Black";
    }

    public void C1grayEyesSelect(ActionEvent event) {
        C1EyeColor = "GrayEyes";
        ClientC1EyeColor.setText("Gray");
        eyeIdentifier = "Gray";
    }

    public void C1pinkEyesSelect(ActionEvent event) {
        C1EyeColor = "PinkEyes";
        ClientC1EyeColor.setText("Pink");
        eyeIdentifier = "Pink";
    }

    public void C1brownEyesSelect(ActionEvent event) {
        C1EyeColor = "BrownEyes";
        ClientC1EyeColor.setText("Brown");
        eyeIdentifier = "Brown";
    }

    public void C1hazelEyesSelect(ActionEvent event) {
        C1EyeColor = "HazelEyes";
        ClientC1EyeColor.setText("Hazel");
        eyeIdentifier = "Hazel";
    }

    public void C1unknownEyesSelect(ActionEvent event) {
        C1EyeColor = "UnknownEyes";
        ClientC1EyeColor.setText("Other");
        eyeIdentifier = "Other";
    }
    public void C2yesLatinoSelect(ActionEvent event) {
        C2Ethnicity = "Hispanic-yes";
        ClientC2Ethnicity.setText("Latino");
    }

    public void C2noLatinoSelect(ActionEvent event) {
        C2Ethnicity = "Hispanic-no";
        ClientC2Ethnicity.setText("Not Latino");
    }

    public void C2asianSelect(ActionEvent event) {
        C2Race = "Asian";
        ClientC2Race.setText("Asian");
    }

    public void C2whiteSelect(ActionEvent event) {
        C2Race = "White";
        ClientC2Race.setText("White");
    }

    public void C2blackSelect(ActionEvent event) {
        C2Race = "Black";
        ClientC2Race.setText("Black");
    }

    public void C2amerindianSelect(ActionEvent event) {
        C2Race = "Amerindian";
        ClientC2Race.setText("Amerindian");
    }

    public void C2pacificSelect(ActionEvent event) {
        C2Race = "Hawaii";
        ClientC2Race.setText("Pacific Islander");
    }

    public void C2baldHairSelect(ActionEvent event) {
        C2HairColor = "Bald";
        ClientC2HairColor.setText("Bald");
        hairIdentifier = "Bald";
    }

    public void C2brownHairSelect(ActionEvent event) {
        C2HairColor = "BrownHair";
        ClientC2HairColor.setText("Brown");
        hairIdentifier = "Brown";
    }

    public void C2sandyHairSelect(ActionEvent event) {
        C2HairColor = "SandyHair";
        ClientC2HairColor.setText("Sandy");
        hairIdentifier = "Sandy";
    }

    public void C2blackHairSelect(ActionEvent event) {
        C2HairColor = "BlackHair";
        ClientC2HairColor.setText("Black");
        hairIdentifier = "Black";
    }

    public void C2grayHairSelect(ActionEvent event) {
        C2HairColor = "GrayHair";
        ClientC2HairColor.setText("Gray");
        hairIdentifier = "Gray";
    }

    public void C2whiteHairSelect(ActionEvent event) {
        C2HairColor = "WhiteHair";
        ClientC2HairColor.setText("White");
        hairIdentifier = "White";
    }

    public void C2blondHairSelect(ActionEvent event) {
        C2HairColor = "BlondHair";
        ClientC2HairColor.setText("Blond");
        hairIdentifier = "Blond";
    }

    public void C2redHairSelect(ActionEvent event) {
        C2HairColor = "RedHair";
        ClientC2HairColor.setText("Red");
        hairIdentifier = "Red";
    }

    public void C2unknownHairSelect(ActionEvent event) {
        C2HairColor = "UnknownHair";
        ClientC2HairColor.setText("Other");
        hairIdentifier = "Other";
    }

    public void C2blueEyesSelect(ActionEvent event) {
        C2EyeColor = "BlueEyes";
        ClientC2EyeColor.setText("Blue");
        eyeIdentifier = "Blue";
    }

    public void C2maroonEyesSelect(ActionEvent event) {
        C2EyeColor = "MaroonEyes";
        ClientC2EyeColor.setText("Maroon");
        eyeIdentifier = "Maroon";
    }

    public void C2greenEyesSelect(ActionEvent event) {
        C2EyeColor = "GreenEyes";
        ClientC2EyeColor.setText("Green");
        eyeIdentifier = "Green";
    }

    public void C2blackEyesSelect(ActionEvent event) {
        C2EyeColor = "BlackEyes";
        ClientC2EyeColor.setText("Black");
        eyeIdentifier = "Black";
    }

    public void C2grayEyesSelect(ActionEvent event) {
        C2EyeColor = "GrayEyes";
        ClientC2EyeColor.setText("Gray");
        eyeIdentifier = "Gray";
    }

    public void C2pinkEyesSelect(ActionEvent event) {
        C2EyeColor = "PinkEyes";
        ClientC2EyeColor.setText("Pink");
        eyeIdentifier = "Pink";
    }

    public void C2brownEyesSelect(ActionEvent event) {
        C2EyeColor = "BrownEyes";
        ClientC2EyeColor.setText("Brown");
        eyeIdentifier = "Brown";
    }

    public void C2hazelEyesSelect(ActionEvent event) {
        C2EyeColor = "HazelEyes";
        ClientC2EyeColor.setText("Hazel");
        eyeIdentifier = "Hazel";
    }

    public void C2unknownEyesSelect(ActionEvent event) {
        C2EyeColor = "UnknownEyes";
        ClientC2EyeColor.setText("Other");
        eyeIdentifier = "Other";
    }
    public void C3yesLatinoSelect(ActionEvent event) {
        C3Ethnicity = "Hispanic-yes";
        ClientC3Ethnicity.setText("Latino");
    }

    public void C3noLatinoSelect(ActionEvent event) {
        C3Ethnicity = "Hispanic-no";
        ClientC3Ethnicity.setText("Not Latino");
    }

    public void C3asianSelect(ActionEvent event) {
        C3Race = "Asian";
        ClientC3Race.setText("Asian");
    }

    public void C3whiteSelect(ActionEvent event) {
        C3Race = "White";
        ClientC3Race.setText("White");
    }

    public void C3blackSelect(ActionEvent event) {
        C3Race = "Black";
        ClientC3Race.setText("Black");
    }

    public void C3amerindianSelect(ActionEvent event) {
        C3Race = "Amerindian";
        ClientC3Race.setText("Amerindian");
    }

    public void C3pacificSelect(ActionEvent event) {
        C3Race = "Hawaii";
        ClientC3Race.setText("Pacific Islander");
    }

    public void C3baldHairSelect(ActionEvent event) {
        C3HairColor = "Bald";
        ClientC3HairColor.setText("Bald");
        hairIdentifier = "Bald";
    }

    public void C3brownHairSelect(ActionEvent event) {
        C3HairColor = "BrownHair";
        ClientC3HairColor.setText("Brown");
        hairIdentifier = "Brown";
    }

    public void C3sandyHairSelect(ActionEvent event) {
        C3HairColor = "SandyHair";
        ClientC3HairColor.setText("Sandy");
        hairIdentifier = "Sandy";
    }

    public void C3blackHairSelect(ActionEvent event) {
        C3HairColor = "BlackHair";
        ClientC3HairColor.setText("Black");
        hairIdentifier = "Black";
    }

    public void C3grayHairSelect(ActionEvent event) {
        C3HairColor = "GrayHair";
        ClientC3HairColor.setText("Gray");
        hairIdentifier = "Gray";
    }

    public void C3whiteHairSelect(ActionEvent event) {
        C3HairColor = "WhiteHair";
        ClientC3HairColor.setText("White");
        hairIdentifier = "White";
    }

    public void C3blondHairSelect(ActionEvent event) {
        C3HairColor = "BlondHair";
        ClientC3HairColor.setText("Blond");
        hairIdentifier = "Blond";
    }

    public void C3redHairSelect(ActionEvent event) {
        C3HairColor = "RedHair";
        ClientC3HairColor.setText("Red");
        hairIdentifier = "Red";
    }

    public void C3unknownHairSelect(ActionEvent event) {
        C3HairColor = "UnknownHair";
        ClientC3HairColor.setText("Other");
        hairIdentifier = "Other";
    }

    public void C3blueEyesSelect(ActionEvent event) {
        C3EyeColor = "BlueEyes";
        ClientC3EyeColor.setText("Blue");
        eyeIdentifier = "Blue";
    }

    public void C3maroonEyesSelect(ActionEvent event) {
        C3EyeColor = "MaroonEyes";
        ClientC3EyeColor.setText("Maroon");
        eyeIdentifier = "Maroon";
    }

    public void C3greenEyesSelect(ActionEvent event) {
        C3EyeColor = "GreenEyes";
        ClientC3EyeColor.setText("Green");
        eyeIdentifier = "Green";
    }

    public void C3blackEyesSelect(ActionEvent event) {
        C3EyeColor = "BlackEyes";
        ClientC3EyeColor.setText("Black");
        eyeIdentifier = "Black";
    }

    public void C3grayEyesSelect(ActionEvent event) {
        C3EyeColor = "GrayEyes";
        ClientC3EyeColor.setText("Gray");
        eyeIdentifier = "Gray";
    }

    public void C3pinkEyesSelect(ActionEvent event) {
        C3EyeColor = "PinkEyes";
        ClientC3EyeColor.setText("Pink");
        eyeIdentifier = "Pink";
    }

    public void C3brownEyesSelect(ActionEvent event) {
        C3EyeColor = "BrownEyes";
        ClientC3EyeColor.setText("Brown");
        eyeIdentifier = "Brown";
    }

    public void C3hazelEyesSelect(ActionEvent event) {
        C3EyeColor = "HazelEyes";
        ClientC3EyeColor.setText("Hazel");
        eyeIdentifier = "Hazel";
    }
    public void C3unknownEyesSelect(ActionEvent event) {
        C3EyeColor = "UnknownEyes";
        ClientC3EyeColor.setText("Other");
        eyeIdentifier = "Other";
    }
    public void C1selectSpouse1(ActionEvent event) {
        C1SpouseNumber = "1";
        ClientC1Parent.setText("Spouse " + C1SpouseNumber);
    }
    public void C1selectSpouse2(ActionEvent event) {
        C1SpouseNumber = "2";
        ClientC1Parent.setText("Spouse " + C1SpouseNumber);
    }
    public void C1selectSpouse3(ActionEvent event) {
        C1SpouseNumber = "3";
        ClientC1Parent.setText("Spouse " + C1SpouseNumber);
    }
    public void C1selectSpouse4(ActionEvent event) {
        C1SpouseNumber = "4";
        ClientC1Parent.setText("Spouse " + C1SpouseNumber);
    }
    public void C1selectSpouse5(ActionEvent event) {
        C1SpouseNumber = "5";
        ClientC1Parent.setText("Spouse " + C1SpouseNumber);
    }
    public void C2selectSpouse1(ActionEvent event) {
        C2SpouseNumber = "1";
        ClientC2Parent.setText("Spouse " + C2SpouseNumber);
    }
    public void C2selectSpouse2(ActionEvent event) {
        C2SpouseNumber = "2";
        ClientC2Parent.setText("Spouse " + C2SpouseNumber);
    }
    public void C2selectSpouse3(ActionEvent event) {
        C2SpouseNumber = "3";
        ClientC2Parent.setText("Spouse " + C2SpouseNumber);
    }
    public void C2selectSpouse4(ActionEvent event) {
        C2SpouseNumber = "4";
        ClientC2Parent.setText("Spouse " + C2SpouseNumber);
    }
    public void C2selectSpouse5(ActionEvent event) {
        C2SpouseNumber = "5";
        ClientC2Parent.setText("Spouse " + C2SpouseNumber);
    }
    public void C3selectSpouse1(ActionEvent event) {
        C3SpouseNumber = "1";
        ClientC3Parent.setText("Spouse " + C3SpouseNumber);
    }
    public void C3selectSpouse2(ActionEvent event) {
        C3SpouseNumber = "2";
        ClientC3Parent.setText("Spouse " + C3SpouseNumber);
    }
    public void C3selectSpouse3(ActionEvent event) {
        C3SpouseNumber = "3";
        ClientC3Parent.setText("Spouse " + C3SpouseNumber);
    }
    public void C3selectSpouse4(ActionEvent event) {
        C3SpouseNumber = "4";
        ClientC3Parent.setText("Spouse " + C3SpouseNumber);
    }
    public void C3selectSpouse5(ActionEvent event) {
        C3SpouseNumber = "5";
        ClientC3Parent.setText("Spouse " + C3SpouseNumber);
    }
    public void uncheckMaleGender(ActionEvent event) {
        maleGender.setSelected(false);
    }
    public void uncheckFemaleGender(ActionEvent event) {
        femaleGender.setSelected(false);
    }
    public void uncheckOtherApt(ActionEvent event) {
        AddressSte.setSelected(false);
        AddressFlr.setSelected(false);
    }
    public void uncheckOtherSte(ActionEvent event) {
        AddressApt.setSelected(false);
        AddressFlr.setSelected(false);
    }
    public void uncheckOtherFlr(ActionEvent event) {
        AddressApt.setSelected(false);
        AddressSte.setSelected(false);
    }
    public void uncheckOtherApt1(ActionEvent event) {
        AddressSte1.setSelected(false);
        AddressFlr1.setSelected(false);
    }
    public void uncheckOtherSte1(ActionEvent event) {
        AddressApt1.setSelected(false);
        AddressFlr1.setSelected(false);
    }
    public void uncheckOtherFlr1(ActionEvent event) {
        AddressApt1.setSelected(false);
        AddressSte1.setSelected(false);
    }
    public void uncheckOtherApt2(ActionEvent event) {
        AddressSte2.setSelected(false);
        AddressFlr2.setSelected(false);
    }
    public void uncheckOtherSte2(ActionEvent event) {
        AddressApt2.setSelected(false);
        AddressFlr2.setSelected(false);
    }
    public void uncheckOtherFlr2(ActionEvent event) {
        AddressApt2.setSelected(false);
        AddressSte2.setSelected(false);
    }
    public void uncheckJobOtherApt(ActionEvent event) {
        jobAddressSte.setSelected(false);
        jobAddressFlr.setSelected(false);
    }
    public void uncheckJobOtherSte(ActionEvent event) {
        jobAddressApt.setSelected(false);
        jobAddressFlr.setSelected(false);
    }
    public void uncheckJobOtherFlr(ActionEvent event) {
        jobAddressApt.setSelected(false);
        jobAddressSte.setSelected(false);
    }
    public void uncheckJobOtherApt1(ActionEvent event) {
        jobAddressSte1.setSelected(false);
        jobAddressFlr1.setSelected(false);
    }
    public void uncheckJobOtherSte1(ActionEvent event) {
        jobAddressApt1.setSelected(false);
        jobAddressFlr1.setSelected(false);
    }
    public void uncheckJobOtherFlr1(ActionEvent event) {
        jobAddressApt1.setSelected(false);
        jobAddressSte1.setSelected(false);
    }
    public void uncheckJobOtherApt2(ActionEvent event) {
        jobAddressSte2.setSelected(false);
        jobAddressFlr2.setSelected(false);
    }
    public void uncheckJobOtherSte2(ActionEvent event) {
        jobAddressApt2.setSelected(false);
        jobAddressFlr2.setSelected(false);
    }
    public void uncheckJobOtherFlr2(ActionEvent event) {
        jobAddressApt2.setSelected(false);
        jobAddressSte2.setSelected(false);
    }
    public void uncheckC1MaleGender(ActionEvent event) {
        child1Gender.setSelected(false);
    }
    public void uncheckC1FemaleGender(ActionEvent event) {
        C1Female.setSelected(false);
    }
    public void uncheckC2MaleGender(ActionEvent event) {
        child2Gender.setSelected(false);
    }
    public void uncheckC2FemaleGender(ActionEvent event) {
        C2Female.setSelected(false);
    }
    public void uncheckC3MaleGender(ActionEvent event) {
        child3Gender.setSelected(false);
    }
    public void uncheckC3FemaleGender(ActionEvent event) {
        C3Female.setSelected(false);
    }
    public void uncheckC4MaleGender(ActionEvent event) {
        child4Gender.setSelected(false);
    }
    public void uncheckC4FemaleGender(ActionEvent event) {
        C4Female.setSelected(false);
    }
    public void uncheckC5MaleGender(ActionEvent event) {
        child5Gender.setSelected(false);
    }
    public void uncheckC5FemaleGender(ActionEvent event) {
        C5Female.setSelected(false);
    }
    public void uncheckC6MaleGender(ActionEvent event) {
        child6Gender.setSelected(false);
    }
    public void uncheckC6FemaleGender(ActionEvent event) {
        C6Female.setSelected(false);
    }
    public void uncheckC7MaleGender(ActionEvent event) {
        child7Gender.setSelected(false);
    }
    public void uncheckC7FemaleGender(ActionEvent event) {
        C7Female.setSelected(false);
    }
    public void uncheckSpouseMaleGender(ActionEvent event) {
        SpouseGender.setSelected(false);
    }
    public void uncheckSpouseFemaleGender(ActionEvent event) {
        SpouseFemale.setSelected(false);
    }
    public void maleSelect(ActionEvent event) throws Exception {
        AGender = "Male";
        sex.setText(AGender);
    }
    public void femaleSelect(ActionEvent event) throws Exception {
        AGender = "Female";
        sex.setText(AGender);
    }

    public void visitGithub(ActionEvent event) throws Exception {
        URI u = new URI("https://github.com/MithridatesEupator/ImmigrationsForms");
        java.awt.Desktop.getDesktop().browse(u);
    }


    @FXML
    public void closeWindow(ActionEvent event) {
        try { SaveAdditionalNameVars(); }
        catch (Exception ex) { }
        try { SaveC1InfoVars(); }
        catch (Exception ex) { }
        try { SaveC2InfoVars(); }
        catch (Exception ex) { }
        try { SaveC3InfoVars(); }
        catch (Exception ex) { }
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void closeGeneralWindow(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void minimizeGeneralWindow(ActionEvent event) {
        Stage stage = (Stage) minimizeButton.getScene().getWindow();
        stage.setIconified(true);
    }


    @FXML
    public void openAdditionalNamesWindow(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AdditionalNames.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Additional Names");
        stage.setScene((new Scene(root1, 600, 400)));
        stage.initStyle(StageStyle.UTILITY);
        stage.show();
    }

    @FXML
    public void openC1InfoWindow(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AdditionalC1Info.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Additional Information for Child #1");
        stage.setScene((new Scene(root1, 600, 400)));
        stage.initStyle(StageStyle.UTILITY);
        stage.show();
    }

    public void openC2InfoWindow(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AdditionalC2Info.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Additional Information for Child #2");
        stage.setScene((new Scene(root1, 600, 400)));
        stage.initStyle(StageStyle.UTILITY);
        stage.show();
    }

    public void openC3InfoWindow(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AdditionalC3Info.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Additional Information for Child #3");
        stage.setScene((new Scene(root1, 600, 400)));
        stage.initStyle(StageStyle.UTILITY);
        stage.show();
    }

    @FXML
    public void SaveAdditionalNameVars() {

        if (clientFamilyName1.getText() != null) {
            FamilyName1 = clientFamilyName1.getText();
        }
        if (clientFirstName1.getText() != null) {
            FirstName1 = clientFirstName1.getText();
        }
        if (clientMiddleName1.getText() != null) {
            MiddleName1 = clientMiddleName1.getText();
        }
        if (clientFamilyName2.getText() != null) {
            FamilyName2 = clientFamilyName2.getText();
        }
        if (clientFirstName2.getText() != null) {
            FirstName2 = clientFirstName2.getText();
        }
        if (clientMiddleName2.getText() != null) {
            MiddleName2 = clientMiddleName2.getText();
        }
        if (clientFamilyName3.getText() != null) {
            FamilyName3 = clientFamilyName3.getText();
        }
        if (clientFirstName3.getText() != null) {
            FirstName3 = clientFirstName3.getText();
        }
        if (clientMiddleName3.getText() != null) {
            MiddleName3 = clientMiddleName3.getText();
        }
    }

    @FXML
    public void ShowNameVars() {
        if (FamilyName1.equals("NONE")) {
            FamilyName1 = "";
        }
        if (!FamilyName1.trim().isEmpty()) {
            clientFamilyName1.setText(FamilyName1);
        }
        if (!FirstName1.trim().isEmpty()) {
            clientFirstName1.setText(FirstName1);
        }
        if (!MiddleName1.trim().isEmpty()) {
            clientMiddleName1.setText(MiddleName1);
        }
        if (!FamilyName2.trim().isEmpty()) {
            clientFamilyName2.setText(FamilyName2);
        }
        if (!FirstName2.trim().isEmpty()) {
            clientFirstName2.setText(FirstName2);
        }
        if (!MiddleName2.trim().isEmpty()) {
            clientMiddleName2.setText(MiddleName2);
        }
        if (!FamilyName3.trim().isEmpty()) {
            clientFamilyName3.setText(FamilyName3);
        }
        if (!FirstName3.trim().isEmpty()) {
            clientFirstName3.setText(FirstName3);
        }
        if (!MiddleName3.trim().isEmpty()) {
            clientMiddleName3.setText(MiddleName3);
        }
    }

    @FXML
    public void SaveC1InfoVars() {
        if (ClientC1FamilyName1.getText() != null) {
            C1FamilyName1 = ClientC1FamilyName1.getText();
        }
        if (ClientC1FirstName1.getText() != null) {
            C1FirstName1 = ClientC1FirstName1.getText();
        }
        if (ClientC1MiddleName1.getText() != null) {
            C1MiddleName1 = ClientC1MiddleName1.getText();
        }
        if (ClientC1Weight.getText() != null) {
            C1Weight = ClientC1Weight.getText();
            if (C1Weight.length() == 3) {
                C1PD1 = C1Weight.substring(0, 1);
                C1PD2 = C1Weight.substring(1, 2);
                C1PD3 = C1Weight.substring(2, 3);
            } else if (C1Weight.length() == 2) {
                C1Weight = "0" + C1Weight;
                C1PD1 = C1Weight.substring(0, 1);
                C1PD2 = C1Weight.substring(1, 2);
                C1PD3 = C1Weight.substring(2, 3);
            } else if (C1Weight.length() == 1) {
                C1Weight = "00" + C1Weight;
                C1PD1 = C1Weight.substring(0, 1);
                C1PD2 = C1Weight.substring(1, 2);
                C1PD3 = C1Weight.substring(2, 3);
            }
        }
        if (ClientC1Height.getText() != null) {
            try {
                String C1TMPheight = ClientC1Height.getText();
                C1Height = C1TMPheight;
                String C1Height = C1TMPheight.replace("0", "");
                String[] C1HeightVar = C1Height.toString().split("\\|");
                if (Character.toString(C1HeightVar[0].charAt(0)).equals("0")) {
                    C1HeightVar[0] = Character.toString(C1HeightVar[0].charAt(1));
                }
                if (Character.toString(C1HeightVar[1].charAt(0)).equals("0")) {
                    C1HeightVar[1] = Character.toString(C1HeightVar[1].charAt(1));
                }
                C1Feet = C1HeightVar[0];
                C2Inches = C1HeightVar[1];
            }
            catch (Exception ex) {}
        }
    }

    public void ShowC1InfoVars() {
        if (!C1Ethnicity.trim().isEmpty()) {
            if (C1Ethnicity == "Hispanic-yes") {
                ClientC1Ethnicity.setText("Latino");
            }
            else if (C1Ethnicity == "Hispanic-no") {
                ClientC1Ethnicity.setText("Not Latino");
            }
        }
        if (!C1Race.trim().isEmpty()) {
            if (C1Race == "Hawaii") {
                ClientC1Race.setText("Pacific Islander");
            }
            else {
                ClientC1Race.setText(C1Race);
            }
        }
        if (!C1EyeColor.isEmpty()) {
            ClientC1EyeColor.setText(eyeIdentifier);
        }
        if (!C1HairColor.isEmpty()) {
            ClientC1HairColor.setText(hairIdentifier);
        }
        if (!C1FamilyName1.trim().isEmpty()) {
            ClientC1FamilyName1.setText(C1FamilyName1);
        }
        if (!C1FirstName1.trim().isEmpty()) {
            ClientC1FirstName1.setText(C1FirstName1);
        }
        if (!C1MiddleName1.trim().isEmpty()) {
            ClientC1MiddleName1.setText(C1MiddleName1);
        }
        if (!C1Feet.trim().isEmpty()) {
            ClientC1Height.setText(C1Height);
        }
        if (!C1SpouseNumber.trim().equals("")) {
            ClientC1Parent.setText("Spouse " + C1SpouseNumber);
        }
    }
    public void SaveC2InfoVars() {
        if (ClientC2FamilyName1.getText() != null) {
            C2FamilyName1 = ClientC2FamilyName1.getText();
        }
        if (ClientC2FirstName1.getText() != null) {
            C2FirstName1 = ClientC2FirstName1.getText();
        }
        if (ClientC2MiddleName1.getText() != null) {
            C2MiddleName1 = ClientC2MiddleName1.getText();
        }
        if (ClientC2Weight.getText() != null) {
            C2Weight = ClientC2Weight.getText();
            if (C2Weight.length() == 3) {
                C2PD1 = C2Weight.substring(0, 1);
                C2PD2 = C2Weight.substring(1, 2);
                C2PD3 = C2Weight.substring(2, 3);
            } else if (C2Weight.length() == 2) {
                C2Weight = "0" + C2Weight;
                C2PD1 = C2Weight.substring(0, 1);
                C2PD2 = C2Weight.substring(1, 2);
                C2PD3 = C2Weight.substring(2, 3);
            } else if (C2Weight.length() == 1) {
                C2Weight = "00" + C2Weight;
                C2PD1 = C2Weight.substring(0, 1);
                C2PD2 = C2Weight.substring(1, 2);
                C2PD3 = C2Weight.substring(2, 3);
            }
        }
        if (ClientC2Height.getText() != null) {
            try {
                String C2TMPheight = ClientC2Height.getText();
                C2Height = C2TMPheight;
                String C2Height = C2TMPheight.replace("0", "");
                String[] C2HeightVar = C2Height.toString().split("\\|");
                if (Character.toString(C2HeightVar[0].charAt(0)).equals("0")) {
                    C2HeightVar[0] = Character.toString(C2HeightVar[0].charAt(1));
                }
                if (Character.toString(C2HeightVar[1].charAt(0)).equals("0")) {
                    C2HeightVar[1] = Character.toString(C2HeightVar[1].charAt(1));
                }
                C2Feet = C2HeightVar[0];
                C2Inches = C2HeightVar[1];
            }
            catch (Exception ex) {}
        }
    }
    public void ShowC2InfoVars() {
        if (!C2Ethnicity.trim().isEmpty()) {
            if (C2Ethnicity == "Hispanic-yes") {
                ClientC2Ethnicity.setText("Latino");
            }
            else if (C2Ethnicity == "Hispanic-no") {
                ClientC2Ethnicity.setText("Not Latino");
            }
        }
        if (!C2Race.trim().isEmpty()) {
            if (C2Race == "Hawaii") {
                ClientC2Race.setText("Pacific Islander");
            }
            else {
                ClientC2Race.setText(C2Race);
            }
        }
        if (!C2EyeColor.isEmpty()) {
            ClientC2EyeColor.setText(eyeIdentifier);
        }
        if (!C2HairColor.isEmpty()) {
            ClientC2HairColor.setText(hairIdentifier);
        }
        if (!C2FamilyName1.trim().isEmpty()) {
            ClientC2FamilyName1.setText(C2FamilyName1);
        }
        if (!C2FirstName1.trim().isEmpty()) {
            ClientC2FirstName1.setText(C2FirstName1);
        }
        if (!C2MiddleName1.trim().isEmpty()) {
            ClientC2MiddleName1.setText(C2MiddleName1);
        }
        if (!C2Feet.trim().isEmpty()) {
            ClientC2Height.setText(C2Height);
        }
        if (!C2SpouseNumber.trim().equals("")) {
            ClientC2Parent.setText("Spouse " + C2SpouseNumber);
        }
    }

    public void SaveC3InfoVars() {
        if (ClientC3FamilyName1.getText() != null) {
            C3FamilyName1 = ClientC3FamilyName1.getText();
        }
        if (ClientC3FirstName1.getText() != null) {
            C3FirstName1 = ClientC3FirstName1.getText();
        }
        if (ClientC3MiddleName1.getText() != null) {
            C3MiddleName1 = ClientC3MiddleName1.getText();
        }
        if (ClientC3Weight.getText() != null) {
            C3Weight = ClientC3Weight.getText();
            if (C3Weight.length() == 3) {
                C3PD1 = C3Weight.substring(0, 1);
                C3PD2 = C3Weight.substring(1, 2);
                C3PD3 = C3Weight.substring(2, 3);
            } else if (C3Weight.length() == 2) {
                C3Weight = "0" + C3Weight;
                C3PD1 = C3Weight.substring(0, 1);
                C3PD2 = C3Weight.substring(1, 2);
                C3PD3 = C3Weight.substring(2, 3);
            } else if (C3Weight.length() == 1) {
                C3Weight = "00" + C3Weight;
                C3PD1 = C3Weight.substring(0, 1);
                C3PD2 = C3Weight.substring(1, 2);
                C3PD3 = C3Weight.substring(2, 3);
            }
        }
        if (ClientC3Height.getText() != null) {
            try {
                String C3TMPheight = ClientC3Height.getText();
                C3Height = C3TMPheight;
                String C3Height = C3TMPheight.replace("0", "");
                String[] C3HeightVar = C3Height.toString().split("\\|");
                if (Character.toString(C3HeightVar[0].charAt(0)).equals("0")) {
                    C3HeightVar[0] = Character.toString(C3HeightVar[0].charAt(1));
                }
                if (Character.toString(C3HeightVar[1].charAt(0)).equals("0")) {
                    C3HeightVar[1] = Character.toString(C3HeightVar[1].charAt(1));
                }
                C3Feet = C3HeightVar[0];
                C3Inches = C3HeightVar[1];
            }
            catch (Exception ex) {}
        }

    }

    public void ShowC3InfoVars() {
        if (!C3Ethnicity.trim().isEmpty()) {
            if (C3Ethnicity == "Hispanic-yes") {
                ClientC3Ethnicity.setText("Latino");
            }
            else if (C3Ethnicity == "Hispanic-no") {
                ClientC3Ethnicity.setText("Not Latino");
            }
        }
        if (!C3Race.trim().isEmpty()) {
            if (C3Race == "Hawaii") {
                ClientC3Race.setText("Pacific Islander");
            }
            else {
                ClientC3Race.setText(C3Race);
            }
        }
        if (!C3EyeColor.isEmpty()) {
            ClientC3EyeColor.setText(eyeIdentifier);
        }
        if (!C3HairColor.isEmpty()) {
            ClientC3HairColor.setText(hairIdentifier);
        }
        if (!C3FamilyName1.trim().isEmpty()) {
            ClientC3FamilyName1.setText(C3FamilyName1);
        }
        if (!C3FirstName1.trim().isEmpty()) {
            ClientC3FirstName1.setText(C3FirstName1);
        }
        if (!C3MiddleName1.trim().isEmpty()) {
            ClientC3MiddleName1.setText(C3MiddleName1);
        }
        if (!C3Feet.trim().isEmpty()) {
            ClientC3Height.setText(C3Height);
        }
        if (!C3SpouseNumber.trim().equals("")) {
            ClientC3Parent.setText("Spouse " + C3SpouseNumber);
        }
    }

    @FXML
    public void SaveVars() throws Exception {
        fileIteration = 0;
        if (clientANumber.getText() != null) {
            String ANumTMP = clientANumber.getText();
            if (ANumTMP.length() > 9) {
                ANum = ANumTMP.substring(0, 9);
            } else {
                ANum = ANumTMP;
            }
        }
        if (clientFamilyName.getText() != null) {
            FamilyName = clientFamilyName.getText().trim();
        }
        if (clientFirstName.getText() != null) {
            FirstName = clientFirstName.getText().trim();
        }
        if (clientMiddleName.getText() != null) {
            MiddleName = clientMiddleName.getText().trim();
        }
        if (FamilyName1.trim().isEmpty()) {
            FamilyName1 = "NONE";
        }
        if (clientBirthCity.getText() != null) {
            CityBirth = clientBirthCity.getText();
        }
        if (clientDOB.getText() != null) {
            String TEMPORARY = clientDOB.getText();
            DOBDate = new DateValue(TEMPORARY);
        }
        if (clientBirthCountry.getText() != null) {
            CountryBirth = clientBirthCountry.getText();
            int ethnicityIndex = ArrayUtils.indexOf(ethnicityArray, CountryBirth.toUpperCase()) + 1;
            Nationality = ethnicityArray[ethnicityIndex];
        }
        if (clientSocialSecurity.getText() != null) {
            String SocialSecurityTMP = clientSocialSecurity.getText();
            if (SocialSecurityTMP.length() > 9) {
                SocialSecurity = SocialSecurityTMP.substring(0, 9);
            } else {
                SocialSecurity = SocialSecurityTMP;
            }
        }
        if (clientSocialSecurity.getText().trim().isEmpty()) {
            SocialSecurityBox = "SS-no";
        }
        else {
            SocialSecurityBox = "SS-yes";
        }

        if (clientPassport.getText() != null) {
            PassportNum = clientPassport.getText();
        }
        else  {
            PassportNum = "N/A";
        }
        if (clientTravelDoc.getText() != null) {
            TravelNum = clientTravelDoc.getText();
        }
        else {
            TravelNum = "N/A";
        }
        if (clientPort.getText() != null) {
            EntryCity = clientPort.getText();
        }
        if (clientPortState.getText() != null) {
            EntryState = clientPortState.getText();
        }
        if (clientI94Number.getText() != null) {
            I94Num = clientI94Number.getText();
        }
        if (clientI94Status.getText() != null) {
            if (I94Status.trim().isEmpty()) {
                I94Status = clientI94Status.getText();
            }
        }
        if (clientPortDate.getText() != null) {
            LastArrivalDate = new DateValue(clientPortDate.getText());
        }
        if (documentExpiration.getText() != null) {
            ExpirationDate = new DateValue(documentExpiration.getText());
        }
        if (clientI94Expiration.getText() != null) {
            ExpirationDate1 = new DateValue(clientI94Expiration.getText());
        }
        if (documentCountry.getText() != null) {
            PassportCountry = documentCountry.getText();
        }
        if (clientWeight.getText() != null) {
            String PDFull = clientWeight.getText().toString();
            if (PDFull.length() == 3) {
                PD1 = PDFull.substring(0, 1);
                PD2 = PDFull.substring(1, 2);
                PD3 = PDFull.substring(2, 3);
            } else if (PDFull.length() == 2) {
                PDFull = "0" + PDFull;
                PD1 = PDFull.substring(0, 1);
                PD2 = PDFull.substring(1, 2);
                PD3 = PDFull.substring(2, 3);
            } else if (PDFull.length() == 1) {
                PDFull = "00" + PDFull;
                PD1 = PDFull.substring(0, 1);
                PD2 = PDFull.substring(1, 2);
                PD3 = PDFull.substring(2, 3);
            }
        }
        if (clientHeight.getText() != null) {
            String TMPheight = clientHeight.getText().toString();
            String height = TMPheight.replace("0", "");
            String[] C1HeightVar = height.split("\\|");
            try {
                if (Character.toString(C1HeightVar[0].charAt(0)).equals("0")) {
                    C1HeightVar[0] = Character.toString(C1HeightVar[0].charAt(1));
                }
                if (Character.toString(C1HeightVar[1].charAt(0)).equals("0")) {
                    C1HeightVar[1] = Character.toString(C1HeightVar[1].charAt(1));
                }

                Feet = C1HeightVar[0];
                Inches = C1HeightVar[1];
            }
            catch (Exception ex) {}
        }
        if (clientEmail.getText() != null) {
            AEmail = clientEmail.getText();
        }
        if (clientPhoneNum.getText() != null) {
            if (clientPhoneNum.getText().length() > 9) {
                ADayTimeNum = clientPhoneNum.getText().substring(0, 9);
                AMobNum = ADayTimeNum;
            } else {
                ADayTimeNum = clientPhoneNum.getText();
                AMobNum = ADayTimeNum;
            }
        }
        if (interpreterFamilyName.getText() != null) {
            IFamilyName = interpreterFamilyName.getText();
        }
        if (interpreterMiddleName.getText() != null) {
            IMiddleName = interpreterMiddleName.getText();
        }
        if (interpreterFirstName.getText() != null) {
            IFirstName = interpreterFirstName.getText();
        }
        if (interpreterLanguage.getText() != null) {
            Language = interpreterLanguage.getText();
        }
        if (Language.trim().isEmpty()) {
            InterpreterQuestion = "English";
            IOrganizationName = "";
            IAddressStreet = "";
            ITenantInfo = "";
            IAddInfoAddress = "";
            IAddressCity = "";
            IState = "";
            IZipcode = "";
            ICountry = "";
        } else {
            InterpreterQuestion = "Interpreter";
            IOrganizationName = "International Rescue Committee";
            IAddressStreet = "208 Commerce Street";
            ITenantInfo = "IFlr";
            IAddInfoAddress = "4";
            IAddressCity = "Elizabeth";
            IState = "NJ";
            IZipcode = "07201";
            ICountry = "USA";
        }
        if (interpreterEmail.getText() != null) {
            IEmail = interpreterEmail.getText();
        }
        if (interpreterPhoneNumber.getText() != null) {
            if (clientPhoneNum.getText().length() > 10) {
                IDayTimeNum = clientPhoneNum.getText().substring(0, 10);
                IMobNum = IDayTimeNum;
            } else {
                IDayTimeNum = clientPhoneNum.getText();
                IMobNum = IDayTimeNum;
            }
        }
        if (todayDate.getText() != null) {
            String TEMPORARY = todayDate.getText();
            SignatureDate = new DateValue(TEMPORARY);
        }
        if (countryMilitary.getText() != null) {
            CountryOrganization = countryMilitary.getText();
        }
        if (welfarePast.isSelected()) {
            Q61 = "61-yes";
            PN = "13";
            PaN = "61";
            AddendumA = "After I was admitted into the US, I";
            AddendumB = "did receive means tested benefits.";
            protectAdd = true;

        } else {
            Q61 = "61-no";
        }
        if (welfarePresent.isSelected()) {
            Q62 = "62-yes";
            if (AddendumA.trim().isEmpty()) {
                PN = "13";
                PaN = "8";
                IN = "62";
                AddendumA = "I intend to keep receiving mean tested";
                AddendumB = "benefits until otherwise terminated.";
                protectAdd = true;
            } else {
                PN1 = "13";
                PaN1 = "8";
                IN1 = "62";
                Addendum1A = "I intend to keep receiving mean tested";
                Addendum1B = "benefits until otherwise terminated.";
                protectAdd1 = true;
            }
        } else {
            Q62 = "62-no";
        }
        if (CountryOrganization.trim().isEmpty()) {
            OrgAnswer = "Org-no";
            Q49 = "49-no";
            Q55 = "55-no";
        } else {
            OrgAnswer = "Org-yes";
            int ethnicityIndexOrg = ArrayUtils.indexOf(ethnicityArray, CountryOrganization.toUpperCase()) + 1;
            NameOrganization = ethnicityArray[ethnicityIndexOrg] + " military";
            NatureOrganization = "Military Service";
            Q49 = "49-yes";
            Q55 = "55-yes";
            if (AddendumA.trim().isEmpty()) {
                AddendumA = "When I was in " + CountryOrganization + ", I served in the";
                AddendumB = "military from " + OrganizationStartDate + " to " + OrganizationEndDate + ".";
                PN = "12";
                PaN = "8";
                IN = "55";
            }
            else if (Addendum1A.trim().isEmpty()) {
                Addendum1A = "When I was in " + CountryOrganization + ", I served in the";
                Addendum1B = "military from " + OrganizationStartDate + " to " + OrganizationEndDate + ".";
                PN1 = "12";
                PaN1 = "8";
                IN1 = "55";
            }
            else if (Addendum2A.trim().isEmpty()) {
                Addendum2A = "When I was in " + CountryOrganization + ", I served in the";
                Addendum2B = "military from " + OrganizationStartDate + " to " + OrganizationEndDate + ".";
                PN2 = "12";
                PaN2 = "8";
                IN2 = "55";
            }
            else if (Addendum3A.trim().isEmpty()) {
                Addendum3A = "When I was in " + CountryOrganization + ", I served in the";
                Addendum3B = "military from " + OrganizationStartDate + " to " + OrganizationEndDate + ".";
                PN3 = "12";
                PaN3 = "8";
                IN3 = "55";
            }
            else if (Addendum4A.trim().isEmpty()) {
                Addendum4A = "When I was in " + CountryOrganization + ", I served in the";
                Addendum4B = "military from " + OrganizationStartDate + " to " + OrganizationEndDate + ".";
                PN4 = "12";
                PaN4 = "8";
                IN4 = "55";
            }
        }
        if (cityMilitary.getText() != null) {
            CityOrganization = countryMilitary.getText();
        }
        if (startDateMilitary.getText() != null) {
            OrganizationStartDate = new DateValue(startDateMilitary.getText());
        }
        if (endDateMilitary.getText() != null) {
            OrganizationEndDate = new DateValue(endDateMilitary.getText());
        }
        if (AddressStreetName.getText() != null) {
            AddressStreet = AddressStreetName.getText();
        }
        if (AddressNumber.getText() != null) {
            AddInfoAddress = AddressNumber.getText();
        }
        if (AddressCityTown.getText() != null) {
            AddressCity = AddressCityTown.getText();
        }
        if (AddressState.getText() != null) {
            State = AddressState.getText();
        }
        if (AddressZipcode.getText() != null) {
            Zipcode = AddressZipcode.getText();
        }
        if (AddressStartTime.getText() != null) {
            StartDate = new DateValue(AddressStartTime.getText());
        }
        EndDate = new DateValue("PRESENT");
        if (AddressStreetName1.getText() != null) {
            AddressStreet1 = AddressStreetName1.getText();
        }
        if (AddressNumber1.getText() != null) {
            AddInfoAddress1 = AddressNumber1.getText();
        }
        if (AddressCityTown1.getText() != null) {
            AddressCity1 = AddressCityTown1.getText();
        }
        if (AddressState1.getText() != null) {
            State1 = AddressState1.getText();
        }
        if (AddressZipcode1.getText() != null) {
            Zipcode1 = AddressZipcode1.getText();
        }
        if (AddressCountry1.getText() != null) {
            Country1 = AddressCountry1.getText();
        }
        if (AddressStartTime1.getText() != null) {
            StartDate1 = new DateValue(AddressStartTime1.getText());
        }
        if (AddressEndTime1.getText() != null ) {
            EndDate1 = new DateValue(AddressEndTime1.getText());
        }
        if (AddressStreetName2.getText() != null) {
            AddressStreet2 = AddressStreetName2.getText();
        }
        if (AddressNumber2.getText() != null) {
            AddInfoAddress2 = AddressNumber2.getText();
        }
        if (AddressCityTown2.getText() != null) {
            AddressCity2 = AddressCityTown2.getText();
        }
        if (AddressState2.getText() != null) {
            State2 = AddressState2.getText();
        }
        if (AddressZipcode2.getText() != null) {
            Zipcode2 = AddressZipcode2.getText();
        }
        if (AddressCountry2.getText() != null) {
            Country2 = AddressCountry2.getText();
        }
        if (AddressStartTime2.getText() != null) {
            StartDate2 = new DateValue(AddressStartTime2.getText());
        }
        if (AddressEndTime2.getText() != null ) {
            EndDate2 = new DateValue(AddressEndTime2.getText());
        }
        if (Address3Info.getText() != null) {
            if (!Address3Info.getText().trim().isEmpty()) {
                needAddendum = true;
            }
            try {
                String TMPAddress3 = Address3Info.getText();
                String[] TMPA3Info = TMPAddress3.split("\\|");

                A3Info[0] = TMPA3Info[0].trim();
                A3Info[1] = TMPA3Info[1].trim();
                A3Info[2] = TMPA3Info[2].trim();
                A3Info[3] = TMPA3Info[3].trim();
                A3Info[4] = TMPA3Info[4].trim();
                A3Info[5] = TMPA3Info[5].trim();
                A3Info[6] = TMPA3Info[6].trim();
                AddressStreet3 = A3Info[0];
                AddInfoAddress3 = A3Info[2];
                AddressCity3 = A3Info[3];
                State3 = A3Info[4];
                Country3 = A3Info[5];
                Zipcode3 = A3Info[6];
                if (AddressStartTime3.getText() != null) {
                    StartDate3 = new DateValue(AddressEndTime2.getText());
                }
                if (AddressEndTime3.getText() != null) {
                    EndDate3 = new DateValue(AddressEndTime3.getText());
                }
            }
            catch (ArrayIndexOutOfBoundsException ArrayEx) {
            }
        }
        if (Address4Info.getText() != null) {
            try {
                String TMPAddress4 = Address4Info.getText();
                String[] TMPA4Info = TMPAddress4.split("\\|");
                A4Info[0] = TMPA4Info[0];
                A4Info[1] = TMPA4Info[1];
                A4Info[2] = TMPA4Info[2];
                A4Info[3] = TMPA4Info[3];
                A4Info[4] = TMPA4Info[4];
                A4Info[5] = TMPA4Info[5];
                A4Info[6] = TMPA4Info[6];
            }
            catch (ArrayIndexOutOfBoundsException ArrayEx) {

            }
        }
        if (Address5Info.getText() != null) {
            try {
                String TMPAddress5 = Address5Info.getText();
                String[] TMPA5Info = TMPAddress5.split("\\|");
                A5Info[0] = TMPA5Info[0];
                A5Info[1] = TMPA5Info[1];
                A5Info[2] = TMPA5Info[2];
                A5Info[3] = TMPA5Info[3];
                A5Info[4] = TMPA5Info[4];
                A5Info[5] = TMPA5Info[5];
                A5Info[6] = TMPA5Info[6];
            }
            catch (ArrayIndexOutOfBoundsException ArrayEx) {

            }
        }
        if (Address6Info.getText() != null) {
            try {
                String TMPAddress6 = Address6Info.getText();
                String[] TMPA6Info = TMPAddress6.split("\\|");
                A6Info[0] = TMPA6Info[0];
                A6Info[1] = TMPA6Info[1];
                A6Info[2] = TMPA6Info[2];
                A6Info[3] = TMPA6Info[3];
                A6Info[4] = TMPA6Info[4];
                A6Info[5] = TMPA6Info[5];
                A6Info[6] = TMPA6Info[6];
                A6Info[7] = AddressStartTime6.getText();
                A6Info[8] = AddressEndTime6.getText();
            }
            catch (ArrayIndexOutOfBoundsException ArrayEx) {

            }
        }
        if (jobAddressApt.isSelected()) {
            ETenantInfo = "EApt";
        } else if (jobAddressSte.isSelected()) {
            ETenantInfo = "ESte";
        } else if (jobAddressFlr.isSelected()) {
            ETenantInfo = "EFlr";
        }
        if (jobAddressApt1.isSelected()) {
            ETenantInfo1 = "EApt1";
        } else if (jobAddressSte1.isSelected()) {
            ETenantInfo1 = "ESte1";
        } else if (jobAddressFlr1.isSelected()) {
            ETenantInfo1 = "EFlr1";
        }
        if (jobAddressApt2.isSelected()) {
            ETenantInfo2 = "EApt2";
        } else if (jobAddressSte2.isSelected()) {
            ETenantInfo2 = "ESte2";
        } else if (jobAddressFlr2.isSelected()) {
            ETenantInfo2 = "EFlr2";
        }
        String dateJobEnd = jobAddressEndTime.getText().trim();
        String dateJobStart = jobAddressStartTime.getText().trim();
        String dateJobEnd1 = jobAddressEndTime1.getText().trim();
        String dateJobStart1 = jobAddressStartTime1.getText().trim();
        String dateJobEnd2 = jobAddressEndTime2.getText().trim();
        String dateJobStart2 = jobAddressStartTime2.getText().trim();
        if (dateJobEnd.isEmpty()) {
            dateJobEnd = "PRESENT";
        }

        if (jobAddressStreetName.getText() != null) {
            methodAddressStreet = jobAddressStreetName.getText().trim();
        }
        if (jobAddressNumber.getText() != null) {
            methodAddressNumber = jobAddressNumber.getText().trim();
        }
        if (jobAddressCityTown.getText() != null) {
            methodAddressCity = jobAddressCityTown.getText().trim();
        }
        if (jobAddressState.getText() != null) {
            methodState = jobAddressState.getText().trim();
        }
        if (jobAddressZipcode.getText() != null) {
            methodZipcode = jobAddressZipcode.getText().trim();
        }
        if (jobAddressCountry.getText() != null) {
            methodCountry = jobAddressCountry.getText().trim();
        }
        if (jobOccupation.getText() != null) {
            methodOccupation = jobOccupation.getText().trim();
        }
        if (jobEmployer.getText() != null) {
            methodEmployer = jobEmployer.getText().trim();
        }
        if (jobAddressStreetName1.getText() != null) {
            methodAddressStreet1 = jobAddressStreetName1.getText().trim();
        }
        if (jobAddressNumber1.getText() != null) {
            methodAddressNumber1 = jobAddressNumber1.getText().trim();
        }
        if (jobAddressCityTown1.getText() != null) {
            methodAddressCity1 = jobAddressCityTown1.getText().trim();
        }
        if (jobAddressState1.getText() != null) {
            methodState1 = jobAddressState1.getText().trim();
        }
        if (jobAddressZipcode1.getText() != null) {
            methodZipcode1 = jobAddressZipcode1.getText().trim();
        }
        if (jobAddressCountry1.getText() != null) {
            methodCountry1 = jobAddressCountry1.getText().trim();
        }
        if (jobOccupation1.getText() != null) {
            methodOccupation1 = jobOccupation1.getText().trim();
        }
        if (jobEmployer1.getText() != null) {
            methodEmployer1 = jobEmployer1.getText().trim();
        }
        if (jobAddressStreetName2.getText() != null) {
            methodAddressStreet2 = jobAddressStreetName2.getText().trim();
        }
        if (jobAddressNumber2.getText() != null) {
            methodAddressNumber2 = jobAddressNumber2.getText().trim();
        }
        if (jobAddressCityTown2.getText() != null) {
            methodAddressCity2 = jobAddressCityTown2.getText().trim();
        }
        if (jobAddressState2.getText() != null) {
            methodState2 = jobAddressState2.getText().trim();
        }
        if (jobAddressZipcode2.getText() != null) {
            methodZipcode2 = jobAddressZipcode2.getText().trim();
        }
        if (jobAddressCountry2.getText() != null) {
            methodCountry2 = jobAddressCountry2.getText().trim();
        }
        if (jobOccupation2.getText() != null) {
            methodOccupation2 = jobOccupation2.getText().trim();
        }
        if (jobOccupation2.getText() != null) {
            methodOccupation2 = jobOccupation2.getText().trim();
        }
        if (jobEmployer2.getText() != null) {
            methodEmployer2 = jobEmployer2.getText().trim();
        }
        //-------------------------------------------------------------------------
        if (jobOccupation.getText().isEmpty()) {
            methodOccupation = "NONE";
            dateJobStart = DOBDate.Value;
        }
        if (jobEmployer.getText().trim().isEmpty()) {
            methodEmployer = "UNEMPLOYED";
        }
        if (jobOccupation1.getText().trim().isEmpty() && !jobOccupation.getText().trim().isEmpty()) {
            methodOccupation1 = "NONE";
            dateJobEnd1 = dateJobStart;
            dateJobStart1 = DOBDate.Value;
            methodEmployer1 = "UNEMPLOYED";
        }
        if (jobOccupation2.getText().trim().isEmpty() && !jobOccupation1.getText().trim().isEmpty()) {
            methodOccupation2 = "NONE";
            dateJobEnd2 = dateJobStart1;
            dateJobStart2 = DOBDate.Value;
            methodEmployer2 = "UNEMPLOYED";
        }

        WorkInfoEntry.addNode(methodAddressStreet, ETenantInfo, methodAddressNumber, methodAddressNumber, methodState,
                methodZipcode, methodCountry, methodEmployer, methodOccupation, new DateValue(dateJobStart),
                new DateValue(dateJobEnd));
        WorkInfoEntry.addNode(methodAddressStreet1, ETenantInfo1, methodAddressNumber1, methodAddressNumber1, methodState1,
                methodZipcode1, methodCountry1, methodEmployer1, methodOccupation1, new DateValue(dateJobStart1),
                new DateValue(dateJobEnd1));
        WorkInfoEntry.addNode(methodAddressStreet2, ETenantInfo2, methodAddressNumber2, methodAddressNumber2, methodState2,
                methodZipcode2, methodCountry2, methodEmployer2, methodOccupation2, new DateValue(dateJobStart2),
                new DateValue(dateJobEnd2));
        System.out.println(WorkInfoEntry.Root.display());
        System.out.println(WorkInfoEntry.Root.NextNode.display());
        System.out.println(WorkInfoEntry.Root.NextNode.NextNode.display());
        //-----------------
        if (job3Info.getText() != null) {
            if (!job3Info.getText().trim().isEmpty()) {
                needAddendum = true;
            }
            try {
                String TMPEmployment3 = job3Info.getText();
                String[] TMPE3Info = TMPEmployment3.split("\\|");
                E3Info[0] = TMPE3Info[0];
                E3Info[1] = TMPE3Info[1];
                E3Info[2] = TMPE3Info[2];
                E3Info[3] = TMPE3Info[3];
                E3Info[4] = TMPE3Info[4];
                E3Info[5] = TMPE3Info[5];
                E3Info[6] = jobAddressStartTime3.getText();
                E3Info[7] = jobAddressEndTime3.getText();
                E3Info[8] = Employer3.getText();
                E3Info[9] = Occupation3.getText();
            }
            catch (ArrayIndexOutOfBoundsException ArrayEx) {
            }
        }
        if (job4Info.getText() != null) {
            try {
                String TMPEmployment4 = job4Info.getText();
                String[] TMPE4Info = TMPEmployment4.split("\\|");
                E4Info[0] = TMPE4Info[0];
                E4Info[1] = TMPE4Info[1];
                E4Info[2] = TMPE4Info[2];
                E4Info[3] = TMPE4Info[3];
                E4Info[4] = TMPE4Info[4];
                E4Info[5] = TMPE4Info[5];
                E4Info[6] = jobAddressStartTime4.getText();
                E4Info[7] = jobAddressEndTime4.getText();
                E4Info[8] = Employer4.getText();
                E4Info[9] = Occupation4.getText();
            }
            catch (ArrayIndexOutOfBoundsException ArrayEx) {
            }
        }
        if (job6Info.getText() != null) {
            try {
                String TMPEmployment6 = job6Info.getText();
                String[] TMPE6Info = TMPEmployment6.split("\\|");
                E6Info[0] = TMPE6Info[0];
                E6Info[1] = TMPE6Info[1];
                E6Info[2] = TMPE6Info[2];
                E6Info[3] = TMPE6Info[3];
                E6Info[4] = TMPE6Info[4];
                E6Info[5] = TMPE6Info[5];
                E6Info[6] = jobAddressStartTime5.getText();
                E6Info[7] = jobAddressEndTime5.getText();
                E6Info[8] = Employer5.getText();
                E6Info[9] = Occupation5.getText();
            }
            catch (ArrayIndexOutOfBoundsException ArrayEx) {
            }
        }
        if (job6Info.getText() != null) {
            try {
                String TMPEmployment6 = job6Info.getText();
                String[] TMPE6Info = TMPEmployment6.split("\\|");
                E6Info[0] = TMPE6Info[0];
                E6Info[1] = TMPE6Info[1];
                E6Info[2] = TMPE6Info[2];
                E6Info[3] = TMPE6Info[3];
                E6Info[4] = TMPE6Info[4];
                E6Info[5] = TMPE6Info[5];
                E6Info[6] = TMPE6Info[6];
                E6Info[7] = TMPE6Info[7];
                E6Info[8] = Employer6.getText();
                E6Info[9] = Occupation6.getText();
            }
            catch (ArrayIndexOutOfBoundsException ArrayEx) {
            }
        }

        if (SpouseFamilyName.getText() != null) {
            SFamilyName = SpouseFamilyName.getText();
        }
        if (SpouseFirstName.getText() != null) {
            SFirstName = SpouseFirstName.getText();
        }
        if (SpouseMiddleName.getText() != null) {
            SMiddleName = SpouseMiddleName.getText();
        }
        if (SpouseANum.getText() != null) {
            SANum = SpouseANum.getText();
        }
        if (SpouseDOB.getText() != null) {
            String TEMPORARY = SpouseDOB.getText();
            SDOBDate = new DateValue(TEMPORARY);
        }
        if (SpouseCountryOfBirth.getText() != null) {
            SCountryBirth = SpouseCountryOfBirth.getText();
        }
        if (SpouseCityOfBirth.getText() != null) {
            SCountryBirth = SpouseCityOfBirth.getText();
        }
        if (SpouseMarriageDate.getText() != null) {
            SMarriageDate = SpouseMarriageDate.getText();
        }
        if (SpouseCityOfMarriage.getText() != null) {
            SCityMarriage = SpouseCityOfMarriage.getText();
        }
        if (SpouseMarriageCountry.getText() != null) {
            SCountryMarriage = SpouseMarriageDate.getText();
        }

        if (Spouse1Info.getText() != null) {
            if (!Spouse1Info.getText().trim().isEmpty()) {
                needAddendum = true;
            }
            try {
                String TMPSpouse3 = Spouse3Info.getText();
                String[] TMPS1Info = TMPSpouse3.split("\\|");
                S1Info[0] = TMPS1Info[0];
                S1Info[1] = TMPS1Info[1];
                S1Info[2] = TMPS1Info[2];
                S1Info[3] = TMPS1Info[3];
                S1Info[4] = TMPS1Info[4];
                S1Info[5] = TMPS1Info[5];
                S1Info[6] = TMPS1Info[6];
                S1Info[7] = TMPS1Info[7];
                S1Info[8] = Spouse1MarriageDate.getText();
                S1Info[9] = Spouse1DivorceDate.getText();
            }
            catch (ArrayIndexOutOfBoundsException ArrayEx) {
            }
        }
        if (Spouse2Info.getText() != null) {
            try {
                String TMPSpouse2 = Spouse2Info.getText();
                String[] TMPS2Info = TMPSpouse2.split("\\|");
                S2Info[0] = TMPS2Info[0];
                S2Info[1] = TMPS2Info[1];
                S2Info[2] = TMPS2Info[2];
                S2Info[3] = TMPS2Info[3];
                S2Info[4] = TMPS2Info[4];
                S2Info[5] = TMPS2Info[5];
                S2Info[6] = TMPS2Info[6];
                S2Info[7] = TMPS2Info[7];
                S2Info[8] = Spouse2MarriageDate.getText();
                S2Info[9] = Spouse2DivorceDate.getText();
            }
            catch (ArrayIndexOutOfBoundsException ArrayEx) {
            }
        }
        if (Spouse3Info.getText() != null) {
            try {
                String TMPSpouse3 = Spouse3Info.getText();
                String[] TMPS3Info = TMPSpouse3.split("\\|");
                S3Info[0] = TMPS3Info[0];
                S3Info[1] = TMPS3Info[1];
                S3Info[2] = TMPS3Info[2];
                S3Info[3] = TMPS3Info[3];
                S3Info[4] = TMPS3Info[4];
                S3Info[5] = TMPS3Info[5];
                S3Info[6] = TMPS3Info[6];
                S3Info[7] = TMPS3Info[7];
                S3Info[8] = Spouse3MarriageDate.getText();
                S3Info[9] = Spouse3DivorceDate.getText();
            }
            catch (ArrayIndexOutOfBoundsException ArrayEx) {
            }
        }
        if (Spouse4Info.getText() != null) {
            try {
                String TMPSpouse4 = Spouse4Info.getText();
                String[] TMPS4Info = TMPSpouse4.split("\\|");
                S4Info[0] = TMPS4Info[0];
                S4Info[1] = TMPS4Info[1];
                S4Info[2] = TMPS4Info[2];
                S4Info[3] = TMPS4Info[3];
                S4Info[4] = TMPS4Info[4];
                S4Info[5] = TMPS4Info[5];
                S4Info[6] = TMPS4Info[6];
                S4Info[7] = TMPS4Info[7];
                S4Info[8] = Spouse4MarriageDate.getText();
                S4Info[9] = Spouse4DivorceDate.getText();
            }
            catch (ArrayIndexOutOfBoundsException ArrayEx) {
            }
        }
        if (Widow.isSelected()) {
            MaritalStatus = "Widowed";
        }
        if (SFamilyName.trim().isEmpty() && S1Info[0].trim().isEmpty()) {
            MaritalStatus = "Single";
        }
        else if (!SFamilyName.trim().isEmpty()) {
            MaritalStatus = "Married";
        }
        else if (!SFamilyName.trim().isEmpty() && S1Info[0].trim().isEmpty()) {
            MaritalStatus = "Divorced";
        }
        if (child1FamilyName.getText() != null) {
            C1FamilyName = child1FamilyName.getText();
        }
        if (child1FirstName.getText() != null) {
            C1FirstName = child1FirstName.getText();
        }
        if (child1MiddleName.getText() != null) {
            C1MiddleName = child1MiddleName.getText();
        }
        if (child1DOB.getText() != null) {
            C1DOBDate = new DateValue(child1DOB.getText());
        }
        if (child1CityOfBirth.getText() != null) {
            C1CityBirth = child1CityOfBirth.getText();
        }
        if (child1CountryOfBirth.getText() != null) {
            C1CountryBirth = child1CountryOfBirth.getText();
        }
        if (child2FamilyName.getText() != null) {
            C2FamilyName = child2FamilyName.getText();
        }

        if (child2FirstName.getText() != null) {
            C2FirstName = child2FirstName.getText();
        }
        if (child2MiddleName.getText() != null) {
            C2MiddleName = child2MiddleName.getText();
        }
        if (child2ANum.getText() != null) {
            C2ANum = child2ANum.getText();
        }
        if (child2DOB.getText() != null) {
            C2DOBDate = new DateValue(child2DOB.getText());
        }
        if (child2CityOfBirth.getText() != null) {
            C2CityBirth = child2CityOfBirth.getText();
        }
        if (child2CountryOfBirth.getText() != null) {
            C2CountryBirth = child2CountryOfBirth.getText();
        }
        if (child3FamilyName.getText() != null) {
            C3FamilyName = child3FamilyName.getText();
        }
        if (child3FirstName.getText() != null) {
            C3MiddleName = child3FirstName.getText();
        }
        if (child3MiddleName.getText() != null) {
            C3FirstName = child3MiddleName.getText();
        }
        if (child3ANum.getText() != null) {
            C3ANum = child3ANum.getText();
        }
        if (child3DOB.getText() != null) {
            C3DOBDate = new DateValue(child3DOB.getText());
        }
        if (child3CityOfBirth.getText() != null) {
            C3CityBirth = child3CityOfBirth.getText();
        }
        if (child3CountryOfBirth.getText() != null) {
            C3CountryBirth = child3CountryOfBirth.getText();
        }
        if (child4Info.getText() != null) {
            if (!child4Info.getText().trim().isEmpty()) {
                needAddendum = true;
            }
            try {
                String TMPchild4 = child4Info.getText();
                String[] TMPC4Info = TMPchild4.split("\\|");
                C4Info[0] = TMPC4Info[0].trim();
                C4Info[1] = TMPC4Info[1].trim();
                C4Info[2] = TMPC4Info[2].trim();
                C4Info[3] = TMPC4Info[3].trim();
                C4Info[4] = TMPC4Info[4].trim();
                C4Info[5] = TMPC4Info[5].trim();
                C4Info[6] = TMPC4Info[6].trim();
                C4FamilyName = C4Info[0];
                C4FirstName = C4Info[1];
                C4MiddleName = C4Info[2];
                C4ANum = C4Info[3];
                C4DOBDate = new DateValue(C4Info[6]);
                C4CountryBirth = C4Info[5];
            }
            catch (ArrayIndexOutOfBoundsException ArrayEx) {
            }
        }
        if (child5Info.getText() != null) {
            try {
                String TMPchild5 = child5Info.getText();
                String[] TMPC5Info = TMPchild5.split("\\|");
                C5Info[0] = TMPC5Info[0].trim();
                C5Info[1] = TMPC5Info[1].trim();
                C5Info[2] = TMPC5Info[2].trim();
                C5Info[3] = TMPC5Info[3].trim();
                C5Info[4] = TMPC5Info[4].trim();
                C5Info[5] = TMPC5Info[5].trim();
                C5Info[6] = TMPC5Info[6].trim();
                C5FamilyName = C5Info[0];
                C5FirstName = C5Info[1];
                C5MiddleName = C5Info[2];
                C5ANum = C5Info[3];
                C5DOBDate = new DateValue(C5Info[6]);
                C5CountryBirth = C5Info[5];
            }

            catch (ArrayIndexOutOfBoundsException ArrayEx) {
            }
        }
        if (child6Info.getText() != null) {
            try {
                String TMPchild6 = child6Info.getText();
                String[] TMPC6Info = TMPchild6.split("\\|");
                C6Info[0] = TMPC6Info[0].trim();
                C6Info[1] = TMPC6Info[1].trim();
                C6Info[2] = TMPC6Info[2].trim();
                C6Info[3] = TMPC6Info[3].trim();
                C6Info[4] = TMPC6Info[4].trim();
                C6Info[5] = TMPC6Info[5].trim();
                C6Info[6] = TMPC6Info[6].trim();
                C6FamilyName = C6Info[0];
                C6FirstName = C6Info[1];
                C6MiddleName = C6Info[2];
                C6ANum = C6Info[3];
                C6DOBDate = new DateValue(C6Info[6]);
                C6CountryBirth = C6Info[5];
            }
            catch (ArrayIndexOutOfBoundsException ArrayEx) {
            }
        }
        if (child7Info.getText() != null) {
            try {
                String TMPchild7 = child7Info.getText();
                String[] TMPC7Info = TMPchild7.split("\\|");
                C7Info[0] = TMPC7Info[0].trim();
                C7Info[1] = TMPC7Info[1].trim();
                C7Info[2] = TMPC7Info[2].trim();
                C7Info[3] = TMPC7Info[3].trim();
                C7Info[4] = TMPC7Info[4].trim();
                C7Info[5] = TMPC7Info[5].trim();
                C7Info[6] = TMPC7Info[6].trim();
                C7FamilyName = C7Info[0];
                C7FirstName = C7Info[1];
                C7MiddleName = C7Info[2];
                C7ANum = C7Info[3];
                //C7DOBDate = C7Info[6];
                //C7CountryBirth = C7Info[5];
            }
            catch (ArrayIndexOutOfBoundsException ArrayEx) {
            }
        }
        if (!child7Info.getText().isEmpty()) {
            ChildNum = "6";
        }
        if (child7Info.getText().isEmpty()) {
            ChildNum = "5";
        }
        if (child6Info.getText().isEmpty()) {
            ChildNum = "4";
        }
        if (child5Info.getText().isEmpty()) {
            ChildNum = "4";
        }
        if (child4Info.getText().isEmpty()) {
            ChildNum = "3";
        }
        if (C3FamilyName.trim().isEmpty()) {
            ChildNum = "2";
        }
        if (C3FamilyName.trim().isEmpty()) {
            ChildNum = "2";
        }
        if (C2FamilyName.trim().isEmpty()) {
            ChildNum = "1";
        }
        if (C1FamilyName.trim().isEmpty()) {
            ChildNum = "0";
        }
        if (fatherFamilyName.getText() != null) {
            FFamilyName = fatherFamilyName.getText();
        }
        if (fatherFirstName.getText() != null) {
            FFirstName = fatherFirstName.getText();
        }
        if (fatherMiddleName.getText() != null) {
            FMiddleName = fatherMiddleName.getText();
        }
        if (fatherCityOfBirth.getText() != null) {
            FCityBirth = fatherCityOfBirth.getText();
        }
        if (fatherCountryOfBirth.getText() != null) {
            FCountryBirth = fatherCountryOfBirth.getText();
        }
        if (fatherCurrentCity.getText() != null) {
            FCityCurrent = fatherCurrentCity.getText();
        }
        if (fatherCurrentCountry.getText() != null) {
            FCountryCurrent = fatherCurrentCountry.getText();
        }
        if (FCityCurrent.trim().isEmpty()||FCountryBirth.trim().isEmpty()) {
            FCountryCurrent = "DECEASED";
            FCityCurrent = "DECEASED";
        }
        if (motherFamilyName.getText() != null) {
            MFamilyName = motherFamilyName.getText();
        }
        if (motherFirstName.getText() != null) {
            MFirstName = motherFirstName.getText();
        }
        if (motherMiddleName.getText() != null) {
            MMiddleName = motherMiddleName.getText();
        }
        if (motherCityOfBirth.getText() != null) {
            MCityBirth = motherCityOfBirth.getText();
        }
        if (motherCountryOfBirth.getText() != null) {
            MCountryBirth = motherCountryOfBirth.getText();
        }
        if (motherCurrentCity.getText() != null) {
            MCityCurrent = motherCurrentCity.getText();
        }
        if (motherCurrentCountry.getText() != null) {
            MCountryCurrent = motherCurrentCountry.getText();
        }
        if (MCityCurrent.trim().isEmpty()||MCountryBirth.trim().isEmpty()) {
            MCountryCurrent = "DECEASED";
            MCityCurrent = "DECEASED";
        }
        //---------------------------------------------------------
        if (AddressApt.isSelected()) {
            TenantInfo = "Apt";
        } else if (AddressSte.isSelected()) {
            TenantInfo = "Ste";
        } else if (AddressFlr.isSelected()) {
            TenantInfo = "Flr";
        }
        if (AddressApt1.isSelected()) {
            TenantInfo1 = "Apt1";
        } else if (AddressSte1.isSelected()) {
            TenantInfo1 = "Ste1";
        } else if (AddressFlr1.isSelected()) {
            TenantInfo1 = "Flr1";
        }
        if (AddressApt2.isSelected()) {
            TenantInfo2 = "Apt2";
        } else if (AddressSte2.isSelected()) {
            TenantInfo2 = "Ste2";
        } else if (AddressFlr2.isSelected()) {
            TenantInfo2 = "Flr2";
        }
        if (SpouseGender.isSelected()) {
            SGender = "Male";
        }
        else {
            SGender = "Female";
        }
        if (SpouseCoastGuard.isSelected()) {
            USGuard = "Guard-yes";
        }
        else if (SFamilyName.trim().isEmpty()) {
            USGuard = "Guard-NA";
        }
        else if (!SFamilyName.trim().isEmpty()) {
            USGuard = "Guard-no";
        }
        if (child1Apply.isSelected()) {
            C1status = "C1-yes";
        } else if (child1FamilyName.getText() != null) {
            C1status = "C1-no";
        }
        if (SpouseApply.isSelected()) {
            SApply = "SApply-yes";
        }
        else {
            SApply = "SApply-no";
        }
        if (child2Apply.isSelected()) {
            C2status = "C2-yes";
        } else if (child2FamilyName.getText() != null) {
            C2status = "C2-no";
        }
        if (child3Apply.isSelected()) {
            C3status = "C3-yes";
            C4status = "C4-yes";
            C5status = "C5-yes";
            C6status = "C6-yes";
            C7status = "C7-yes";
        } else if (child3FamilyName.getText() != null) {
            C3status = "C3-no";
            C4status = "C4-no";
            C5status = "C5-no";
            C6status = "C6-no";
            C7status = "C7-no";
        }
        if (child1Gender.isSelected()) {
            C1Gender = "Male";
        }
        else {
            C1Gender = "Female";
        }
        if (child2Gender.isSelected()) {
            C2Gender = "Male";
        }
        else {
            C2Gender = "Female";
        }
        if (child3Gender.isSelected()) {
            C3Gender = "Male";
        }
        else {
            C3Gender = "Female";
        }
        if (child1Apply.isSelected()) {
            C1status = "C1-yes";
            C1Files = true;
        }
        else {
            C1status = "C1-no";
        }
        if (child2Apply.isSelected()) {
            C2status = "C2-yes";
            C2Files = true;
        }
        else {
            C2status = "C2-no";
        }
        if (child3Apply.isSelected()) {
            C3status = "C3-yes";
            C3Files = true;
        }
        else {
            C3status = "C3-no";
        }
        CNameList[0] = C1FamilyName;
        CNameList[1] = C1FirstName;
        CNameList[2] = C1MiddleName;
        CNameList[3] = C2FamilyName;
        CNameList[4] = C2FirstName;
        CNameList[5] = C2MiddleName;
        CNameList[6] = C3FamilyName;
        CNameList[7] = C3FirstName;
        CNameList[8] = C3MiddleName;
        CANumList[0] = C1ANum;
        CANumList[1] = C2ANum;
        CANumList[2] = C3ANum;
        CGenderList[0] = C1Gender;
        CGenderList[1] = C2Gender;
        CGenderList[2] = C3Gender;
        //CDOBList[0] = C1DOBDate = new DateValue("");
        //CDOBList[1] = C2DOBDate = new DateValue("");
        //CDOBList[2] = C3DOBDate = new DateValue("");
        CCountryList[0] = C1CountryBirth;
        CCountryList[1] = C2CountryBirth;
        CCountryList[2] = C3CountryBirth;
        CApplyList[0] = C1Files;
        CApplyList[1] = C2Files;
        CApplyList[2] = C3Files;
    }

    public Scene getShadowScene(Parent p) {
        Scene scene;
        VBox outer = new VBox();
        outer.getChildren().add( p );
        outer.setPadding(new javafx.geometry.Insets(20.0d));
        outer.setBackground( new Background(new BackgroundFill( javafx.scene.paint.Color.rgb(0,0,0,0), new CornerRadii(0), new
                javafx.geometry.Insets(0))));

        p.setEffect(new DropShadow(GAUSSIAN, javafx.scene.paint.Color.rgb(0,0,0,.25), 15, 0, 0, 0));
        ((VBox)p).setBackground( new Background(new BackgroundFill( javafx.scene.paint.Color.TRANSPARENT, new CornerRadii(0), new Insets(0)
        )));

        scene = new Scene( outer );
        scene.setFill( Color.rgb(0,255,0,0) );
        return scene;
    }



    @FXML
    public void fillApp(ActionEvent event)  throws Exception {
        resetVars();
        needAddendum = false;
        SaveVars();
        addAddendums();
        fillAppHelper();
    }
    public void resetVars() throws Exception {
        String[] resetArray = {ANum, FamilyName, FirstName, MiddleName, FamilyName1, MiddleName1, FirstName1, FamilyName2, FirstName2, MiddleName2, FamilyName3, MiddleName3,
                FirstName3, Name, DOBDate.Value, CityBirth, CountryBirth, Nationality, SocialSecurity, AddressStreet, AddInfoAddress, AddressCity, State, Zipcode,
                PassportNum, TravelNum, ExpirationDate.Value, PassportCountry, EntryInspectionStatus, EntryParoledStatus, OtherStatus, EntryCity, EntryState,
                LastArrivalDate.Value, I94Num, ExpirationDate1.Value, I94Status, CurrentImmigrationStatus, I94FamilyName, I94FirstName, I94MiddleName,
                StartDate.Value, EndDate.Value, AddressStreet1, AddInfoAddress1, AddressCity1, State1, Zipcode1, Country1, StartDate1.Value,
                EndDate.Value, AddressStreet2, AddInfoAddress2, AddressCity2, State2, Zipcode2, Country2, StartDate2.Value, EndDate2.Value,
                FFamilyName, FFirstName, FMiddleName, FFamilyNameB, FFirstNameB, FMiddleNameB, FDOB.Value,
                FCityBirth, FCountryBirth, FCityCurrent, FCountryCurrent, MFamilyName, MFirstName, MMiddleName, MFamilyNameB, MFirstNameB, MMiddleNameB, MDOB.Value,
                MCityBirth, MCountryBirth, MCityCurrent, MCountryCurrent, MarriageNum, SFamilyName, SMiddleName, SFirstName, SANum, SDOBDate.Value, SMarriageDate,
                SCityBirth, SCountryBirth, DFamilyName, DFirstName, DMiddleName, DDOBDate.Value, DMarriageDate.Value, DCityMarriage, DStateMarriage, DMarriageEndDate.Value,
                SCityEnd, SStateEnd, SCountryEnd,  SCityMarriage, SCountryMarriage, ChildNum, C1FamilyName, C1MiddleName, C1FirstName, C1ANum, C1DOBDate.Value, C1MarriageDate.Value,
                C1CityBirth, C1CountryBirth, C2FamilyName, C2MiddleName, C2FirstName, C2ANum, C2DOBDate.Value, C2MarriageDate.Value, C2CityBirth, C2CountryBirth,
                C3FamilyName, C3MiddleName, C3FirstName, C3ANum, C3DOBDate.Value, C3MarriageDate.Value, C3CityBirth, C3CountryBirth, Feet, Inches, PD1, PD2, PD3,
                NameOrganization, CityOrganization, StateOrganization, CountryOrganization, NatureOrganization, OrganizationStartDate.Value, OrganizationEndDate.Value,
                NameOrganization1, CityOrganization1, StateOrganization1, CountryOrganization1, NatureOrganization1, OrganizationStartDate1.Value, OrganizationEndDate1.Value,
                NameOrganization2, CityOrganization2, StateOrganization2, CountryOrganization2, NatureOrganization2, OrganizationStartDate2.Value, OrganizationEndDate2.Value,
                ADayTimeNum, AMobNum, AEmail, SignatureDate.Value, IFamilyName, FamilyName, IFirstName, IOrganizationName, IAddressStreet, IAddInfoAddress, IAddressCity, IState,
                IZipcode, ICountry, IDayTimeNum, IMobNum, IEmail, Language, PN, PaN, IN, AddendumA, AddendumB, AddendumC, AddendumD, AddendumE, AddendumF, AddendumG, AddendumH, AddendumI,
                AddendumJ, PN1, PaN1, IN1, Addendum1A, Addendum1B, Addendum1C, Addendum1D, Addendum1E, Addendum1F, Addendum1G, Addendum1H, Addendum1I, Addendum1J, PN2, PaN2, IN2, Addendum2A,
                Addendum2B, Addendum2C, Addendum2D, Addendum2E, Addendum2F, Addendum2G, Addendum2J, PN3, PaN3, IN3, Addendum3A, Addendum3B, Addendum3C, Addendum3D, Addendum3E, Addendum3F,
                Addendum3G, Addendum3H, Addendum3I, PN4, PaN4, IN4, Addendum4A, Addendum4B, Addendum4C, Addendum4D, Addendum4E, Addendum4F, Addendum4G, Addendum4H, Addendum4I, Addendum4J,
                EntryI765,ANumChildren,C4FamilyName,C4FirstName,C4MiddleName,C4ANum,C4DOBDate.Value,C4CountryBirth,C5FamilyName,C5FirstName, C5MiddleName,C5ANum,C5DOBDate.Value,
                C5CountryBirth,C6FamilyName,C6FirstName,C6MiddleName,C6ANum,C6DOBDate.Value,C6CountryBirth,C7FamilyName,C7FirstName,C7MiddleName,C7ANum,C7DOBDate.Value,
                C7CountryBirth, AddressStreet3, AddInfoAddress3, AddressCity3, State3, Zipcode3, Country3, StartDate3.Value, EndDate3.Value,AGender, TenantInfo, AltTenantInfo,
                lastArrived, ImmigrationStatus, TenantInfo1, TenantInfo2, ETenantInfo, ETenantInfo1, ETenantInfo2, MaritalStatus, USGuard, SApply, C1status, C2status, C3status, Ethnicity, Race,
                EyeColor, HairColor, OrgAnswer, DisabilityAnswer, InterpreterQuestion, ITenantInfo, PTenantInfo, Q49, Q55, Q61, Q62, SocialSecurityBox,C4status,C5status,C6status,C7status};

        for (int j = 0; j < resetArray.length; j++) {
            resetArray[j] = "";
        }
        for (int b = 0; b < CApplyList.length; b++) {
            CApplyList[b] = false;
        }
        WorkInfoEntry = new jobData();

    }

    public void fillAppHelper() throws Exception {

        String NameTitle = new String();
        NameTitle = (FirstName + "_" + MiddleName + "_" + FamilyName).replace(" ","_");
        Name = NameTitle.replace("_"," ");
        String[] fieldArray = {ANum, FamilyName, FirstName, MiddleName, FamilyName1, MiddleName1, FirstName1, FamilyName2, FirstName2, MiddleName2, FamilyName3, MiddleName3,
                FirstName3, Name, DOBDate.Value, CityBirth, CountryBirth, Nationality, SocialSecurity, AddressStreet, AddInfoAddress, AddressCity, State, Zipcode,
                PassportNum, TravelNum, ExpirationDate.Value, PassportCountry, EntryInspectionStatus, EntryParoledStatus, OtherStatus, EntryCity, EntryState,
                LastArrivalDate.Value, I94Num, ExpirationDate1.Value, I94Status, CurrentImmigrationStatus, I94FamilyName, I94FirstName, I94MiddleName,
                StartDate.Value, EndDate.Value, AddressStreet1, AddInfoAddress1, AddressCity1, State1, Zipcode1, Country1, StartDate1.Value,
                EndDate.Value, AddressStreet2, AddInfoAddress2, AddressCity2, State2, Zipcode2, Country2, StartDate2.Value, EndDate2.Value, WorkInfoEntry.Root.Employer,
                WorkInfoEntry.Root.AddressStreet, WorkInfoEntry.Root.AddressAddInfo, WorkInfoEntry.Root.AddressCity, WorkInfoEntry.Root.State, WorkInfoEntry.Root.Zipcode,
                WorkInfoEntry.Root.Country, WorkInfoEntry.Root.Occupation, WorkInfoEntry.Root.StartDate.Value, WorkInfoEntry.Root.EndDate.Value,
                WorkInfoEntry.Root.NextNode.Employer, WorkInfoEntry.Root.NextNode.AddressStreet, WorkInfoEntry.Root.NextNode.AddressAddInfo, WorkInfoEntry.Root.NextNode.AddressCity,
                WorkInfoEntry.Root.NextNode.State, WorkInfoEntry.Root.NextNode.Zipcode, WorkInfoEntry.Root.NextNode.Country, WorkInfoEntry.Root.NextNode.Occupation, WorkInfoEntry.Root.NextNode.StartDate.Value,
                WorkInfoEntry.Root.NextNode.EndDate.Value, WorkInfoEntry.Root.NextNode.NextNode.Employer, WorkInfoEntry.Root.NextNode.NextNode.AddressStreet, WorkInfoEntry.Root.NextNode.NextNode.AddressAddInfo,
                WorkInfoEntry.Root.NextNode.NextNode.AddressCity, WorkInfoEntry.Root.NextNode.NextNode.State, WorkInfoEntry.Root.NextNode.NextNode.Zipcode, WorkInfoEntry.Root.NextNode.NextNode.Country,
                WorkInfoEntry.Root.NextNode.NextNode.Occupation, WorkInfoEntry.Root.NextNode.NextNode.StartDate.Value, WorkInfoEntry.Root.NextNode.NextNode.EndDate.Value,
                FFamilyName, FFirstName, FMiddleName, FFamilyNameB, FFirstNameB, FMiddleNameB, FDOB.Value,
                FCityBirth, FCountryBirth, FCityCurrent, FCountryCurrent, MFamilyName, MFirstName, MMiddleName, MFamilyNameB, MFirstNameB, MMiddleNameB, MDOB.Value,
                MCityBirth, MCountryBirth, MCityCurrent, MCountryCurrent, MarriageNum, SFamilyName, SMiddleName, SFirstName, SANum, SDOBDate.Value, SMarriageDate,
                SCityBirth, SCountryBirth, DFamilyName, DFirstName, DMiddleName, DDOBDate.Value, DMarriageDate.Value, DCityMarriage, DStateMarriage, DMarriageEndDate.Value,
                SCityEnd, SStateEnd, SCountryEnd,  SCityMarriage, SCountryMarriage, ChildNum, C1FamilyName, C1MiddleName, C1FirstName, C1ANum, C1DOBDate.Value, C1MarriageDate.Value,
                C1CityBirth, C1CountryBirth, C2FamilyName, C2MiddleName, C2FirstName, C2ANum, C2DOBDate.Value, C2MarriageDate.Value, C2CityBirth, C2CountryBirth,
                C3FamilyName, C3MiddleName, C3FirstName, C3ANum, C3DOBDate.Value, C3MarriageDate.Value, C3CityBirth, C3CountryBirth, Feet, Inches, PD1, PD2, PD3,
                NameOrganization, CityOrganization, StateOrganization, CountryOrganization, NatureOrganization, OrganizationStartDate.Value, OrganizationEndDate.Value,
                NameOrganization1, CityOrganization1, StateOrganization1, CountryOrganization1, NatureOrganization1, OrganizationStartDate1.Value, OrganizationEndDate1.Value,
                NameOrganization2, CityOrganization2, StateOrganization2, CountryOrganization2, NatureOrganization2, OrganizationStartDate2.Value, OrganizationEndDate2.Value,
                ADayTimeNum, AMobNum, AEmail, SignatureDate.Value, IFamilyName, FamilyName, IFirstName, IOrganizationName, IAddressStreet, IAddInfoAddress, IAddressCity, IState,
                IZipcode, ICountry, IDayTimeNum, IMobNum, IEmail, Language, PN, PaN, IN, AddendumA, AddendumB, AddendumC, AddendumD, AddendumE, AddendumF, AddendumG, AddendumH, AddendumI,
                AddendumJ, PN1, PaN1, IN1, Addendum1A, Addendum1B, Addendum1C, Addendum1D, Addendum1E, Addendum1F, Addendum1G, Addendum1H, Addendum1I, Addendum1J, PN2, PaN2, IN2, Addendum2A,
                Addendum2B, Addendum2C, Addendum2D, Addendum2E, Addendum2F, Addendum2G, Addendum2J, PN3, PaN3, IN3, Addendum3A, Addendum3B, Addendum3C, Addendum3D, Addendum3E, Addendum3F,
                Addendum3G, Addendum3H, Addendum3I, PN4, PaN4, IN4, Addendum4A, Addendum4B, Addendum4C, Addendum4D, Addendum4E, Addendum4F, Addendum4G, Addendum4H, Addendum4I, Addendum4J,
                EntryI765,ANumChildren,C4FamilyName,C4FirstName,C4MiddleName,C4ANum,C4DOBDate.Value,C4CountryBirth,C5FamilyName,C5FirstName, C5MiddleName,C5ANum,C5DOBDate.Value,
                C5CountryBirth,C6FamilyName,C6FirstName,C6MiddleName,C6ANum,C6DOBDate.Value,C6CountryBirth,C7FamilyName,C7FirstName,C7MiddleName,C7ANum,C7DOBDate.Value,
                C7CountryBirth, AddressStreet3, AddInfoAddress3, AddressCity3, State3, Zipcode3, Country3, StartDate3.Value, EndDate3.Value,AGender, TenantInfo, AltTenantInfo,
                lastArrived, ImmigrationStatus, TenantInfo1, TenantInfo2, ETenantInfo, ETenantInfo1, ETenantInfo2, MaritalStatus, USGuard, SApply, C1status, C2status, C3status, Ethnicity, Race,
                EyeColor, HairColor, OrgAnswer, DisabilityAnswer, InterpreterQuestion, ITenantInfo, PTenantInfo, Q49, Q55, Q61, Q62, SocialSecurityBox,C4status,C5status,C6status,C7status};
        String[] nameFieldArray = {"ANum", "FamilyName", "FirstName", "MiddleName", "FamilyName1", "MiddleName1", "FirstName1", "FamilyName2", "FirstName2", "MiddleName2", "FamilyName3", "MiddleName3",
                "FirstName3", "Name", "DOBDate", "CityBirth", "CountryBirth", "Nationality", "SocialSecurity", "AddressStreet", "AddInfoAddress", "AddressCity", "State", "Zipcode",
                "PassportNum", "TravelNum", "ExpirationDate", "PassportCountry", "EntryInspectionStatus", "EntryParoledStatus", "OtherStatus", "EntryCity", "EntryState",
                "LastArrivalDate", "I94Num", "ExpirationDate1", "I94Status", "CurrentImmigrationStatus", "I94FamilyName", "I94FirstName", "I94MiddleName",
                "StartDate", "EndDate", "AddressStreet1", "AddInfoAddress1", "AddressCity1", "State1", "Zipcode1", "Country1", "StartDate1", "EndDate", "AddressStreet2",
                "AddInfoAddress2", "AddressCity2", "State2", "Zipcode2", "Country2", "StartDate2", "EndDate2", "Employer", "WorkAddressStreet", "WorkAddInfoAddress", "WorkAddressCity",
                "WorkState", "WorkZipcode", "WorkCountry", "WorkOccupation", "WorkStartDate", "WorkEndDate", "Employer1", "WorkAddressStreet1", "WorkAddInfoAddress1", "WorkAddressCity1", "WorkState1", "WorkZipcode1", "WorkCountry1", "WorkOccupation1", "WorkStartDate1",
                "WorkEndDate1", "Employer2", "WorkAddressStreet2", "WorkAddInfoAddress2", "WorkAddressCity2", "WorkState2", "WorkZipcode2", "WorkCountry2", "WorkOccupation2",
                "WorkStartDate2", "WorkEndDate2", "FFamilyName", "FFirstName", "FMiddleName", "FFamilyNameB", "FFirstNameB", "FMiddleNameB", "FDOB",
                "FCityBirth", "FCountryBirth", "FCityCurrent", "FCountryCurrent", "MFamilyName", "MFirstName", "MMiddleName", "MFamilyNameB", "MFirstNameB", "MMiddleNameB", "MDOB",
                "MCityBirth", "MCountryBirth", "MCityCurrent", "MCountryCurrent", "MarriageNum", "SFamilyName", "SMiddleName", "SFirstName", "SANum", "SDOBDate", "SMarriageDate",
                "SCityBirth", "SCountryBirth", "DFamilyName", "DFirstName", "DMiddleName", "DDOBDate", "DMarriageDate", "DCityMarriage", "DStateMarriage", "DMarriageEndDate",
                "SCityEnd", "SStateEnd", "SCountryEnd", " SCityMarriage", "SCountryMarriage", "ChildNum", "C1FamilyName", "C1MiddleName", "C1FirstName", "C1ANum", "C1DOBDate", "C1MarriageDate",
                "C1CityBirth", "C1CountryBirth", "C2FamilyName", "C2MiddleName", "C2FirstName", "C2ANum", "C2DOBDate", "C2MarriageDate", "C2CityBirth", "C2CountryBirth",
                "C3FamilyName", "C3MiddleName", "C3FirstName", "C3ANum", "C3DOBDate", "C3MarriageDate", "C3CityBirth", "C3CountryBirth", "Feet", "Inches", "PD1", "PD2", "PD3",
                "NameOrganization", "CityOrganization", "StateOrganization", "CountryOrganization", "NatureOrganization", "OrganizationStartDate", "OrganizationEndDate",
                "NameOrganization1", "CityOrganization1", "StateOrganization1", "CountryOrganization1", "NatureOrganization1", "OrganizationStartDate1", "OrganizationEndDate1",
                "NameOrganization2", "CityOrganization2", "StateOrganization2", "CountryOrganization2", "NatureOrganization2", "OrganizationStartDate2", "OrganizationEndDate2",
                "ADayTimeNum", "AMobNum", "AEmail", "SignatureDate", "IFamilyName", "FamilyName", "IFirstName", "IOrganizationName", "IAddressStreet", "IAddInfoAddress", "IAddressCity", "IState",
                "IZipcode", "ICountry", "IDayTimeNum", "IMobNum", "IEmail", "Language", "PN", "PaN", "IN", "AddendumA", "AddendumB", "AddendumC", "AddendumD", "AddendumE", "AddendumF", "AddendumG", "AddendumH", "AddendumI",
                "AddendumJ", "PN1", "PaN1", "IN1", "Addendum1A", "Addendum1B", "Addendum1C", "Addendum1D", "Addendum1E", "Addendum1F", "Addendum1G", "Addendum1H", "Addendum1I", "Addendum1J", "PN2",
                "PaN2", "IN2", "Addendum2A", "Addendum2B", "Addendum2C", "Addendum2D", "Addendum2E", "Addendum2F", "Addendum2G", "Addendum2J", "PN3", "PaN3", "IN3", "Addendum3A", "Addendum3B", "Addendum3C", "Addendum3D", "Addendum3E", "Addendum3F",
                "Addendum3G", "Addendum3H", "Addendum3I", "PN4", "PaN4", "IN4", "Addendum4A", "Addendum4B", "Addendum4C", "Addendum4D", "Addendum4E", "Addendum4F", "Addendum4G", "Addendum4H","Addendum4I", "Addendum4J",
                "EntryI765","ANumChildren","C4FamilyName","C4FirstName","C4MiddleName","C4ANum","C4DOBDate","C4CountryBirth","C5FamilyName","C5FirstName", "C5MiddleName","C5ANum","C5DOBDate",
                "C5CountryBirth","C6FamilyName","C6FirstName","C6MiddleName","C6ANum","C6DOBDate","C6CountryBirth","C7FamilyName","C7FirstName","C7MiddleName","C7ANum","C7DOBDate",
                "C7CountryBirth", "AddressStreet3", "AddInfoAddress3", "AddressCity3", "State3", "Zipcode3", "Country3", "StartDate3", "EndDate3","AGender", "TenantInfo", "AltTenantInfo",
                "lastArrived", "ImmigrationStatus", "TenantInfo1", "TenantInfo2", "ETenantInfo", "ETenantInfo1", "ETenantInfo2", "MaritalStatus", "USGuard", "SApply", "C1status", "C2status", "C3status", "Ethnicity", "Race",
                "EyeColor", "HairColor", "OrgAnswer", "DisabilityAnswer", "InterpreterQuestion", "ITenantInfo", "PTenantInfo", "Q49", "Q55", "Q61", "Q62", "SocialSecurityBox","C4status","C5status","C6status","C7status"};
        String[] checkArray = {AGender, TenantInfo, AltTenantInfo, lastArrived, ImmigrationStatus, TenantInfo1, TenantInfo2, ETenantInfo,
                ETenantInfo1, ETenantInfo2, MaritalStatus, USGuard, SApply, C1status, C2status, C3status, Ethnicity, Race, EyeColor, HairColor, OrgAnswer,
                DisabilityAnswer, InterpreterQuestion, ITenantInfo, PTenantInfo, Q49, Q55, Q61, Q62, SocialSecurityBox,C4status,C5status,C6status,C7status};
        if (fileType == "") {
            fileType = "i-485";
        }
        InputStream in = getClass().getResourceAsStream("resources/pdf/" + fileType + ".pdf");
        PDDocument document = PDDocument.load(in);
        PDDocumentCatalog docCatalog = document.getDocumentCatalog();
        PDAcroForm acroForm = docCatalog.getAcroForm();
        for (int i = 0; i < fieldArray.length; i++) {
            String entryFieldArray = fieldArray[i];
            String entryNameArray = nameFieldArray[i];
            //System.out.println(entryFieldArray + " : " + entryNameArray);
            try {
                PDField fieldTemp = acroForm.getField(entryNameArray);
                if (fieldTemp != null) {
                    fieldTemp.setValue(entryFieldArray.toUpperCase());
                }
            }
            catch (Exception ex){ }
        }
        for (int b = 0; b < checkArray.length; b++) {
            String entryCheckArray = checkArray[b];
            if (entryCheckArray.trim() != "") {
                PDCheckBox boxTemp = (PDCheckBox) acroForm.getField(entryCheckArray);
                try {
                    boxTemp.check();
                }
                catch (NullPointerException problem) {
                }
            }
        }
        FileChooser pdfFile = new FileChooser();
        pdfFile.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
        pdfFile.setTitle("Save " + fileType.toUpperCase());
        pdfFile.setInitialFileName(fileType + "-" + NameTitle + ".pdf");
        File dest = pdfFile.showSaveDialog(null);
        String pathFile = new String();
        if (dest != null) {
            try {
                pathFile = dest.getAbsolutePath();
                document.save(pathFile);
                document.close();
            } catch (IOException ex) {
                alertMessage();
                document.close();
            }
        }
        document.close();
        fileAddApplication();
    }

    public void fileAddApplication() throws Exception {
        if (C1SpouseNumber.trim().isEmpty()) {
            C1SpouseNumber = "1";
        }
        if (fileIteration < Integer.valueOf(ChildNum) && CApplyList[fileIteration]) {
            if (AGender == "Male") {
                FFamilyName = FamilyName;
                FFirstName = FirstName;
                FMiddleName = MiddleName;
                FDOB = DOBDate = new DateValue("");
                FCountryBirth = CountryBirth;
                FCityBirth = CityBirth;
                FCountryCurrent = "USA";
                FCityBirth = CityBirth;
                FCityCurrent = AddressCity;
                if (C1SpouseNumber.equals("1")) {
                    MFamilyName = SFamilyName;
                    MFirstName = SFirstName;
                    MMiddleName = SMiddleName;
                    MDOB = SDOBDate = new DateValue("");
                    MCountryBirth = SCountryBirth;
                    MCityBirth = SCityBirth;
                    MCountryCurrent = "USA";
                    MCityCurrent = AddressCity;
                }
                else if (C1SpouseNumber.equals("2")) {
                    MFamilyName = S1Info[0];
                    MFirstName = S1Info[1];
                    MMiddleName = S1Info[2];
                    MCountryBirth = S1Info[3];
                    MDOB = new DateValue(S1Info[4]);
                    MCityBirth = "";
                    MCountryCurrent = "";
                    MCityCurrent = "";
                }
                else if (C1SpouseNumber.equals("3")) {
                    MFamilyName = S2Info[0];
                    MFirstName = S2Info[1];
                    MMiddleName = S2Info[2];
                    MCountryBirth = S2Info[3];
                    MDOB = new DateValue(S2Info[4]);
                    MCityBirth = "";
                    MCountryCurrent = "";
                    MCityCurrent = "";
                }
                else if (C1SpouseNumber.equals("4")) {
                    MFamilyName = S3Info[0];
                    MFirstName = S3Info[1];
                    MMiddleName = S3Info[2];
                    MCountryBirth = S3Info[3];
                    MDOB = new DateValue(S3Info[4]);
                    MCityBirth = "";
                    MCountryCurrent = "";
                    MCityCurrent = "";
                }
                else if (C1SpouseNumber.equals("5")) {
                    MFamilyName = S4Info[0];
                    MFirstName = S4Info[1];
                    MMiddleName = S4Info[2];
                    MCountryBirth = S4Info[3];
                    MDOB = new DateValue(S4Info[4]);
                    MCityBirth = "";
                    MCountryCurrent = "";
                    MCityCurrent = "";
                }
                if (C2SpouseNumber.equals("1")) {
                    MFamilyName = SFamilyName;
                    MFirstName = SFirstName;
                    MMiddleName = SMiddleName;
                    MDOB = SDOBDate = new DateValue("");
                    MCountryBirth = SCountryBirth;
                    MCityBirth = SCityBirth;
                    MCountryCurrent = "USA";
                    MCityCurrent = AddressCity;
                }
                else if (C2SpouseNumber.equals("2")) {
                    MFamilyName = S1Info[0];
                    MFirstName = S1Info[1];
                    MMiddleName = S1Info[2];
                    MCountryBirth = S1Info[3];
                    MDOB = new DateValue(S1Info[4]);
                    MCityBirth = "";
                    MCountryCurrent = "";
                    MCityCurrent = "";
                }
                else if (C2SpouseNumber.equals("3")) {
                    MFamilyName = S2Info[0];
                    MFirstName = S2Info[1];
                    MMiddleName = S2Info[2];
                    MCountryBirth = S2Info[3];
                    MDOB = new DateValue(S2Info[4]);
                    MCityBirth = "";
                    MCountryCurrent = "";
                    MCityCurrent = "";
                }
                else if (C2SpouseNumber.equals("4")) {
                    MFamilyName = S3Info[0];
                    MFirstName = S3Info[1];
                    MMiddleName = S3Info[2];
                    MCountryBirth = S3Info[3];
                    MDOB = new DateValue(S3Info[4]);
                    MCityBirth = "";
                    MCountryCurrent = "";
                    MCityCurrent = "";
                }
                else if (C2SpouseNumber.equals("5")) {
                    MFamilyName = S4Info[0];
                    MFirstName = S4Info[1];
                    MMiddleName = S4Info[2];
                    MCountryBirth = S4Info[3];
                    MDOB = new DateValue(S4Info[4]);
                    MCityBirth = "";
                    MCountryCurrent = "";
                    MCityCurrent = "";
                }
                if (C3SpouseNumber.equals("1")) {
                    MFamilyName = SFamilyName;
                    MFirstName = SFirstName;
                    MMiddleName = SMiddleName;
                    MDOB = SDOBDate = new DateValue("");
                    MCountryBirth = SCountryBirth;
                    MCityBirth = SCityBirth;
                    MCountryCurrent = "USA";
                    MCityCurrent = AddressCity;
                }
                else if (C3SpouseNumber.equals("2")) {
                    MFamilyName = S1Info[0];
                    MFirstName = S1Info[1];
                    MMiddleName = S1Info[2];
                    MCountryBirth = S1Info[3];
                    MDOB = new DateValue(S1Info[4]);
                    MCityBirth = "";
                    MCountryCurrent = "";
                    MCityCurrent = "";
                }
                else if (C3SpouseNumber.equals("3")) {
                    MFamilyName = S2Info[0];
                    MFirstName = S2Info[1];
                    MMiddleName = S2Info[2];
                    MCountryBirth = S2Info[3];
                    MDOB = new DateValue(S2Info[4]);
                    MCityBirth = "";
                    MCountryCurrent = "";
                    MCityCurrent = "";
                }
                else if (C3SpouseNumber.equals("4")) {
                    MFamilyName = S3Info[0];
                    MFirstName = S3Info[1];
                    MMiddleName = S3Info[2];
                    MCountryBirth = S3Info[3];
                    MDOB = new DateValue(S3Info[4]);
                    MCityBirth = "";
                    MCountryCurrent = "";
                    MCityCurrent = "";
                }
                else if (C3SpouseNumber.equals("5")) {
                    MFamilyName = S4Info[0];
                    MFirstName = S4Info[1];
                    MMiddleName = S4Info[2];
                    MCountryBirth = S4Info[3];
                    MDOB = new DateValue(S4Info[4]);
                    MCityBirth = "";
                    MCountryCurrent = "";
                    MCityCurrent = "";
                }

            }
            else if (AGender == "Female") {
                MFamilyName = FamilyName;
                MFirstName = FirstName;
                MMiddleName = MiddleName;
                MDOB = DOBDate = new DateValue("");
                MCountryBirth = CountryBirth;
                MCityBirth = CityBirth;
                MCountryCurrent = "USA";
                MCityCurrent = AddressCity;
                if (C1SpouseNumber.equals("1")) {
                    FFamilyName = SFamilyName;
                    FFirstName = SFirstName;
                    FMiddleName = SMiddleName;
                    FDOB = SDOBDate = new DateValue("");
                    FCountryBirth = SCountryBirth;
                    FCityBirth = SCityBirth;
                    FCountryCurrent = "USA";
                    FCityCurrent = AddressCity;
                }
                else if (C1SpouseNumber.equals("2")) {
                    FFamilyName = S1Info[0];
                    FFirstName = S1Info[1];
                    FMiddleName = S1Info[2];
                    FCountryBirth = S1Info[3];
                    FDOB = new DateValue(S1Info[4]);
                    FCityBirth = "";
                    FCountryCurrent = "";
                    FCityCurrent = "";
                }
                else if (C1SpouseNumber.equals("3")) {
                    FFamilyName = S2Info[0];
                    FFirstName = S2Info[1];
                    FMiddleName = S2Info[2];
                    FCountryBirth = S2Info[3];
                    FDOB = new DateValue(S2Info[4]);
                    FCityBirth = "";
                    FCountryCurrent = "";
                    FCityCurrent = "";
                }
                else if (C1SpouseNumber.equals("4")) {
                    FFamilyName = S3Info[0];
                    FFirstName = S4Info[1];
                    FMiddleName = S4Info[2];
                    FCountryBirth = S4Info[3];
                    FDOB = new DateValue(S4Info[4]);
                    FCityBirth = "";
                    FCountryCurrent = "";
                    FCityCurrent = "";
                }
                else if (C1SpouseNumber.equals("5")) {
                    FFamilyName = S4Info[0];
                    FFirstName = S4Info[1];
                    FMiddleName = S4Info[2];
                    FCountryBirth = S4Info[3];
                    FDOB = new DateValue(S4Info[4]);
                    FCityBirth = "";
                    FCountryCurrent = "";
                    FCityCurrent = "";
                }
                if (C2SpouseNumber.equals("1")) {
                    FFamilyName = SFamilyName;
                    FFirstName = SFirstName;
                    FMiddleName = SMiddleName;
                    FDOB = SDOBDate = new DateValue("");
                    FCountryBirth = SCountryBirth;
                    FCityBirth = SCityBirth;
                    FCountryCurrent = "USA";
                    FCityCurrent = AddressCity;
                }
                else if (C2SpouseNumber.equals("2")) {
                    FFamilyName = S1Info[0];
                    FFirstName = S1Info[1];
                    FMiddleName = S1Info[2];
                    FCountryBirth = S1Info[3];
                    FDOB = new DateValue(S1Info[4]);
                    FCityBirth = "";
                    FCountryCurrent = "";
                    FCityCurrent = "";
                }
                else if (C2SpouseNumber.equals("3")) {
                    FFamilyName = S2Info[0];
                    FFirstName = S2Info[1];
                    FMiddleName = S2Info[2];
                    FCountryBirth = S2Info[3];
                    FDOB = new DateValue(S2Info[4]);
                    FCityBirth = "";
                    FCountryCurrent = "";
                    FCityCurrent = "";
                }
                else if (C2SpouseNumber.equals("4")) {
                    FFamilyName = S3Info[0];
                    FFirstName = S4Info[1];
                    FMiddleName = S4Info[2];
                    FCountryBirth = S4Info[3];
                    FDOB = new DateValue(S4Info[4]);
                    FCityBirth = "";
                    FCountryCurrent = "";
                    FCityCurrent = "";
                }
                else if (C2SpouseNumber.equals("5")) {
                    FFamilyName = S4Info[0];
                    FFirstName = S4Info[1];
                    FMiddleName = S4Info[2];
                    FCountryBirth = S4Info[3];
                    FDOB = new DateValue(S4Info[4]);
                    FCityBirth = "";
                    FCountryCurrent = "";
                    FCityCurrent = "";
                }
                if (C3SpouseNumber.equals("1")) {
                    FFamilyName = SFamilyName;
                    FFirstName = SFirstName;
                    FMiddleName = SMiddleName;
                    FDOB = SDOBDate = new DateValue("");
                    FCountryBirth = SCountryBirth;
                    FCityBirth = SCityBirth;
                    FCountryCurrent = "USA";
                    FCityCurrent = AddressCity;
                }
                else if (C3SpouseNumber.equals("2")) {
                    FFamilyName = S1Info[0];
                    FFirstName = S1Info[1];
                    FMiddleName = S1Info[2];
                    FCountryBirth = S1Info[3];
                    FDOB = new DateValue(S1Info[4]);
                    FCityBirth = "";
                    FCountryCurrent = "";
                    FCityCurrent = "";
                }
                else if (C3SpouseNumber.equals("3")) {
                    FFamilyName = S2Info[0];
                    FFirstName = S2Info[1];
                    FMiddleName = S2Info[2];
                    FCountryBirth = S2Info[3];
                    FDOB = new DateValue(S2Info[4]);
                    FCityBirth = "";
                    FCountryCurrent = "";
                    FCityCurrent = "";
                }
                else if (C3SpouseNumber.equals("4")) {
                    FFamilyName = S3Info[0];
                    FFirstName = S4Info[1];
                    FMiddleName = S4Info[2];
                    FCountryBirth = S4Info[3];
                    FDOB = new DateValue(S4Info[4]);
                    FCityBirth = "";
                    FCountryCurrent = "";
                    FCityCurrent = "";
                }
                else if (C3SpouseNumber.equals("5")) {
                    FFamilyName = S4Info[0];
                    FFirstName = S4Info[1];
                    FMiddleName = S4Info[2];
                    FCountryBirth = S4Info[3];
                    FDOB = new DateValue(S4Info[4]);
                    FCityBirth = "";
                    FCountryCurrent = "";
                    FCityCurrent = "";
                }
            }

            FamilyName = CNameList[3 * fileIteration];
            FirstName = CNameList[3 * fileIteration + 1];
            MiddleName = CNameList[3 * fileIteration + 2];
            if (C1FamilyName1.trim().isEmpty()) {
                FamilyName1 = "NONE";
            }
            else {
                FamilyName1 = C1FamilyName1;
                FirstName1 = C1FirstName1;
                MiddleName1 = C1MiddleName1;
            }
            ANum = CANumList[fileIteration];
            Feet = C1Feet;
            Inches = C1Inches;
            Ethnicity = C1Ethnicity;
            Race = C1Race;
            SFamilyName = "";
            SFirstName = "";
            SMiddleName = "";
            SDOBDate = new DateValue(null);
            SApply = "";
            C1FamilyName = "";
            C1FirstName = "";
            C1MiddleName = "";
            C2FamilyName = "";
            C2FirstName = "";
            C2MiddleName = "";
            C3FamilyName = "";
            C3FirstName = "";
            C3MiddleName = "";
            C1CountryBirth = "";
            C2CountryBirth = "";
            C3CountryBirth = "";
            Q49 = "49-no";
            Q55 = "55-no";
            Q61 = "61-no";
            Q62 = "62-no";
            if (!protectAdd) {
                AddendumA = "";
                AddendumB = "";
                AddendumC = "";
                AddendumD = "";
                AddendumE = "";
                AddendumF = "";
                AddendumG = "";
                AddendumH = "";
                AddendumI = "";
            }
            if (!protectAdd1) {
                Addendum1A = "";
                Addendum1B = "";
                Addendum1C = "";
                Addendum1D = "";
                Addendum1E = "";
                Addendum1F = "";
                Addendum1G = "";
                Addendum1H = "";
                Addendum1I = "";
            }
            Addendum2A = "";
            Addendum2B = "";
            Addendum2C = "";
            Addendum2D = "";
            Addendum2E = "";
            Addendum2F = "";
            Addendum2G = "";
            Addendum2H = "";
            Addendum2I = "";
            Addendum3A = "";
            Addendum3B = "";
            Addendum3C = "";
            Addendum3D = "";
            Addendum3E = "";
            Addendum3F = "";
            Addendum3G = "";
            Addendum3H = "";
            Addendum3I = "";
            Addendum4A = "";
            Addendum4B = "";
            Addendum4C = "";
            Addendum4D = "";
            Addendum4E = "";
            Addendum4F = "";
            Addendum4G = "";
            Addendum4H = "";
            Addendum4I = "";
            CheckNum += 1;
            NameOrganization = "";
            CityOrganization = "";
            StateOrganization = "";
            CountryOrganization = "";
            NatureOrganization = "";
            OrganizationStartDate = new DateValue(null);
            OrganizationEndDate = new DateValue(null);
            NameOrganization1 = "";
            CityOrganization1 = "";
            StateOrganization1 = "";
            CountryOrganization1 = "";
            NatureOrganization1 = "";
            OrganizationStartDate1 = new DateValue(null);
            OrganizationEndDate1 = new DateValue(null);
            NameOrganization2 = "";
            CityOrganization2 = "";
            StateOrganization2 = "";
            CountryOrganization2 = "";
            NatureOrganization2 = "";
            OrganizationStartDate2 = new DateValue(null);
            OrganizationEndDate2 = new DateValue(null);
            MaritalStatus = "Single";
            USGuard = "Guard-NA";
            fileIteration += 1;
            needAddendum = false;
            fillAppHelper();
        }
        else if (fileIteration < Integer.valueOf(ChildNum)){
            CheckNum += 1;
            fileIteration += 1;
        }
    }
    public void addAddendums() throws Exception {
        try {
            Files.deleteIfExists(Paths.get("src/sample/resources/pdf/temporary/work.pdf"));
        }
        catch (Exception ex) {
            System.out.println("file Error");
        }
        if (needAddendum) {
            PDFMergerUtility mergerOfPDfs = new PDFMergerUtility();
            InputStream mainFile = getClass().getResourceAsStream("resources/pdf/" + fileType + ".pdf");
            InputStream children = getClass().getResourceAsStream("resources/pdf/addendum_children.pdf");
            InputStream address = getClass().getResourceAsStream("resources/pdf/addendum_addresses.pdf");
            mergerOfPDfs.addSource(mainFile);
            if (!Address3Info.getText().trim().isEmpty()) {
                mergerOfPDfs.addSource(address);
            }
            if (!child4Info.getText().trim().isEmpty()) {
                mergerOfPDfs.addSource(children);
            }
            OutputStream dest = new FileOutputStream("src/sample/resources/pdf/temporary/work.pdf");
            mergerOfPDfs.setDestinationStream(dest);
            mergerOfPDfs.mergeDocuments(MemoryUsageSetting.setupTempFileOnly());
            Thread.sleep(4000);
            PDDocument document = PDDocument.load(getClass().getResourceAsStream("resources/pdf/temporary/work.pdf"));
        }
    }
    public void alertMessage() {
        Alert fileSaveError = new Alert(Alert.AlertType.WARNING);
        stage = (Stage) fileSaveError.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(ClassLoader.getSystemResourceAsStream("sample/resources/images/error.png")));
        fileSaveError.setResizable(false);
        fileSaveError.setTitle("Error Message");
        fileSaveError.setHeaderText("Overwrite Failed");
        fileSaveError.setContentText("Your file failed to save. Please try again.");
        fileSaveError.showAndWait();
    }
}