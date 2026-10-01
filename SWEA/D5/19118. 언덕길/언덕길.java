/*
28,032 kb
메모리
130 ms
실행시간
931
코드길이
*/
import java.io.*;
import java.util.*;


public class Solution {
	static int N, result;
	static int[] heights;
	static int[] dp; // i번째 집을 남겼을 때 무너뜨려야하는 최소 개수
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
			solve();
			System.out.println("#"+test_case+" "+dp[N]);
		}
	}
	public static void solve() {
		for (int i = 1; i < N + 1; i++) { // dp[i] 채우기
			int min = i; //최대 경우의 수는 0 ~ i-1 까지 모두 무너뜨려야하는 상황
			for (int j = 0; j < i; j++) { // i 이전 건물 중 가장 마지막 생존이 j일 때
				if(i < N && heights[j] >= heights[i]) continue;// j 높이가 i 높이보다 높은 상황 제외
				min = Math.min(min, dp[j] + (i - j - 1)); // dp[j] + i와 j사이의 건물 개수
			} // dp[N+1]은 정답을 담음. 정답을 담을 땐 높이비교 필요없어서 i<N 조건 포함
			dp[i] = min;			
		}
	}
}