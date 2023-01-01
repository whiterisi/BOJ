import java.util.*;

public class Main {
	static int L, C;
	static char [] list, res;
	static boolean [] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt();
		
		
		list = new char[C];
		for(int i=0; i<C; i++)
			list[i]=sc.next().charAt(0);
		
		Arrays.sort(list);
		res = new char[L];
		
		makeNum(0, 0);
		
	}
	//C개중에 L개 선택, 순서o, 중복x
	public static void makeNum(int idx, int cnt) {
		if(cnt==L) {
			if(isOk(res)) {
				StringBuilder sb = new StringBuilder();
				for(int i=0; i<L; i++)
					sb.append(res[i]);
				System.out.println(sb.toString());
			}
			return;
		}
		
		for(int i=idx; i<C; i++) {
			res[cnt]=list[i];
			makeNum(i+1, cnt+1);
		}
	}
	
	//조건: 최소 한개의 모음과 두 개의 자음 + 증가하는 순서로 배열
	public static boolean isOk(char[] cList) {
		List<Character> check = Arrays.asList('a', 'e', 'i','o', 'u');
		int cnt=0; 
		for(int i=0; i<L; i++) {
			if(check.contains(cList[i])) cnt++;
		}

		if(cnt<1) return false;
		if(L-cnt<2) return false;
		
		return true;
	}
}