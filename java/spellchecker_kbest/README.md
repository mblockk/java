# Homework 4 Programming

## Due Sunday, April 22 th at 11:59pm. With a late deadline *4* days later.

Please remember that to submit the assignment you will need to the Education drop down menu and select 
assignment complete.   Also remember that you should submit a txt file on canvas that indicates your codio username so that we can cross check our grade data entry.

## Problem 1 - Implementing a Spell Checker - 35 points

Based on Weiss Exercise 5.21 - implement this problem as described with the exception of the secondary dictionary.  Your program, called SpellChecker.java should take two command line arguments (that is via the args variable in main): (1) the name of a dictionary file (there is a sample words.txt in the workspace), and (2) the name of the file that contains the text you wish to spellcheck. Submit some sample text with your solution. 

Your program should be case insensitive (so you can toLower everything). Numbers and contractions are valid input, don't strip them out or treat them any differently than a regular word. Only strip one leading and one trailing punctuation, do not worry about ' characters at the end of a possessive plural; just remove them.

Note that each of the suggestion rules should be applied independently and in the first rule (add character) you need to try the characters a-z and the ', you do not need to add numbers.

You may use the java HashSet, HashMap, or HashTable to implement this program; but it must use some kind of hash table.

## Problem 2 - k-Largest Values - 30 points

Finding the k-largest values in a set of data - Assume you are given a sequence of values. We do not know how many elements there are in this sequence. In fact, there could be infinitely many. Implement the class
```KBestCounter<T extends Comparable<? super T>>``` that keeps track of the k-largest elements seen so far in a set of data. The class should have two methods:

* ```public void count(T x)``` - process the next element in the set of data. This operation should run in the at worst O(log k) time.

* ```public List<T> kbest()``` - return a sorted (largest to smallest) list of the klargest elements. This should run in O(k log k) time. The method should restore the priority queue to its original state after retrieving the k largest elements. If you run this method twice in a row, it should return the same values.

Use a Priority Queue to implement this functionality. We suggest using the built-in java.util.PriorityQueue, which implements a min-heap for you. You should never have more than k elements inserted into the Priority Queue at any given time.

An example illustrates how KBestCounter could be used in this attached tester class: TestKBest.java.  We also include a skeleton for the KBestCounter class in the following file: KBestCounter.java.

## Problem 3 - The Readme File

Please fill in the STUDENTREADME.md file which should indicate exactly what files you are submitting, what problem they solve, and how to compile and run them. This is also a good place to tell us any assumptions or special issues associated with your submission.