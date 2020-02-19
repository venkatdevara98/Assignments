import edu.duke.*;
import java.io.File;
public class PerimeterRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }
    public int getNumPoints(Shape s)
    {
        int count=0;
        for (Point currPt : s.getPoints()){
            count+=1;
        }
        return count;
    }
    public double getAverageLength(Shape s)
    {
        return getPerimeter(s)/getNumPoints(s);
    }
    public double getLargestSide(Shape s)
    {
        double largest=0.0;
        Point prevPnt=s.getLastPoint();
        for ( Point currPnt : s.getPoints() ){
            double currDst=prevPnt.distance(currPnt);
            if (currDst>largest)
             largest=currDst;
            prevPnt=currPnt;
        }
        return largest;
    }
    public double getLargestX(Shape s)
    {
        double largestX=0.0;
        for ( Point currPnt : s.getPoints() ){
            if(currPnt.getX()>largestX)
             largestX=currPnt.getX();
            }
            return largestX;
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("The number of points are "+ getNumPoints(s));
        System.out.println("The largest side is " + getLargestSide(s));
        System.out.println("The largest x value is "+getLargestX(s));
        System.out.println("The average length of side is "+ getAverageLength(s));
        System.out.println("perimeter = " + length);
    }
    public double getLargestPerimeterMultipleFiles()
    {
        DirectoryResource dir=new DirectoryResource();
        double largestPerimeter=0.0;
        for (File f : dir.selectedFiles())
        {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            if(getPerimeter(s)>largestPerimeter)
             largestPerimeter=getPerimeter(s);
            }
        return largestPerimeter;
    }
    public File getFileWithLargestPerimeter()
    {
        File largestPerimeterFile=null;
        DirectoryResource dir=new DirectoryResource();
        double largestPerimeter=0.0;
        for (File f : dir.selectedFiles())
        {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            if(getPerimeter(s)>largestPerimeter)
            {
             largestPerimeter=getPerimeter(s);
             largestPerimeterFile=f;
            }
        }
        return largestPerimeterFile;
    }
        
    public void testPerimeterMultipleFiles()
    {
        System.out.println("Largest Perimeter is "+getLargestPerimeterMultipleFiles());
        System.out.println("Name of file with largest Perimeter is "+ getFileWithLargestPerimeter().getName());
    }
    

    public static void main (String[] args) {
        PerimeterRunner pr = new PerimeterRunner();
        pr.testPerimeter();
    }
}
