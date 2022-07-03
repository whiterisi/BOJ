import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	static BigInteger [][] com;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		com = new BigInteger[101][101];
		DpCom(n, m);
		System.out.println(com[n][m]);
	}
	static void DpCom(int n, int m) {
		for(int i=0; i<101; i++)
			for(int j=0; j<=i; j++) {
				if(j==i||j==0)
					com[i][j]= new BigInteger("1");
				else
					com[i][j]=com[i-1][j-1].add(com[i-1][j]);
			}
	}

}