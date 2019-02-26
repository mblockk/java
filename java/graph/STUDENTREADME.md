Nearest neighbor implementation gave me some trouble, I believe my implementation is
very memory-heavy and inefficient, but it works.

N:    3-trial avg dist(time)
2         85.01 (0 ms)
3         122.49 (0 ms)
4         182.91 (0 ms)
5         255.15 (0 ms)
6         261.94 (0 ms)
7         284.61 (0 ms)
8         327.84 (1 ms)


BruteForceTsp also gave me trouble, mostly trying to find a permutation algorithm that
gave me what I wanted. The final implementation is a combination of various algorithms
I found online, adapted to store all of the permutations in an ArrayList<String>. I think
my implementation of bruteforce is also very inefficient. I'm sure there's a way
to generate permutations that keep the first and last character the same, but I found it
easier to just hardcode it on the back end of each permutation and check the edge cost of
each after. Only works for |V| less than 10, otherwise the VM runs out of memory. Also, 
the permutation method only handles single-digit elements (10 would become 1, 0), but, per
what blaer said in class, I believe this is within the scope of what our program needs to handle.
Also, I altered the getVertex method. It still takes in a string, but it was unable to find 
vertices with String names, so I parsed the argument to int and used that to find the needed
vertex. I think this was necessary as vertex.name is int anyway. 
    
N:    3-trial avg dist(time)
2         85.01 (0 ms)
3         122.49 (0 ms) 
4         182.91 (0 ms)
5         244.58 (2 ms) 
6         236.61 (3 ms)
7         262.47 (14 ms)
8         286.72 (221 ms)



Comparing the 3-trial average for N values 2-8, it's clear the
distance improves with the bruteForce algorithm with higher values,
but the difference is less significant that I thought it would be.
Also, the time taken increases significantly between the NN algo
and BruteForce. I was curious why NN was reading 0ms every time, but 
then I got a readout on N=8. I thought the bruteForce algorithm would
take longer than it did.