import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, M;
	static int[] lst;
	static int max;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case<=TC; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			lst = new int[N];
			max = -1;
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<N; i++) {
				lst[i] = Integer.parseInt(st.nextToken());
			}
			for(int i = 0; i<N; i++) {
				for(int j = i; j<N; j++) {
					if(i!=j) {
						if(lst[i]+lst[j]<=M && lst[i]+lst[j] >max) {
							max = lst[i]+lst[j];
						}
					}
				}
			}
			System.out.println("#"+test_case+" "+max);
		}
	}
}
