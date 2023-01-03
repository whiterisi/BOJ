import java.util.*;

public class Main {
	static char [][] box;
	static StringBuilder sb ;
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int N = sc.nextInt();
		 box = new char [N][N];

		 for(int i=0; i<N; i++) {
			 String str = sc.next();
			 for(int j=0; j<N; j++)
				 box[i][j]=str.charAt(j);
		 }
		 
		 sb = new StringBuilder();
		 check(0, 0, N);
		 System.out.println(sb.toString());
	}

	public static void check(int x, int y, int n) {	
		if(isOk(x, y, n)) {
			sb.append(box[x][y]);
			return;
		}
		//분할하기
		if(n/2==0) {
			return;
		}
		sb.append("(");
		check(x, y, n/2);
		check(x, y+n/2, n/2);
		check(x+n/2, y, n/2);
		check(x+n/2, y+n/2, n/2);
		sb.append(")");
	}
	public static boolean isOk(int x, int y, int n) {

		char stand = box[x][y];
		for(int i=x; i<x+n; i++)
			for(int j=y; j<y+n; j++)
				if(stand!=box[i][j])
					return false;

		return true;
	}

}