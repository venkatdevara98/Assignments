/*Question:
Gruber Healthcare has different types of forms for their customer, one of which is a know your customer form ( KYC ) which has to be filled annually. Each form has a date which signifies the date the form was filled called the form date.

Due to government regulations the KYC form can only be filled within + or - 30 days of the signup anniversary of a customer. When filling it up, you have to provide the form date. If you are past the +-30 day anniversary then you can back-date it so that it falls in the +-30-day window. When filling it up you cannot use a future date for the form date.

For Example, assuming today is 4 Apr 2017 and I had signed up on 1st Mar 2014, my window for KYC submission this year would be 30 Jan 2017 to 31 Mar 2017. Since it is already 4th Apr - I would have to back-date the KYC to a date in this range.

Note: The KYC form can be filled only for the closest anniversary in the past or within 30 days range in future.
Anniversary refers to same day and month every year. If your birthday is 01-02-1992 -then your first anniversary will be 01-02-1993, the 2nd will be 01-02-1994 and so on. 01-02-1992 is not an anniversary.

Given the signup date and the current date, provide the allowable date range for the form date.

Input - First line is an integer n as the number of inputs to be passed. Next, n lines are n input for the program in the format dd-mm-yyyy dd-mm-yyyy Each line has two dates separated by space where the first date in signup date and the second date is the current date.

Output - Range of dates for KYC form in format dd-mm-yyyy dd-mm-yyyy */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;



public class KYC {
    public Calendar getAnniversaryDate(Calendar signUpDate,Calendar currentDate){
        int signUpYear=signUpDate.getWeekYear();
        int currentYear=currentDate.getWeekYear();
        signUpDate.add(Calendar.YEAR,currentYear-signUpYear);
        return signUpDate;
    }
    public Calendar getDate(String date) throws ParseException {
        Calendar returnDate=Calendar.getInstance();
        SimpleDateFormat formatDate=new SimpleDateFormat("dd-MM-yyyy");
        returnDate.setTime(formatDate.parse(date));
        return returnDate;
    }
    public void displayRange(Calendar anniversaryDateOriginal,Calendar currentDate){
        Calendar startDate=(Calendar)anniversaryDateOriginal.clone();
        startDate.add(Calendar.DAY_OF_MONTH,-30);
        Calendar endDate=(Calendar)anniversaryDateOriginal.clone();
        endDate.add(Calendar.DAY_OF_MONTH,30);
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
        if(endDate.compareTo(currentDate)>0)
            endDate=(Calendar)currentDate.clone();
        System.out.println(dateFormat.format(startDate.getTime())+"  "+dateFormat.format(endDate.getTime()));
    }

    public static void main(String args[]) throws ParseException {
        KYC kyc=new KYC();
        Scanner numberScanner=new Scanner(System.in);
        int numberOfInputs=numberScanner.nextInt();
        ArrayList<String> dates=new ArrayList<>();
        Scanner datesScanner = new Scanner(System.in);
        for(int i=numberOfInputs;i>0;i--) {
            dates.add(datesScanner.nextLine());
        }
        for(int i=0;i<numberOfInputs;i++){
            String signUpDateString=dates.get(i).substring(0,10);
            String currentDateString=dates.get(i).substring(11);
            Calendar signUpDate=kyc.getDate(signUpDateString);
            Calendar currentDate=kyc.getDate(currentDateString);
            if(signUpDate.compareTo(currentDate)>0){
                System.out.println("No range");
            }
            else {
                Calendar anniversaryDate = kyc.getAnniversaryDate(signUpDate, currentDate);
                if(anniversaryDate.compareTo(currentDate)>0)
                    anniversaryDate.add(Calendar.YEAR,-1);
                kyc.displayRange(anniversaryDate,currentDate);
            }
        }
    }
}
