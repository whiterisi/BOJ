import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i: scoville)
            pq.add(i);
        
        int answer = 0;
        boolean flag=false;
        while(true){
            int first = pq.poll();
            if(first>=K){
                flag = true;
                break;
            }
            if(pq.size()==0) break;
            int second = pq.poll();
            pq.add(first+second*2);
            answer++;
        }
        
        if(flag) return answer;
        return -1;
    }
}