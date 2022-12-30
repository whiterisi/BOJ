import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		HashMap<Integer, Integer>  hash = new HashMap<>();
		for(int i=0; i<n+m; i++)
			hash.put(sc.nextInt(), sc.nextInt());

		int [] map = new int [101];
		Arrays.fill(map, Integer.MAX_VALUE);
		map[1]=0;
		
		Queue<Integer> que = new LinkedList<>();
		que.add(1);
		
		while(!que.isEmpty()) {
			int cur = que.poll();
			
			if(cur==100) break;
			
			for(int i=1; i<7; i++) {
				int x = cur+i;
				if(x>100) continue;
				if(hash.containsKey(x))
					x=hash.get(x);
				if(map[cur]+1<map[x]) {
					map[x]=map[cur]+1;
					que.add(x);
				}
			}
		}
		System.out.println(map[100]);
	}
}
