class Solution {
    public int solution(int[][] signals) {
        int lcm = 1;
        
        for(int[] signal : signals){
            int cycle = signal[0] + signal[1] + signal[2];
            lcm = lcm(lcm, cycle);
        }
        
        for(int time = 1; time <= lcm; time++){ //1초마다 확인
            boolean allyellow = true;
            
            for(int[] signal : signals){
                int green = signal[0];
                int yellow = signal[1];
                int cycle = signal[0]+signal[1]+signal[2];
                // 실제 시간 : 1  2  3  4  5  6  7  8 ...
                // 주기 위치 : 1  2  3  4  5  1  2  3 ...
                int current = (time - 1) % cycle + 1;
                // 노란불이 아니면
                if(current <= green || current > green + yellow){
                    allyellow = false;
                    break;
                }
            }
            if(allyellow){
                return time;
            }
        }
        return -1;
    }
    private int gcd(int a, int b){ //최대공약수 유클리드 호제법
        while(b!=0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    
    private int lcm(int a, int b){ //최소공배수 처음과 같아지는 시간
        return a / gcd(a, b) * b;
    }
}