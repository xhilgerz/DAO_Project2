import java.util.*;
import java.math.*;

public class Project2 {

    public static int[] inputs;
    public static int numRods;
    public static int count = 0;
    public static int[][] memo;

    private static int[][] dp;
    private static int[] prefixSum;
    
    public static void main(String[] args) {

        char algoType = args[0].charAt(0);
        numRods = Integer.parseInt(args[1]);
        inputs = new int[numRods];

        memo = new int[numRods][numRods];

        dp = new int[numRods][numRods];

        prefixSum = new int[numRods+1];

        for(int i = 2; i< args.length; i++){
            inputs[i-2] = Integer.parseInt(args[i]);
            //System.out.println(inputs[i-2]);
            
        }


        for (int[] row: memo){
        Arrays.fill(row,-1);
        }

        for (int i = 0; i < numRods; i++) {
            prefixSum[i + 1] = prefixSum[i] + inputs[i];
           // System.out.println(prefixSum[i+1]+" = "+ prefixSum[0] + " +" + inputs[i]);
        }
        
        

        chooseAlgorithm(algoType);



        

    }

    private static void chooseAlgorithm(char algoType) {
        
        switch(algoType){

            case 'R':
                System.out.print(recMinWeldingCost(0,numRods-1));
                break;


            case 'M':
                System.out.print(useMemoAlgo(0,numRods-1));
                break;


            case 'D':
            
                System.out.print(useDynamicAlgo(numRods));
            break;



            case 'r':
                recMinWeldingCost(0,numRods-1);
                System.out.print(count);

            break;

            case 'm':
                 useMemoAlgo(0,numRods-1);
                printMemoMatrix();
                break;
                 

            case 'd':
            useDynamicAlgo(numRods);
            printDynamicTable();
            

            break;


        };
        
    }

    private static void printDynamicTable() {
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp.length; j++){
                if(dp[i][j] == Integer.MAX_VALUE){
                    System.out.print(-1+ " ");
                }
                else{
                    System.out.print(dp[i][j]+ " ");
                }
                
            }
            if( i != dp.length -1)
            System.out.println();
        }
        
        
    }

    private static void printMemoMatrix() {
        for (int i = 0; i< memo.length; i++){
            for (int j = 0; j< memo.length; j++){
            System.out.print(memo[i][j]+ " ");
            }
            if( i != memo.length -1)
            System.out.println();
        }
        
    }

 
    private static int useDynamicAlgo(int size) {
        
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        for (int i = 0; i < size; i++) {
            dp[i][i] = 0;  
        }

    
        
        for (int length = 1; length < size; length++) {
            for (int i = 0; i < size - length; i++) {
                int j = i + length;
                for (int k = i; k < j; k++) {
                    int totalSum = prefixSum[j+1] - prefixSum[i];
                    int cost = dp[i][k] + dp[k+1][j] + totalSum;
                    dp[i][j] = Math.min(dp[i][j], cost);
                    
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        
        return dp[0][size-1];
    }

    


    private static int useMemoAlgo(int start, int end) {

       if (memo[start][end] != -1) {
            return memo[start][end];
        }

        if (start ==end) {
            memo[start][end] = 0;
            return 0;
        }

        int minCost = Integer.MAX_VALUE;

        for (int k = start; k < end; k++) {
            int leftCost = useMemoAlgo(start, k);
            int rightCost =useMemoAlgo(k + 1, end);
            int currentCost = leftCost + rightCost + sum(start, k) + sum(k + 1, end);

            
                minCost = Math.min(minCost, currentCost);
                memo[start][end] = minCost;
                
        }
        
        return minCost;
    }

        


    
    public static int recMinWeldingCost(int start, int end) {
        count++;
         if (start ==end) {
            return 0;
        }

        int minCost = Integer.MAX_VALUE;

        for (int k = start; k < end; k++) {
           
            int leftCost = recMinWeldingCost(start, k);
            
            int rightCost = recMinWeldingCost(k + 1, end);
            
            int currentCost = leftCost + rightCost + sum(start, k) + sum(k + 1, end);

            
                minCost = Math.min(minCost, currentCost);
            
        }

        return minCost;
    }

     private static int sum(int start, int end) {
        int total = 0;
        for (int i = start; i <= end; i++) {
            total += inputs[i];
        }
        return total;
    }

    

        
}
