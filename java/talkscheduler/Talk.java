import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class Talk implements Comparable<Talk>{
    
    public int startTime;
    public int endTime;
    public String talker;

    public Talk(String t, int s, int e){
        talker = t;    
        startTime = s;
        endTime = e;
    }
    
    public int compareTo(Talk b){

        if (endTime < b.endTime)
            return -1;
        else if (endTime > b.endTime)
            return 1;
        else if (endTime == b.endTime && startTime < b.startTime)
            return -1;
        else if (endTime == b.endTime && startTime > b.startTime)
            return 1;
        else
            return 0;
    }
    
    public int getStart(){
        return startTime;
    } 
    
    public int getEnd(){
        return endTime;
    } 
    
    public String getTalker(){
        return talker;
    }
    
    public String toString(){
        String finalTalker = ("Speaker: "+ talker + " ~ ")+ 
                          ("Speaks from: " +startTime+"-" +endTime);
        return finalTalker;
 
    }     
}
                              