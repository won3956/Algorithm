import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int[] arr, dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			dp = new int[N+1];
			Arrays.fill(dp, 1);
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j < i; j++) {
					if(arr[j] < arr[i]) {
						dp[i] = Math.max(dp[j] + 1, dp[i]);
					}
				}
			}
			Arrays.sort(dp);
			System.out.println("#"+test_case+" "+dp[N]);
		}
	}
}