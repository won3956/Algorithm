package com.ssafy.divide;

import java.io.*;
import java.util.*;

public class Solution {
	static int N, result;
	static char[][] map;
	static int sr, sc, hr, hc;
	static boolean[][] visited;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {

			N = Integer.parseInt(br.readLine());
			result = -1;
			map = new char[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					char c = st.nextToken().charAt(0);
					map[i][j] = c;
					if (c == 'S') {
						sr = i;
						sc = j;
					} else if (c == 'H') {
						hr = i;
						hc = j;
					}
				}
			}
			bfs(sr, sc);
			
			System.out.println("#" + test_case + " " + result);
		}
	}

	public static void bfs(int row, int col) {
		Queue<int[]> que = new ArrayDeque<>();
		que.offer(new int[] {row, col, 0});
		visited = new boolean[N][N];
		visited[row][col] = true;
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				int dist = cur[2] + 1;
				if(!inrange(nr, nc)) continue;
				if(map[nr][nc]=='X') continue;
				if(map[nr][nc]=='H') {
					result = dist;
					return;
				}
				if(visited[nr][nc]) continue;
				que.offer(new int[] {nr, nc, dist});
				visited[nr][nc] = true;
			}
		}
	}

	public static boolean inrange(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}