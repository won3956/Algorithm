import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

	static int[][] arr;
	static boolean[][] visited;
	static int sr, sc;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for(int test_case=1; test_case<=T; test_case++) {
			br.readLine();
			arr = new int[16][16];
			visited = new boolean[16][16];
			for(int i = 0; i < 16; i++) {
				String input = br.readLine();
				for(int j = 0; j < 16; j++) {
					arr[i][j] = input.charAt(j) - '0';
					if(arr[i][j]==2) {
						sr = i; sc = j;
					}
				}
			}
			System.out.println("#"+ test_case+" "+bfs());
		}
	}

	public static int bfs() {
		Queue<int[]> que = new ArrayDeque<>();
		visited[sr][sc] = true;
		que.offer(new int[] {sr, sc});
		
		while(!que.isEmpty()) {
			int[] node = que.poll();
			for(int idx = 0; idx < 4; idx++) {
				int nr = node[0] + dr[idx];
				int nc = node[1] + dc[idx];
				if(!inrange(nr, nc)) continue;
				
				if(arr[nr][nc]==0&&!visited[nr][nc]) {
					que.offer(new int[] {nr, nc});
					visited[nr][nc] = true;
				}else if(arr[nr][nc]==3) {
					return 1;
				}
			}
		}
		return 0;   // 도착 못함
	}
	public static boolean inrange(int r, int c) {
		return r>=0&&r<16&&c>=0&&c<16;
	}
}