package numberguessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberGuessing 
{
    public static void main(String[] args) throws IOException 
    {
       BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
       int numCases = Integer.parseInt(input.readLine());
       
       for(int i = 0 ; i < numCases; i++)
       {
           String[] inits = input.readLine().split(" ");
           long lowerLimit = Integer.parseInt(inits[0]) + 1;
           long upperLimit = Integer.parseInt(inits[1]);
           int numTries = Integer.parseInt(input.readLine());
           //input.readLine(); //Clear the number of tries
           
           while(true)
           {
               long mid = (lowerLimit + upperLimit) / 2;
               System.out.println(mid);
               //System.out.flush();
               String response = input.readLine();
               
               if(response.equals("WRONG_ANSWER"))
                   return;
               else if(response.equals("CORRECT"))
                   break;
               else if(response.equals("TOO_SMALL"))
               {
                   lowerLimit = mid + 1;
               }else
               {
                   upperLimit = mid - 1;
               }
           }
       }
    }
}
