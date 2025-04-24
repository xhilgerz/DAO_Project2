import java.util.*;
import java.math.*;

public class Project2 {

    public static int[] inputs;
    public static int numRods;
    public static int count;
    public static void main(String[] args) {

        char algoType = args[0].charAt(0);
        numRods = Integer.parseInt(args[1]);
        inputs = new int[numRods];
        
        

        for(int i = 2; i< args.length; i++){
            inputs[i-2] = Integer.parseInt(args[i]);
            //System.out.println(inputs[i-2]);
            
        }
        

        int answer = chooseAlgorithm(algoType);

        System.out.println(answer);


        

    }

    private static int chooseAlgorithm(char algoType) {
        int answer = -1;
        switch(algoType){

            case 'R':
            //System.out.println(numRods);
                 //Arrays.sort(inputs);
                return minWeldingCost(inputs);


            case 'M':
                //return useMemoAlgo(inputs);

            break;

            case 'D':
               // return useDynamicAlgo(inputs);

            break;


            case 'r':
                /*answer = useRecursiveAlgo(inputs);
                printRecursiceCalls(inputs);
                return answer;*/

            break;

            case 'm':
               /*  answer =useMemoAlgo(inputs);
                printMemoMatrix(inputs);
                return(answer) */

            break;

            case 'd':
               /*  answer = useDynamicAlgo(inputs);
                printDynamicTable(inputs);
                return answer;*/

            break;


        };
        return answer;
    }

    private static void printDynamicTable(int[] inputs) {
        
        
    }

    private static void printMemoMatrix(int[] inputs) {
        
    }

    private static void printRecursiceCalls(int[] inputs) {
        
    }
/* 
    private static int useDynamicAlgo(int[] inputs) {
        // TODO Auto-generated method stub
       
        return
    }

    private static int useMemoAlgo(int[] inputs) {
        // TODO Auto-generated method stub
        
        return
    }
 */

    public static int minWeldingCost(int[] rods) {
        int n = rods.length;
        if (n == 1) {
            return 0; // Base case: no welding needed
        }

        int minTotal = Integer.MAX_VALUE;

        
        for (int k = 1; k < n; k++) {
            int[] left = new int[k];
            int[] right = new int[n - k];
            System.arraycopy(rods, 0, left, 0, k);
            System.arraycopy(rods, k, right, 0, n - k);

            int cost = minWeldingCost(left) + minWeldingCost(right) + sum(left) + sum(right);

            if (cost < minTotal) {
                minTotal = cost;
            }
        }

        return minTotal;
    }

    // Helper function to compute the sum of an array
    private static int sum(int[] arr) {
        int total = 0;
        for (int num : arr) {
            total += num;
        }
        return total;
    }

    ; // Output: 21



    private static int colby(int length){
        
        if (length <= 2){
            return inputs[0]+inputs[1];
        }

        

        return colby(length - 2) + colby(length-1);


    }
        
}

/*
 * if (index < 0) {  // Base case: invalid index
            return 0;
        }
        // Return current element + sum of all previous elements
        int min = inputs[index] + useRecursiveAlgo(index - 1);
        
        return min;
    }
 * 
 * 
 */