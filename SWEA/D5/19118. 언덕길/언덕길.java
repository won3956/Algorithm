import java.io.*;

/*
 * 가로 세로 번갈아 가면서
 * 
 * x, y가 3, 7이라면 3 * 3은 가로 세로 번갈아가면서 이동 가능
 * y를 4만큼 더 이동하면 되기 때문에 남은 값이 홀, 짝인지 판단 후 정답 계산
 */
import java.util.*;


public class Solution {
	static int N, result;
	static int[] heights;
	static int[] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			heights = new int[N];
			dp = new int[N + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				heights[i] = Integer.parseInt(st.nextToken());
			}
			dp[0] = 0;
			solve();
			System.out.println("#"+test_case+" "+dp[N]);
		}
	}
	public static void solve() {
		for (int i = 1; i < N + 1; i++) {
			int min = i;
			for (int j = 0; j < i; j++) {
				if(i < N && heights[j] >= heights[i]) continue;
				min = Math.min(min, dp[j] + (i - j - 1));
			}
			dp[i] = min;			
		}
	}
}