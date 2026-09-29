import java.io.*;
import java.util.*;

/* 스킬은 매 초마다 상하좌우 인접한 영역을 부식시키며 확장
 * N행 M열 수연이는 1초에 4방향으로 한 칸 이동
 * X로 되어있는 공간은 이동 안되고 스킬도 확장 안됨
 * 
 * 수연이 위치는 'S', 여신은 'D', 돌:'X', 악마와 부식은 '*',
 * 평범한 지역은 '.'
 * 
 * [문제 풀이]
 * 최소 시간 -> BFS 
 * 종료 조건: 위치가 D에 해당되면
 * 악마 위치에서 4방향으로 확장 시키며 부식 => 큐 크기 측정하고 크기만큼 반복되면 부식 연산 진행 
 * continue 조건: 1.범위 안인지, 2.'.'이외의 지역인지, 3.D 위치에 도착했는지
 * 
 * 악마가 둘 이상일 수 있음, 독이 여신의 자리에는 갈 수 없음
 **** 수연이가 있던 자리에 독이 퍼지는 경우도 고려 => 큐에서 꺼내서 4방향 확인할 때 [nr][nc]의 좌우상하에 독이 있는지 확인
 *     => 하려 했으나 독을 먼저 퍼뜨리면 nnr, nnc 고려 할 필요없음.
 *
 * [제약사항]
 * (2 ≤ N, M ≤ 50)
 * 
 * [출력]
 * 여신이 있는 곳까지 스킬을 피하며 이동하는 최소 시간
 * 만약 불가능하면 GAME OVER 를 출력
 * 
 * [입력]
 * T
 * N, M
 * N개 줄에 M개의 문자
 */


public class Solution {
	static int N, M;
	static String result;
	static int sr, sc, er, ec;
	static char[][] map;
	static boolean[][] visited;
	static List<int[]> demons;
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, -1, 0, 1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			result = "";
			map = new char[N][M];
			visited = new boolean[N][M];
			demons = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < M; j++) {
					char c = str.charAt(j);
					map[i][j] = c;
					if(map[i][j]=='S') { sr = i; sc = j; }
					else if(map[i][j]=='D') { er = i; ec = j; }
					else if(map[i][j]=='*') {
						demons.add(new int[] {i, j});
					}
				}
			}
			bfs(sr, sc);
			System.out.println("#"+test_case+" "+result);
		}
	}
	
	public static void bfs(int startRow, int startCol) {
		int time = 0;
		Queue<int[]> que = new ArrayDeque<>();
		que.offer(new int[] {startRow, startCol});
		visited[startRow][startCol] = true;
		
		while(!que.isEmpty()) {
			time++;
			corrosion();
			int size = que.size();
			for (int turn = 0; turn < size; turn++) {
				int[] cur = que.poll();
				for (int i = 0; i < 4; i++) {
					int nr = cur[0] + dr[i];
					int nc = cur[1] + dc[i];
					
					if(!inRange(nr, nc)) continue;
					if(map[nr][nc]=='D') {
						result += time;
						return;
					}
					if(visited[nr][nc]) continue;
					if(map[nr][nc]!='.') continue;
					que.offer(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
		}
		result = "GAME OVER";
		return;
	}
	
	public static boolean inRange(int row, int col) {
		return row >= 0 && row < N && col >= 0 && col < M;
	}
	
	public static void corrosion() {
		if(demons.isEmpty()) return;
		int size = demons.size();
		for (int i = 0; i < size; i++) {
			int[] demon = demons.get(i);
			for (int idx = 0; idx < 4; idx++) {
				int nr = demon[0] + dr[idx];
				int nc = demon[1] + dc[idx];
				if(!inRange(nr, nc)) continue;
				if(map[nr][nc] != '.') continue;
				map[nr][nc] = '*';
				demons.add(new int[] {nr, nc});
			}
		}
		return;
	}
}