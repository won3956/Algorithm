import java.io.*;
import java.util.*;
public class Solution {
	static int N, L, result;
	static int[] scoreList;
	static int[] kcalList;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			result = 0;
			scoreList = new int[N];
			kcalList = new int[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				scoreList[i] = Integer.parseInt(st.nextToken());
				kcalList[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0, 0, 0);
			System.out.println("#" + test_case + " " + result);
		}
		
	}
	public static void dfs(int idx, int scoreSum, int kcalSum) {
		
		if(kcalSum > L)	return;
		
		result = Math.max(result, scoreSum);
		
		if(idx == N) return;
		
		dfs(
			idx + 1, 
			scoreSum+scoreList[idx], 
			kcalSum+kcalList[idx]
		);
		dfs(
			idx + 1,
			scoreSum,
			kcalSum
		);
	}
}
