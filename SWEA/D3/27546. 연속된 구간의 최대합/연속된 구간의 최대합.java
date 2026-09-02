import java.io.*;
import java.util.*;
public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			long window = 0;
			for(int i = 0; i < K; i++) {
				window += arr[i];
			}
			long maxSum = window;
			for(int i = 0; i < N-K; i++) {
				window = window - arr[i] + arr[i+K];
				maxSum = Math.max(maxSum, window);
			}
			System.out.println("#"+tc+" "+maxSum);
		}
	}
}