import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
	static class Input implements Comparable<Input> {
		int origin;
		int abs;
		
		Input(int origin, int abs){
			this.origin=origin;
			this.abs=abs;
		}

		@Override
		public int compareTo(Input o) {
			if(this.abs<o.abs)
				return -1;
			else if(this.abs==o.abs)
				return this.origin<o.origin?-1:1;
			else
				return 1;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Input> pq = new PriorityQueue<>();
		for(int i=0; i<n; i++) {
			int in = Integer.parseInt(br.readLine());
			if(in==0) {
				if(pq.size()==0)
					bw.write("0\n");
				else
					bw.write(Integer.toString(pq.poll().origin)+"\n");
			}else {
				pq.add(new Input(in, Math.abs(in)));
			}
		}
		bw.flush();
		bw.close();
	}
}
