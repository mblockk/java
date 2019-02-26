Problem 1:
I found this problem tricky as I was having trouble visualizing the tree 
and figuring out the best way to implement the methods recursively,
but after talking to a TA I had an easier time.

Compile with javac ExpressionTree.java
Run with java ExpressionTree
Tester: Compile with javac Problem1.java
        Run with java Problem1

Problem2:
Stripping away the AvlTree class of generics and finding my way around
the class was challenging, and I didn't know how to change things to 
get them how I wanted them, but once I got the hang of it, it was much
simpler. I wasn't sure what to do with the indexWord method, so I
just had it call insert. My Problem2.java uses the indexWord method to
insert words into the tree. I also got hung up for hours trying to figure 
out the right regex to use. I wanted to break my keyboard. Turns out I 
put a space in the wrong spot. Oh, Java. It takes a filename in as a 
command line argument. Also, I had no idea I was about to index every 
word in Frankenstein when I ran Problem2 frank.txt. I laughed.

Compile with javac AvlTree.java
Run with java AvlTree 
Tester: Compile with javac Problem2.java
        Run with java Problem2 (filename)