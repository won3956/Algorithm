import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, M;
	static int[][] othello;
	static int row, col, color;
	static final int[] dr = {0, 1, 1, 1, 0, -1, -1, -1};
	static final int[] dc = {1, 1, 0, -1, -1, -1, 0, 1};
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			othello = new int[N][N];
			int black = 0;
			int white = 0;
			// 시작 시 기본 세팅
			int d = N/2 -1;
			othello[d][d] = 2;
			othello[d][d+1] = 1;
			othello[d+1][d] = 1;
			othello[d+1][d+1] = 2;

			while(M-- >0) {
				st = new StringTokenizer(br.readLine());
				col = Integer.parseInt(st.nextToken()) - 1;
				row = Integer.parseInt(st.nextToken()) - 1;
				color = Integer.parseInt(st.nextToken());
				othello[row][col] = color;
				
				for(int idx = 0; idx<8; idx++) {	// 8방향 한번씩 실행
					int nr = row + dr[idx];
					int nc = col + dc[idx];
					if(nr < 0 || nr>=N || nc<0 || nc>=N)	continue;	//첫 칸 범위 밖이면 다음 방향
					if(othello[nr][nc]==0||othello[nr][nc]==color) continue;	//첫 칸이 빈칸이거나 같은색이면 다음 반복
					while(nr >= 0 && nr<N && nc>=0 && nc<N) {
						if(othello[nr][nc]==0) {	// 빈칸이면 바로 다음 방향
							break;
						} else if(othello[nr][nc]==color) {		// 같은 색을 만나면 
							int i = row;
							int j = col;
							while(!(i == nr && j == nc)) {
								othello[i][j] = color;
								i += dr[idx];
								j += dc[idx];
							}
							break;
						}
						nr += dr[idx];		//다른색이면 한칸 더 전진
						nc += dc[idx];
					}
				}
			}
			for(int[] line : othello){
                for(int color : line){
                    if(color == 1) black++;
                    else if(color == 2) white++;
                }
            }
            System.out.println("#" + test_case + " " + black + " " +white);
		}
	}
}
