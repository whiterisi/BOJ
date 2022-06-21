import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Integer.parseInt(st.nextToken()); //밑
		long b = Integer.parseInt(st.nextToken()); // 지수
		long c = Integer.parseInt(st.nextToken()); // 나눌 값
		System.out.println(mid(a, b, c));
	}
	private static long mid(long a, long b, long c) {
		if(b==0) return 1;
		if(b==1) return a%c;
		long tmp = mid(a, b/2, c);
		if(b%2==0){
			return tmp*tmp%c;
		}else {
			return tmp*tmp%c*a%c;
		}
	}
}