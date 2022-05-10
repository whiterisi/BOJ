import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0; i<n; i++) {
			int in =Integer.parseInt(br.readLine());
			if(in ==0) {
				if(pq.isEmpty()) bw.write(0+"\n");
				else bw.write(pq.poll()+"\n");
			}else {
				pq.add(in);
			}
		}
		bw.flush();
		bw.close();
	}
}