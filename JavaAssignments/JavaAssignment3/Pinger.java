/*Write a java function that will ping any host ( given as input ) and computes the median of the time taken to ping.

        Use the system ping utility, do not use any deprecated methods.*/
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;
/*This program takes IP address from the user and pings the host by sending 5 packets.
It then computes the median of those five ping values and displays it
 */
public class Pinger {
    public void pingHost(String ip){
        ArrayList<Double> pingValues=new ArrayList<Double>();
        try {
            Process process=Runtime.getRuntime().exec("ping -c 5 "+ip);
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String presentLine="";
            while((presentLine=inputStream.readLine())!=null) {
                if (presentLine.length()>0&&presentLine.substring(0, 2).equals("64")) {
                    int indexOfTime = presentLine.indexOf("time");
                    String timeString = presentLine.substring(indexOfTime + 5, indexOfTime + 9);
                    if (Character.isLetterOrDigit(timeString.charAt(0)) && !Character.isLetter(timeString.charAt(0))) {

                        double time = Double.parseDouble(timeString);
                        pingValues.add(time);
                    }
                }
            }
            computeMedian(pingValues);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void computeMedian(ArrayList<Double> pingValues){
        Collections.sort(pingValues);
        System.out.println("Median of ping values is : "+pingValues.get(3));
    }
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        String ip=scanner.nextLine();
        Pinger pinger=new Pinger();
        pinger.pingHost(ip);
    }
}
