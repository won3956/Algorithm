package com.ssafy.divide;

import java.io.*;
import java.util.*;

public class Solution2 {
	static int N, M, R, result;
	static int[][] map;
	static int[] pots;
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			pots = new int[R];
			result = -1;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				} 
			}
			comb();
			System.out.println("#"+test_case+" "+result);
		}
	}
	public static void comb(int cnt, int start) {
		if(cnt == R) {
			int sum = 0;
			for (int i : pots) {
				int row = i / M;
				int col = i % M;
				sum += map[row][col];
			}
			result = Math.max(result, sum);
			return;
		}
		for (int i = start + 1; i < N*M; i++) {
			int row = i / M;
			int col = i % M;
			if(!check(row, col)) continue;
			pots[cnt] = i;
			comb(cnt + 1, start + i);
		}
	}
	public static boolean check(int row, int col) {
		for (int i = 0; i < 4; i++) {
			int idx = (row + dr[i]) * M + (col + dc[i]);
			for (int j : pots) {
				if(idx == j) return false;
			}
		}
		return true;
	}
}