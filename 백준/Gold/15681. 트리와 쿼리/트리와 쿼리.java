import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static ArrayList<Integer>[] list;
	static int [] dp;
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //정점의 수
		int r = sc.nextInt(); //루트의 번호
		int q = sc.nextInt(); //쿼리의 수
		
		//n-1개의 간선정보
		list = new ArrayList[n+1];
		for(int i=0; i<n+1; i++)
			list[i]= new ArrayList<>();
		for(int i=0; i<n-1; i++) {
			int sta = sc.nextInt();
			int end = sc.nextInt();
			list[sta].add(end);
			list[end].add(sta);
		}
			

		//서브쿼리 결과값 저장
		dp = new int [n+1];
		Arrays.fill(dp, 1);
		
		subcnt(r, -1);
		
		for(int i=0; i<q; i++)
			System.out.println(dp[sc.nextInt()]);
		
	}
	public static void subcnt(int cur, int par) {
		for(int n :list[cur])
			if(n!=par) 
				subcnt(n, cur);

		if(par!=-1)
			dp[par]+=dp[cur];
	}
}
