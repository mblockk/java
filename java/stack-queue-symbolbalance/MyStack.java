import java.util.LinkedList;

//* Michael Block -- mb4239 
//* This program creates a Linked List stack
//* compile with javac MyStack.java

public class MyStack<AnyType>{

   
LinkedList<AnyType> theStack = new LinkedList<AnyType>();

    
public void push(AnyType x){
    theStack.add(x);
}

public AnyType pop(){
    if (theStack.size() == 0){
        return null;
    }
    return theStack.removeLast();
} 
    
public AnyType peek(){
    if (theStack.size() <= 0){
        return null;
    }
    return theStack.getLast(); 
}

public boolean isEmpty(){
    if (theStack.size()==0){
        return true;
    }
    else{
        return false;
    }
}

public int size(){
    return theStack.size();
}

    
}