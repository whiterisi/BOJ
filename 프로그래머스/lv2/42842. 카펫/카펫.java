class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int [2];
        
        brown = (brown-4)/2;
        for(int i=1; i<brown; i++){
            int j = brown-i;
            if(i*j==yellow){
                answer[0]=j+2;
                answer[1]=i+2;
                break;
            }
        }

        return answer;
    }
}