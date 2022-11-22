import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        String bomb = br.readLine();
        int leng = input.length();
        int bleng = bomb.length();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < leng; i++) {
            char ch = input.charAt(i);
            stack.push(ch);

            if (stack.size() >= bleng) {
                boolean flag = true;
                for (int j = 0; j < bleng; j++) {
                    if (stack.get(stack.size() - bleng + j) != bomb.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    for (int j = 0; j < bleng; j++) {
                        stack.pop();
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character character : stack) {
            sb.append(character);
        }

        String answer = sb.toString();
        if(answer.length()==0) answer ="FRULA";
        
        bw.write(answer);
        bw.flush();
        bw.close();
    }
}
