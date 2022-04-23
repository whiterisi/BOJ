import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		//결과값 출력할 때 활용
		int [] idx = new int [n];
		
		HashSet<Integer> input = new HashSet<>();
		for(int i=0; i<n; i++) {
			idx[i]=sc.nextInt();
			input.add(idx[i]);
		}
		
		//자동으로 중복제거-> 정렬해줘야됨
		Integer [] result = input.toArray(new Integer[input.size()]);
		Arrays.sort(result);
		
		HashMap<Integer, Integer> maps = new HashMap<>();
		for(int i = result.length-1 ;i>=0; i--) 
			maps.put(result[i], i);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<n; i++) 
			sb.append(maps.get(idx[i])+" ");
		System.out.println(sb.toString());

		/*for(int i=0; i<n; i++)
			sb.append(Arrays.asList(result).indexOf(idx[i])+" ");
		System.out.println(sb.toString());*/
	}
}