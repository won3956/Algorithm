
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] parent; //부모
	static int V, E;
	
	public static class Edge implements Comparable<Edge>{
		int a;
		int b;
		int cost;
		public Edge(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge o) {	//정렬을 위해 오버라이딩
			return this.cost - o.cost;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());	//정점
			E = Integer.parseInt(st.nextToken());	//간선
			
			Edge[] edges = new Edge[E]; //간선 저장할 배열
			for(int i = 0; i<E; i++) {	//저장
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				edges[i] = new Edge(a, b, c);
			}
			
			Arrays.sort(edges);		// 비용 순으로 정렬
			parent = new int[V+1];
			
			for(int i = 0; i < V+1; i++) {	// 부모 매열 초기화
				parent[i] = i;
			}
			
			int count = 0;	// 지금까지 선택한 간선 수
			long answer = 0; // 총 비용 Long 타입 필수
			for(Edge edge:edges) {
				int rootA = find(edge.a);
				int rootB = find(edge.b);
				
				if(rootA != rootB) {
					count++;
					answer += edge.cost;
					union(rootA, rootB);
				}
				if(count == V - 1)	break;	// 최소신장트리의 간선의 수는 정점-1개이므로
			}
			System.out.println("#"+test_case+" "+answer);
		}
	}
	public static int find(int a) {
		if(parent[a]==a)	return a;		//자기 자신이 부모(대표)인 경우
		else return parent[a] = find(parent[a]);	// 대표를 찾아서 대입
	}
	public static void union(int rootA, int rootB) {	// 집합 연결 메서드
		parent[rootA] = rootB;
	}
}
