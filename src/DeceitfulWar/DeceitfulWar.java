package DeceitfulWar;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DeceitfulWar {
    
    public static void main(String[] args){
        Scanner scanner = null;
        FileOutputStream outputFile = null; 
        
        try{
            File inputData = new File("src/DeceitfulWar/large.in");
            scanner = new Scanner(inputData);
            /* Firstly, read the case counts N */
            int caseNumber = scanner.nextInt();
            /* Solve cases one by one */            
            StringBuilder output = new StringBuilder();
            for(int i = 1; i <= caseNumber; i++){
                System.out.println("--------Case #" + i + "---------");   
                int N = scanner.nextInt();
                double[] naomiBlocks = new double[N];
                double[] kenBlocks = new double[N];
                for (int j = 0; j < N; j++)
                    naomiBlocks[j] = scanner.nextDouble();
                for (int j = 0; j < N; j++)
                    kenBlocks[j] = scanner.nextDouble();
                Arrays.sort(naomiBlocks);
                Arrays.sort(kenBlocks);
//                System.out.println(playDeceitfulWar(naomiBlocks, kenBlocks));
                output.append("Case #").append(i).append(": ")
                         .append(playDeceitfulWar(naomiBlocks, kenBlocks))
                         .append(" ")
                         .append(playWar(naomiBlocks, kenBlocks)); 
                output.append("\n");
                
            }
            outputFile = new FileOutputStream(new File("src/DeceitfulWar/output_large.txt"));
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
    
    static int playWar(double[] naomi, double[] ken) {
        ArrayList<Double> kenBlocks = new ArrayList<Double>(ken.length);
        for (double w : ken)
            kenBlocks.add(w);
        
        int naomiPoints = 0;
        for (double w : naomi) {
            int index = 0-Arrays.binarySearch(kenBlocks.toArray(), w)-1;
            if (index >= kenBlocks.size()) {
                naomiPoints++;
                kenBlocks.remove(0);
            } else {
                kenBlocks.remove(index);
            }
        }
        
        return naomiPoints;
    }
    
    static int playDeceitfulWar(double[] naomi, double[] ken) {
        ArrayList<Double> kenBlocks = new ArrayList<Double>(ken.length);
        for (double w : ken)
            kenBlocks.add(w);
        
        int naomiPoints = 0;
        for (double w : naomi) {
            int index = 0-Arrays.binarySearch(kenBlocks.toArray(), w)-1;
            if (index >= kenBlocks.size() || index != 0) {
                naomiPoints++;
                kenBlocks.remove(0);
            } else {
                kenBlocks.remove(kenBlocks.size()-1);
            } 
        }
        
        return naomiPoints;
    }

}
