
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int[] arr;
	static long min, max;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int M = (N*(N-1))/2;
			int E = N - 1;
			arr = new int[M];
			min = 0;
			max = 0;
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<M; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			if(N == 2) {
				System.out.println(arr[0] + " "+ arr[0]);
				continue;
			}
			
			Arrays.sort(arr);
			for(int i = 0; i < E; i++) {
				min += (long)arr[i];
			}
			
			int count = 1;
			for(int i = 1; i <= N-1; i++) {
				max += (long)arr[i*(i-1)/2];
			}
			
			System.out.println(min + " " + max);
		}
	}
}
