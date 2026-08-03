import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1961
{
	static int N;
	static int[][] arr;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		int T = Integer.parseInt(br.readLine());		

		for(int test_case = 1; test_case <= T; test_case++)
		{

			sb = new StringBuilder();
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int k = 0; k < N; k++) {
					sb.append(arr[N-k-1][i]);
				}
				sb.append(" ");
				for(int k = 0; k < N; k++) {
					sb.append(arr[N-i-1][N-k-1]);
				}
				sb.append(" ");
				for(int k = 0; k < N; k++) {
					sb.append(arr[k][N-i-1]);
				}
				sb.append("\n");
			}
			
			System.out.println("#"+test_case);
			System.out.print(sb);
		}
	}
}