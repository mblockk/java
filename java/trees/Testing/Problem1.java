/* Following the specification in the README.md file, provide your 
 * Problem1 class.
 * /

/* Following the specification in the README.md file, provide your 
 * Problem2 class.
 */
import java.util.*; 
public class Problem1{
 
public static void main(String[] args) {
String theString = "2 2 * 9 9 / +";
String theString2 = "900 1 * 1000 10 / +"; 
String theString3 = "27 26 - 1 / 99 +";
String theString4 = "1050 50 - 100 * 99999 -";
String theString8 = "88888";

ExpressionTree tree = new ExpressionTree(theString);
if(!tree.isEmpty()){
System.out.println("**************************");         
System.out.println("\n"+ "TRIAL ONE: ");    
System.out.println("\n" + "Hardcoded value: " + theString);
System.out.println("\n" + "prefix: " + tree.prefix());
System.out.println("\n" + "infix: " + tree.infix());
System.out.println("\n" + "postfix: " + tree.postfix());
System.out.println("\n\n" + "evaluated: " + tree.eval() +"\n\n");
}
    
ExpressionTree tree2 = new ExpressionTree(theString2);
if (!tree2.isEmpty()){
System.out.println("**************************");            
System.out.println("\n"+ "TRIAL TWO: ");  
System.out.println("\n" + "Hardcoded value: " + theString2);
System.out.println("\n" + "prefix: " + tree2.prefix());
System.out.println("\n" + "infix: " + tree2.infix());
System.out.println("\n" + "postfix: " + tree2.postfix());
System.out.println("\n\n" + "evaluated: " + tree2.eval() +"\n\n");
}     
     
ExpressionTree tree3 = new ExpressionTree(theString3);
if (!tree3.isEmpty()){
System.out.println("**************************");          
System.out.println("\n"+ "TRIAL THREE: ") ;   
System.out.println("\n" + "Hardcoded value: " + theString3);
System.out.println("\n" + "prefix: " + tree3.prefix());
System.out.println("\n" + "infix: " + tree3.infix());
System.out.println("\n" + "postfix: " + tree3.postfix());
System.out.println("\n\n" + "evaluated: " + tree3.eval() +"\n\n");
}
    
ExpressionTree tree4 = new ExpressionTree(theString4);
if (!tree4.isEmpty()){
System.out.println("**************************");           
System.out.println("\n"+ "TRIAL FOUR: ") ;   
System.out.println("\n" + "Hardcoded value: " + theString4);
System.out.println("\n" + "prefix: " + tree4.prefix());
System.out.println("\n" + "infix: " + tree4.infix());
System.out.println("\n" + "postfix: " + tree4.postfix());
System.out.println("\n\n" + "evaluated: " + tree4.eval() +"\n\n");
}
 }
}