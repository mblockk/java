import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Collections;

public class Scheduler{

    public static ArrayList<Talk> makeTalks(String talkFile) throws IOException {
        try {
        ArrayList<Talk> talks = new ArrayList<Talk>();
        FileNotFoundException e = new FileNotFoundException();    
        FileReader inputFile = new FileReader(talkFile);
        BufferedReader reader = new BufferedReader(inputFile);
        String line = null;
            
        while((line = reader.readLine()) != null) {        
            String[] data = line.trim().split("\\s+");
            int startTime = Integer.parseInt(data[1]);
            if (startTime > 2400  || startTime < 0){
                System.out.println("please use an input file with valid times");
                System.exit(0);
            }
            int endTime = Integer.parseInt(data[2]);
            if (endTime > 2400 || endTime < 0 || endTime - startTime <0 ){
                System.out.println("please use an input file with valid times");
                System.exit(0);
        }
            Talk t = new Talk(data[0], startTime, endTime);
            talks.add(t);
        }     
         Collections.sort(talks);
         inputFile.close();
         reader.close();
         return talks;
        }    
            catch (NumberFormatException f){
            NumberFormatException e = new NumberFormatException();
            System.out.println("invalid times in input file, please use digits");
            throw e;
            }
    }         

    public static ArrayList<Talk> scheduleTalks(ArrayList<Talk> t){
        ArrayList<Talk> finalList = new ArrayList<Talk>();
            finalList.add(t.get(0));
            int i = 1;
            int j = 0;   
        while (i < t.size() && j <= finalList.size()){
            int start = (t.get(i).getStart());
            int finalEnd = (finalList.get(j).getEnd());
            int end = (t.get(i).getEnd());
            int nextEnd = (t.get(i).getStart());
                if (finalEnd <= start){ 
                    Talk x = new Talk(t.get(i).getTalker(), t.get(i).getStart(),
                                  t.get(i).getEnd());
                    finalList.add(x);
                    i++;
                    j++;
                }
                else
                    i++;            
        }	
        return finalList;
    }
}