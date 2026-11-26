import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] parents;
	static Map<String, Integer> map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			map = new HashMap<>();
			parents = new int[2*N];
			Arrays.fill(parents, -1);
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				String a = st.nextToken();
				String b = st.nextToken();
				
				int idA = map.computeIfAbsent(a, key -> map.size());
				int idB = map.computeIfAbsent(b, key -> map.size());
				
				int size = union(idA, idB);
				
				sb.append(size).append("\n");
			}
		}
		System.out.print(sb);
	}

	public static int union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if(rootA == rootB) return -parents[rootA];
		
		if(parents[rootA] > parents[rootB]) { // 최적화 - 작은 집합을 큰 집합에 붙이기 (음수 고려)
			int temp = rootA;
			rootA = rootB;
			rootB = temp;
		}
		
		parents[rootA] += parents[rootB];
		parents[rootB] = rootA;
		return -parents[rootA];
	}
	
	public static int find(int a) {
		if(parents[a] < 0) return a;
		
		return parents[a] = find(parents[a]);
	}
}
