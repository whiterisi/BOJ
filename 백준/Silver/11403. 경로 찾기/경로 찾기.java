import java.util.Scanner;

public class Main {
	static int n;
	static int [][] map, result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map=new int[n][n];
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)  //방향그래프
			map[i][j]=sc.nextInt();
		
		result = new  int [n][n];
		
		for(int m=0; m<n; m++)
			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++)
					if(map[i][m]==1&&map[m][j]==1)
						map[i][j]=1;
				
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}