import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {

        int [][] map = new int [101][101];
        for(int i=0; i<puddles.length; i++){
            map[puddles[i][1]][puddles[i][0]]=-1;
        }
        
        for(int j=1; j<=m; j++){
            if(map[1][j]==-1) break; 
            map[1][j]=1;
        }
        
        for(int i=2; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(map[i][j]==-1) continue;
                if(map[i-1][j]!=-1){
                    map[i][j]+=map[i-1][j];
                } 
                if(j==1) continue;
                if(map[i][j-1]!=-1){
                    map[i][j]+=map[i][j-1];
                } 
                if (map[i][j] > 1000000007) {
                    map[i][j] %= 1000000007;
                }
            }
        }
        
        return map[n][m];
    }

}