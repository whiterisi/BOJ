import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static List<String> broken;
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		int target = sc.nextInt();
		String str = Integer.toString(target);
		char [] div = str.toCharArray();
		int malfunc = sc.nextInt();
		
		broken = new ArrayList<>();
		for(int i=0; i<malfunc; i++)
			broken.add(sc.next());

		//최솟값 1. target-100(수빈이가 지금 보는 채널)
		int pre = target>100?target-100:100-target;
		
		//최솟값 2.
		int min = Integer.MAX_VALUE;
		
		//완탐
		for(int i=0; i<=999999; i++) {
			String s = Integer.toString(i);
			if(isContain(s)) continue;
			int gap = i>target?i-target:target-i;
			gap+=s.length();
			min=min<gap?min:gap;
		}
		if(target==100) System.out.println(0);
		else if(min>pre) System.out.println(pre);
		else System.out.println(min);
	}
	public static boolean isContain(String s) {
		for(String str: broken)
			if(s.contains(str))
				return true;
		return false;
	}
}