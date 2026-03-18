import java.io.*;
import java.util.*;
// 1,2,3 의 합으로 숫자 나타내기. dp > top-down 방식
public class Main9095 {
    public static Integer dp[] = new Integer[12];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n > 2) {
                sb.append(solve(n)).append('\n');
            }
            else {
                sb.append(n).append('\n');
            }
        }
        System.out.print(sb);

    }
    public static int solve(int n) {
        if (dp[n] == null) {
            dp[n] = solve(n - 1) + solve(n - 2) + solve(n - 3);
        }
        return dp[n];
    }
}
