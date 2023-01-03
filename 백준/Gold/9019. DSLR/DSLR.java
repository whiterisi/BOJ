import java.util.*;

public class Main {
	public static class Node{
		int x;
		int cnt;
		String command;
		Node(int x, int cnt, String command){
			this.x=x;
			this.cnt=cnt;
			this.command=command;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			
			int [] count = new int [10000];
			Arrays.fill(count, 10000);
			count[start]=0;
			
			Queue<Node> que = new LinkedList<>();
			que.add(new Node(start, 0, ""));
			
			String result ="";
			while(!que.isEmpty()) {
				Node cur = que.poll();
				if(cur.x==end) {
					result=cur.command;
					break;
				}
				if(cur.x!=start&&cur.cnt>=count[cur.x]) continue;
				count[cur.x]=cur.cnt;

				que.add(new Node(D(cur.x), cur.cnt+1, cur.command+"D"));
				que.add(new Node(S(cur.x), cur.cnt+1, cur.command+"S"));
				que.add(new Node(L(cur.x), cur.cnt+1, cur.command+"L"));
				que.add(new Node(R(cur.x), cur.cnt+1, cur.command+"R"));
				
			}
			System.out.println(result);
			
		}
	}
	public static int D(int n) {
		int x = n*2;
		if(x>9999) return x%10000; 
		return x;
	}
	public static int S(int n) {
		if(n==0) return 9999;
		else return n-1;
	}
	public static int L(int n) {
		return (n % 1000) * 10 + n / 1000;
	}
	public static int R(int n) {
		return (n% 10) * 1000 + n / 10;
	}

}