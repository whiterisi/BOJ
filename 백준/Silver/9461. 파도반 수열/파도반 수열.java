import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		long [] dp = new long [101];
		dp[1]=1;
		dp[2]=1;
		for(int i=3; i<101; i++)
			dp[i]=dp[i-2]+dp[i-3];
		
		int TC = sc.nextInt();
		for(int tc=0; tc<TC; tc++) 
			System.out.println(dp[sc.nextInt()]);

	}
}