import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int wMax=0; 
        int hMax=0;
        for(int i=0; i<sizes.length; i++){
            int w = Math.max(sizes[i][0], sizes[i][1]);
            int h = Math.min(sizes[i][0], sizes[i][1]);
            wMax = Math.max(wMax, w);
            hMax = Math.max(hMax, h);
        }
        return wMax*hMax;
    }
}
