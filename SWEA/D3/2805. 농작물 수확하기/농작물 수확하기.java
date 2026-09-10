import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	static int cr, cc, ableDis;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			result = 0;
			cr = (N - 1) / 2;
			cc = (N - 1) / 2;
			ableDis = (N - 1) / 2;
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					int temp = str.charAt(j) - '0';
					if (isAble(i, j)) {
						result += temp;
					}
				}
			}
			System.out.println("#" + test_case + " " + result);
		}
	}

	public static boolean isAble(int r, int c) {
		return (Math.abs(r - cr) + Math.abs(c - cc)) <= ableDis;
	}
}
