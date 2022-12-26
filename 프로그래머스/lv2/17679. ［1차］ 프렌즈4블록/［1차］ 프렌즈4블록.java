import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        ArrayList<Character>[] map = new ArrayList[n];
        for(int i=0; i<n; i++)
            map[i]= new ArrayList<>();
        
        for(int i=m-1; i>=0; i--){
            char [] list = board[i].toCharArray();
            for(int j=0; j<n; j++)
                map[j].add(list[j]);
        }
        
        
        
        
        
        return answer;
    }
}