import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			br.readLine();
			Deque<Integer> que = new ArrayDeque<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			sb = new StringBuilder();
			for(int i = 0; i < 8; i++) {
				int temp = Integer.parseInt(st.nextToken());
				que.offer(temp);
			}
			int cnt = 1;
			while(true) {
				int first = que.poll();
				if(first-cnt<=0) {
					que.offer(0);
					break;
				}
				que.offer(first-cnt);
				cnt++;
				if(cnt==6) cnt = 1;
			}
			sb.append("#").append(test_case).append(" ");
			for(int i = 0; i < 8; i++) {
				sb.append(que.poll()).append(" ");
			}
			System.out.println(sb);
		}
	}
}