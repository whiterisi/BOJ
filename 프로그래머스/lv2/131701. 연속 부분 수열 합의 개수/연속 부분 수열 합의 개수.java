import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int length = elements.length;
        Set<Integer> count = new HashSet<>();
        
        for(int i=0; i<length; i++){
            int sum=0;
            for(int j=0; j<length; j++){
                sum+=elements[(i+j)%length];
                count.add(sum);
            }
        }
        
        
        return count.size();
    }
}