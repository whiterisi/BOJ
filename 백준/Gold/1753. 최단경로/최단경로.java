import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
	static class Node implements Comparable<Node>{
		int to;
		int val;
		Node(int to, int val){
			this.to=to;
			this.val=val;
		}
		@Override
		public int compareTo(Node o) {
			return this.val>o.val?1:-1;
		}
	}
	static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int V = sc.nextInt();
		 int E = sc.nextInt();

		 //우선순위큐
		 PriorityQueue<Node> pq = new PriorityQueue<>();
		 int start = sc.nextInt();
		 pq.add(new Node(start, 0));
		 
		 
		 //방문확인 배열
		 boolean[] visited = new boolean [V+1];

		 //결과값 넣을 배열
		 int[] res = new int [V+1];
		 Arrays.fill(res, INF);
		 res[start]=0;
		 
		 //인접리스트
		 List<Node>[] list = new ArrayList[V+1];
		 for(int i=0; i<V+1; i++)
			 list[i]= new ArrayList<>();
		 for(int i=0; i<E; i++)
			 list[sc.nextInt()].add(new Node(sc.nextInt(), sc.nextInt()));
		 
		 //다익스트라
		 while(!pq.isEmpty()) {
			 Node cur = pq.poll();
			 int curTo = cur.to;
			 int curVal = cur.val;
			 
			 if(visited[curTo]) continue;
			 visited[curTo]=true;
			 
			 for(Node node : list[curTo]) {
				 if(res[node.to]<res[curTo]+node.val) continue;
				 res[node.to]=Math.min(res[node.to], res[curTo]+node.val);
				 pq.add(new Node(node.to, res[node.to]));
			 }

		 }
		 //결과값출력
		 for(int i=1; i<V+1; i++) {
			 if(res[i]!=INF) System.out.println(res[i]);
			 else System.out.println("INF");
		 }
	}
}