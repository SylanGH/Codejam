
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution 
{
    private static String currentInput;
    private static ArrayList<Integer> known;
    
    private static class BST
    {
        int index;
        int errors;
        int LE;
        int RE;
        int num;
        BST leftChild;
        BST rightChild;
        boolean active;
        
        public BST(int numNodes, int numErrors, int currIndex)
        {
            active = true;
            
            num = numNodes;
            errors = numErrors;
            index = currIndex;
            
            if(numNodes == numErrors)
            {
                active = false;
                
                for(int i = index; i < index + numNodes; i++)
                {
                    known.add(i);
                }
            }else if(numNodes == 1 || numErrors == 0)
            {
                active = false;
            }
        }
        
        public void generate()
        {
            if(!active)
            {
                for(int i = 0; i < num; i++)
                    currentInput += "1";
                
                return;
            }
            
            if(leftChild == null)
            {
                for(int i = 0; i < num / 2; i++)
                    currentInput += "1";
                for(int i = 0; i < num - (num / 2); i++)
                    currentInput += "0";
            }else
            {
                leftChild.generate();
                rightChild.generate();
            }
        }
        
        public void parse(String in)
        {
            if(!active)               
                return;
            
            if(leftChild == null)
            {
                int leftErrors = num / 2;
                int rightErrors = num - (num / 2);
                
                for(int i = 0; i < in.length(); i++)
                {
                    if(in.charAt(i) == '1')
                        leftErrors--;
                    else
                        rightErrors--;
                }
                
                leftChild = new BST(num / 2, leftErrors, index);
                rightChild = new BST(num - (num / 2), rightErrors, index + (num / 2));
                
                LE = leftErrors;
                RE = rightErrors;
            }else
            {
                leftChild.parse(in.substring(0, ((num / 2) - LE)));
                rightChild.parse(in.substring(((num / 2) - LE)));
            }
        }
    }
    
    public static void main(String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(input.readLine());
        
        for(int curr = 0; curr < numCases; curr++)
        {
            known = new ArrayList<>();
            String[] vals = input.readLine().split(" ");
            
            int numWorkers = Integer.parseInt(vals[0]);
            int numBroken = Integer.parseInt(vals[1]);
            int numTries = Integer.parseInt(vals[2]);
            
            int tries = 0;         
            BST solveBST = new BST(numWorkers, numBroken, 0);
            
            while(known.size() != numBroken)
            {
                currentInput = "";
                solveBST.generate();
                
                System.out.println(currentInput);
                System.out.flush();
                
                String in = input.readLine();
                solveBST.parse(in);
            }
            
            if(known.size() == numBroken)
            {
                String solution = "";
                known.sort(null);
                
                for(int i = 0; i < known.size() - 1; i++)
                    solution += known.get(i) + " ";
                
                solution += known.get(known.size() - 1);
                System.out.println(solution);
                System.out.flush();
                
                int isTrue = Integer.parseInt(input.readLine());
                
                if(isTrue == -1)
                    return;
            }
        }
    }
}
