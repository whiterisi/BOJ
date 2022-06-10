import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class Node implements Comparable<Node>{
		int to;
		long dis;
		Node(int to, long dis){
			this.to=to;
			this.dis=dis;
		}
		@Override
		public int compareTo(Node o) {
			return this.dis>o.dis?1:-1;
		}
	}
	static int V, E;
	static List<Node>[] list;
	static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 V = sc.nextInt();
		 E = sc.nextInt();

		 //인접리스트 - 방향성없는 그래프
		 list = new ArrayList[V+1];
		 for(int i=0; i<V+1; i++)
			 list[i]= new ArrayList<>();
		 for(int i=0; i<E; i++) {
			 int from = sc.nextInt();
			 int to = sc.nextInt();
			 int dis= sc.nextInt();
			 list[from].add(new Node(to, dis));
			 list[to].add(new Node(from, dis));
		 }
		 
		 //지나왔어야하는 정점 두개 
		 int midA = sc.nextInt();
		 int midB = sc.nextInt();
		 
		 //다익스트라 
		 long sA=dij(1, midA);
		 long AB=dij(midA, midB);
		 long Be=dij(midB, V);
		 
		 long sB=dij(1, midB);
		 long BA=dij(midB, midA);
		 long Ae=dij(midA, V);
		
		 
		 //출력
		 long A = sA+AB+Be;
		 long B = sB+BA+Ae;
		 long result = Math.min(A, B);
		 
		 if(result>=INF) System.out.println(-1);
		 else System.out.println(result);
		 
		
	}
	
	static long dij(int start, int end) {
		 //우선순위큐
		 PriorityQueue<Node> pq = new PriorityQueue<>();
		 pq.add(new Node(start, 0));
		 
		 //방문확인 배열
		 boolean[] visited = new boolean [V+1];

		 //최단거리 결과값 넣을 배열
		 long[] res = new long [V+1];
		 Arrays.fill(res, INF);
		 res[start]=0;
		 
		 //다익스트라
		 while(!pq.isEmpty()) {
			 Node cur = pq.poll();
			 int curTo = cur.to;
			 
			 if(visited[curTo]) continue;
			 visited[curTo]=true;
			 
			 for(Node node : list[curTo]) {
				 if(res[node.to]<res[curTo]+node.dis) continue;
				 res[node.to]=Math.min(res[node.to], res[curTo]+node.dis);
				 pq.add(new Node(node.to, res[node.to]));
			 }
		 }
		return res[end];
		
	}
}
