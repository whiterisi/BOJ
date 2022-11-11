import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int [] answer = new int [commands.length];
        for(int tc=0; tc<commands.length; tc++){
            int start = commands[tc][0];
            int end = commands[tc][1];
            int order = commands[tc][2];
            int [] temp = new int [end-start+1];
            int t=0;
            for(int i=start-1; i<end; i++){
                temp[t++]=array[i];
            }
            Arrays.sort(temp);
            answer[tc]=temp[order-1];
        }
        return answer;
    }
}