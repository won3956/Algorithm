package com.ssafy.divide;

import java.io.*;
import java.util.*;

public class Solution {
	static int N, M;
	static int[] parents;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.print("#" + test_case + " ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			parents = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				parents[i] = i;
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int cmd = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if (cmd == 0) {
					union(a, b);
				} else {
					System.out.print(check(a, b) ? 0 : 1);
				}
			}
			System.out.println();
		}
	}

	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a == b)
			return;
		
		parents[a] = b;
	}
	public static boolean check(int a, int b) {
		a = find(a);
		b = find(b);

		if (a == b)
			return false;
		return true;
	}
	public static int find(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = find(parents[a]);
	}
}