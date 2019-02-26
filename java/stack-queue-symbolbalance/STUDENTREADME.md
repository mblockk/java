Michael Block - mb4239

I have not changed any of the file names, so the files submitted are the 
same ones we were provided. MyQueue is the provided interface, MyStack 
contains a program that creates a stack from a Linked List, Problem2 is
the tester class I made for the TwoStackQueue problem, SymbolBalance 
implements an algorithm for determining whether symbols are balanced in
java, and the TwoStackQueue solves the problem of creating a FILO queue
from two LIFO stacks. 

The symbol balance program gave me the hardest time of these because I felt 
like I kept getting lost in what I was trying to solve. I was definitely
guilty of "monte carlo" coding, as Blaer calls it, and I spent several
hours making small changes to the code without really thinking about how
each change would impact the entire program. The program requires a file
path to be inputted into the command line. For example: 
java SymbolBalance filepath/filename.java
I tried to handle some exceptions that could be thrown during this 
operation, and also added a catch for general exceptions that I hope
removes other potential pitfalls.  

The Two Stack Queue program was interesting, it definitely took some
thinking to get the algorithm right, but Blaer was right that it was
pretty simple once you figure out what you're actually doing. 

My tester class for the 2SQ, Problem2.java just creates a bunch of strings,
enqueues some, dequeues them, then enqueues more, and a while loop prints 
the remaining queued items in a special order. 
