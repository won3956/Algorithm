package com.ssafy.divide;

import java.io.*;
import java.util.*;

public class Solution2 {
	static int N, M, R, result;
	static int[][] map;
	static int[] selected;
	static List<int[]> houses;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append("\n");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			result = Integer.MAX_VALUE;
			map = new int[N][M];
			houses = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					int type = Integer.parseInt(st.nextToken());
					map[i][j] = type;
					if(type == 1) {
						houses.add(new int[] {i, j});
					}
				}
			}
			selected = new int[R];
			comb(0, 0);
			System.out.println("#"+test_case+" "+result);
		}
	}
	public static void comb(int cnt, int start) {
		if(cnt == R) {
			result = Math.min(result, sumDis());
			return;
		}
		
		for (int i = start; i < N * M; i++) {
			int row = i/M;
			int col = i%M;
			if(map[row][col] != 0) continue;
			selected[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}
	public static int sumDis() {
		int sum = 0;
		for (int[] house : houses) {
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < R; i++) {
				int cur = selected[i];
				int row = cur/M;
				int col = cur%M;
				min = Math.min(Math.abs(row - house[0]) + Math.abs(col - house[1]), min);
			}
			sum += min;
		}
		return sum;
	}
}