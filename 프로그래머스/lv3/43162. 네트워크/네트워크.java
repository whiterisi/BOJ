
import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int l = computers.length;
        boolean [] visited = new boolean[l];      
        for(int i=0; i<l; i++){
            if(!visited[i]){
                dfs(i, visited, computers);
                answer++;
            }
        }
        return answer;
    }
    public void dfs(int i,  boolean [] visited, int[][] computers){
        Stack<Integer> stack = new Stack<>();
        stack.add(i);
        while(!stack.isEmpty()){
            int cur = stack.pop();
            if(visited[cur]) continue;  
            visited[cur]=true;
            for(int x=0; x<computers.length; x++){
                if(computers[cur][x]==0||visited[x]) continue;
                stack.add(x);
            }
        }
    }
}