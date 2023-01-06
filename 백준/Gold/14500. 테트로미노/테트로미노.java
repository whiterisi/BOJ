import java.util.*;

public class Main {
	
	static int N, M, max;
	static int [][] box;
	static boolean [][] visit;
	static int [] dx= {0,0,-1,1};
	static int [] dy = {-1, 1, 0,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N= sc.nextInt();
		M=sc.nextInt();
		box = new int[N][M];
		for(int i=0; i<N; i++)
			for(int j=0; j<M; j++)
				box[i][j]=sc.nextInt();
		max=0;
		visit= new boolean [N][M];
		for(int i=0; i<N; i++)
			for(int j=0; j<M; j++) {
				visit[i][j]=true;
				checkBlock(i, j, box[i][j], 1);
				visit[i][j]=false;
				checkException(i, j);
			}
		System.out.println(max);
	}
	
	public static void checkBlock(int x, int y, int sum, int cnt) {
		if(cnt==4) {
			max=Math.max(max, sum);
			return;
		}
		for(int idx=0; idx<4; idx++) {
			int i=x+dx[idx];
			int j=y+dy[idx];
			if(isOut(i, j)||visit[i][j]) continue;
			visit[i][j]=true;
			checkBlock(i, j, sum+box[i][j], cnt+1);
			visit[i][j]=false;
		}
	}
	
	public static void checkException(int x, int y) {
		int min=Integer.MAX_VALUE;
		int sum=0;
		int cnt=0;
		for(int idx=0; idx<4; idx++) {
			int i=x+dx[idx];
			int j=y+dy[idx];
			if(isOut(i, j)) continue;
			cnt++;
			sum+=box[i][j];
			min=Math.min(min, box[i][j]);
		}
		if(cnt<3) return;
		
		min=cnt==3? 0:min;
		max=Math.max(max, box[x][y]+sum-min);
		
	}
	
	public static boolean isOut(int i, int j) {
		if(i<0||j<0||i>=N||j>=M) return true;
		return false;
	}

}