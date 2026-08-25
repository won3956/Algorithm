import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N, M, K;
	static Cell[][] cells;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int result; // 활성화 + 비활성화 개수
	static Queue<Cell> que;

	public static class Cell {
		int row;
		int col;
		int life;
		int time;
		int time_act;
		int state; // 비어있음: -1, 죽은 상태: 0, 활성 상태: 1, 비활성 상태: 2
		int create;

		public Cell(int row, int col, int life, int time, int time_act, int state, int create) {
			this.row = row;
			this.col = col;
			this.life = life; // 생명력
			this.time = time; // 비활성화 중 생존 시간
			this.time_act = time_act; // 활성화 후 생존 시간
			this.state = state;
			this.create = create;
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 초기 세로
			M = Integer.parseInt(st.nextToken()); // 초기 가로
			K = Integer.parseInt(st.nextToken()); // 배양 시간
			
			cells = new Cell[N + 2 * K][M + 2 * K];
			que = new ArrayDeque<>();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					int life = Integer.parseInt(st.nextToken());
					if (life > 0) {
						Cell cell = new Cell(K + i, K + j, life, 0, 0, 2, 0);
						cells[K + i][K + j] = cell;
						que.offer(cell);
					}
				}
			}
			bfs();
			System.out.println("#" + test_case + " " + result);
		}
	}

	public static void bfs() {
		int time = 0;
		// 번식하려는 셀이 겹칠 때 > 생명력이 높은 줄기세포 = 번식하려는 셀이 time이 0일 때
		while (!que.isEmpty() && time < K) {
			time++;
			int size = que.size();
			for(int i = 0; i < size; i++) {
				Cell cell = que.poll();
				if (cell.state == 2) { // 비활성화 상태
					cell.time++;
					if (cell.time == cell.life) {	// 비활성 -> 활성화
						cell.state = 1;
					}
					que.offer(cell);
				} else if (cell.state == 1) {	// 활성화 상태
					cell.time_act++;
					if(cell.time_act==1) {
						for (int idx = 0; idx < 4; idx++) {
							int nr = cell.row + dr[idx];
							int nc = cell.col + dc[idx];
							if(cells[nr][nc]==null) {	//비어있으면
								Cell temp = new Cell(nr, nc, cell.life, 0, 0, 2, time);
								cells[nr][nc] = temp;
								que.offer(temp);
							}else if(cells[nr][nc].create == time && cells[nr][nc].state==2) {	
								// 지금 번식된 셀이면 생명력 비교
								int max = Math.max(cells[nr][nc].life, cell.life);
								cells[nr][nc].life = max;
							}
						}
					}
					if(cell.time_act == cell.life) {
						cell.state = 0; // 죽은 상태가 되면 큐에 다시 넣지 않음
					} else {
						que.offer(cell); // 수명이 남았다면 큐에 다시 넣기
					}
				}
			}
		}
		// 결과값 찾기
		result = que.size();
	}
}
