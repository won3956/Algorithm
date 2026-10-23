import java.io.*;
import java.util.*;

/*
 * [문제]
 *  2차원 격자의 바깥으로 이동하는 방향이면, 반대편에 있는 위치로 이동
 *  처음 위치는 제일 왼쪽 위, 이동 방향은 오른쪽
 *  
 *  문자	수행 명령
	<	이동 방향을 왼쪽으로 바꾼다.
	>	이동 방향을 오른쪽으로 바꾼다.
	^	이동 방향을 위쪽으로 바꾼다.
	v	이동 방향을 아래쪽으로 바꾼다.
	_	메모리에 0이 저장되어 있으면 이동 방향을 오른쪽으로 바꾸고, 아니면 왼쪽으로 바꾼다.
	|	메모리에 0이 저장되어 있으면 이동 방향을 아래쪽으로 바꾸고, 아니면 위쪽으로 바꾼다.
	?	이동 방향을 상하좌우 중 하나로 무작위로 바꾼다. 방향이 바뀔 확률은 네 방향 동일하다.
	.	아무 것도 하지 않는다.
	@	프로그램의 실행을 정지한다.
	0~9	메모리에 문자가 나타내는 값을 저장한다.
	+	메모리에 저장된 값에 1을 더한다. 만약 더하기 전 값이 15이라면 0으로 바꾼다.
	-	메모리에 저장된 값에 1을 뺀다. 만약 빼기 전 값이 0이라면 15로 바꾼다.

 * 
 * [입력]
 *  R, C (2 ≤ R, C ≤ 20)
 *  R개의 줄의 각 줄에는 C개의 문자
 * 
 * [출력]
 * 정지할 수 있으면 “YES”를 출력하고, 아니면 “NO”를 출력
 */

public class Solution {
	static int R, C;
	static boolean result;
	static char[][] map;
	static boolean[][][][] visited;
	static int[] dr = {0, 1, 0, -1}; // 우 하 좌 상
	static int[] dc = {1, 0, -1, 0};
	static class Pointer{
		int row;
		int col;
		int dir;
		int memory;
		public Pointer(int row, int col, int dir, int memory) {
			super();
			this.row = row;
			this.col = col;
			this.dir = dir;
			this.memory = memory;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int test_case=1; test_case<=T; test_case++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R][C];
			result = true;
			
			for (int i = 0; i < R; i++) {
				String inputString = br.readLine();
				for (int j = 0; j < C; j++) {
					map[i][j] = inputString.charAt(j);
				}
			}
			bfs();
			System.out.println("#"+test_case+" "+(result?"YES":"NO"));
		}
	}
	public static void bfs() {
		visited = new boolean[R][C][4][16];
		Queue<Pointer> que = new ArrayDeque<>();
		que.offer(new Pointer(0, 0, 0, 0));
		visited[0][0][0][0] = true;
		
		while(!que.isEmpty()) {
			
			Pointer cur = que.poll();
			int row = cur.row;
			int col = cur.col;
			int dir = cur.dir;
			int memory = cur.memory;
			char command = map[row][col];
			
			if(command == '@') { result = true; return; }
			
			switch (command) {
            case '>': dir = 0; break;
            case 'v': dir = 1; break;
            case '<': dir = 2; break;
            case '^': dir = 3; break;
            case '_': dir = (memory == 0) ? 0 : 2; break;
            case '|': dir = (memory == 0) ? 1 : 3; break;
            case '+': memory = (memory + 1) % 16; break;
            case '-': memory = (memory + 15) % 16; break;
			}
			if (command >= '0' && command <= '9') {
                memory = command - '0';
            }
			int startDir = (command == '?') ? 0 : dir;
	        int endDir = (command == '?') ? 3 : dir;
			
	        for (int nextDir = startDir; nextDir <= endDir; nextDir++) {
				// 다음 좌표 범위 확인, 반대 전환
				int nr = inRange(row + dr[nextDir], R);
				int nc = inRange(col + dc[nextDir], C);
				if(visited[nr][nc][nextDir][memory]) continue;
				que.offer(new Pointer(nr, nc, nextDir, memory));
				visited[nr][nc][nextDir][memory] = true;
	        }
		}
		
		result = false;
		return;
	}
	public static int inRange(int num, int rowOrcol) {
		if(num >= 0 && num < rowOrcol) return num;
		return (num + rowOrcol) % rowOrcol;
	}
}
