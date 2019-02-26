/* Following the specification in the README.md file, provide your 
 * ExpressionTree class.
 */ 
import java.io.*; 
import java.util.*;


public class ExpressionTree{
    
   private ExpressionNode root;
   private LinkedList<ExpressionNode> stack = new LinkedList<ExpressionNode>();


public ExpressionTree(String postFixExpression){
    Scanner exp = new Scanner(postFixExpression);

    while (exp.hasNext()){
        String next = exp.next();
        if (isDigit(next)){
            ExpressionNode digit = new ExpressionNode(next);
            stack.push(digit);

        }
        else if (stack.size() >= 2 && (next.equals("+") || next.equals("*") || 
                 next.equals("/") || next.equals("-"))){
            ExpressionNode symbol = new ExpressionNode(next, stack.pop(), stack.pop());
            root = symbol;
            stack.push(symbol);
            
        }
            else{
            throw new IllegalArgumentException("Invalid Expression.");
        }
    }
    stack.pop();
    if(stack.size() > 0){
    throw new RuntimeException("Invalid expression");
    }

}

private static class ExpressionNode{
    ExpressionNode left, right;
    boolean isOperator;
    String data;


public ExpressionNode(String operand){

    isOperator = false;
    data = operand;
    
}    

public ExpressionNode(String operator, ExpressionNode r, ExpressionNode l){

    left = l;
    right = r;
    data = operator;
    isOperator = true;
        
}    
}
public String prefix(){

if(root == null){
    throw new IllegalArgumentException("Invalid Expression");
}
else
    return prefix(root);


}
private String prefix(ExpressionNode x){
    if(x != null ){
        if(x.left != null && x.right != null){
        return ("("+x.data +" "+prefix(x.left)+" "+prefix(x.right)+")");
        }
    
    else{
    return (x.data+ ""+prefix(x.left)+" "+prefix(x.right)); 
    }
    }
        return "";

}

public String postfix(){
if(root == null){
    throw new IllegalArgumentException("Invalid Expression");
}    
else
    return postfix(root);
    
}
private String postfix(ExpressionNode x){
    if(x != null ){
        if(x.left != null && x.right != null){
        return ("("+postfix(x.left)+" "+postfix(x.right)+" "+x.data+")");
        }
    
    else{
    return (postfix(x.left)+" "+postfix(x.right)+" "+x.data); 
    }
    }
        return "";

}
    
public String infix(){
if(root == null){
    throw new IllegalArgumentException("Invalid Expression");
}   
else
    return infix(root);
    
}
private String infix(ExpressionNode x){
    if(x != null ){
        if(x.left != null && x.right != null){
        return ("("+infix(x.left)+" "+x.data+""+infix(x.right)+")");
        }
    
    else{
    return (infix(x.left)+" "+ x.data + " "+infix(x.right)); 
    }
    }
        return "";

}
    
public int eval(){
   if(root == null){
    throw new IllegalArgumentException("Invalid Expression");
   }
    else
        return (eval(root));
   
}
private int eval(ExpressionNode x){
if(x.left == null && x.right == null){
    return Integer.parseInt(x.data);
} 
    if (x.isOperator && x.data.equals("*")){
        return (eval(x.left) * eval(x.right));
    }    
    else if (x.isOperator && x.data.equals("/")){
        return (eval(x.left) / eval(x.right));
    }
    else if (x.isOperator && x.data.equals("-")){
        return (eval(x.left) - eval(x.right));
    }
    else{
        return (eval(x.left) + eval(x.right));        
    }

}
public boolean isDigit(String s){

    try{
        int n = Integer.parseInt(s);
    }
    catch (NumberFormatException e){
        return false;
    }
    return true;
}
public boolean isEmpty(){
    return root == null;
}
}
    


