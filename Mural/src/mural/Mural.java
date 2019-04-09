package mural;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Mural 
{
    public static void main(String[] args) throws IOException 
    {
       FileReader inFile = new FileReader("B-large.in");
       BufferedReader input = new BufferedReader(inFile);
       //BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
       PrintWriter output = new PrintWriter("B-large.out");
       
       int numCases = Integer.parseInt(input.readLine());
       
       for(int i = 0; i < numCases; i++)
       {
           int sections = Integer.parseInt(input.readLine());
           String sectionValues = input.readLine();
           
           int possibleLength = sectionValues.length() / 2;
           
           if(sectionValues.length() % 2 != 0)
               possibleLength++;
           
           long optimal = 0;
           long previous = -1;
           
           for(int j = 0; j < sectionValues.length() - possibleLength + 1; j++)
           {
               long current = 0;
               
               if(previous == -1)
               {
                for(int k = 0; k < possibleLength; k++)
                {
                    current += Integer.parseInt(sectionValues.substring(j + k, j + k + 1));
                }
               } else
               {
                   current = (previous - Integer.parseInt(sectionValues.substring(j - 1, j))) + Integer.parseInt(sectionValues.substring(j + possibleLength - 1, j + possibleLength));
               }
               
               if(current > optimal)
                   optimal = current;
               
               previous = current;
           }
           
           output.println("Case #" + (i + 1) + ": " + optimal);
       }
       
       inFile.close();
       output.close();
    }
}
