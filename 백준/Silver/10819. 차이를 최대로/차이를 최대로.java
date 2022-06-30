import java.util.Scanner;
public class Main {
	static int n, max;
	static int [] num, res;
	static boolean [] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		num = new int[n];
		for(int i=0; i<n; i++)
			num[i]=sc.nextInt();
		max=0;
		res = new int [n];
		visited = new boolean [n];
		per(0);
		System.out.println(max);
	}
	static void per(int idx) {
		if(idx==n) {
			max=Math.max(max, cal());
			return;
		}
		
		for(int i =0; i<n; i++) {
			if(visited[i]) continue;
			visited[i]=true;
			res[idx]=num[i];
			per(idx+1);
			visited[i]=false;
		}
	}
	static int cal(){
		int sum=0;
		for(int i=0; i<n-1; i++)
			sum+=Math.abs(res[i+1]-res[i]);
		return sum;
	}
}