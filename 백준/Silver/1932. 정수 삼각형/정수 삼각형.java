import java.util.Scanner;

public class Main {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [][] map = new int [n][n+1];
		
		for(int i=0; i<n; i++)
			for(int j=1; j<=i+1; j++)
				map[i][j]=sc.nextInt();
		
		int [][] dp = new int [n][n+1];
		dp[0][1]=map[0][1];
		int max=dp[0][1];
		for(int i=1; i<n; i++)
			for(int j=1; j<=i+1; j++) {
				dp[i][j]=Math.max(dp[i-1][j-1]+map[i][j], dp[i-1][j]+map[i][j]);
				max=Math.max(max, dp[i][j]);
			}
		
		System.out.println(max);
	}
}