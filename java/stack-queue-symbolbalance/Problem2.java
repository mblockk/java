// Michael Block -- mb4239
// Tester class for the TwoStackQueue
// compile with javac Problem2.java
// run with java Problem2.java

public class Problem2 {
    public static void main(String[] args){
        
     TwoStackQueue<String> s = new TwoStackQueue<String>();

        String h = (" | | |____||____| | || |    |_____|   | | ");
        String u = ("useless String");        
        String c = (" | |  ____  ____  | || |     _____    | | ");
        String z = ("hobbyist zoologist");
        String g = (" | |  _| |  | |_  | || |     _| |_    | | ");
        String n = ("");
        String p = ("don't mind me");
        String b = (" | .--------------. || .--------------. | ");          
        String m = (""); 
        String y = ("y me tho");        
        String f = (" | |   |  __  |   | || |      | |     | |");
        String t = ("t is for tom");    
        String j = (" | '--------------' || '--------------' | ");
        String l = ("");
        String o = ("over this");
        String e = (" | |   | |__| |   | || |      | |     | |");
        String v = ("VIS: Very Exciting String");
        String i = (" | |              | || |              | | ");
        String q = ("nothing to see here, folks.");        
        String k = ("  '----------------'  '----------------' ");
        String w = ("weeeee");
        String x = ("xxx");
        String a = ("  .----------------.  .----------------. ");
        String r = ("i wish i were an int");
        String d = (" | | |_   ||   _| | || |    |_   _|   | | ");

        s.enqueue(l);
        s.enqueue(m);
        s.enqueue(n);
        s.enqueue(o);
        s.enqueue(p);
        s.enqueue(q);
        s.enqueue(r);
        s.enqueue(t);
        s.enqueue(u);
        s.enqueue(v);
        s.enqueue(w);
        s.enqueue(x);
        s.enqueue(y);
        s.enqueue(z);
        while(!s.isEmpty())
            s.dequeue();
        s.enqueue(a); 
        s.enqueue(b);
        s.enqueue(c);
        s.enqueue(d);
        s.enqueue(e);
        s.enqueue(f);
        s.enqueue(g);
        s.enqueue(h);        
        s.enqueue(i);
        s.enqueue(j);
        s.enqueue(k);       
        while(!s.isEmpty())
            System.out.println(s.dequeue());        
    }
}