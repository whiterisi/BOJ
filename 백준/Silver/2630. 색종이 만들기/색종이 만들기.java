import java.util.*;

public class Main {
	static int n, white, blue;
	static int [][] box;
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 n = sc.nextInt();
		 box = new int[n][n];
		 for(int i=0; i<n; i++)
			 for(int j=0; j<n; j++)
				 box[i][j] = sc.nextInt();
		 
		 white=0;
		 blue=0;
		 countPaper(0, 0, n);
		 
		 System.out.println(white);
		 System.out.println(blue);
	}
	public static void countPaper(int i, int j, int size) {
		if(checkColor(i, j, size)) {
			if(box[i][j] == 0) {
				white++;
			}
			else {
				blue++;
			}
			return;
		}
		
		countPaper(i, j, size/2);
		countPaper(i, j+size/2, size/2);
		countPaper(i+size/2, j, size/2);
		countPaper(i+size/2, j+size/2, size/2);
	}
	
	public static boolean checkColor(int i, int j, int size) {
		int color = box[i][j];
		
		for(int x = i; x < i + size; x++) {
			for(int y = j; y < j + size; y++) {
				if(box[x][y] != color) {
					return false;
				}
			}
		}
		return true;
	}
}