import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, M;
	static int result;
	static int[] weight;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			weight = new int[N];
			result = -1;
			for (int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					int sum = weight[i] + weight[j];
					if (sum <= M) {
						result = Math.max(sum, result);
					}
				}
			}
			System.out.println("#" + test_case + " " + result);
		}
	}
}
