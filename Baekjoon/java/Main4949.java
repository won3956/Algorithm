import java.io.*;
import java.util.*;

public class Main4949 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            String s = br.readLine();
            if (s.equals(".")) break;
                sb.append(solve(s)).append('\n');
        }
        System.out.println(sb);
    }

    public static String solve(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(')
                    return "no";
            } else if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[')
                    return "no";
            }
        }
        if (stack.empty()) {
            return "yes";
        }
        else {
            return "no";
        }
    }
}
