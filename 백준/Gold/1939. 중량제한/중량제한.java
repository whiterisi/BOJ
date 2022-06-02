import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class Node implements Comparable<Node>{
		int y;
		int limit;
		
		Node(int y, int limit){
			this.y = y;
			this.limit = limit;
		}

		@Override
		public int compareTo(Node o) {
			return this.limit<o.limit?1:-1;
		}

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); 
		int M = sc.nextInt(); 
		
		ArrayList<Node>[] list = new ArrayList[N+1];
		for(int i=0; i<N+1; i++)
			list[i]=new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			int l = sc.nextInt();
			list[s].add(new Node(e, l));
			list[e].add(new Node(s, l));
		}
		
		int start=sc.nextInt();
		int end=sc.nextInt();
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, Integer.MAX_VALUE));
		
		int [] min = new int [N+1];
		min[start]=Integer.MAX_VALUE; 
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int x =cur.y;
			int weight =cur.limit;
			
			if(min[x]>weight) continue;
			
			for(int i=0; i<list[x].size(); i++) {
				int y=list[x].get(i).y;
				int newWeight = Math.min(weight, list[x].get(i).limit);
				if(newWeight>min[y]) {
					min[y]=newWeight;
					pq.add(new Node(y, newWeight));
				}
			}
		}
		
		System.out.println(min[end]);
	}

}
