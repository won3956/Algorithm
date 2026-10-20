import java.io.*;
import java.util.*;

/*
 * [제약사항]
 * 성능 P는 10이상 500이하의 짝수이다
 * 초기 위치(0초)부터 충전을 할 수 있다.
 * 같은 위치에 2개 이상의 BC가 설치된 경우는 없다. 
 * 그러나 사용자A, B가 동시에 같은 위치로 이동할 수는 있다
 */

public class Solution {
	static int M, A, result;
	static int[] pathA, pathB;
	static List<BC> charges;
	static int rowA, colA, rowB, colB;
	static int[] dr = {0, -1, 0, 1, 0};
	static int[] dc = {0, 0, 1, 0, -1};

	static class BC {
		int row;
		int col;
		int C;
		int P;

		public BC(int row, int col, int C, int P) {
			this.row = row;
			this.col = col;
			this.C = C;
			this.P = P;
		}
		
		public boolean canCharge(int userRow, int userCol) {
			return C >= (Math.abs(row - userRow) + Math.abs(col - userCol));
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			pathA = new int[M+1];
			pathB = new int[M+1];
			charges = new ArrayList<>();
			rowA = 1;
			colA = 1;
			rowB = 10;
			colB = 10;

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= M; i++) {
				pathA[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= M; i++) {
				pathB[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				int row = Integer.parseInt(st.nextToken());
				int col = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				int P = Integer.parseInt(st.nextToken());
				charges.add(new BC(row, col, C, P));
			}

			System.out.println("#" + test_case + " " + result);
		}
	}
	public static void simul() {
		
		for (int i = 0; i <= M; i++) {
			
			
			rowA += dr[pathA[i]];
			colA += dc[pathA[i]];
			rowB += dr[pathB[i]];
			colB += dc[pathB[i]];
			
			for (BC bc : charges) {
				if(bc.canCharge(rowA, colA)) {
					
				}
				if(bc.canCharge(rowB, colB)) {
					
				}
			}
		}
	}
	
	public static boolean inRange(int row, int col) {
		return row >= 0 && row <10 && col >= 0 && col < 10;
	}
}