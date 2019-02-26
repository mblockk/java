The spellchecker program gave me a lot of trouble. I kept thinking I had it, but then found some
additional issue that I needed to take care of. I pretty much had to learn how to use StringBuilder
to make this happen. I'd avoided it in all previous assignments. I broke the program up into
methods for readability, and I ran made a new instance of SpellChecker from the main method 
so that I could make calls to dictionary.contains() from those separate methods. 
compile with javac SpellChecker.java
run with java SpellChecker (dictionary filepath) (document filepath)

I also had an issue with the testKBest program. I wasn't taking into consideration that the length
of the queue decreases every time, and it took me a bit to figure out that I needed to set it's initial
length to a variable before running a for loop using the priority queue's length.
compile with javac TestKBest.java
run with java TestKBest
