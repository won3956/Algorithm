import java.io.*;
import java.util.*;

public class Solution {
	static int[][] snail;
	static boolean[][] check;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			snail = new int[N][N];
			check = new boolean[N][N];
			int row = 0, col = 0;
			int idx = 0;
			for(int i = 1; i<=N*N;i++) {
				snail[row][col] = i;
				check[row][col] = true;
				
				int nr = row + dr[idx];
				int nc = col + dc[idx];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || check[nr][nc]) {
					idx = (idx + 1) % 4;
                    nr = row + dr[idx];
                    nc = col + dc[idx];
				}
				
				row = nr;
				col = nc;
			}
			System.out.println("#"+test_case);
			for(int i = 0; i<N;i++) {
				for(int k = 0; k<N; k++) {
					System.out.print(snail[i][k]+" ");
				}
				System.out.println();
			}
		}
	}
}
