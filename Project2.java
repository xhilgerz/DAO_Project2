import java.util.*;

public class Project2 {
    public static void main(String[] args) {

        char algoType = args[0].charAt(0);
        int numRods = Integer.parseInt(args[1]);
        int[] inputs = new int[args.length -2];

        int j = 0;
        for(int i = 2; i< args.length; i++){
            inputs[j] = Integer.parseInt(args[i]);
            j++;
        }

        int answer = chooseAlgorithm(algoType,inputs);


        

    }

    private static int chooseAlgorithm(char algoType, int[] inputs) {
        int answer;
        switch(algoType){

            case 'R':
                return useRecursiveAlgo(inputs);

            break;

            case 'M':
                return useMemoAlgo(inputs);

            break;

            case 'D':
                return useDynamicAlgo(inputs);

            break;


            case 'r':
                answer = useRecursiveAlgo(inputs);
                printRecursiceCalls(inputs);
                return answer;


            break;

            case 'm':
                answer =useMemoAlgo(inputs);
                printMemoMatrix(inputs);
                return(answer) 

            break;

            case 'd':
                answer = useDynamicAlgo(inputs);
                printDynamicTable(inputs);
                return answer;

            break;


        };
    }

    private static void printDynamicTable(int[] inputs) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'printDynamicTable'");
    }

    private static void printMemoMatrix(int[] inputs) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'printMemoMatrix'");
    }

    private static void printRecursiceCalls(int[] inputs) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'printRecursiceCalls'");
    }

    private static int useDynamicAlgo(int[] inputs) {
        // TODO Auto-generated method stub
       
        return
    }

    private static int useMemoAlgo(int[] inputs) {
        // TODO Auto-generated method stub
        
        return
    }

    private static int useRecursiveAlgo(int[] inputs) {
        

        return;
    }
}