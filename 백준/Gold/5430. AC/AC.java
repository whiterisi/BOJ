import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			boolean flag=true;
			boolean reverse=false;
			String str = br.readLine();
			int n =Integer.parseInt(br.readLine());
			
			Deque<Integer> dq = new LinkedList<>();
			String line = br.readLine();
			if(n!=0) {
				line=line.substring(1, line.length()-1);
				String [] num = line.split(",");
				for(int k=0; k<num.length; k++) 
					dq.add(Integer.parseInt(num[k]));
			}
			
			for(int j=0; j<str.length();j++) {
				char c = str.charAt(j);
				if(c=='D') {
					if(dq.size()==0) {
						flag=false;
						break;
					}
					if(reverse) {
						dq.pollLast();
					}else {
						dq.pollFirst();
					}
				}else {
					reverse=reverse?false:true;
				}
			}
			
			
			if(!flag) {
				sb.append("error");
			}else if(reverse){
				sb.append("[");
				while(dq.size()>1) {
					sb.append(dq.pollLast()+",");
				}
				if(!dq.isEmpty()) sb.append(dq.pollLast());
				sb.append("]");
			}else {
				sb.append("[");
				while(dq.size()>1) {
					sb.append(dq.pollFirst()+",");
				}
				if(!dq.isEmpty()) sb.append(dq.pollFirst());
				sb.append("]");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}