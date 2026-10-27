import java.io.*;
import java.util.*;

public class Solution {
	static int N, result;
	static int[] list;
	static boolean[] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			result = 0;
			int sum = 0;
			list = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				list[i] = Integer.parseInt(st.nextToken());
				sum += list[i];
			}
			dp = new boolean[sum+1];
			dp[0] = true;
			int cursum = 0;
			for (int i = 0; i < N; i++) {
				int point = list[i];
				cursum += point;
				
				for(int j = cursum; j >= point; j--) {
					if(dp[j - point]) {
						dp[j] = true;
					}
				}
			}
			for (int i = 0; i <= sum; i++) {
				if(dp[i]) {
					result++;
				}
			}
			System.out.println("#"+test_case+" "+result);
		}
	}
}