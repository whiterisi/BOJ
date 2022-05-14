import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n= Integer.parseInt(br.readLine());
		String [] input = br.readLine().split(" ");

		int [] plus = new int [10000001];
		int [] minus = new int [10000001];
		for(int i=0; i<n; i++) {
			int x = Integer.parseInt(input[i]);
			if(x>=0) {
				plus[x]++;
			}else {
				x*=-1;
				minus[x]++;
			}	
		}
		int m= Integer.parseInt(br.readLine());
		String [] com = br.readLine().split(" ");
		for(int i=0; i<m; i++) {
			int x = Integer.parseInt(com[i]);
			if(x>=0) {
				bw.write(plus[x]+" ");
			}else {
				x*=-1;
				bw.write(minus[x]+" ");
			}	
		}
		bw.flush();
		bw.close();
	}
}