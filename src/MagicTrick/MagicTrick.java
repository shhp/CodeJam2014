package MagicTrick;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MagicTrick {
    
    private static final int ROW_NUMBER = 4;

    public static void main(String[] args){
        Scanner scanner = null;
        FileOutputStream outputFile = null; 
        
        try{
            File inputData = new File("src/MagicTrick/small.in");
            scanner = new Scanner(inputData);
            /* Firstly, read the case counts N */
            int caseNumber = scanner.nextInt();
            /* Solve cases one by one */            
            StringBuilder output = new StringBuilder();
            for(int i = 1; i <= caseNumber; i++){
                System.out.println("--------Case #" + i + "---------");   
                
                int firstAnswer = scanner.nextInt();
                int[][] firstArrange = new int[ROW_NUMBER][ROW_NUMBER];
                for (int j = 0; j < ROW_NUMBER; j++)
                    for (int k = 0; k < ROW_NUMBER; k++)
                        firstArrange[j][k] = scanner.nextInt();
                int secondAnswer = scanner.nextInt();
                int[][] secondArrange = new int[ROW_NUMBER][ROW_NUMBER];
                for (int j = 0; j < ROW_NUMBER; j++)
                    for (int k = 0; k < ROW_NUMBER; k++)
                        secondArrange[j][k] = scanner.nextInt();
                
                ArrayList<Integer> same = findSame(firstArrange[firstAnswer-1], secondArrange[secondAnswer-1]);
                if (same.size() == 0)
                    output.append("Case #").append(i).append(": ").append("Volunteer cheated!");   
                else if (same.size() > 1)
                    output.append("Case #").append(i).append(": ").append("Bad magician!"); 
                else
                    output.append("Case #").append(i).append(": ").append(same.get(0)); 
                output.append("\n");
                
            }
            outputFile = new FileOutputStream(new File("src/MagicTrick/output_small.txt"));
            outputFile.write(output.toString().getBytes(),0,output.toString().length());
            System.out.println(output.toString());
                        
        }       
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                if(scanner != null)
                    scanner.close();
                if(outputFile != null)
                    outputFile.close();
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }
    }
    
    static ArrayList<Integer> findSame(int[] a, int[] b) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < a.length; i++) {
            int target = a[i];
            for (int j = 0; j < b.length; j++) {
                if (b[j] == target) {
                    result.add(target);
                    break;
                }
            }
        }
        return result;
    }
}
