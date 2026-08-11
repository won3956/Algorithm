import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[][] arr;
	static boolean[][] check;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int result, value, count;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int test_case=1; test_case<=T; test_case++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			result = 0;
			value = 0;
			
			for(int i =0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int k =0;k<N;k++) {
					arr[i][k]=Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i =0;i<N;i++) {
				for(int k =0;k<N;k++) {
					
					check = new boolean[N][N];
					count = 0;
					step(i, k);
					if(count>result) {
						result = count;
						value=arr[i][k];
					}else if(count==result&&arr[i][k]<value) {
						value=arr[i][k];
					}
				}
			}
			
			System.out.println("#"+test_case+" "+ value+" "+result);
		}
	}
	public static void step(int i, int k) {
		count++;
		check[i][k]= true;
		for(int idx = 0; idx < 4; idx++) {
			int nr = i + dr[idx];
			int nc = k + dc[idx];
			if(nr>=0&&nr<N&&nc>=0&&nc<N&&arr[nr][nc]==arr[i][k]+1&&check[nr][nc]==false) {
				step(nr, nc);
				break;
			}
		}
	}
}
