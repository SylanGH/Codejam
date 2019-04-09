package foregonesolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class ForegoneSolution 
{
    public static void main(String[] args) throws IOException 
    {
       BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
       
       int numCases = Integer.parseInt(input.readLine());
              
       for(int curr = 1; curr <= numCases; curr++)
       {
           
           String in = input.readLine();
       
           String A = "";
           String B = "";
           
           for(int i = 0; i < in.length(); i++)
           {
               if(in.charAt(i) == '4')
               {
                   A += "2";
                   B += "2";
               }else
               {
                   A += in.charAt(i);
                   B += "0";
               }                            
           }
           
           BigInteger ARes = new BigInteger(A);
           BigInteger BRes = new BigInteger(B);
               
           System.out.println("Case #" + curr + ": " + ARes + " " + BRes);
       }
    }
}
