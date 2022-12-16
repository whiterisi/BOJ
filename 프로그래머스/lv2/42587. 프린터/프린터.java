import java.util.*;

class Solution {
    public static class Info implements Comparable<Info>{
        int idx;
        int priority;
        
        public Info(int idx, int priority){
            this.idx = idx;
            this.priority = priority;
        }
        
        @Override
        public int compareTo(Info o) {
            if(o.priority == this.priority)
                return this.idx - o.idx;
            return o.priority -this.priority;
        }
    }
    public int solution(int[] priorities, int location) {
        PriorityQueue<Info> pq = new PriorityQueue<>();
        Queue<Info> order = new LinkedList<>();
        for(int i=0; i<priorities.length; i++){
            Info info = new Info(i, priorities[i]);
            order.add(info);
            pq.add(info);
        }
        int answer = 0;
        while(!pq.isEmpty()){
            Info cur = pq.peek();
            Info check = order.poll();
            System.out.println();
            if(cur.priority==check.priority){
                pq.poll();
                answer++;
                if(check.idx==location) break;
            }else{
                order.add(check);
            }
        }
        return answer;
    }
}