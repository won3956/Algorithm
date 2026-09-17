package com.ssafy.divide;

import java.io.*;
import java.util.*;

public class Solution {
	static int N, M;
	static int[] parents;
	static boolean result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			result = false;
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			parents = new int[N+1];
			for (int i = 1; i <= N; i++) {
				parents[i] = i;
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(!union(a, b)) {
					result = true;
					break;
				}
			}
			
			System.out.println("#"+test_case+" "+(result?"YES":"NO"));
		}
	}
	public static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a == b) return false;
		
		parents[a] = b;
		return true;
	}
	public static int find(int a) {
		if(a == parents[a]) return a;
		
		return parents[a] = find(parents[a]);
	}
}