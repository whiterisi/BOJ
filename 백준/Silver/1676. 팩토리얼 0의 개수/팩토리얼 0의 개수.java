import java.util.Scanner;

public class Main {
	static int fact;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt=0;
		for(int i=1; i<=n; i++) {
			int k=i;
			while(k>=5&&k%5==0) {
				cnt++;
				k/=5;
			}
		}
		System.out.println(cnt);
	}
}
