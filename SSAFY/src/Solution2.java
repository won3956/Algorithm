import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
// 단방향 최소 비용 다익스트라
public class Solution2 {
	static class State{
		int v, dist; //도착 정점, 출발지에서 v까지 비용
		public State(int v, int dist) { 
			this.v = v;
			this.dist = dist;
		}
	}
	static class Node{
		int to, cost;
		public Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}
	static final int INF = Integer.MAX_VALUE;
	static int N, M, S, E, result;
	static List<Node>[] adjList;
	static int[] minDist;
	static boolean[] fixed;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int test_case=1; test_case<=T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			
			adjList = new ArrayList[N];
			
			for (int i = 0; i < M; i++) {
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				adjList[A - 1].add(new Node(B - 1, C));
			}
			
			dijkstra();
			result = minDist[E];
			System.out.println("#"+test_case+" "+ result);
		}
	}
	public static void dijkstra() {
		minDist = new int[N];
		Arrays.fill(minDist, INF);
		fixed = new boolean[N];
		PriorityQueue<State> pq = new PriorityQueue<>();
		minDist[S - 1] = 0;
		pq.offer(new State(S - 1, 0));
		
		while(!pq.isEmpty()) {
			State cur = pq.poll();
			int minV = cur.v;
			if(fixed[minV]) continue; // 이미 최단거리 확정
			
			fixed[minV] = true;
			
			for (Node node : adjList[minV]) {
				int to = node.to;
				int cost = node.cost;
				
				if(fixed[to]) continue;
				if(minDist[to] <= minDist[minV] + cost) continue;
				
				minDist[to] = minDist[minV] + cost;
				pq.offer(new State(to, minDist[to]));
			}
		}
	}
}
