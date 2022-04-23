import java.util.Scanner;

public class Main {
	static int n, m, cnt;
	static int [][] link;
	static int INF = 10000;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		n = sc.nextInt();//정점의 수
		m = sc.nextInt();//간선의 수
		link = new int [n+1][n+1];
		for(int i=0; i<m; i++) {
			int f = sc.nextInt();
			int b = sc.nextInt();
			link[f][b]++;
			link[b][f]++;
		}

		//플루이드-와샬
		for(int i=1; i<n+1; i++)
			for(int j=1; j<n+1; j++)
				if(link[i][j]==0&&i!=j) link[i][j]=INF;
		
		for(int m=1; m<n+1; m++) //경유지
			for(int i=1; i<n+1; i++) //출발지
				for(int j=1; j<n+1; j++)//도착지
					if(link[i][m]+link[m][j]<link[i][j])
						link[i][j]=link[i][m]+link[m][j];

		
		int min=Integer.MAX_VALUE;
		int idx=-1;
		for(int i=n; i>0; i--) {
			int sum=0;
			for(int j=1; j<n+1; j++)
				if(i!=j) sum+=link[i][j];	
			min=min<sum?min:sum;
			idx=min<sum?idx:i;
		}
		System.out.println(idx);
	}
}