import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			int n = Integer.parseInt(br.readLine());
			HashMap<String, Integer> closet = new HashMap<>();
			for(int i=0; i<n; i++) {
				String str = br.readLine();
				StringTokenizer st = new StringTokenizer(str);
				String name = st.nextToken();
				String type = st.nextToken();
				if(closet.containsKey(type)) {
					closet.put(type, closet.get(type)+1);
				}else {
					closet.put(type, 1);
				}
			}
			int result=1;
			for (int i : closet.values())
				result *= i + 1;
			
			System.out.println(result-1);
		}
	}
}