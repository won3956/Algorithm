package com.ssafy.divide;

import java.io.*;
import java.util.*;

public class Solution2 {
	static int[][] map;
	static int result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append("\n");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			result = 0;
			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N*M; i++) {
				for (int j = i + 1; j < N*M; j++) {
					int sum = map[i / M][i % M] + map[j / M][j % M];
					if(sum != K) continue;
					int dis = Math.abs(i / M - j / M) + Math.abs(i % M - j % M);
					if(dis > D) continue;
					
					result++;
				}
			}
			System.out.println("#"+test_case+" "+result);
		}
	}
}