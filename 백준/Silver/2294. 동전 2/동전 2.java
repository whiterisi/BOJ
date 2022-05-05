import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int [] input = new int[n+1];
		for(int i=1; i<n+1; i++)
			input[i]=sc.nextInt();
		int [] dp = new int [k+1];
		Arrays.fill(dp, 10001);
		dp[0]=0;
		for(int i=1; i<n+1; i++)
			for(int j=input[i]; j<k+1; j++) {
				dp[j]=Math.min(dp[j], dp[j-input[i]]+1);
			}
		if(dp[k]==10001) System.out.println(-1);
		else System.out.println(dp[k]);
	}
}
