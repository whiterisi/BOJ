import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int leng = triangle.length;
        for(int i=1; i<leng; i++)
           for(int j=0; j<=i; j++){
               if(j==0){
                  triangle[i][j]+=triangle[i-1][0];
               }else if(j==i){
                 triangle[i][j]+=triangle[i-1][j-1];
               }else{
                   triangle[i][j]+=Math.max(triangle[i-1][j-1], triangle[i-1][j]);
               }
           }
        for(int i=0; i<leng; i++){
            answer = Math.max(answer, triangle[leng-1][i]);
        }
        return answer;
    }
}