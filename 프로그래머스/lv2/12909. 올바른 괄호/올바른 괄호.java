import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        char [] list = s.toCharArray();
        for(char c: list){
            if(stack.isEmpty()||c=='('){
                stack.add(c);
            }else{
                if(stack.peek()=='('){
                    stack.pop();
                }else{
                    answer=false;
                    break;
                }
            }
        }
        if(!stack.isEmpty()) answer=false;

        return answer;
    }
}