import java.io.*;

/*
 * 가로 세로 번갈아 가면서
 * 첫 이동은 가로 세로 상관 x => 시작 방향 4가지 모두 돌리기?
 */
import java.util.*;

public class Solution {
	static int c1, r1, c2, r2;
	static int result, remain;
	static int[] dr = {1, 0, -1, 0}; // y
	static int[] dc = {0, -1, 0, 1}; // x
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			c1 = Integer.parseInt(st.nextToken());
			r1 = Integer.parseInt(st.nextToken());
			c2 = Integer.parseInt(st.nextToken());
			r2 = Integer.parseInt(st.nextToken());
			result = 0;
			int diffRow = Math.abs(r2 - r1);
			int diffCol = Math.abs(c2 - c1);
			if(diffRow == diffCol) {
				System.out.println("#"+test_case+" "+diffRow*2);
				continue;
			}else if(diffRow > diffCol) {
				result += diffCol * 2;
				remain = diffRow - diffCol;
			}else if(diffRow < diffCol) {
				result += diffRow * 2;
				remain = diffCol - diffRow;
			}
			if(remain % 2 == 0) {
				result += remain * 2;
			}else {
				result += remain * 2 - 1;
			}
//			bfs(r1, c1);
			
			System.out.println("#"+test_case+" "+result);
		}
	}
//	public static void bfs(int sr, int sc) {
//		Queue<int[]> que = new ArrayDeque<>();
//		que.offer(new int[] {sr, sc});
//	}
}