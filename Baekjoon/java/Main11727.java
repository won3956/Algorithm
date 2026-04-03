import java.io.*;
// 2 x n 타일링 2번째 문제
public class Main11727 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        int[] dp = new int[Math.max(n + 1, 3)];
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + (2 * dp[i - 2])) % 10007;
        }
        
        System.out.print(dp[n]);
    } 
}
