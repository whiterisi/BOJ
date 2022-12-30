import java.util.*;

public class Main {
	static int [] dx = {-1, 0, 0, 1};
	static int [] dy = {0, -1, 1, 0};
	static int [][] box;
	static int m, n;
	static class Node{
		int  x, y, cnt;
		
		Node( int x, int y, int cnt){
			this.x=x;
			this.y=y;
			this.cnt=cnt;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		box = new int [n][m];
		boolean [][] visit = new boolean [n][m];
		for(int i=0; i<n; i++)
			Arrays.fill(box[i], Integer.MAX_VALUE);
		Queue<Node> que = new LinkedList<>();
		for(int i=0; i<n; i++)
			for(int j=0; j<m; j++) {
				int x=sc.nextInt();
				if(x==1) {
					que.add(new Node(i, j, 0));
					box[i][j]=x;
					visit[i][j]=true;
				}else if(x==-1) {
					box[i][j]=x;
					visit[i][j]=true;
				}
			}
		int max=0;
		while(!que.isEmpty()) {
			Node cur = que.poll();
			
			for(int idx=0; idx<4; idx++) {
				int x = cur.x+dx[idx];
				int y = cur.y+dy[idx];
				
				if(isOut(x, y)) continue;
				if(box[x][y]<=cur.cnt+1) continue;
				que.add(new Node(x, y, cur.cnt+1));
				box[x][y]=cur.cnt+1;
				visit[x][y]=true;
				max=Math.max(max, box[x][y]);
			}
		}
		boolean flag=true;
		for(int i=0; i<n; i++)
			for(int j=0; j<m; j++)
				if(!visit[i][j]) flag=false;
		
		if(flag) System.out.println(max);
		else System.out.println(-1);


	}
	public static boolean isOut(int x, int y) {
		if(x<0||y<0||x>=n||y>=m) return true;
		if(box[x][y]==-1||box[x][y]==1) return true;
		return false;
	}

}