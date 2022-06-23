import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int [] stu = new int [n+1];
		
		ArrayList<Integer>[] list= new ArrayList[n+1];
		for(int i=0; i<n+1; i++)
			list[i] = new ArrayList<>();
		
		for(int i=0; i<m; i++){
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			list[s].add(t);
			stu[t]++;
		}
		Queue<Integer> que = new LinkedList<>();
		for(int i=1; i<n+1; i++)
			if(stu[i]==0) {
				stu[i]=-1;
				que.add(i);
			}
		
		StringBuilder sb = new StringBuilder();
		while(!que.isEmpty()) {
			int cur = que.poll();
			sb.append(cur).append(" ");
			for(int i:list[cur]) {
				stu[i]--;
			}
			for(int i=1; i<n+1; i++)
				if(stu[i]==0) {
					stu[i]=-1;
					que.add(i);
				}	
		}
		System.out.println(sb.toString());
	}
}
