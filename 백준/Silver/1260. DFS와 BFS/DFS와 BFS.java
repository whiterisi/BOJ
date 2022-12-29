import java.util.*;

public class Main {
	static int N;
	static ArrayList<Integer> res;
	static boolean [][] box;
	static boolean [] visit;
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		
		box = new boolean[N+1][N+1];
		for(int i=0; i<M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			box[x][y]=true;
			box[y][x]=true;
		}
		
		res = new ArrayList<>();
		visit = new boolean[N+1];
		dfs(V);
		for(int c : res)
			System.out.print(c+" ");
		System.out.println();
		
		res =  new ArrayList<>();
		visit = new boolean[N+1];
		bfs(V);
		for(int c : res)
			System.out.print(c+" ");
		
	}
	
	public static void dfs(int V) {
		Stack<Integer> stack = new Stack<>();
		stack.add(V);
		
		while(!stack.isEmpty()) {
			int cur = stack.pop();
			if(!res.contains(cur)) res.add(cur);
			visit[cur]=true;
			for(int i=N; i>0; i--) {
				if(!box[cur][i]||visit[i]) continue;
				
				stack.add(i);
			}
		}
		
	}
	
	public static void bfs(int V) {
		Queue<Integer> que = new LinkedList<>();
		que.add(V);
		visit[V]=true;
		
		while(!que.isEmpty()) {
			int cur = que.poll();
			res.add(cur);
			for(int i=1; i<N+1; i++) {
				if(!box[cur][i]||visit[i]) continue;
				visit[i]=true;
				que.add(i);
			}
		}
		
	}
}