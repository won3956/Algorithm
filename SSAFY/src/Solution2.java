import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
// 단방향 최소 비용 다익스트라
public class Solution2 {
	static long result;
	static String A, B;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int test_case=1; test_case<=T; test_case++) {
			st = new StringTokenizer(br.readLine());
			A = st.nextToken();
			B = st.nextToken();
			
			result += (long)count(A) + (long)count(B);
			
			System.out.println("#" + test_case + " " + result);
		}
	}
	public static int count(String str) {
		int sum = 0;
		int startIndex = 0;
		int length = str.length();
		if(str.charAt(0) == '-') {
			startIndex = 1;
		}
		int cnt = 0;
		for (int i = length - 1; i >= startIndex; i--) {
			int temp = str.charAt(i) - '0';
			if (temp >= 4) temp--;
			for (int j = 0; j < cnt; j++) {
				temp *= 9;
			}
			sum += temp;
		}
		
		return sum;
	}
}
