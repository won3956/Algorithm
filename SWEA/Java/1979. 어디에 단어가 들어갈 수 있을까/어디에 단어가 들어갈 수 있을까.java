import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, K;
	static int[][] arr;
	static int result, count;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			result = 0;
			for(int i = 0; i< N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i< N; i++) {	//가로 탐색
				count = 0;
				for(int j = 0; j < N; j++) {
					if(arr[i][j]==1) {
						count++;
					}else {
						if(count == K) {
							result++;
						}
						count = 0;
					}
				}
				if(count == K) {
					result++;
				}
			}
			for(int i = 0; i< N; i++) {
				count = 0;
				for(int j = 0; j < N; j++) {
					if(arr[j][i]==1) {
						count++;
					}else {
						if(count == K) {
							result++;
						}
						count = 0;
					}
				}
				if(count == K) {
					result++;
				}
			}
			System.out.println("#"+test_case+" "+ result);
		}
	}
}