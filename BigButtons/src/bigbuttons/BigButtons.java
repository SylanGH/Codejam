package bigbuttons;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class BigButtons 
{
    public static void main(String[] args) throws IOException 
    {
       FileReader inFile = new FileReader("A-large.in");
       BufferedReader input = new BufferedReader(inFile);
       PrintWriter output = new PrintWriter("A-large.out");
       int numCases = Integer.parseInt(input.readLine());
       
       for(int i = 0; i < numCases; i++)
       {
           HashMap<String, Long> existing = new HashMap<>();
           
            String rawData[] = input.readLine().split(" ");
            int length = Integer.parseInt(rawData[0]);
            int numBanned = Integer.parseInt(rawData[1]);
            
            long possible = (long) Math.pow(2, length);
            
            for(int j = 0; j < numBanned; j++)
            {
                String banned = input.readLine();
                boolean cont = false;
                
                for(Map.Entry<String, Long> combo : existing.entrySet())
                {                    
                    if(combo.getKey().length() <= banned.length())
                        if(banned.substring(0, 0 + combo.getKey().length()).equals(combo.getKey()))
                        {
                          cont = true;
                          break;
                        }
                    
                    if(banned.length() <= combo.getKey().length())
                        if(combo.getKey().substring(0, 0 + banned.length()).equals(banned))
                        {
                            cont = true;
                            possible += combo.getValue();
                            long consequence = (long) Math.pow(2, length - banned.length());
                            possible -= consequence;
                            existing.remove(combo.getKey());
                            existing.put(banned, consequence);
                            break;
                        }
                }
                
                if(cont)
                    continue;
                
                long consequence = (long) Math.pow(2, length - banned.length());
                possible -= consequence;
                existing.put(banned, consequence);
            }
                        
            output.println("Case #" + (i + 1) + ": " + possible);
       }
       
       inFile.close();
       output.close();
    }
}
