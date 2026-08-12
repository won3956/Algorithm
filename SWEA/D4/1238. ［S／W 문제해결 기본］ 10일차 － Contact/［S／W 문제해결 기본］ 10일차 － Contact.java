import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int[][] graph;
	static int[] visited;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = 10;
		for(int test_case=1; test_case<=T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			
			graph = new int[101][101];
			visited = new int[101];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				graph[from][to] = 1;
			}
			
			System.out.println("#"+test_case+" "+bfs(S));
		}
	}
	public static int bfs(int s) {
		Queue<Integer> que = new ArrayDeque<>();
		que.offer(s);
		
		int depth = 1;
		visited[s] = 1;
		
		while(!que.isEmpty()) {
			int k = que.poll();
			for(int i = 1; i < 101; i++) {
				if(graph[k][i]==1&&visited[i]==0) {
					que.offer(i);
					visited[i] = visited[k] + 1;
				}
				depth = Math.max(depth, visited[i]);
			}
		}
		for(int i = 100; i > 0; i--) {
			if(visited[i]==depth) {
				return i;
			}
		}
		
		return 0;
	}
}
