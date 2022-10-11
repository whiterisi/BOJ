import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        int[] answer;
        if(s/n==0) { 
            answer = new int [1];
            answer[0]=-1;
        }else{
            answer = new int [n];
            Arrays.fill(answer, s/n);
            int remain = s-(s/n*n);
            int idx=answer.length;
            for(int i=0; i<remain; i++)
                answer[--idx]++;
        }
        return answer;
    }
}