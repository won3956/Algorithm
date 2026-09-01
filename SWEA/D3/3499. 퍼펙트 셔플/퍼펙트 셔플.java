import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 메모리:27,776 KB, 시간:91ms
 * @author won3956
 *
 */

public class Solution {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine());
			String[] cards = new String[N];
			sb.append("#").append(test_case).append(" ");

			for (int i = 0; i < N; i++) {
			    cards[i] = st.nextToken();
			}

			int mid = (N + 1) / 2;

			for (int i = 0; i < N; i++) {
			    if (i % 2 == 0) {
			        sb.append(cards[i / 2]);
			    } else {
			        sb.append(cards[mid + i / 2]);
			    }

			    sb.append(" ");
			}
			System.out.println(sb);
		}
	}
}