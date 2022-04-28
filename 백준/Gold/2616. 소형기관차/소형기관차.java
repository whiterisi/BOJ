import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //딸려있는 객차 수 
		int [] info = new int [n+1];
		int [] sum = new int [n+1];
		for(int i=1; i<=n; i++) {
			info[i]=sc.nextInt();
			sum[i]=sum[i-1]+info[i];
		}
		
		int m = sc.nextInt();//소형 기관차 당 최대 객차 수 

		int dp[][] = new int [4][n+1];
		for(int i=1; i<4; i++)
			for(int j=i*m; j<=n; j++)
				dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j-m]+(sum[j]-sum[j-m]));
		
		System.out.println(dp[3][n]);
	}
}