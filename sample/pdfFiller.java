package sample;
import java.io.*;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.*;


class pdfFiller {

    public static String ANum = "123456789";
    public static String FamilyName = "Bey";
    public static String FirstName = "Mehmet";
    public static String MiddleName = "Celal";
    public static String FamilyName1 = "None";
    public static String FirstName1 = "";
    public static String MiddleName1 = "";
    public static String FamilyName2 = "";
    public static String FirstName2 = "";
    public static String MiddleName2 = "";
    public static String Name = FirstName + " " + MiddleName + " " + FamilyName;
    public static String CityBirth = "Istanbul";
    public static String DOBDate = "02/15/1863";
    public static String CountryBirth = "Ottoman Empire";
    public static String Nationality = "Turkish";
    public static String SocialSecurity = "123456789";
    public static String AddressStreet = "Hagia Sofia Lane";
    public static String AddInfoAddress = "3A";
    public static String AddressCity = "New York City";
    public static String State = "NY";
    public static String Zipcode = "07401";
    public static String PassportNum = "A37212BA2";
    public static String TravelNum = "1234-ABCD-5678-EFGH";
    public static String ExpirationDate = "12/24/2020";
    public static String PassportCountry = "Turkey";
    public static String EntryCity = "Miami";
    public static String EntryState = "FL";
    public static String LastArrivalDate = "01/20/2012";
    public static String I94Num = "12345678901";
    public static String ExpirationDate1 = "06/30/2020";
    public static String I94Status = "Refugee";
    public static String CurrentImmigrationStatus = "N/A";
    public static String I94FamilyName = "Bey";
    public static String I94FirstName = "Mehmet";
    public static String I94MiddleName = "Celal";
    public static String StartDate = "10/10/2010";
    public static String EndDate = "PRESENT";
    public static String AddressStreet1 = "";
    public static String AddInfoAddress1 = "";
    public static String AddressCity1 = "";
    public static String State1 = "";
    public static String Zipcode1 = "";
    public static String Country1 = "";
    public static String StartDate1 = "";
    public static String EndDate1 = "";
    public static String AddressStreet2 = "";
    public static String AddInfoAddress2 = "";
    public static String AddressCity2 = "";
    public static String State2 = "";
    public static String Zipcode2 = "";
    public static String Country2 = "";
    public static String StartDate2 = "";
    public static String EndDate2 = "";
    public static String Employer = "RA Motors";
    public static String WorkAddressStreet = "SD";
    public static String WorkAddInfoAddress = "SDASD";
    public static String WorkAddressCity = "ASDA";
    public static String WorkState = "NJ";
    public static String WorkZipcode = "01327";
    public static String WorkCountry = "USA";
    public static String WorkStartDate = "12/10/2010";
    public static String WorkEndDate = "12/10/2015";
    public static String Employer1 = "";
    public static String WorkAddressStreet1 = "";
    public static String WorkAddInfoAddress1 = "";
    public static String WorkAddressCity1 = "";
    public static String WorkState1 = "";
    public static String WorkZipcode1 = "";
    public static String WorkCountry1 = "";
    public static String WorkStartDate1 = "";
    public static String WorkEndDate1 = "";
    public static String Employer2 = "";
    public static String WorkAddressStreet2 = "";
    public static String WorkAddInfoAddress2 = "";
    public static String WorkAddressCity2 = "";
    public static String WorkState2 = "";
    public static String WorkZipcode2 = "";
    public static String WorkCountry2 = "";
    public static String WorkStartDate2 = "";
    public static String WorkEndDate2 = "";
    public static String FFamilyName = "Bey";
    public static String FFirstName = "Lol";
    public static String FMiddleName = "sda";
    public static String FFamilyNameB = "N/A";
    public static String FFirstNameB = "";
    public static String FMiddleNameB = "";
    public static String FDOB = "08/21/1958";
    public static String FCityBirth = "Istanbul";
    public static String FCountryBirth = "Ottoman Empire";
    public static String FCityCurrent = "Rahway";
    public static String FCountryCurrent = "USA";
    public static String MFamilyName = "Bey";
    public static String MFirstName = "Lol";
    public static String MMiddleName = "sda";
    public static String MFamilyNameB = "N/A";
    public static String MFirstNameB = "";
    public static String MMiddleNameB = "";
    public static String MDOB = "04/12/1948";
    public static String MCityBirth = "Istanbul";
    public static String MCountryBirth = "Ottoman Empire";
    public static String MCityCurrent = "Rahway";
    public static String MCountryCurrent = "USA";
    public static String MarriageNum = "2";
    public static String SFamilyName1 = "Braton";
    public static String SMiddleName1 = "May";
    public static String SFirstName1 = "Angela";
    public static String SANum = "123456789";
    public static String SDOBDate = "05/31/1987";
    public static String SMarriageDate = "05/31/2007";
    public static String SCityBirth = "Istanbul";
    public static String SCountryBirth = "Turkey";
    public static String DFamilyName = "Jo";
    public static String DFirstName = "Mary";
    public static String DMiddleName = "Barbara";
    public static String DDOBDate = "03/23/1975";
    public static String DMarriageDate = "07/18/2012";
    public static String DCityMarriage = "Rome";
    public static String DStateMarriage = "";
    public static String DMarriageEndDate  = "07/18/2012";
    public static String SCityEnd = "New York City";
    public static String SStateEnd = "NY";
    public static String SCountryEnd = "USA";
    public static String ChildNum = "2";
    public static String C1FamilyName1 = "Braton";
    public static String C1MiddleName1 = "May";
    public static String C1FirstName1 = "Angela";
    public static String C1ANum = "123456789";
    public static String C1DOBDate = "05/31/1987";
    public static String C1MarriageDate = "05/31/2007";
    public static String C1CityBirth = "Istanbul";
    public static String C1CountryBirth = "Turkey";
    public static String C2FamilyName = "Braton";
    public static String C2MiddleName = "May";
    public static String C2FirstName = "Angela";
    public static String C2ANum = "123456789";
    public static String C2DOBDate = "05/31/1987";
    public static String C2MarriageDate = "05/31/2007";
    public static String C2CityBirth = "Istanbul";
    public static String C2CountryBirth = "Turkey";
    public static String C3FamilyName = "Braton";
    public static String C3MiddleName = "May";
    public static String C3FirstName = "Angela";
    public static String C3ANum = "123456789";
    public static String C3DOBDate = "05/31/1987";
    public static String C3MarriageDate = "05/31/2007";
    public static String C3CityBirth = "Istanbul";
    public static String C3CountryBirth = "Turkey";
    public static String Feet = "1";
    public static String Inches = "04";
    public static String PD1 = "1";
    public static String PD2 = "1";
    public static String PD3 = "1";
    public static String NameOrganization = "Syria Military";
    public static String CityOrganization = "Aleppo";
    public static String StateOrganization = "Aleppo";
    public static String CountryOrganization = "Syria";
    public static String NatureOrganization = "Syria";
    public static String OrganizationStartDate = "08/12/1987";
    public static String OrganizationEndDate = "08/13/1988";
    public static String NameOrganization1 = "Syria Military";
    public static String CityOrganization1 = "Aleppo";
    public static String StateOrganization1 = "Aleppo";
    public static String CountryOrganization1 = "Syria";
    public static String NatureOrganization1 = "Syria";
    public static String OrganizationStartDate1 = "08/12/1987";
    public static String OrganizationEndDate1 = "08/13/1988";
    public static String NameOrganization2 = "Syria Military";
    public static String CityOrganization2 = "Aleppo";
    public static String StateOrganization2 = "Aleppo";
    public static String CountryOrganization2 = "Syria";
    public static String NatureOrganization2 = "Syria";
    public static String OrganizationStartDate2 = "08/12/1987";
    public static String OrganizationEndDate2 = "08/13/1988";
    public static String InterpreterForm = "Spanish";
    public static String PreparerForm = "Alejandro Vazquez Rojas";
    public static String ADayTimeNum = "9738121552";
    public static String AMobNum = "9738121552";
    public static String AEmail = "dankmemes@gmail.com";
    public static String IFamilyName = "Castro";
    public static String IFirstName = "Marjorie";
    public static String IOrganizationName = "International Rescue Committee";
    public static String IAddressStreet = "208 Commerce Place";
    public static String IAddInfoAddress = "3";
    public static String IAddressCity = "Elizabeth";
    public static String IState = "NJ";
    public static String IZipcode = "07201";
    public static String ICountry = "USA";
    public static String IDayTimeNum = "9738121552";
    public static String IMobNum = "9738121552";
    public static String IEmail = "dankmemes@gmail.com";
    public static String Language = "Spanish";
    public static String PFamilyName = "Vazquez Rojas";
    public static String PFirstName = "alejandro";
    public static String POrganizationName = "International Rescue Committee";
    public static String PAddressStreet = "208 Commerce Place";
    public static String PAddInfoAddress = "3";
    public static String PAddressCity = "Elizabeth";
    public static String PState = "NJ";
    public static String PZipcode = "07201";
    public static String PDayTimeNum = "9085412415";
    public static String PMobNum = "9085412415";
    public static String PEmail = "lol@rescue.org";

    public static String[] fieldArray = {ANum,FamilyName,FirstName,MiddleName,FamilyName1,MiddleName1,FirstName1,FamilyName2,FirstName2,MiddleName2,Name,DOBDate,CityBirth,CountryBirth,
            Nationality,SocialSecurity,AddressStreet,AddInfoAddress,AddressCity,State,Zipcode,PassportNum,TravelNum,ExpirationDate,PassportCountry,EntryCity,EntryState,LastArrivalDate,
            I94Num,ExpirationDate1,I94Status,CurrentImmigrationStatus,I94FamilyName,I94FirstName,I94MiddleName,StartDate, EndDate,AddressStreet1,AddInfoAddress1,AddressCity1,State1,Zipcode1,
            Country1,StartDate1,EndDate1,AddressStreet2,AddInfoAddress2,AddressCity2,State2,Zipcode2,Country2,StartDate2,EndDate2,Employer,WorkAddressStreet,WorkAddInfoAddress,WorkAddressCity,
            WorkState,WorkZipcode,WorkCountry,WorkStartDate,WorkEndDate,Employer1,WorkAddressStreet1,WorkAddInfoAddress1,WorkAddressCity1,WorkState1,WorkZipcode1,WorkCountry1,WorkStartDate1,
            WorkEndDate1,Employer2,WorkAddressStreet2,WorkAddInfoAddress2,WorkAddressCity2,WorkState2,WorkZipcode2,WorkCountry2,WorkStartDate2,WorkEndDate2,FFamilyName,FFirstName,FMiddleName,
            FFamilyNameB,FFirstNameB,FMiddleNameB,FDOB,FCityBirth,FCountryBirth,FCityCurrent,FCountryCurrent,MFamilyName,MFirstName,MMiddleName,MFamilyNameB,MFirstNameB,MMiddleNameB,MDOB,MCityBirth,
            MCountryBirth,MCityCurrent,MCountryCurrent,MarriageNum,SFamilyName1,SMiddleName1,SFirstName1,SANum,SDOBDate,SMarriageDate,SCityBirth,SCountryBirth,DFamilyName,DFirstName,
            DMiddleName,DDOBDate,DMarriageDate,DCityMarriage,DStateMarriage,DMarriageEndDate,SCityEnd,SStateEnd,SCountryEnd,ChildNum,C1FamilyName1,C1MiddleName1,C1FirstName1,C1ANum,C1DOBDate,
            C1MarriageDate,C1CityBirth,C1CountryBirth,C2FamilyName,C2MiddleName,C2FirstName,C2ANum,C2DOBDate,C2MarriageDate,C2CityBirth,C2CountryBirth,C3FamilyName,C3MiddleName,C3FirstName,
            C3ANum,C3DOBDate,C3MarriageDate,C3CityBirth,C3CountryBirth,Feet,Inches,PD1,PD2,PD3,NameOrganization,CityOrganization,StateOrganization,CountryOrganization,NatureOrganization,
            OrganizationStartDate,OrganizationEndDate,NameOrganization1,CityOrganization1,StateOrganization1,CountryOrganization1,NatureOrganization1,OrganizationStartDate1,OrganizationEndDate1,
            NameOrganization2,CityOrganization2,StateOrganization2,CountryOrganization2,NatureOrganization2,OrganizationStartDate2,OrganizationEndDate2,InterpreterForm,PreparerForm,ADayTimeNum,
            AMobNum,AEmail,IFamilyName,FamilyName,IFirstName,IOrganizationName,IAddressStreet,IAddInfoAddress,IAddressCity,IState,IZipcode,ICountry,IDayTimeNum,IMobNum,IEmail,Language,PFamilyName,PFirstName,
            POrganizationName,PAddressStreet,PAddInfoAddress,PAddressCity,PState,PZipcode,PDayTimeNum,PMobNum,PEmail};
    public static String[] nameFieldArray = {"ANum","FamilyName","FirstName","MiddleName","FamilyName1","FirstName1","MiddleName1","FamilyName2","FirstName2","MiddleName2","Name","DOBDate",
            "CityBirth","CountryBirth","Nationality","SocialSecurity","AddressStreet","AddInfoAddress","AddressCity","State","Zipcode","PassportNum","TravelNum","ExpirationDate","PassportCountry",
            "EntryCity","EntryState","LastArrivalDate", "I94Num","ExpirationDate1","I94Status","CurrentImmigrationStatus","I94FamilyName","I94FirstName","I94MiddleName","StartDate","EndDate",
            "AddressStreet1","AddInfoAddress1","AddressCity1","State1","Zipcode1","Country1","StartDate1","EndDate1","AddressStreet2","AddInfoAddress2","AddressCity2","State2","Zipcode2",
            "Country2","StartDate2","EndDate2","Employer","WorkAddressStreet","WorkAddInfoAddress","WorkAddressCity","WorkState","WorkZipcode","WorkCountry","WorkStartDate","WorkEndDate",
            "Employer1","WorkAddressStreet1","WorkAddInfoAddress1","WorkAddressCity1","WorkState1","WorkZipcode1","WorkCountry1","WorkStartDate1","WorkEndDate1","Employer2","WorkAddressStreet2",
            "WorkAddInfoAddress2","WorkAddressCity2","WorkState2","WorkZipcode2","WorkCountry2","WorkStartDate2","WorkEndDate2","FFamilyName","FFirstName","FMiddleName","FFamilyNameB","FFirstNameB",
            "FMiddleNameB","FDOB","FCityBirth","FCountryBirth","FCityCurrent","FCountryCurrent","MFamilyName","MFirstName","MMiddleName","MFamilyNameB","MFirstNameB","MMiddleNameB","MDOB","MCityBirth",
            "MCountryBirth","MCityCurrent","MCountryCurrent","MarriageNum","SFamilyName1","SMiddleName1","SFirstName1","SANum","SDOBDate","SMarriageDate","SCityBirth","SCountryBirth","DFamilyName",
            "DFirstName","DMiddleName","DDOBDate","DMarriageDate","DCityMarriage","DStateMarriage","DMarriageEndDate","SCityEnd","SStateEnd","SCountryEnd","ChildNum","C1FamilyName1","C1MiddleName1",
            "C1FirstName1","C1ANum","C1DOBDate","C1MarriageDate","C1CityBirth","C1CountryBirth","C2FamilyName","C2MiddleName","C2FirstName","C2ANum","C2DOBDate","C2MarriageDate","C2CityBirth",
            "C2CountryBirth","C3FamilyName","C3MiddleName","C3FirstName","C3ANum","C3DOBDate","C3MarriageDate","C3CityBirth","C3CountryBirth","Feet","Inches","PD1","PD2","PD3","NameOrganization",
            "CityOrganization","StateOrganization","CountryOrganization","NatureOrganization","OrganizationStartDate","OrganizationEndDate","NameOrganization1","CityOrganization1","StateOrganization1",
            "CountryOrganization1","NatureOrganization1","OrganizationStartDate1","OrganizationEndDate1","NameOrganization2","CityOrganization2","StateOrganization2","CountryOrganization2",
            "NatureOrganization2","OrganizationStartDate2","OrganizationEndDate2","InterpreterForm","PreparerForm","ADayTimeNum","AMobNum","AEmail","IFamilyName","FamilyName","IFirstName","IOrganizationName",
            "IAddressStreet","IAddInfoAddress","IAddressCity","IState","IZipcode","ICountry","IDayTimeNum","IMobNum","IEmail","Language","PFamilyName","PFirstName","POrganizationName","PAddressStreet",
            "PAddInfoAddress","PAddressCity","PState","PZipcode","PDayTimeNum","PMobNum","PEmail"};

    public static String AGender = "Male";
    public static String TenantInfo  = "Apt";
    public static String AltTenantInfo  = "AltApt";
    public static String lastArrived = "Other";
    public static String ImmigrationStatus = "Asylum";
    public static String TenantInfo1  = "Apt1";
    public static String TenantInfo2  = "Apt2";
    public static String ETenantInfo  = "EApt";
    public static String ETenantInfo1  = "EApt1";
    public static String ETenantInfo2  = "Apt2";
    public static String MaritalStatus  = "Married";
    public static String USGuard  = "Guard-NA";
    public static String SApply  = "SApply-yes";
    public static String C1status = "C1-yes";
    public static String C2status = "C2-yes";
    public static String C3status = "C3-yes";
    public static String Ethnicity = "Hispanic-yes";
    public static String Race = "White";
    public static String EyeColor = "BlackEyes";
    public static String HairColor = "Bald";
    public static String OrgAnswer = "Org-yes";
    public static String DisabilityAnswer = "Accom-yes";
    public static String InterpreterQuestion = "Interpreter";
    public static String ITenantInfo  = "IApt";
    public static String PTenantInfo  = "PApt";

    public static String[] checkArray = {AGender,TenantInfo,AltTenantInfo,lastArrived,ImmigrationStatus,TenantInfo1,TenantInfo2,ETenantInfo,
            ETenantInfo1,ETenantInfo2,MaritalStatus,USGuard,SApply,C1status,C2status,C3status,Ethnicity,Race,EyeColor,HairColor,OrgAnswer,
            DisabilityAnswer,InterpreterQuestion,ITenantInfo,PTenantInfo};
    public static void main(String[] args) throws IOException {

        fill_app();

    }

    public static void fill_app() throws IOException {

        String fileType = "i-485";
        String fileLocation = "C:\\Users\\Filip\\IdeaProjects\\PDFfiller\\src\\main\\resources\\pdf\\i-485.pdf";
        File file = new File(fileLocation);
        PDDocument document = PDDocument.load(file);

        PDDocumentCatalog docCatalog = document.getDocumentCatalog();
        PDAcroForm acroForm = docCatalog.getAcroForm();

        for (int i = 0; i < fieldArray.length; i++) {

            String entryFieldArray = fieldArray[i];
            String entryNameArray = nameFieldArray[i];
            PDField fieldTemp = acroForm.getField(entryNameArray);
            if (fieldTemp != null) {
                fieldTemp.setValue(entryFieldArray.toUpperCase());

            }
        }

        for (int b = 0; b < checkArray.length; b++) {

            String entryCheckArray = checkArray[b];

            PDCheckBox boxTemp = (PDCheckBox) acroForm.getField(entryCheckArray);
            boxTemp.check();

        }

        fileSave(document, fileType, 0);

    }


    public static void fileSave( PDDocument documentPass, String fileTypePass, int fileIteration) throws IOException {
        PDDocument document1 = documentPass;
        String fileType1 = fileTypePass;
        if (fileIteration == 0) {
            String saveLocation = "C:\\Users\\Filip\\Desktop\\" + fileTypePass + "-finished.pdf";
            File finalFile = new File(saveLocation);
            boolean checkFileStatus = finalFile.exists();

            if (checkFileStatus == false) {
                documentPass.save(saveLocation);
                documentPass.close();

            } else {
                int fileIterationCheck = fileIteration + 1;
                fileSave(document1, fileType1, fileIterationCheck);
            }
        }
        else {
            String saveLocation = "C:\\Users\\Filip\\Desktop\\" + fileTypePass + "-finished-" + fileIteration + ".pdf";
            File finalFile = new File(saveLocation);
            boolean checkFileStatus = finalFile.exists();
            if (checkFileStatus == false) {
                documentPass.save(saveLocation);
                documentPass.close();

            } else {
                int fileIterationCheck = fileIteration + 1;
                fileSave(document1, fileType1, fileIterationCheck);
            }
        }
    }
}