import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int test_case = 1; test_case <= 10; test_case++) {
			arr = new int[100][100];
			visited = new boolean[100][100];
			br.readLine();
			for(int i = 0; i < 100; i++) {
				String str = br.readLine();
				for(int j = 0; j < 100; j++) {
					arr[i][j] = str.charAt(j)-'0';
				}
			}
			System.out.println("#"+test_case+" "+bfs(1, 1));
		}
	}
	public static int bfs(int sr, int sc) {
		Queue<int[]> que = new ArrayDeque<>();
		que.offer(new int[] {sr, sc});
		visited[sr][sc] = true;
		
		while(!que.isEmpty()) {
			int[] temp = que.poll();
			int row = temp[0];
			int col = temp[1];
			
			for(int idx=0; idx<4; idx++) {
				int nr = row + dr[idx];
				int nc = col + dc[idx];
				if(nr<=0||nr>=100||nc<=0||nc>=100) {
					continue;
				}
				if(arr[nr][nc]==3) {
					return 1;
				}
				if(visited[nr][nc]==true||arr[nr][nc]==1) {
					continue;
				}
				que.offer(new int[] {nr, nc});
				visited[nr][nc]=true;
			}
		}
		return 0;
	}
}
