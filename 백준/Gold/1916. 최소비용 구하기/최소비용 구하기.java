import java.util.*;
import java.io.*;

public class Main {
	static class Node implements Comparable<Node>{
		int y, bill;
		Node(int y,  int bill){
			this.y=y;
			this.bill=bill;
		}
		public int compareTo(Node o) {
			return this.bill-o.bill;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<Node>>list = new ArrayList<>();
		for(int i=0; i<N+1; i++)
			list.add(new ArrayList<>());
		
		for(int i=0; i<M; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			int bill=Integer.parseInt(st.nextToken());
			
			list.get(x).add(new Node(y, bill));
		}
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		boolean [] visit = new boolean[N+1];
		int [] res = new int [N+1];
		Arrays.fill(res, Integer.MAX_VALUE);
		res[start]=0;
		
		PriorityQueue<Node> que = new PriorityQueue<>();
		que.add(new Node(start, 0));
		
		while(!que.isEmpty()) {
			Node cur = que.poll();
			int x=cur.y;
			int bill = cur.bill;
			
			if(visit[x]) continue;
			visit[x]=true;

			for(Node node: list.get(x)) {
				if(visit[node.y]) continue;
				if(res[node.y]>res[x]+node.bill) {
					res[node.y]=res[x]+node.bill;
					que.add(new Node(node.y, res[node.y]));
				}
			}
		}
		
		System.out.println(res[end]);
	}
}