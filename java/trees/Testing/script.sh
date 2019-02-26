#! /bin/sh
rm *.class
javac Problem2.java
java Problem2 test.txt > student.txt
diff student.txt output.txt
grep -rni "printIndex" * > printIndex.txt
grep -rni "getLinesfor" * > getLines.txt
grep -rni "indexWord" * > indexWord.txt
