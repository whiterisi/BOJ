import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine())*2+1;
		int length = Integer.parseInt(br.readLine());
		String str = br.readLine();
		char [] one = str.toCharArray();
		int [] check= new int[length];
		int num=0;
		if(one[0]=='I') check[0]=1;
		
		
		for(int i=1; i<length; i++) {
			if(one[i]==one[i-1]) {
				check[i]=one[i]=='I'?1:0;
				continue;
			}

			if(check[i-1]==N) {
				check[i]=N-1;
			}else {
				check[i]=check[i-1]+1;
			}
			
			if(check[i]==N) num++;

		}		
		System.out.println(num);
	}
}