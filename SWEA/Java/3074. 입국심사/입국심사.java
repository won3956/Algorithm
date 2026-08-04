import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static long[] time;
	static int N, M;
	static long result;
	static int[] times;
	static long left, right;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case<=TC; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int max = 0;
			times = new int[N];
			for(int i=0; i<N; i++) {
				times[i] = Integer.parseInt(br.readLine());
				if(times[i] > max) {
					max = times[i];
				}
			}
			result = (long)max*M;
			left = 0; right = (long)max*M;
			while(left <= right) {
				long mid = (right + left)/2;
				long ap = 0;
				for(int time : times) {
					ap += mid / time;
				}
				if(ap >= M) {
					result = mid;
					right = mid -1;
				}else {
					left = mid + 1;
				}
			}
			
			System.out.println("#"+test_case+" "+result);
		}
	}
	
}
