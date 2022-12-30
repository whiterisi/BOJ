import java.util.*;


public class Main {
	static int [] dx = {-1, 0, 0, 1, 0, 0};
	static int [] dy = {0, -1, 1, 0, 0, 0};
	static int [] dz = {0,0,0,0,1,-1};
	static int [][][] box;
	static int m, n, h;
	static class Node{
		int  z, x, y, cnt;
		
		Node(int z,  int x, int y, int cnt){
			this.z=z;
			this.x=x;
			this.y=y;
			this.cnt=cnt;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		h=sc.nextInt();
		box = new int [h][n][m];
		boolean [][][] visit = new boolean [h][n][m];
		for(int k=0; k<h; k++)
			for(int i=0; i<n; i++)
				Arrays.fill(box[k][i], Integer.MAX_VALUE);
		Queue<Node> que = new LinkedList<>();
		for(int k=0; k<h; k++)
			for(int i=0; i<n; i++)
				for(int j=0; j<m; j++) {
					int x=sc.nextInt();
					if(x==1) {
						que.add(new Node(k, i, j, 0));
						box[k][i][j]=x;
						visit[k][i][j]=true;
					}else if(x==-1) {
						box[k][i][j]=x;
						visit[k][i][j]=true;
				}
			}
		int max=0;
		while(!que.isEmpty()) {
			Node cur = que.poll();
			
			for(int idx=0; idx<6; idx++) {
				int x = cur.x+dx[idx];
				int y = cur.y+dy[idx];
				int z = cur.z+dz[idx];
				
				if(isOut(x, y, z)) continue;
				if(box[z][x][y]<=cur.cnt+1) continue;
				que.add(new Node(z, x, y, cur.cnt+1));
				box[z][x][y]=cur.cnt+1;
				visit[z][x][y]=true;
				max=Math.max(max, box[z][x][y]);
			}
		}
		
		boolean flag=true;
		for(int k=0; k<h; k++)
			for(int i=0; i<n; i++)
				for(int j=0; j<m; j++)
					if(!visit[k][i][j]) flag=false;
		
		if(flag) System.out.println(max);
		else System.out.println(-1);


	}
	public static boolean isOut(int x, int y, int z) {
		if(x<0||y<0||x>=n||y>=m||z<0||z>=h) return true;
		if(box[z][x][y]==-1||box[z][x][y]==1) return true;
		return false;
	}

}