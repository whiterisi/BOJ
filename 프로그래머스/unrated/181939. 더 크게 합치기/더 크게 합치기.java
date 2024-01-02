class Solution {
    public int solution(int a, int b) {
        String ab = Integer.toString(a)+Integer.toString(b);
        String ba = Integer.toString(b)+Integer.toString(a);
        int answer = Integer.parseInt(ab)>=Integer.parseInt(ba)?Integer.parseInt(ab):Integer.parseInt(ba);
        return answer;
    }
}