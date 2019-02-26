/* Michael Block -- mb4239
 * This program implements a queue
 * from two stacks. 
 * compile with javac TwoStackQueue.java
 */ 

public class TwoStackQueue<AnyType> implements MyQueue<AnyType>{
    MyStack<AnyType> S1 = new MyStack<AnyType>();
    MyStack<AnyType> S2 = new MyStack<AnyType>();

    public void enqueue(AnyType x){
        S1.push(x);
    }

    public AnyType dequeue(){
        if(S2.isEmpty()){
        while(!S1.isEmpty()){
            S2.push(S1.pop());
            }
        }
        return S2.pop();

    }

    public boolean isEmpty(){
        if (S1.isEmpty() && S2.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
   
    public int size(){
        return S1.size()+S2.size();
    }
    
    
}
 
