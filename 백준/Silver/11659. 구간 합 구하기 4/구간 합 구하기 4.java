import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int [] num = new int [n+1];
		int [] sum = new int [n+1];
		for(int i=1; i<n+1; i++) {
			num[i]=sc.nextInt();
			sum[i]=sum[i-1]+num[i];
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<m; i++) {
			int start = sc.nextInt()-1;
			int end = sc.nextInt();
			sb.append(sum[end]-sum[start]+"\n");
		}
		System.out.println(sb.toString());
	}
}
