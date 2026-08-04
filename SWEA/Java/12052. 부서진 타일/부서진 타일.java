import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, M;
	static boolean[][] lst;
	static boolean result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case<=TC; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			result = true;
			lst = new boolean[N][M];
			for(int i = 0; i<N; i++) {
				String str = br.readLine();
				for(int j = 0; j<M; j++) {
					char temp = str.charAt(j);
					if(temp == '#') {
						lst[i][j] = false;
					}else if(temp == '.'){
						lst[i][j] = true;
					}
				}
			}
			for(int i = 0; i<N-1; i++) {
				for(int j = 0; j<M-1; j++) {
					if(lst[i][j]==false&&lst[i+1][j]==false&&
							lst[i][j+1]==false&&lst[i+1][j+1]==false) {
						lst[i][j]=true;
						lst[i+1][j]=true;
						lst[i][j+1]=true;
						lst[i+1][j+1]=true;
					}
				}
			}
			check();
			if(result==true) {
				System.out.println("#"+test_case+" YES");
			}else {
				System.out.println("#"+test_case+" NO");
			}
		}
	}
	public static void check() {
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(lst[i][j]==false) {
					result = false;
					return;
				}
			}
		}
	}
}
