import java.io.*;
// (라그랑주) 모든 자연수는 네 개 이하의 제곱수들의 합으로 표현 가능. ㅈㄴ 어렵노
public class Main17626 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        Integer[] dp = new Integer[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            int minV = 4;
            for (int j = 1; j * j <= i; j++) {
                minV = Math.min(minV, dp[i - j * j]);
            }
            dp[i] = minV + 1;
        }

        System.out.print(dp[n]);
    }
}
