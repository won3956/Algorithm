import java.io.*;
import java.util.*;

public class Solution {
	static int N, M;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			dp = new int[N][M];
			for (int i = 0; i < N; i++) {
			    dp[i][0] = 1;
			}

			for (int j = 0; j < M; j++) {
			    dp[0][j] = 1;
			}
			for (int i = 1; i < N; i++) {
				 for (int j = 1; j < M; j++) {
					dp[i][j] = dp[i-1][j] + dp[i][j-1];
				}
			}
			System.out.println("#"+test_case+" "+dp[N - 1][M - 1]);
		}
	}
}