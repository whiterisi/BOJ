import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int n;
	static char [][] box;
	static boolean [][] visited;
	static int [] dx= {0, 0, 1, -1};
	static int [] dy= {1, -1, 0, 0};
	static List<Character> same ;
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		n = sc.nextInt();
		box = new char[n][n];
		for(int i=0; i<n; i++) {
			String str = sc.next();
			for(int j=0; j<n; j++) {
				box[i][j]=str.charAt(j);
			}
		}
		
		visited= new boolean[n][n];
		int rgb=0;
		for(int i=0; i<n; i++) 
			for(int j=0; j<n; j++)
				if(!visited[i][j]) {
					rgb++;
					RGB(i, j, box[i][j]);
				}
		System.out.print(rgb+" ");
		
		same = new ArrayList<>();
		same.add('R'); same.add('G');
		visited= new boolean[n][n];
		rgb=0;
		for(int i=0; i<n; i++) 
			for(int j=0; j<n; j++)
				if(!visited[i][j]) {
					rgb++;
					RB(i, j, box[i][j]);
				}
		System.out.print(rgb);
			
	}
	public static void RGB(int i, int j, char c) {
		if(box[i][j]!=c) {
			return;
		}
		visited[i][j]=true;
		for(int d=0; d<4; d++) {
			int x=i+dx[d];
			int y=j+dy[d];
			if(isOut(x, y)||visited[x][y]) continue;
			RGB(x, y, c);
		}

	}
	public static void RB(int i, int j, char c) {
		if(box[i][j]!=c) {
			if(!same.contains(c)||!same.contains(box[i][j])) {
				return;
			}
		}
		visited[i][j]=true;
		for(int d=0; d<4; d++) {
			int x=i+dx[d];
			int y=j+dy[d];
			if(isOut(x, y)||visited[x][y]) continue;
			RB(x, y, c);
		}
	}
	public static boolean isOut(int i, int j) {
		if(i<0||j<0||i>=n||j>=n) return true;
		return false;
	}
}