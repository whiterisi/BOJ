import java.util.*;
import java.io.*;

class Solution {
    static int[] dx={0, 0, 1, -1};
    static int[] dy={1, -1, 0, 0};
    static int [][] box;
    static boolean [][] res;
    static int n, m;
    static class Node{
        int x, y, cnt;
        public Node(int x, int y, int cnt){
            this.x=x;
            this.y=y;
            this.cnt=cnt;
        }
    }
    public int solution(int[][] maps) {
        box=maps;
        n = maps.length;
        m = maps[0].length;
        res = new boolean [n][m];
        int answer = -1;
        
        Queue<Node> que = new LinkedList<>();
        res[0][0]=true;
        que.add(new Node(0, 0, 1));
        while(!que.isEmpty()){
            Node cur = que.poll();
            if(cur.x==n-1&&cur.y==m-1){
                answer=cur.cnt;
                break;
            }
            for(int d=0; d<4; d++){
                int x = cur.x+dx[d];
                int y = cur.y+dy[d];

                if(!isOk(x, y)) continue;
                if(res[x][y]) continue;
                que.add(new Node(x, y, cur.cnt+1));
                res[x][y]=true;
            }
        }        
        return answer;
    }
    public boolean isOk(int x, int y ){
        if(x<0||y<0||x>=n||y>=m||box[x][y]==0) return false;
        return true;
    }
}