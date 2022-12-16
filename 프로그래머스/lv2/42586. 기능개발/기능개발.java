import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int [] rest = new int [speeds.length];
        for(int i=0; i<speeds.length; i++){
            float res = (100- progresses[i])%speeds[i]*10;
            if(res==0) rest[i]=(100- progresses[i])/speeds[i];
            else rest[i]=(100- progresses[i])/speeds[i]+1;
        }
        
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<speeds.length; i++){
            if(stack.isEmpty()){
                stack.add(rest[i]);
                map.put(rest[i], 1);
            }else if(stack.peek()<rest[i]){
                stack.add(rest[i]);
                map.put(rest[i], 1);
            }else {
                int x = map.get(stack.peek());
                map.replace(stack.peek(), x+1);
            }
        }
        
        int[] answer = new int [stack.size()];
        for(int i=stack.size()-1;i>=0; i--)
            answer[i]=map.get(stack.pop());
        return answer;
    }
}