import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int idx=B.length-1;
        for(int i=B.length-1; i>=0; i--){
            if(B[idx]>A[i]){
                answer++;
                idx--;
            }
            if(idx<0) break;
        }
        return answer;
    }
}