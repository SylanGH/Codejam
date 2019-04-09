package youcangoyourownway;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class YouCanGoYourOwnWay 
{
    public static void main(String[] args) throws IOException 
    {
       BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
       
       int numCases = Integer.parseInt(input.readLine());
       
       for(int curr = 1; curr <= numCases; curr++)
       {
           int size = Integer.parseInt(input.readLine());
           String path = input.readLine();
           
           String solution = "";
           
           for(int i = 0; i < path.length(); i++)
           {
               if(path.charAt(i) == 'E')
                   solution += "S";
               else
                   solution += "E";
           }
           
           System.out.println("Case #" + curr + ": " + solution);
       }
    }
}
