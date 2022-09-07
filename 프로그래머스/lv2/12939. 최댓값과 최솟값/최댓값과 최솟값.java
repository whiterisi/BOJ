import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        StringTokenizer st = new StringTokenizer(s);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        while(st.hasMoreTokens()) {
	    	int x = Integer.parseInt(st.nextToken());
	        max = max>x?max:x;
	        min = min<x?min:x;
	    }
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(min)+" "+Integer.toString(max));
        answer = sb.toString();
        return answer;
    }
}