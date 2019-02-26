# Homework 3 Programming

## Due Wednesday, April 4th at 11:59pm. With a late deadline *4* days later.

Please remember that to submit the assignment you will need to the Education drop down menu and select 
assignment complete.   Also remember that you should submit a txt file on canvas that indicates your codio username so that we can cross check our grade data entry.

## Problem 1 - Implementing Expression Trees - 35 points

Implement a class called *ExpressionTree* in the provided empty ExpressionTree.java file. The constructor to ExpressionTree will take in a String that contains a postfix expression. The operands will be integers and the binary operators will be restricted to +, -, *, and divide. Individual tokens, that is the operands and operators, will be delimited by spaces. So for example:

34 2 - 5 *

would mean (34-2)*5.

Your constructor will run the stack based algorithm we discussed in class to build an expression tree. ExpressionNodes will be a nested class within ExpressionTree. You may use any code posted on canvas or from the Weiss textbook as a starting point for this class. As a stack data structure, you can either use java.util.LinkedList, your own class from homework 2, or the MyStack.java file from the sample solution for homework 2.  Please indicate your choice in the STUDENTREADME.md file.

Once you have the ExpressionTree constructed you should provide the following four methods:

* ```public int eval()``` - this method, when invoked on an expression tree object will return the integer value associated with evaluating the expression tree. It will need to call a private recursive method that takes in the root.
* ```public String postfix()``` - this method, when invoked on an expression tree object will return a String that contains the corresponding postfix expression. It will need to call a private recursive method that takes in the root.
* ```public String prefix()``` - this method, when invoked on an expression tree object will return a String that contains the corresponding prefix expression. It will need to call a private recursive method that takes in the root.
* ```public String infix()``` - this method, when invoked on an expression tree object will return a String that contains the corresponding correct infix expression. Keep in mind that parenthesis will be needed (excessive parenthesis will be tolerated as long as it is correct). It will need to call a private recursive method that takes in the root.

Fill in the class Problem1.java such that it instantiates an expression tree on a hard coded string representing a postfix expression tree, and demonstrate all of the methods listed above.

## Problem 2 - Indexing Text with an AVL Tree - 30 points

Fill in the class Problem2.java such that it indexes the words contained in a text file. Your program should go through the input file line by line. For each line, it extracts each word, and insert that word, along with it's line number into an AVL tree. Each element of the AVL tree should contain a unique word and a java.util.LinkedList of line numbers where that word occurs. The file being indexed should be passed into the program as a command line argument, so the program should be run like this:

```java Problem2 test.txt```

To implement this AVL tree, use the AVLTree code from the textbook as a starting point. I've included this code in the project workspace.  I've also included the UnderFlowException class which is needed for AVLTree to compile.  Modify this file directly and add the following functionality: 

* Make sure the elements in the AvlTree are pairs of a word and a linked lists storing line numbers. The relative order of elements in the data structure should depend on the word only.  To do this I recommend adding a LinkedList object to the existing AVLNode class.  In this particular case it's also not necessary for AVLTree to be generic, so you may remove generics and make the class simply an AVLTree of String objects.
* Write the method public void ```indexWord(String word, int line)``` that adds an occurrence of the word ```word``` in line ```line```. If a word already exists in the AVL Tree, simply add the new line number to the existing node. If a word appears on the same line twice, it should only have one entry in the list for that line.
* Write the method public List getLinesForWord(String word) that looks up a word and returns a list of lines in which it occurs.
* Write the method public void printIndex() the prints out each unique word that is stored in the Avl tree along with a list of line numbers in which that word appears.

You are allowed to remove extraneous methods from AVLTree.

Finally, the main method in Problem2.java should create an instance of your AvlTree and uses it to indexes the words contained in a text file (provided to the program as a command line argument). Ignore case in the input text (insert everything as lower case), and ignore all punctuation. When indexing has finished, the program should call the printIndex method to display a list of unique words in the text file and the line numbers in which that word occurs. 

I've provided a very simple file called ```test.txt``` that you can use to test your program.  I've also provided a file called ```output.txt``` which contains the correct output for the program on the ```test.txt``` file.  I've also provided a much larger test file called ```frank.txt```. For the larger test file I will not be providing sample output.  

The TAs will test your code on a variety of additional test files.

## Problem 3 - The Readme File

Please fill in the STUDENTREADME.md file which should indicate exactly what files you are submitting, what problem they solve, and how to compile and run them. This is also a good place to tell us any assumptions or special issues associated with your submission.