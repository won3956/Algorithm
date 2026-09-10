import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static int N, M;
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static ArrayList<int[]> cores;
	static int maxConnect, result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			cores = new ArrayList<>();
			maxConnect = 0;
			result = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						if(!(i==0||j==0||i==N-1||j==N-1)) {
							cores.add(new int[] { i, j });
						}
					}
				}
			}

			dfs(0, 0, 0);
			System.out.println("#"+test_case+" "+result);
		}
	}

	static void dfs(int idx, int connectCnt, int wireLen) {
		if (idx == cores.size()) { // 종료 조건
			if (connectCnt > maxConnect) {
				maxConnect = connectCnt;
				result = wireLen;
			} else if (connectCnt == maxConnect) {
				result = Math.min(result, wireLen);
			}
			return;
		}

		int row = cores.get(idx)[0];
		int col = cores.get(idx)[1];

		for (int i = 0; i < 5; i++) {
			if(i == 4) {
				dfs(idx + 1, connectCnt, wireLen);
				break;
			}
			if (canConnect(row, col, i)) {
				int length = connect(row, col, i);
				dfs(idx + 1, connectCnt + 1, wireLen + length);
				disconnect(row, col, i);
			}
		}
	}

	public static boolean inrange(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

	public static boolean canConnect(int row, int col, int dir) {
		int nr = row + dr[dir];
		int nc = col + dc[dir];
		while (inrange(nr, nc)) {
			if (map[nr][nc] != 0)
				return false;
			nr += dr[dir];
			nc += dc[dir];
		}

		return true;
	}

	public static int connect(int row, int col, int dir) {
		int length = 0;
		int nr = row + dr[dir];
		int nc = col + dc[dir];

		while (inrange(nr, nc)) {
			map[nr][nc] = 2;
			nr += dr[dir];
			nc += dc[dir];
			length++;
		}

		return length;
	}

	public static void disconnect(int row, int col, int dir) {
		int nr = row + dr[dir];
		int nc = col + dc[dir];

		while (inrange(nr, nc)) {
			map[nr][nc] = 0;
			nr += dr[dir];
			nc += dc[dir];
		}
		return;
	}
}
