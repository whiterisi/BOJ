import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N= Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int k=-1;
			int lcm = M*N/gcd(M,N);
			int n=0;
			while(n*M<lcm) {
				if((n*M+x-y)%N==0) {
					k=n*M+x;
					break;
				}
				n++;
			}
			sb.append(k).append("\n");
		}
		System.out.print(sb.toString());
	}
	public static int gcd(int x, int y) {
		if(y==0) return x;
		return gcd(y, x%y);
	}

}