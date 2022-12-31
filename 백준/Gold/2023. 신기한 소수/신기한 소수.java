import java.util.*;

public class Main {
	static int [] prime;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
			
		ArrayList<Integer>[] list = new ArrayList[N+1];
		for(int i=0; i<N+1; i++)
			list[i]=new ArrayList<>();
		list[0].add(0);
		
		for(int i=1; i<=N; i++) {
			for(int num: list[i-1]) {
				int check = num*10;
				for(int k=1; k<10; k++)
					if(isPrime(check+k))
						list[i].add(check+k);
			}
		}
		
		for(int num: list[N])
			System.out.println(num);
	}
	public static boolean isPrime(int num) {
		if(num==1) return false;
		for(int i=2; i<num/2+1; i++)
			if(num%i==0) return false;
		return true;
	}
	
}