import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
	
public class Solution {
	static int N, M, result;
	static int[] dr = {0, -1, 0, 1}; //우 상 좌 하
	static int[] dc = {1, 0, -1, 0};
	static int[][] map; // 상태 [ 0: 산, 1:빈 농지 ]
	static int[][] smap; // 시뮬용 맵 [ 0: 산, 1:빈 농지, 2++: 수확 가능해지는 day ]
	static int[][] ssak; //싹이 난 횟수
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			result = 0; // 가장 많은 수확 횟수
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int temp = Integer.parseInt(st.nextToken());
					if(temp==1) {
						map[i][j] = 0;
					}else {
						map[i][j]=1;
					}
				}
			}
			
			for (int sr = 0; sr < N; sr++) {
				for (int sc = 0; sc < N; sc++) {
					if(map[sr][sc]==0) continue;
					for (int i = 0; i < 4; i++) {
						result = Math.max(simul(sr, sc, i), result);
					}
				}
			}
			
			
			System.out.println("#"+test_case+" "+result);
		}
	}
	public static int simul(int row, int col, int idx) {
		int day = 1;
		int suhwak = 0;
		ssak = new int[N][N];
		smap = new int[N][N];
		for (int i = 0; i < N; i++) {
			smap[i] = map[i].clone();
		}
		
		while(day <= M) {
			
			if(smap[row][col]==1) {
				if(findCanMove(row, col, idx, day) >= 0) { //이동할 수 있는 칸이 하나라도 있는 경우, 포자를 뿌린다.
					ssak[row][col]++;
					smap[row][col] = day + 4 + ssak[row][col];
				}else { // 로봇이 이동할 수 있는 칸이 하나도 없는 경우, 아무것도 하지 않고 현재 위치에 머무른다.
					
				}
			}else if(smap[row][col] > 1 && smap[row][col] <= day) { // 현재 칸의 해조류가 다 자란 경우, 해조류를 수확
				suhwak++;
				smap[row][col] = 1; //수확한 자리는 다시 빈 양식 구역이 된다.
			}
			
			// 오후
			// 로봇은 오후에 인접한 4방향 중 이동 가능한 칸으로 이동한다.
			// 이동 가능한 칸은 빈 양식 구역, 또는 해조류가 다 자란 칸이다. 암초이거나, 싹이 터서 아직 다 자라는 중인 칸으로는 이동할 수 없다.
			int canMove = findCanMove(row, col, idx, day);
			if(canMove>=0) { // 이동 가능 => 해당 칸으로 이동
				idx = canMove;
				row += dr[idx];
				col += dc[idx];
			}			
			day++;
		}
		return suhwak;
	}
	// 이동할 수 있는지 여부와 방향 찾기
	public static int findCanMove(int row, int col, int idx, int day) {
		int canMove = -1;
		for (int i = -1; i < 3; i++) {
			int nidx = (idx + i + 4)%4;
			int nr = row + dr[nidx];
			int nc = col + dc[nidx];
			if(!isAble(nr, nc)) continue;
			if(smap[nr][nc] == 1 || (smap[nr][nc] > 1 && smap[nr][nc] <= day)) {
				if(canMove==-1) {
					canMove = nidx;
				}
			}
		}
		return canMove;
	}
	public static boolean isAble(int row, int col) {
		return row >= 0 && row < N && col >= 0 && col < N;
	}
}
