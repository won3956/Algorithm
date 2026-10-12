import java.io.*;
import java.util.*;

public class Solution {
	static class Edge {
		int from, to, cost;

		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}

	static Edge[] edges;
	static int[] parents;
	static int N, M, result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine()); // 정점
			M = Integer.parseInt(br.readLine()); // 간선
			edges = new Edge[M];
			result = 0;

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				edges[i] = new Edge(s, e, c);
			}

			Arrays.sort(edges, (a, b) -> Integer.compare(a.cost, b.cost));
			makeSet();

			int edgeCnt = 0;
			
			for (Edge edge : edges) {
				if (!union(edge.from, edge.to))
					continue;
				result += edge.cost;
				edgeCnt++;
				if(edgeCnt == N - 1) break;
			}

			System.out.println("#" + test_case + " " + result);
		}
	}

	public static void makeSet() {
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}

	public static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);

		if (rootA == rootB)
			return false;
		parents[rootA] = rootB;
		return true;
	}

	public static int find(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = find(parents[a]);
	}
}