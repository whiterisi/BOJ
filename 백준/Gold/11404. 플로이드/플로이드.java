import java.util.Scanner;

public class Main {
	static int INF = 10000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int [][] map = new int [n+1][n+1];
		for(int i=1; i<n+1; i++)
			for(int j=1; j<n+1; j++) {
				if(i==j) continue;
				map[i][j]=INF;
			}
		
		for(int i=0; i<m; i++) {
			int s= sc.nextInt();
			int e = sc.nextInt();
			int c = sc.nextInt();
			map[s][e]=Math.min(map[s][e], c);
		}
		
		for(int mid =1; mid<n+1; mid++)
			for(int start=1; start<n+1; start++) 
				for(int end=1; end<n+1; end++) 
					if(map[start][end]>map[start][mid]+map[mid][end])
						map[start][end]=map[start][mid]+map[mid][end];

		StringBuilder sb = new StringBuilder();
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(map[i][j]==INF) map[i][j]=0;
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
