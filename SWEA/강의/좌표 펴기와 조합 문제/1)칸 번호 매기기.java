import java.io.*;
import java.util.*;

public class Solution2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append("\n");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < Q; i++) {
				st = new StringTokenizer(br.readLine());
				int cmd = Integer.parseInt(st.nextToken());
				if(cmd == 1) {
					int num = Integer.parseInt(st.nextToken());
					int r = num / M;
					int c = num % M;
					sb.append(r).append(" ").append(c).append("\n");
				}else if(cmd == 2) {
					int r = Integer.parseInt(st.nextToken());
					int c = Integer.parseInt(st.nextToken());
					int num = r * M + c;
					sb.append(num).append("\n");
				}else {
					int a = Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());
					int dist = Math.abs(a / M - b / M) + Math.abs(a % M - b % M);
					sb.append(dist).append("\n");
				}
			}
			
		}
		System.out.println(sb);
	}
}