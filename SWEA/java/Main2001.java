import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 파리 퇴치 (NxN 배열에 M크기 마스크 중 가장 큰 값 찾기)
public class Main2001 {
	static int[][] list;
	static int N, M;
	static int maxValue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			list = new int[N][N];
			maxValue = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					list[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			solve();
			System.out.println("#" + test_case + " " + maxValue);

		}
	}

	public static void solve() {
		for (int i = 0; i < N - M + 1; i++) {
			for (int j = 0; j < N - M + 1; j++) {
				int temp = 0;
				addValue(temp, i, j);
			}
		}
	}

	public static void addValue(int temp, int i, int j) {
		for (int k = 0; k < M; k++) {
			for (int l = 0; l < M; l++) {
				temp += list[i + k][j + l];
			}
		}
		if (temp > maxValue) {
			maxValue = temp;
		}

	}

}
