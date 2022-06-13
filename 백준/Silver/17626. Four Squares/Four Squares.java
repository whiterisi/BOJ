import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int [] dp = new int [num+1];
		dp[1]=1;
		for(int i=2; i<num+1; i++) {
			int min = Integer.MAX_VALUE;
			for(int j=1; j*j<=i; j++) {
				min=Math.min(min, dp[i-j*j]);
			}
			dp[i]=min+1;
		}
		System.out.println(dp[num]);
	}
}
