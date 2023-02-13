import java.util.*;

class Solution {

    static boolean [][] visit;
    static int [][] map;
    static List<Integer> list;
    public int[] solution(String[] maps) {
        int I = maps.length;
        int J = maps[0].length(); 
        map = new int [I+2][J+2];
        visit = new boolean [I+2][J+2];
        
        for(int i=0; i<I; i++){
           String str = maps[i];
            for(int j=0; j<J; j++){
                char cha  = str.charAt(j);
                if(cha=='X'){
                    map[i+1][j+1]= 0;
                    visit[i+1][j+1]=true;
                }else{
                     map[i+1][j+1]= cha-48;
                }
            }      
        }
        list = new ArrayList<Integer>();
        for(int i=1; i<I+2; i++)
            for(int j=1; j<J+2; j++)
                if(map[i][j]!=0&&!visit[i][j])
                    list.add(dfs(i, j));
        int [] answer = {-1};
        if(!list.isEmpty()){
            answer = new int [list.size()];
            for(int i=0; i<list.size(); i++)
                answer[i]=list.get(i);
            Arrays.sort(answer);
        }
        return answer;
    }
    static int [] dx= {0,0,-1,1};
    static int [] dy= {-1,1,0,0};
    public static class Node{
        int x, y;
        Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    public static int dfs(int x, int y){
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(x, y));
        visit[x][y]=true;
        int sum=0;
        while(!que.isEmpty()){
            Node cur = que.poll();
            sum+=map[cur.x][cur.y];
            for(int idx=0; idx<4; idx++){
                int nx= cur.x+dx[idx];
                int ny = cur.y+dy[idx];                
                if(map[nx][ny]==0) continue;
                if(visit[nx][ny]) continue;
                visit[nx][ny]=true;
                que.add(new Node(nx, ny));
            }
        }
        return sum;
    }
}