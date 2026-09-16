import java.io.*;
import java.util.*;

public class Solution {
	static int N, M;
	static int[] area;
	static List<Integer>[] list;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			area = new int[N + 1];
			list = new ArrayList[N+1];
			visited = new boolean[N + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				area[i] = Integer.parseInt(st.nextToken());
				list[i] = new ArrayList<>();
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
				list[b].add(a);
			}
			
			System.out.print("#" + test_case + " ");
			for (int i = 1; i <= N; i++) {
				if(visited[i]) continue;
				int sum = 0;
				Queue<Integer> que = new ArrayDeque<>();
				que.add(i);
				visited[i] = true;
				while(!que.isEmpty()) {
					int a = que.poll();
					sum += area[a];
					for (int cur : list[a]) {
						if(visited[cur]) continue;
						visited[cur] = true;
						que.add(cur);
					}
				}
				System.out.print(sum + " ");
			}
			System.out.println();
		}
	}
}