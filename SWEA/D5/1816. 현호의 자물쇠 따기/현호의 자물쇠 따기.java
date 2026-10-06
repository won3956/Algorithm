import java.io.*;
import java.util.*;

/*  비트마스킹 DP
 * ex)
 * 9 10 23
 * 001 : 23 사용
 * 110: 9, 10 사용
 * 
 * dp[mask][remain] : mask에 해당하는 숫자를 사용해서 만든 모든 순열 중 나머지가 remain인 경우
 */
public class Solution {
	static int N, K;
    static String[] nums;
    static int[] len, numMod, pow10;
    static long[][] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			
			N = Integer.parseInt(br.readLine());
			nums = new String[N];
			len = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				nums[i] = st.nextToken(); // 문자로 숫자를 입력받음
				len[i] = nums[i].length(); // 붙일때를 위한 자릿수를 계산하여 저장
			}
			
			K = Integer.parseInt(br.readLine());
			
			numMod = new int[N]; // 각 숫자를 K로 나눈 나머지를 저장
			
			for (int i = 0; i < N; i++) {
				int mod = 0;
				
				for (int j = 0; j < len[i]; j++) {
					int digit = nums[i].charAt(j) - '0'; // 저장된 문자열을 정수로 변환
					
					mod = (mod * 10 + digit) % K; 
				}
				
				numMod[i] = mod;
			}
			
			pow10 = new int[51];
			pow10[0] = 1 % K;
			
			for (int i = 1; i <= 50; i++) {
                pow10[i] = (pow10[i - 1] * 10) % K;
            }
			
			dp = new long[1 << N][K];
			dp[0][0] = 1;
			
			for (int mask = 0; mask < (1 << N); mask++) {

                for (int remain = 0; remain < K; remain++) {

                    if (dp[mask][remain] == 0) continue;
                    
                    for (int i = 0; i < N; i++) {

                        if ((mask & (1 << i)) != 0) continue;

                        int newMask = mask | (1 << i);

                        int newRemain = (remain * pow10[len[i]] + numMod[i]) % K;

                        dp[newMask][newRemain] += dp[mask][remain];
                    }
                }
            }
			
            long answer = dp[(1 << N) - 1][0];

            System.out.println("#" + test_case + " " + answer);
        }
	}
}