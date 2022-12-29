import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [] dp = new int [1001];
		dp[1]=1;
		dp[2]=3;
		dp[3]= 5;
		for(int i=4; i<1001; i++)
			dp[i]=(dp[i-1]+dp[i-2]*2)%10007;
		System.out.print(dp[N]);
	}
}
