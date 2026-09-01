import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 메모리:27,776 KB, 시간:91ms
 * @author won3956
 *
 */

public class Solution {
	static Deque<String> que1;
	static Deque<String> que2;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringBuilder sb = new StringBuilder();
			que1 = new ArrayDeque<>();
			que2 = new ArrayDeque<>();
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			if(N%2==0) {
				for(int i = 0; i < N/2; i++) {
					que1.offer(st.nextToken());
				}
				for(int i = N/2; i < N; i++) {
					que2.offer(st.nextToken());
				}
			}else {
				for(int i = 0; i < N/2 + 1; i++) {
					que1.offer(st.nextToken());
				}
				for(int i = N/2 + 1; i < N; i++) {
					que2.offer(st.nextToken());
				}
			}
			sb.append("#").append(test_case).append(" ");
			for(int i = 0; i < N; i++) {
				if(i%2==0) {
					sb.append(que1.poll()).append(" ");
				}else {
					sb.append(que2.poll()).append(" ");
				}
			}
			System.out.println(sb);
		}
	}
}