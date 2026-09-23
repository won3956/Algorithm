import java.io.*;
import java.util.*;

/**
 * 모든 N 개의 중복 순열 (X의 N승 => 최대 100만)
 * 재귀(DFS)
 * 하나의 순열이 완성되면 
 * if 첫번째 완성된 순열 > 저장
 * else > 기존 순열과 햄스터 합과 비교 후 저장(같다면 먼저 저장된 순열이 사전적으로 우선)
 * 
 * [제약사항]
 * 우리에는 0마리 이상 X마리 이하 햄스터
 * 1 ≤ N ≤ 6, 
 * 1 ≤ X ≤ 10,
 * 1 ≤ M ≤ 10
 */

public class Solution {
	static int N, X, M;
	static int[] result;
	static int[][] record; // 입력
	static int[] pr;
	static boolean noResult; // 먼저 완성된 순열이 있는지
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			pr = new int[N+1];
			record = new int[M][3];
			result = new int[N+1];
			noResult = true;
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				record[i][0] = Integer.parseInt(st.nextToken()); // l
				record[i][1] = Integer.parseInt(st.nextToken()); // r
				record[i][2] = Integer.parseInt(st.nextToken()); // s
			}
			
			makePr(1);
			sb.append("#").append(test_case);
			if(noResult) {
				sb.append(" ").append(-1).append("\n");
			}else {
				for(int i = 1; i <= N; i++) {
					sb.append(" ").append(result[i]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
	public static void makePr(int cnt) { // 모든 중복 순열 만들기
		if(cnt > N) {
			if(checkRecord(pr)) {
				if(noResult) {
					for (int i = 1; i <= N; i++) {
						result[i] = pr[i];
					}
					noResult = false;
				}else {
					int cursum = getSum(pr);
					int resum = getSum(result);
					if(cursum > resum) {
						changeResult(pr);
					}
					return;
				}
			}
			return;
		}
		
		for (int i = 0; i <= X; i++) {
			pr[cnt] = i;
			makePr(cnt + 1);
		}
	}
	public static boolean checkRecord(int[] pr) { // 만든 순열 기록과 일치하는지 확인
		for (int[] cur : record) {
			int sum = 0;
			for (int i = cur[0]; i <= cur[1] ; i++) {
				sum += pr[i];
			}
			if(sum != cur[2]) return false;
		}
		return true;
	}
	public static int getSum(int[] pr) {
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			sum += pr[i];
		}
		return sum;
	}
	public static void changeResult(int[] pr) {
		for (int i = 1; i <= N; i++) {
			result[i] = pr[i];
		}
	}
}
