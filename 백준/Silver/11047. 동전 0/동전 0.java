import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		ArrayList<Integer> num = new ArrayList<>();
		for(int i=0; i<n; i++) {
			int in = sc.nextInt();
			if(in>k) break;
			num.add(in);
		}
		int cnt=0;
		for(int i=num.size()-1; i>=0; i--) {
			cnt+=k/num.get(i);
			k%=num.get(i);
		}
			
		System.out.println(cnt);
	}
}
