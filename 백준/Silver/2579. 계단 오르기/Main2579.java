import java.io.*;
// 계단 오르기(연속 세칸 x, 한 칸 또는 두 칸 가능) - dp
public class Main2579 {
    static Integer dp[];
    static int arr[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        dp = new Integer[N + 1];

        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = arr[0];
        dp[1] = arr[1];
        if (N > 1) {
            dp[2] = arr[2] + arr[1];
        }
        
        System.out.print(find(N));
    }
    
    static int find(int N) {

        if (dp[N] == null) {
            dp[N] = Math.max(find(N - 2), find(N - 3) + arr[N - 1]) + arr[N];
        }

        return dp[N];
    }
}
