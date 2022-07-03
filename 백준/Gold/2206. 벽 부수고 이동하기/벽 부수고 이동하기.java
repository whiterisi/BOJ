import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
		static int [] dx = {-1, 0, 1, 0};
		static int [] dy = {0, 1, 0, -1};
		static boolean[][][] visited;
		static class Node{
			int x;
			int y;
			int cnt;
			int broken;
			
			public Node(int x, int y, int cnt, int broken) {
				this.x=x;
				this.y=y;
				this.cnt=cnt;
				this.broken=broken;
			}
		}
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt(); 
			int m = sc.nextInt();
			int [][] map = new int [n][m];
			visited = new boolean[n][m][2];
			for(int i=0; i<n; i++) {
				String str = sc.next();
				for(int j=0; j<m; j++)
					map[i][j]=str.charAt(j)-'0';
			}
			Queue<Node> que = new LinkedList<>();
			
			Node start = new Node(0,0,1,0);//시작좌표, 시작칸포함, 벽부쉈는지여부
			que.add(start);
			map[0][0]=1;
			visited[0][0][0]=true;

			int result=-1;
			while(!que.isEmpty()) {
				Node node = que.poll();
				if(node.x==n-1&&node.y==m-1) {
					result=node.cnt;
					break ;
				}
				for(int i=0; i<4; i++) {				
					int x = node.x+dx[i];
					int y = node.y+dy[i];
					if(x<0||y<0||x>=n||y>=m) continue;
					
					//이어진 길이 있을때
					if(map[x][y]==0&&!visited[x][y][node.broken]) {
						visited[x][y][node.broken]=true;
						que.add(new Node(x, y, node.cnt+1, node.broken));
					}
					//벽있고+부술 수 있을 때	
					else if(map[x][y]==1&&node.broken==0) {
						visited[x][y][1]=true;
						que.add(new Node(x, y, node.cnt+1,1));	
					}

				}
			}
			System.out.println(result);
		}
	}