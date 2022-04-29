import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int n, h;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String line =br.readLine();
		StringTokenizer st = new StringTokenizer(line);
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		//(2 ≤ N ≤ 200,000, 2 ≤ H ≤ 500,000)
		
		int [] top = new int[h+1]; //종유석
		int [] bottom = new int[h+1]; //석순
			
		for(int i=0; i<n/2; i++) {
			bottom[Integer.parseInt(br.readLine())]++;
			top[Integer.parseInt(br.readLine())]++;
		}
		
		for(int i=h-1; i>0; i--) {
			bottom[i]+=bottom[i+1];
			top[i]+=top[i+1];
		}
		
		int min=Integer.MAX_VALUE;
		int cnt=0;
		for(int i=1; i<h+1; i++) {
			int sum = top[i]+bottom[h-i+1]; 
			
			if(sum<min) {
				cnt=0;
				min=sum;
			}
			if(sum==min) cnt++;
		}
		
		bw.write(min+ " "+cnt);
		bw.flush();
		bw.close();
	}
}