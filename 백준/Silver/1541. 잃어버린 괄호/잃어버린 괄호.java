import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String [] input = str.split("-");
		
		LinkedList<Integer> list = new LinkedList<>();
		for(int i=0; i<input.length; i++) {
			String [] arr = input[i].split("\\+");
			int sum=0;
			for(int j=0; j<arr.length; j++)
				sum+=Integer.parseInt(arr[j]);
			list.add(sum);
		}
		int result=list.get(0);
		for(int i=1; i<list.size(); i++) {
			result-=list.get(i);
		}
		System.out.println(result);

	}
}
