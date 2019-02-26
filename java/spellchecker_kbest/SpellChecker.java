//
//  spellchecker program by Michael Block -- mb4239
// 

import java.util.*;
import java.io.*;

public class SpellChecker{

    Hashtable<String, String>dictionary;
    
private SpellChecker (String file1, String file2) throws IOException{
    File input = new File(file1);
    File input2 = new File(file2);
    Scanner scanner = new Scanner(input);
    String[] tableWords;
    String tableLines;
    String docLines;
    int lineNum = 0;
    
    dictionary = new Hashtable<String, String>();
    
    while (scanner.hasNextLine()){
    tableLines = scanner.nextLine().toLowerCase();
    tableWords = tableLines.split("\\s+");
    for(int i = 0; i<tableWords.length;i++){
    dictionary.put(tableWords[i], tableWords[i]); 
    }  
    }
    scanner = new Scanner(input2);
    
    while(scanner.hasNextLine()){
    docLines = scanner.nextLine() + " "; 
    docLines = docLines.toLowerCase().trim();
    lineNum++;
       
    String[] docWords = docLines.split("\\s+");

    for (int i = 0; i <docWords.length; i++){

        if(docWords[i].length()>0){
        if(docWords[i].substring(docWords[i].length()-1).matches("[^a-zA-Z0-9]+")){
                        docWords[i] = docWords[i].substring(0, docWords[i].length()-1);
        }
        }
        if(docWords[i].length()>0){
        if(docWords[i].substring(0,1).matches("^[^a-zA-Z0-9]+")){
                        docWords[i] = docWords[i].substring(1, docWords[i].length());
        }   
        }


       if (!dictionary.contains(docWords[i])){
           String rep = checkReplace(docWords[i]).trim();
           if(rep!=null && !rep.isEmpty()){
           String[] reps = rep.split("\\s+");
           System.out.println("\n The word:  " + docWords[i] + "  is mispelled on line " + lineNum + 
                             ". It can be replaced with: \n" + Arrays.toString(reps));

            }
            else
               System.out.println("\n The word:  " + docWords[i] +"  is mispelled on line " + lineNum +
                                   ". No suitable replacement found." );
        }        
    }
    }
    scanner.close();
    System.out.println("\n");   
    
}
    
    private String checkReplace(String rep){
        String reps = null;
        String add = add(rep);
        String remove = remove(rep);
        String swap = swap(rep);
        reps = add+remove+swap;

        return reps;
    }
        
    private String remove(String rep){

       String removes = " ";
       StringBuilder sb = new StringBuilder(rep);
        for(int i=0; i<rep.length(); i++){
            char temp = sb.charAt(i);
            sb.deleteCharAt(i);
            String rem = sb.toString();       
            if(dictionary.contains(rem))
                removes += " " + rem + " ";
            sb.insert(i, temp);           
        }

        return removes;
        }
    private String add(String rep){
        String adds = " ";
            char[] az = "abcdefghijklmnopqrstuvwxyz'".toCharArray();
            StringBuilder sb = new StringBuilder(rep.length());
            sb.append(rep);
            for(int t=0;t<sb.length()+1;t++){
                for(int j=0;j<az.length;j++){
            sb.insert(t, az[j]);
            String middle = sb.toString().trim();
                if(dictionary.contains(middle))
                    adds += " " + middle;
            sb.deleteCharAt(t);
                }
            }

        return adds;
            
    }     
    private String swap(String rep){        
        String swaps = " ";
        for (int i=0; i<rep.length()-1;i++){
        String swap = rep.substring(0,i);
        swap = swap + rep.charAt(i+1);
        swap = swap + rep.charAt(i);
        swap = swap.concat(rep.substring((i+2)));
        if (dictionary.contains(swap)){
            swaps += " " + swap;
        }    

        }

        return swaps;
        }

public static void main(String[] args) throws IOException{
    if(args.length != 2){
        System.out.println("Invalid filepath. Please try again.");
        return;
    }
    String dict = args[0];
    String words = args[1];
    SpellChecker checker = new SpellChecker(dict, words);

    }  
} 
    
