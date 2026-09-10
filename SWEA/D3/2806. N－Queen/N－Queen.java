import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
	
	static int N, cnt;
	static boolean[] col, mainDiagonal, subDiagonal;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			cnt = 0;
			
			col = new boolean[N+1];
			mainDiagonal = new boolean[2*N+1];
			subDiagonal = new boolean[2*N+1];
			
			setQueen(1);
			System.out.println("#"+test_case+" "+cnt);
		}
	}
	public static void setQueen(int row) {
		if(row > N) {	// 한 경우의 수 완료
			++cnt;
			return;
		}
		//1열부터 N열 시도
		for (int c = 1; c <= N; c++) {
			if(!isAvailable(row, c)) continue;	//가지치기
			col[c] = mainDiagonal[(row-c)+N] = subDiagonal[row+c] = true;
			setQueen(row+1);
			col[c] = mainDiagonal[(row-c)+N] = subDiagonal[row+c] = false;
		}
	}
	// 유효성 확인
	public static boolean isAvailable(int r, int c) {
		return !col[c] && !mainDiagonal[(r-c)+N] && !subDiagonal[r+c];
	}
}
