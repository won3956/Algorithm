import java.io.*;
import java.util.*;

public class Solution {
	public static final long MOD = 1_000_000_007L;
	public static int[][] list;
	public static long[] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            list = new int[n][2];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                list[i][0] = Integer.parseInt(st.nextToken());
                list[i][1] = Integer.parseInt(st.nextToken());
            }
			Arrays.sort(list, (a, b) -> Integer.compare(a[0], b[0]));
			
			dp = new long[x + 1];
			dp[0] = 1;
			
			for (int[] cur : list) {
                int start = cur[0];
                int end = cur[1];
                
                long[] next = dp.clone(); // 현재 구간을 고르지 않는 경우

                // start <= r + 1인 상태에서만 빈틈없이 구간을 붙일 수 있다.
                for (int r = start - 1; r <= x; r++) {
                    int newEnd = Math.max(r, end);
                    next[newEnd] = (next[newEnd] + dp[r]) % MOD;
                }

                dp = next;
			}
			
			System.out.println("#"+test_case+" "+dp[x]);
		}
	}
}
