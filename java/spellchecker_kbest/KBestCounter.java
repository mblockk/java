//
//KBestCounter program by Michael Block -- mb4239
//

import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

public class KBestCounter<T extends Comparable<? super T>> {

    PriorityQueue<T> pq;
    final int inputSize;

    public KBestCounter(int k) {
        inputSize = k;
        pq = new PriorityQueue<T>();

    }

    public void count(T x) {
        if(pq.size()<inputSize)
        pq.offer(x);
        
        else if( pq.size() == inputSize){
            pq.poll();
            pq.offer(x);
        }
    }

    public List<T> kbest() {
        ArrayList<T> list = new ArrayList<T>();
        int pqlen = pq.size();
        for(int i = 0; i<pqlen; i++)
            list.add(0, pq.poll());
        for(int k = 0; k<list.size(); k++){
            pq.offer(list.get(k));
        }

        return list;
        
    }

}
