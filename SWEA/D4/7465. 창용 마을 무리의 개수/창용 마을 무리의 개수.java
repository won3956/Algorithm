import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] parent;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			parent = new int[N+1];
			for(int i = 1; i <= N; i++) {
				parent[i]=i;
			}
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				union(x, y);
			}
			int count = 0;
			for (int i = 1; i <= N; i++) {
				if (parent[i] == i) {
					count++;
				}
			}
			System.out.println("#"+test_case+" "+count);
		}
	}
	public static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if(rootA != rootB) {
			parent[rootB] = rootA;
		}
	}
	public static int find(int a) {
		if(parent[a]==a)	return a;
		return parent[a] = find(parent[a]);
	}
}
