
class Solution {
    public int solution(int[] money) {
        int n = money.length;
        int[] dp_cf = new int[n + 1]; //첫번째집 선택   => 마지막 집 선택 불가
        int[] dp_nf = new int[n + 1]; //첫번째집 선택 x - 1.i번째 집 선택 2. i번째 x
        
        dp_cf[0] = dp_nf[0] = 0;
        dp_cf[1] = money[0];
        dp_nf[1] = 0;
        
        for(int i = 2; i <= n; i++){
            dp_cf[i] = Math.max(dp_cf[i - 2] + money[i - 1], dp_cf[i - 1]);
            dp_nf[i] = Math.max(dp_nf[i - 2] + money[i - 1], dp_nf[i - 1]);
        }
        return Math.max(dp_cf[n - 1], dp_nf[n]);
    }
}