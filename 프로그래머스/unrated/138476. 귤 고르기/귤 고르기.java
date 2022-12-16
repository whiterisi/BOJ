import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<tangerine.length; i++){
            if(map.containsKey(tangerine[i])){
                int cnt = map.get(tangerine[i]);
                map.replace(tangerine[i], cnt+1);
            }else{
                map.put(tangerine[i], 1);
            }
        }
        int answer = 0;
        List<Integer> count = new ArrayList(map.values());
        Collections.sort(count, Comparator.reverseOrder());
        int sum=0;
        for(int cnt: count){
            sum+=cnt;
            answer++;
            if(sum>=k) break;
        }
        return answer;
    }
}