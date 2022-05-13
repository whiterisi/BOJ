import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int n;
	static int [] pop;
	static int [][] dp;
	static ArrayList<Integer>[] list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//인구수배열
		pop = new int [n+1];
		for(int i=1; i<n+1; i++)
			pop[i]=sc.nextInt();
		
		//인접리스트
		list = new ArrayList[n+1];
		for(int i=0; i<n+1; i++)
			list[i]= new ArrayList<>();
		for(int i=0; i<n-1; i++) {
			int sta = sc.nextInt();
			int end = sc.nextInt();
			list[sta].add(end);
			list[end].add(sta);
		}
		//dp결과값
		//[x][0]=우수마을이 아닌경우, [x][1]은 우수마을인경우
		dp = new int [n+1][2]; 
		
		dfs(1, 0);
		
		System.out.println(Math.max(dp[1][0], dp[1][1]));
			

	}
	public static void dfs(int cur, int par) {
		for(int n: list[cur]) {
			if(n!=par) {
				dfs(n, cur);
				dp[cur][0]+=Math.max(dp[n][0], dp[n][1]); 
				dp[cur][1]+=dp[n][0];
			}
		}
		
		dp[cur][1]+=pop[cur];
	}

}