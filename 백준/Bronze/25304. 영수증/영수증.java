import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int total = sc.nextInt();
		int n = sc.nextInt();
		int sum=0;
		for(int i=0; i<n; i++)
			sum+=(sc.nextInt()*sc.nextInt());
		if(total==sum) System.out.println("Yes");
		else System.out.println("No");
	}
}