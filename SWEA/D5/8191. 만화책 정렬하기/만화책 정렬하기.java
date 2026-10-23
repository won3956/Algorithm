import java.io.*;
import java.util.*;

public class Solution {
	static int N, result;
	static int[] list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int test_case=1; test_case<=T; test_case++) {
			N = Integer.parseInt(br.readLine());
			list = new int[N + 1];
			result = 1;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int temp = Integer.parseInt(st.nextToken());
				list[temp] = i; // temp권이 i번째에 있음.
			}
			int point = 0;
			for (int i = 1; i <= N; i++) {
				if(point > list[i]) { // good
					result++;
				}
				point = list[i];
			}
			
			System.out.println("#"+test_case+" "+result);
		}
	}
}
