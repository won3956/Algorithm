import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static double E;
	static int[] x;
	static int[] y;
	static int[] parent;
	static double result;
	static class Edge{
		int a;
		int b;
		double cost;
		public Edge(int a, int b, double cost) {
			this.a = a;
			this.b = b;
			this.cost = cost*E;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case=1; test_case<=T; test_case++) {
			result = 0.0;
			List<Edge> edges = new ArrayList<>();
			N = Integer.parseInt(br.readLine());
			parent = new int[N+1];
			x = new int[N];
			y = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i ++) {
				x[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i ++) {
				y[i] = Integer.parseInt(st.nextToken());
			}
			
			makeSet();
			
			E = Double.parseDouble(br.readLine());
			
			for(int a = 0; a < N; a++) {	
				for(int b = a+1; b < N; b++) {
					int dx = x[a]- x[b];
					int dy = y[a]- y[b];
					long dist2 = (long)dx*dx + (long)dy*dy;
					
					edges.add(new Edge(a, b, dist2));
				}
			}
			
			edges.sort((a, b)->Double.compare(a.cost, b.cost));
			
			int count = 0;
			for(Edge e: edges) {
				
				if(!union(e)) continue;
				count++;
				result += e.cost;
				if(count == N-1) break;
			}
			System.out.printf("#%d %.0f\n", test_case, result);
		}
	}
	public static void makeSet() {
		Arrays.fill(parent, -1);
	}
	public static boolean union(Edge e) {
		int rootA = find(e.a);
		int rootB = find(e.b);
		
		if(rootA == rootB) return false;
		
		if(parent[rootA] <= parent[rootB]) {
			parent[rootA] += parent[rootB];
			parent[rootB] = rootA;
		}else {
			parent[rootB] += parent[rootA];
			parent[rootA] = rootB;
		}
		return true;
	}
	public static int find(int a) {
		if(parent[a] < 0)	return a;
		return parent[a] = find(parent[a]);
	}

}
