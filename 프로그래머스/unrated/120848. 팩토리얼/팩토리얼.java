class Solution {
    public int solution(int n) {
        int answer = 1;
        int res =1;
        for(int i = 1; i<=n; i++){
            res*=i;
            if(res>n){
                break;
            }else{
                answer = i;
            }
        }
        return answer;
    }
}