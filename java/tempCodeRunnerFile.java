import java.io.*;
import java.util.*;

public class Main4949 {
    static boolean N = true;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (N) {
            sb.append(solve(br.readLine())).append('\n');
        }
        System.out.println(sb);
    }

    public static String solve(String s) {
        Stack<Character> stacka = new Stack<Character>();
        Stack<Character> stackb = new Stack<Character>();
        if (s == ".") {
            N = false;
            return "";
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stacka.push('(');
            } else if (c == '[') {
                stackb.push('[');
            } else if (c == ')') {
                if (stacka.empty()) {
                    return "NO";
                } else {
                    return "YES";
                }
            } else if (c == ']') {
                if (stackb.empty()) {
                    return "NO";
                } else {
                    return "YES";
                }
            } else if (c == '.') {
                return "";
            }
        }
        return "";
    }
}
