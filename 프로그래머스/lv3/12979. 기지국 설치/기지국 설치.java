class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int idx =0;
        int i=1;
        while(i<=n){
            if(idx<stations.length&&i>=stations[idx]-w){
                i=stations[idx]+w+1;
                idx++;
            }else{
                answer++;
                i+=2*w+1;
            }
        }
        return answer;
    }
}