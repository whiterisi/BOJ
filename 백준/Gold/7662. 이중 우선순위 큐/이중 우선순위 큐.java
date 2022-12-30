import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int tc=0; tc<TC; tc++) {
			int k = Integer.parseInt(br.readLine());
			
			TreeMap<Integer, Integer> map = new TreeMap<>();
			
			for(int i=0; i<k; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				String str = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				switch(str) {
					case "I":
						map.put(num, map.getOrDefault(num, 0)+1);
						break;
					case "D":
						if(map.isEmpty()) continue;
						int key=num==1?map.lastKey():map.firstKey();
						if (map.put(key, map.get(key) - 1) == 1)
							map.remove(key);
						break;
				}
			}
			System.out.println(map.isEmpty()?"EMPTY":map.lastKey()+" "+map.firstKey());
			 
		}
	}
}