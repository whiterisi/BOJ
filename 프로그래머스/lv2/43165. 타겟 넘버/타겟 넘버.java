class Solution {
    static int T, answer;
    static boolean [] div;
    static int [] res;
    public int solution(int[] numbers, int target) {
        T=target;
        answer = 0;
        res = numbers;
        div = new boolean[numbers.length];
        cal(0);
        return answer;
    }
    public static void cal(int i){
        if(i==div.length){
            int sum=0; 
            for(int k=0; k<div.length; k++){
                if(div[k]) sum+=res[k];
                else sum-=res[k];
            }
            if(sum==T) answer++;
            return;
        }
        div[i]=true;
        cal(i+1);
        div[i]=false;
        cal(i+1);
    }
}