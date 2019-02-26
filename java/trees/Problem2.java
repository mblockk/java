/* 
 * 
 * 
 */
import java.util.Scanner;
import java.io.*;

public class Problem2{
public static void main(String[] args)throws FileNotFoundException, Exception{
if(args.length<1){
    System.out.println("Please input a valid filename as a command line argument.");
    return;
}   
AvlTree<String> tree = new AvlTree<String>();
try{   
File input = new File(args[0]);
Scanner scanner = new Scanner(input);
String line;
String[] words;
int lineNumber = 1;

    while(scanner.hasNextLine()){
        line = scanner.nextLine();
        line = line.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase();
        words = line.split("\\s+");
        
        for(int i = 0; i<words.length; i++)
            tree.indexWord(words[i], lineNumber);

        lineNumber++;
    }
scanner.close();
tree.printIndex();
//System.out.println(tree.getLinesForWord("frankenstein"));
}
    catch (FileNotFoundException e){
        throw new FileNotFoundException();
    }
    catch (Exception e){
        throw new Exception();
    }
}
}