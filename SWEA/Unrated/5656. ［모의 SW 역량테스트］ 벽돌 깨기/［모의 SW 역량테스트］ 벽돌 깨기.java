import java.io.*;
import java.util.*;

/* [해결]
 * 완전 탐색 => W^N max: 12^4 가능
 */

public class Solution {
	static int N, W, H, sum, result;
	static int[][] map;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int[] selected;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			sum = 0; 
			result = Integer.MAX_VALUE; //남은 벽돌의 개수 => 최소가 되는 경우가 정답
			selected = new int[N];
			map = new int[H][W];
			
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]>0) sum++;
				}
			}
			dfs(0);
			System.out.println("#"+test_case+" "+result);
		}
	}
	public static void dfs(int index) {
		if(index == N) {
			int[][] copyMap = new int[H][W];

			for (int i = 0; i < H; i++) {
			    copyMap[i] = map[i].clone();
			}
			simul(copyMap);
			return;
		}
		for (int i = 0; i < W; i++) {
			selected[index] = i;
			dfs(index + 1);
		}
	}
	public static void simul(int[][] copyMap) { // 완성된 배열을 받아서 벽돌 깨기 시작
		int remain = sum;
		for (int i = 0; i < N; i++) {
			int target = selected[i];
			for (int j = 0; j < H; j++) {
				if(copyMap[j][target]>0) { // 0이 아닌 벽돌 만나면 터짐
					remain -= bomb(j, target, copyMap); // 해당 칸으로 인해 모두 터지고 나면 총합에서 뺌
					pushDown(copyMap);// 떨어지는 메서드
					break;
				}
			}
		}
		result = Math.min(result, remain);
	}
	public static int bomb(int row, int col, int[][] copyMap) {
		int minus = 1;
		int value = copyMap[row][col];
		copyMap[row][col] = 0;
		
		if(value==1) return 1;
		
		for (int i = 0; i < 4; i++) {
			for (int x = 1; x < value; x++) {
				int nr = row + dr[i] * x;
				int nc = col + dc[i] * x;
				if(!inRange(nr, nc)) break;
				if(copyMap[nr][nc]==0) continue;
				minus += bomb(nr, nc, copyMap);
			}
		}
		
		return minus;
	}
	public static void pushDown(int[][] copyMap) {
		for (int i = 0; i < W; i++) {
			int cnt = H - 1;
			for (int j = H-1; j >= 0; j--) {
				if(copyMap[j][i] > 0) {
					int temp = copyMap[j][i];
					copyMap[j][i] = 0;
					copyMap[cnt--][i] = temp;
				}
			}
		}
	}
	public static boolean inRange(int row, int col) {
		return row >= 0 && row < H && col >= 0 && col < W;
	}
}