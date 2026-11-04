import java.util.*;

class Solution {
    final int INF = 10000000;
    public int solution(int[][] info, int n, int m) {
        int result = INF;
        int l = info.length;
        int[][] dp = new int[l + 1][m];
        for (int i = 0; i <= l; i++) {
            Arrays.fill(dp[i], INF);
        }
        
        dp[0][0] = 0;
        for(int i = 0; i < l; i++){
            int a = info[i][0];
            int b = info[i][1];
            
            for(int j = 0; j < m; j++){
                if(dp[i][j] == INF) continue; //불가능한 경우
                // a가 훔침
                if(dp[i][j] + a < n){
                    dp[i + 1][j] = Math.min(dp[i][j]+a, dp[i + 1][j]);
                }
                // b가 훔침
                if(j + b < m){
                    dp[i+1][j+b] = Math.min(dp[i+1][j+b], dp[i][j]);
                }
            }
        }

        for (int j = 0; j < m; j++) {
            result = Math.min(result, dp[l][j]);
        }

        return result == INF ? -1 : result;
    }
}