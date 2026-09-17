import java.io.*;
import java.util.*;

public class Solution {
	static int N, E, S;
	static List<Integer>[] list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N =Integer.parseInt(st.nextToken());
			E =Integer.parseInt(st.nextToken());
			S = Integer.parseInt(br.readLine());
			list = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++) {
				list[i] = new ArrayList<>();
			}
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				list[from].add(to);
				list[to].add(from);
			}
			
			
			System.out.println("#"+test_case+" "+bfs(S));
		}
	}
	public static int bfs(int start) {
		int day = -1;
		boolean[] visited = new boolean[N + 1];
		Queue<Integer> que = new ArrayDeque<>();
		que.offer(start);
		visited[start] = true;
		
		while(!que.isEmpty()) {
			int size = que.size();
			for (int i = 0; i < size; i++) {
				int cur = que.poll();
				for (int v : list[cur]) {
					if(visited[v]) continue;
					que.offer(v);
					visited[v] = true;;
				}
			}
			day++;
		}
		
		return day;
	}
}