import java.util.*;
import java.io.*;
import java.util.Scanner;

// Michael Block -- mb4239
// This program scans an command-line-inputted java 
// file for unbalanced symbols. 
// Compile with javac SymbolBalance.java
// Run with java SymbolBalance filepath.java

public class SymbolBalance{
    
public static void main (String[] args) throws IOException{
    try{
        
    if (args.length < 1){
            System.out.println("File path required.");
        }
    else{
    String argsfile = args[0];
    MyStack<Character> stack = new MyStack<Character>();
    File file = new File(argsfile);
    Scanner in = new Scanner(file);
    String lines = "";
    boolean balanced = true;
    boolean comment = false;
    boolean quote = false;
    char error = '0';
    char c = '0';
    while (in.hasNextLine()){
        lines = lines + in.nextLine(); 
    }
        for (int i = 0; i< lines.length(); i++){
            c = lines.charAt(i);
            error = c;
            if(c == '(' && !comment && !quote) 
                stack.push(c);
            else if(c == '{' && !comment && !quote) 
                stack.push(c);
            else if(c == '[' && !comment && !quote) 
                stack.push(c); 
            else if(c == '"' && !comment && !quote){ 
                stack.push(c);
                quote = true;
            }
            else if(c == '/' && lines.charAt(i+1) == '*' && !comment && !quote){
                stack.push(lines.charAt(i));
                stack.push(lines.charAt(i+1));
                comment = true;
            }      
            else if(c == ')' && !comment && !quote){
                if(!stack.isEmpty()){
                  char check = stack.peek();              
                  if(check == '('){
                      stack.pop();
                      balanced = true;
                  }
                  else{
                      error = c;
                      balanced = false;
                      break;
                  }
                }          
                else{
                  error = c;
                  balanced = false;
                  break;
              
              }
            }
            else if(c == ']' && !comment && !quote){
               if(!stack.isEmpty()){
                char check = stack.peek();            
                if(check == '['){
                    stack.pop();
                    balanced = true;
                }          
                else{
                    error = c;
                    balanced = false;
                    break;
                }
              }          
            else{
                error = c;
                balanced = false;
                break;
             }
            }
            else if(c == '"' && !comment){
              if(!stack.isEmpty()){
               char check = stack.peek();              
               if(check == '"' && quote){
                   stack.pop();
                   balanced = true;
                   quote = false;
              }
             else{
                   error = c;
                   balanced = false;
                   break;
             }
            }          
            else{
                error = c;
                balanced = false;
                break;
             }
            }
            else if(c == '}' && !comment && !quote){
              if(!stack.isEmpty()){
               char check = stack.peek();              
               if(check == '{'){
                  balanced = true;
                  stack.pop();
               }
              else{
                  error = c;
                  balanced = false;
                  break;
              }
             }          
            else{
                error = c;
                balanced = false;
                break;
             }
            }
            else if(c == '*' && lines.charAt(i+1) == '/' && 
                             stack.pop() == '*' && !quote){
              if(!stack.isEmpty()){
               char check = stack.peek();
               if(check == '/'){
                  balanced = true;
                  comment = false;
                  stack.pop();
                }
               else{
                   error = c;
                   balanced = false;
                   break;
               }    
              }
             else{
                error = c;
                balanced = false;
                break;
            }
          }

        }
           
    if(!stack.isEmpty()){
        balanced = false;
        error = c;
    }   
    if(balanced == true){
        System.out.println("balanced");
    }    
        else if(!stack.isEmpty() && !balanced){
            System.out.println("unbalanced. error with: "+ stack.peek()+
                            " triggered by: " + error);
        }
        else{            
            System.out.println("unbalanced. error with: " + error+
                               " triggered by: " + error);
        }       
    }
    } 
    catch(IOException e){
        System.out.println("Invalid file.");
    }
    catch(Exception e){
        System.out.println("Wow, you broke it.");
    }

 }   
}
