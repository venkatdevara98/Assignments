import edu.duke.*;
import java.io.File;
import org.apache.commons.csv.*;
public class BabyNames
{
 
 public void totalBirths(FileResource fr)
 {
     int totalBirths=0,maleBirths=0,femaleBirths=0;
     for(CSVRecord rec : fr.getCSVParser(false))
     {
         totalBirths+=Integer.parseInt(rec.get(2));
         if(rec.get(1).equals("M"))
             maleBirths+=Integer.parseInt(rec.get(2));
         else
             femaleBirths+=Integer.parseInt(rec.get(2));
         
    }
    System.out.println("Total births are : "+totalBirths);
    System.out.println("Male births are : "+maleBirths);
    System.out.println("Female births are : "+femaleBirths);
    
 }
 public int getRank(int year,String name,String gender)
 {
     
     FileResource fr=new FileResource(returnFile(year));
     int rank=1;
     for(CSVRecord rec : fr.getCSVParser(false)){
         if (gender.equals(rec.get(1)))
          {
             if(name.equals(rec.get(0)))
              return rank;
             else
              rank+=1;
            }
           
    }
    return -1;
}
public void testRank()
{
    String name="Olivia";
    String gender="F";
    System.out.println("Rank of "+name+" is "+getRank(2014,name,gender));
}
public String getName(int year,int rank,String gender)
{
  FileResource fr=new FileResource(returnFile(year));
  CSVParser parser=fr.getCSVParser(false);
  for(CSVRecord record : parser)
  {
      if(record.get(1).equals(gender) && rank!=0)
      {
          rank-=1;
        }
      if(rank==0)
         return record.get(0);
        }
        return "NO NAME";

  
}

public void testName()
{
    System.out.println("Name of person at rank 4 is "+ getName(2014,4,"F"));
}
public void whatIsNameYear(String name,int year,int newYear,String gender)
{
    int rankThisYear=getRank(year,name,gender);
    String nameThatYear=getName(newYear,rankThisYear,gender);
    System.out.println(name+" born in "+year+" would be "+nameThatYear+" born in "+ newYear);
}
public void testYearName()
{
    whatIsNameYear("Isabella",2012,2014,"F");
}
public int yearOfHighestRank(String name,String gender)
{
    DirectoryResource dir=new DirectoryResource();
    int yearOfHighestRank=-1;
     int actualYear=0;
    for(File f : dir.selectedFiles())
    {
        FileResource fr=new FileResource(f);
        int currRank=getRank(Integer.parseInt(f.getName().substring(3,7)),name,gender);
        if(currRank==-1)
          continue;
        else if(yearOfHighestRank==-1 || currRank<yearOfHighestRank){
          yearOfHighestRank=currRank;
          actualYear=Integer.parseInt(f.getName().substring(3,7));
        }
    }
        return actualYear;
        
}
public void testYearOfHighestRank()
{
    String name="Mason";
    String gender="M";
    System.out.println(name+"'s year of Highest Rank is "+yearOfHighestRank(name,gender));
}
public double getAverageRank(String name,String gender)
{
    DirectoryResource dir=new DirectoryResource();
    double averageRank=-1;
    double sumOfRanks=0;
    double numberOfRanks=0;
    for(File f : dir.selectedFiles())
    {
        FileResource fr=new FileResource(f);
        int currRank=getRank(Integer.parseInt(f.getName().substring(3,7)),name,gender);
        if(currRank==-1)
          continue;
        else {
          sumOfRanks+=currRank;
          numberOfRanks+=1;
        }
    }
    averageRank=sumOfRanks/numberOfRanks;
        return averageRank;
    }
 public void testAverageRank()
 {
     String name="Jacob";
     String gender="M";
     System.out.println("Average Rank of "+name+"  is "+getAverageRank(name,gender));
    }
 public int getTotalBirthsRankedHigher(int year,String name,String gender)
 {
     
     File f=returnFile(year);
     int totalBirthsHigher=0;
    
     FileResource fr=new FileResource(f);
     int currRank=getRank(year,name,gender);
     for(CSVRecord rec : fr.getCSVParser(false))
             {
                 if(currRank!=1 && gender.equals(rec.get(1)))
                 {
                  totalBirthsHigher+=Integer.parseInt(rec.get(2));
                  currRank-=1;
                }
            }
      
    return totalBirthsHigher;
}
public void testTotalBirthsHigher()
{
    int year=2012;
    String name="Ethan";
    String gender="M";
    System.out.println("Total births higher than "+name+"in the year "+year+" is "+getTotalBirthsRankedHigher(year,name,gender));
}
public File returnFile(int year)
{
    File folder=new File("/home/venkat/Desktop/java/us_babynames/us_babynames_test");
     File[] listOfFiles=folder.listFiles();
     File returnFile=null;
     for(File f : listOfFiles)
     {
         if((Integer.parseInt(f.getName().substring(3,7)))==year)
          returnFile=f;
        }
        return returnFile;
    }
 public void testBirths()
 {
     FileResource fr=new FileResource();
     totalBirths(fr);
     
    }

}
