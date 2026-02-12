import java.io.*;
import java.util.*;

public class Main9012 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            sb.append(solve(br.readLine())).append('\n');
        }
        System.out.print(sb);
    }
    public static String solve(String s) {
    Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (stack.empty()) {
                return "NO";
            } else {
                stack.pop();
            }
        }
        if (stack.empty()) {
            return "YES";
        }else return "NO";
    }
}

