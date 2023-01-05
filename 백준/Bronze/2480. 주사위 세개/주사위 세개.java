import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max =0;
		int cnt=0;
		int [] num = new int[7];
		for(int i=0; i<3; i++) {
			int x=sc.nextInt();
			max=Math.max(max, x);
			num[x]++;
		}
		for(int i=1; i<7; i++) {
			if(num[i]==3) {
				System.out.println(10000+1000*i);
				return;
			}else if(num[i]==2) {
				System.out.println(1000+i*100);
				return;
			}
		}
		System.out.println(100*max);
	}
}
