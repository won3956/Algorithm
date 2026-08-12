import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int[][] arr, visited;
	static int sr, sc, er, ec;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = 10;
		for(int test_case=1; test_case<=T; test_case++) {
			br.readLine();
			arr = new int[16][16];
			visited = new int[16][16];
			for(int i = 0; i < 16; i++) {
				String input = br.readLine();
				for(int j = 0; j < 16; j++) {
					arr[i][j] = input.charAt(j) - '0';
					if(arr[i][j]==2) {
						sr = i; sc = j;
					}else if(arr[i][j]==3) {
						er = i; ec = j;
					}
				}
			}
			
			System.out.println("#"+ test_case+" "+bfs());
		}
	}
	public static int bfs() {
		Queue<Node> que = new ArrayDeque<>();
		visited[sr][sc] = 1;
		que.offer(new Node(sr, sc));
		
		while(!que.isEmpty()) {
			Node node = que.poll();
			for(int idx = 0; idx < 4; idx++) {
				int nr = node.x + dr[idx];
				int nc = node.y + dc[idx];
				if(nr>=0&&nr<16&&nc>=0&&nc<16&&arr[nr][nc]==0&&visited[nr][nc]==0) {
					que.offer(new Node(nr, nc));
					visited[nr][nc] = visited[node.x][node.y] + 1;
				}else if(nr>=0&&nr<16&&nc>=0&&nc<16&&arr[nr][nc]==3) {
					return 1;
				}
			}
		}
		
		return 0;
	}
}
