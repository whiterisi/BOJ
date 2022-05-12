import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static LinkedList<Integer>[] list;
	static int [][] dp;
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		dp=new int [n+1][2];
		
		//인접리스트 만들기
		list = new LinkedList[n+1];
		for(int i=0; i<n+1; i++)
			list[i]= new LinkedList<>();
		for(int i=0; i<n-1; i++) {
			int st =sc.nextInt();
			int end = sc.nextInt();
			list[st].add(end);
			list[end].add(st);
		}

		dp(1, -1); //1번 노드부터시작
		System.out.println(Math.min(dp[1][0], dp[1][1]));
		
	}
	public static void dp(int cur, int par) {
		dp[cur][0]=0; //얼리어답터인경우 0
		dp[cur][1]=1; //얼리어답터가 아닌 경우 1
		
		for(int next: list[cur]) {
			if(next!=par) {
				dp(next, cur);
				dp[cur][0]+=dp[next][1];
				dp[cur][1] +=Math.min(dp[next][0], dp[next][1]);
			}
		}
		
	}
}
