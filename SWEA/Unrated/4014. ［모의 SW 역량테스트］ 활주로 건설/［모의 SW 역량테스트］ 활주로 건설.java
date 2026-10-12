import java.io.*;
import java.util.*;

/* [확인]
 * 0 ~ N-1 안인지
 * 이미 활주로가 설치되어있었는지 = add[]
 * 
 * 
 * 
 * [제약사항]
 * 지형의 높이는 1 이상 6 이하의 정수
 * N 의 크기는 6 이상 20 이하의 정수
 * 경사로의 높이는 항상 1 이고, 길이 X 는 2 이상 4 이하의 정수
 */

public class Solution {
	static int N, X, result;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			result = 0;
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N; i++) {
				if(check(map[i])) {
					result++;
				}
			}
			for (int i = 0; i < N; i++) {
				int[] temp = new int[N];
				for (int j = 0; j < N; j++) {
					temp[j] = map[j][i];					
				}
				if(check(temp)) {
					result++;
				}
			}
			System.out.println("#"+test_case+" "+result);
		}
	}
	public static boolean check(int[] arr) {
		boolean add[] = new boolean[N];
		for (int i = 0; i < N - 1; i++) {
			int diff = arr[i + 1] - arr[i];
			if(diff == 0) {
				continue;
			}else if(diff == 1) {
				for (int j = i; j > i - X ; j--) {
					if(j < 0) return false;
					if(arr[j] != arr[i]) return false;
					if(add[j]) return false;
					add[j] = true;
				}
			}else if(diff == -1) {
				for (int j = i + 1; j <= i + X ; j++) {
					if(j > N - 1) return false;
					if(arr[j] != arr[i + 1]) return false;
					if(add[j]) return false;
					add[j] = true;
				}
				i += X - 1;
			}else {
				return false;
			}
		}
		return true;
	}
}