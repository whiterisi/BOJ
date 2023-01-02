import java.util.Scanner;

public class Main {
	static int plus, zero, minus;
	static int [][] box;
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int N = sc.nextInt();
		 box = new int [N][N];
		 
		 for(int i=0; i<N; i++)
			 for(int j=0; j<N; j++)
				 box[i][j]=sc.nextInt();
		 
		 
		 plus=0; 
		 zero=0;
		 minus=0;
		 
		 check(0, 0, N);
		 
		 
		 System.out.println(minus);
		 System.out.println(zero);
		 System.out.println(plus);
		 		 
	}
	
	public static void check(int x, int y, int n) {	
		if(isOk(x, y, n)) {
			switch(box[x][y]) {
				case -1:
					minus++;
					break;
				case 0:
					zero++;
					break;
				case 1:
					plus++;
					break;
				}
			return;
		}
		//분할하기
		
		if(n/3==0) return;
		check(x, y, n/3);
		check(x+n/3, y, n/3);
		check(x, y+n/3, n/3);
		check(x+n/3, y+n/3, n/3);
		check(x+n/3*2, y, n/3);
		check(x, y+n/3*2, n/3);
		check(x+n/3, y+n/3*2, n/3);
		check(x+n/3*2, y+n/3, n/3);
		check(x+n/3*2, y+n/3*2, n/3);
		
	}
	public static boolean isOk(int x, int y, int n) {
		//같은 종이인지 체크하기
		for(int i=x; i<x+n; i++)
			for(int j=y; j<y+n; j++)
				if(box[x][y]!=box[i][j])
					return false;
		
		return true;
	}

}