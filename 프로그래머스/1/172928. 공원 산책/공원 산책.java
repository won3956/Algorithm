class Solution {
    public int[] solution(String[] park, String[] routes) {
        int H = park.length;
        int W = park[0].length();
        
        int y = 0;
        int x = 0;
        
        // 1. 시작 지점(S) 찾기
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (park[i].charAt(j) == 'S') {
                    y = i;
                    x = j;
                }
            }
        }
        
        // 2. 명령어 수행 (HashMap, split 제거)
        for (int i = 0; i < routes.length; i++) {
            String route = routes[i];
            
            // "E 2" 형태이므로 인덱스 0은 방향, 인덱스 2는 이동 칸수
            char op = route.charAt(0);
            
            // 문제 조건에서 칸수는 1~9 범위의 한 자리 숫자이므로, 
            // 문자 '0'의 아스키코드 값을 빼서 바로 정수로 변환합니다.
            int n = route.charAt(2) - '0';
            
            int dy = 0;
            int dx = 0;
            
            // Map 대신 switch문을 사용하여 방향 결정
            switch (op) {
                case 'N': dy = -1; dx = 0; break;
                case 'S': dy = 1; dx = 0; break;
                case 'W': dy = 0; dx = -1; break;
                case 'E': dy = 0; dx = 1; break;
            }
            
            int ny = y;
            int nx = x;
            boolean isValid = true;
            
            // n칸 이동하며 유효성 검사
            for (int step = 0; step < n; step++) {
                ny += dy;
                nx += dx;
                
                if (ny < 0 || ny >= H || nx < 0 || nx >= W || park[ny].charAt(nx) == 'X') {
                    isValid = false;
                    break;
                }
            }
            
            if (isValid) {
                y = ny;
                x = nx;
            }
        }
        
        return new int[]{y, x};
    }
}